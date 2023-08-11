package sparqles.core.calculation;

import sparqles.avro.Endpoint;
import sparqles.avro.EndpointResult;
import sparqles.core.EndpointTask;
import sparqles.avro.calculation.CResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.mortbay.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sparqles.avro.Endpoint;
import sparqles.avro.analytics.DiscoverabilityView;
import sparqles.avro.analytics.EPView;
import sparqles.avro.analytics.EPViewDiscoverability;
import sparqles.avro.analytics.EPViewDiscoverabilityData;
import sparqles.avro.discovery.DGETInfo;
import sparqles.avro.discovery.DResult;
import sparqles.avro.discovery.QueryInfo;
import sparqles.core.discovery.DTask;
import sparqles.utils.MongoDBManager;

//import org.apache.jena.*;
//import org.apache.jena.rdf.Model;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;
import com.hp.hpl.jena.query.*;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
//import org.apache.jena.rdf.model.*;
//import org.apache.jena.sparql.resultset.JSONOutput;

public class CTask extends EndpointTask<CResult> {
    private static final Logger log = LoggerFactory.getLogger(CTask.class);
    
    private final static String sparqDescNS = "http://www.w3.org/ns/sparql-service-description#";
    private final static String voidNS = "http://rdfs.org/ns/void#";
    private final static String dctermsNS = "http://purl.org/dc/terms/";
    private final static String foafNS = "http://xmlns.com/foaf/0.1/";
    
    private final static String queryPingEndpoint = "" +
	"ASK { ?s ?p ?o }";
    
    private final static String queryNumberOfTriples = "" +
	"SELECT (COUNT (*) as ?value)\n"+
	"WHERE { ?s ?p ?o }";
    
    private final static String queryNumberOfEntities = "" +
	"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
	"SELECT (COUNT (DISTINCT ?entity) as ?value)\n"+
	"WHERE { ?entity rdf:type ?class }";
    
    private final static String queryNumberOfClasses = "" +
	"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
	"SELECT (COUNT (DISTINCT ?class) as ?value)\n"+
	"WHERE { ?entity rdf:type ?class }";
    
    private final static String queryNumberOfProperties = "" +
	"SELECT (COUNT (DISTINCT ?p) as ?value)\n"+
	"WHERE { ?s ?p ?o }";
    
    private final static String queryNumberOfSubjects = "" +
	"SELECT (COUNT (DISTINCT ?s) as ?value)\n"+
	"WHERE { ?s ?p ?o }";
    
    private final static String queryNumberOfObjects = "" +
	"SELECT (COUNT (DISTINCT ?o) as ?value)\n"+
	"WHERE { ?s ?p ?o }";
    
    private final static String queryExampleResource = "" +
	"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
	"SELECT ?value\n"+
	"WHERE { ?value rdf:type ?class }\n" +
	"LIMIT 3";
    
    public CTask(Endpoint ep) {
	super(ep);
    }
    
    @Override
    public CResult process(EndpointResult epr) {
	CResult result = new CResult();
	result.setEndpointResult(epr);
	//if (!_epURI.equals("http://en.openei.org/sparql"))
	//    return result;
	log.info("### execute {}", _epURI);

	// Code for generating a VoID and SPARQL Service Description profile for the endpoint.
	// author: Milos Jovanovik (@mjovanovik)
	
	long triples = -1;
	long entities = -1;
	long classes = -1;
	long properties = -1;
	long distinctSubjects = -1;
	long distinctObjects = -1;
	java.util.List<java.lang.CharSequence> exampleResourceList =  new java.util.ArrayList<>();
	String VoID = "";
	boolean VoIDPart = false;
	String SD = "";
	boolean SDPart = false;
	double coherence = -1.0;
	double relationshipSpecialty = -1.0;

	// Check if the endpoint is accessible or not.
	// If not, there's no need to try and generate a VoID profile for it.
	Boolean ping = false;
	Query query1 = QueryFactory.create(queryPingEndpoint);
	QueryExecution qexec1 = QueryExecutionFactory.sparqlService(_epURI, query1);
	try {
	    ping = qexec1.execAsk();
	}
	catch (Exception e) {
	    log.info("[Error executing SPARQL query for {}]", _epURI);
	    log.info("[Error details: {}]", e.toString());
	}
		
	// If the endpoint is accessible, try to gather VoID statistics and generate the profile.
	if (ping) {
	    log.info("[GENERATION of VoiD] {}", _epURI);
	    triples = executeLongQuery(_epURI, queryNumberOfTriples);
	    if (triples == -1)
		VoIDPart = true;
	    //log.info("Number of triples in {}: {}", _epURI, triples);
	    //if (!_epURI.equals("http://sparql.uniprot.org")) // TODO: fix this hack	    
	    entities = executeLongQuery(_epURI, queryNumberOfEntities);
	    if (entities == -1)
		VoIDPart = true;
	    //log.info("Number of entities in {}: {}", _epURI, entities);
	    classes = executeLongQuery(_epURI, queryNumberOfClasses);
	    if (classes == -1)
		VoIDPart = true;
	    //log.info("Number of classes in {}: {}", _epURI, classes);
	    properties = executeLongQuery(_epURI, queryNumberOfProperties);
	    if (properties == -1)
		VoIDPart = true;
	    //log.info("Number of properties in {}: {}", _epURI, properties);
	    //if (!_epURI.equals("http://fr.dbpedia.org/sparql") && !_epURI.equals("http://sparql.uniprot.org")) // TODO: fix this hack
	    distinctSubjects = executeLongQuery(_epURI, queryNumberOfSubjects);
	    if (distinctSubjects == -1)
		VoIDPart = true;
	    //log.info("Number of distinct subjects in {}: {}", _epURI, distinctSubjects);
	    //if (!_epURI.equals("http://fr.dbpedia.org/sparql") && !_epURI.equals("http://sparql.uniprot.org")) // TODO: fix this hack
	    distinctObjects = executeLongQuery(_epURI, queryNumberOfObjects);
	    if (distinctObjects == -1)
		VoIDPart = true;
	    //log.info("Number of distinct objects in {}: {}", _epURI, distinctObjects);
	    exampleResourceList = executeQuery(_epURI, queryExampleResource);
	    if (exampleResourceList.size() == 0)
		VoIDPart = true;
	    //log.info("Number of example resources in {}: {}", _epURI, exampleResourceList.size());

	    try {
		log.info("Coherence calculation for {} ...", _epURI);
		coherence = calculateCoherence(_epURI);
	    }
	    catch (Exception e) {
		log.warn("[Error details: {}]", e.toString());
	    }
	    try {
		log.info("Relationship Specialty calculation {} ...", _epURI);
		if (triples != -1 && distinctSubjects != -1)
		    relationshipSpecialty = calculateRelationshipSpecialty(_epURI, triples, distinctSubjects);
	    }
	    catch (Exception e) {
		log.warn("[Error details: {}]", e.toString());
	    }
	    
	    Model model = ModelFactory.createDefaultModel();
	    
	    Resource endpointEntity = model.createResource(_epURI);
	    Resource endpointEntityDescription = model.createResource(_epURI + "/profile");
	    
	    Resource sdService = model.createResource(sparqDescNS + "Service");
	    Resource sdDataset = model.createResource(sparqDescNS + "Dataset");
	    Resource sdGraph = model.createResource(sparqDescNS + "Graph");
	    Resource voidDatasetDescription = model.createResource(voidNS + "DatasetDescription");
	    Resource voidDataset = model.createResource(voidNS + "Dataset");
	    Resource sparqlesEntity = model.createResource("https://sparqles.demo.openlinksw.com"); // TODO: This is hardcoded for now, needs to be dynamic
	    
	    Property sdendpoint = model.createProperty(sparqDescNS + "endpoint");
	    Property sddefaultDataset = model.createProperty(sparqDescNS + "defaultDataset");
	    Property sddefaultGraph = model.createProperty(sparqDescNS + "defaultGraph");
	    Property voidtriples = model.createProperty(voidNS + "triples");
	    Property voidentities = model.createProperty(voidNS + "entities");
	    Property voidclasses = model.createProperty(voidNS + "classes");
	    Property voidproperties = model.createProperty(voidNS + "properties");
	    Property voiddistinctSubjects = model.createProperty(voidNS + "distinctSubjects");
	    Property voiddistinctObjects = model.createProperty(voidNS + "distinctObjects");
	    Property dctermsTitle = model.createProperty(dctermsNS + "title");
	    Property dctermsCreator = model.createProperty(dctermsNS + "creator");
	    Property dctermsDate = model.createProperty(dctermsNS + "date");
	    Property foafprimaryTopic = model.createProperty(foafNS + "primaryTopic");
	    Property voidsparqlEndpoint = model.createProperty(voidNS + "sparqlEndpoint");
	    Property voidexampleResource = model.createProperty(voidNS + "exampleResource");
	    Property coherenceValue = model.createProperty("https://www.3dfed.com/ontology/coherence");
	    
	    // get current date
	    LocalDate currentDate = LocalDate.now();
	    String currentDateString = currentDate.format(DateTimeFormatter.ISO_DATE);
	    //Literal currentDateLiteral = model.createTypedLiteral(currentDateString, XSD.date);
	    Literal currentDateLiteral = model.createLiteral(currentDateString);
	    
	    // construct the SPARQL Service Description in RDF
	    endpointEntity.addProperty(RDF.type, sdService);
	    endpointEntity.addProperty(sdendpoint, endpointEntity);
	    endpointEntity.addProperty(sddefaultDataset,
				       model.createResource().addProperty(RDF.type, sdDataset)
				       .addProperty(sddefaultGraph,
						    model.createResource().addProperty(RDF.type, sdGraph)
						    .addProperty(voidtriples, Long.toString(triples))));
	    
	    // construct the VoID Profile in RDF
	    endpointEntityDescription.addProperty(RDF.type, voidDatasetDescription);
	    endpointEntityDescription.addProperty(dctermsTitle, "Automatically constructed VoID description for a SPARQL Endpoint");
	    endpointEntityDescription.addProperty(dctermsCreator, sparqlesEntity);
	    endpointEntityDescription.addProperty(dctermsDate, currentDateLiteral);
	    endpointEntityDescription.addProperty(foafprimaryTopic, endpointEntity);
	    
	    endpointEntity.addProperty(RDF.type, voidDataset);
	    endpointEntity.addProperty(voidsparqlEndpoint, endpointEntity);
	    for (int i = 0; i < exampleResourceList.size(); i++)
		endpointEntity.addProperty(voidexampleResource, model.createResource(exampleResourceList.get(i).toString()));
	    endpointEntity.addProperty(voidtriples, Long.toString(triples));
	    endpointEntity.addProperty(voidentities, Long.toString(entities));
	    endpointEntity.addProperty(voidclasses, Long.toString(classes));
	    endpointEntity.addProperty(voidproperties, Long.toString(properties));
	    endpointEntity.addProperty(voiddistinctSubjects, Long.toString(distinctSubjects));
	    endpointEntity.addProperty(voiddistinctObjects, Long.toString(distinctObjects));
	    
	    // add the Coherence value for the endpoint
	    endpointEntity.addProperty(coherenceValue, Double.toString(coherence));
	    
	    // the profile has been generated, now we persist it
	    java.io.StringWriter stringModel = new java.io.StringWriter() ;
	    model.write(stringModel, "TURTLE");
	    
	    VoID = stringModel.toString();	    
	}

	result.setTriples(triples);
	result.setEntities(entities);
	result.setClasses(classes);
	result.setProperties(properties);
	result.setDistinctSubjects(distinctSubjects);
	result.setDistinctObjects(distinctObjects);
	result.setExampleResources(exampleResourceList);
	result.setVoID(VoID);
	result.setVoIDPart(VoIDPart);
	result.setSD(SD);
	result.setSDPart(SDPart);
	result.setCoherence(coherence);
	result.setRS(relationshipSpecialty);	    
	
	log.info("$$$ executed {}", this);
	
	return result;
    }
    
    public long executeLongQuery(String endpointURL, String queryText) {
	Query query = QueryFactory.create(queryText);
	QueryExecution qexec = QueryExecutionFactory.sparqlService(endpointURL, query);
	qexec.setTimeout(10, TimeUnit.MINUTES);
	long result = -1;
	try {
	    ResultSet results = qexec.execSelect();
	    if(results.hasNext()){
		QuerySolution thisRow = results.next();
		result = ((Literal) thisRow.get("value")).getLong();
	    }
	}
	catch (Exception e) {
	    log.warn("[Error executing SPARQL query for {}]", endpointURL);
	    log.warn("[SPARQL query: {}]", queryText);
	    log.warn("[Error details: {}]", e.toString());
	}
	qexec.close() ;
	return result;
    }

    public java.util.List<java.lang.CharSequence> executeQuery(String endpointURL, String queryText) {
	Query query = QueryFactory.create(queryText);
	QueryExecution qexec = QueryExecutionFactory.sparqlService(endpointURL, query);
	qexec.setTimeout(10, TimeUnit.MINUTES);
	java.util.List<java.lang.CharSequence> list = new java.util.ArrayList<>();
	try {
	    ResultSet results = qexec.execSelect();
	    if (results != null) {
		while (results.hasNext()) {
		    QuerySolution thisRow = results.next();
		    list.add(((Resource)thisRow.get("value")).toString());
		}
	    }
	}
	catch (Exception e) {
	    log.warn("[Error executing SPARQL query for {}]", endpointURL);
	    log.warn("[SPARQL query: {}]", queryText);
	    log.warn("[Error details: {}]", e.toString());
	}
	qexec.close() ;
	return list;
    }
    
    public double calculateCoherence(String endpointUrl) {
	Set<String> types = getRDFTypes(endpointUrl);
	//log.info("Number of types in {}: {}", endpointUrl, types.size());
	//if(types.size()==0) return 0; // the SPARQL query has failed, so we cannot calculate the coherence
	double weightedDenomSum = getTypesWeightedDenomSum(types, endpointUrl);
	//log.info("Weighted denom sum in {}: {}", endpointUrl, weightedDenomSum);
	//if(weightedDenomSum==0) return 0; // the SPARQL query has failed, so we cannot calculate the coherence
	double structuredness = 0;
	for(String type:types) {
	    //log.info("Processing type {} in {}", type, endpointUrl);
	    long occurenceSum = 0;
	    Set<String> typePredicates = getTypePredicates(type, endpointUrl);
	    long typeInstancesSize = getTypeInstancesSize(type, endpointUrl);
	    //if(typeInstancesSize==0) return 0; // the SPARQL query has failed, so we cannot calculate the coherence
	    for (String predicate:typePredicates)
		{
		    long predicateOccurences = getOccurences(predicate, type, endpointUrl);
		    occurenceSum = (occurenceSum + predicateOccurences);
		}
	    double denom = typePredicates.size() * typeInstancesSize;
	    if(typePredicates.size()==0)
		denom = 1;
	    double coverage = occurenceSum/denom;
	    double weightedCoverage = (typePredicates.size()+ typeInstancesSize) / weightedDenomSum;
	    structuredness = (structuredness + (coverage*weightedCoverage));
	}
	return structuredness;
    }
    
    public static Set<String> getRDFTypes(String endpoint) {
	Set<String> types = new HashSet<String>() ;
	String queryString = ""
	    + "SELECT DISTINCT ?type\n"
	    + "WHERE { ?s a ?type }" ;
	Query query = QueryFactory.create(queryString);
	QueryExecution qExec = QueryExecutionFactory.sparqlService(endpoint, query);
	qExec.setTimeout(10, TimeUnit.MINUTES);
	try {
	    ResultSet res = qExec.execSelect();
	    while (res.hasNext())
		types.add(res.next().get("type").toString());
	}
	catch (Exception e) {
	    log.warn("[Error executing SPARQL query for {}]", endpoint);
	    log.warn("[SPARQL query: {}]", queryString);
	    throw e;
	}
	qExec.close();
	return types;
    }
    
    public static double getTypesWeightedDenomSum(Set<String> types, String endpoint) {
	double sum = 0 ;
	for (String type:types)
	    {
		//log.info("Processing type {} in {}", type, endpoint);
		long typeInstancesSize = getTypeInstancesSize(type, endpoint);
		long typePredicatesSize = getTypePredicates(type, endpoint).size();
		sum = sum + typeInstancesSize + typePredicatesSize;
	    }
	return sum;
    }
    
    public static long getTypeInstancesSize(String type, String endpoint)  {
	long typeInstancesSize = 0;
	String queryString = ""
	    + "SELECT (COUNT (DISTINCT ?s) as ?cnt ) \n"
	    + "WHERE {\n"
	    + "   ?s a <"+type.replaceAll("\\s", "")+"> . "
	    + "   ?s ?p ?o"
	    + "}" ;
	Query query = QueryFactory.create(queryString);
	QueryExecution qExec = QueryExecutionFactory.sparqlService(endpoint, query);
	qExec.setTimeout(10, TimeUnit.MINUTES);
	try {
	    ResultSet res = qExec.execSelect();
	    while (res.hasNext())
		typeInstancesSize = Long.parseLong(res.next().get("cnt").asLiteral().getString());
	}
	catch (Exception e) {
	    log.warn("[Error executing SPARQL query for {}]", endpoint);
	    log.warn("[SPARQL query: {}]", queryString);
	    throw e;
	}
	qExec.close();
	return typeInstancesSize;
    }
    
    public static Set<String> getTypePredicates(String type, String endpoint)  {
	Set<String> typePredicates = new HashSet<String>();
	String queryString = ""
	    + "SELECT DISTINCT ?typePred \n"
	    + "WHERE { \n"
	    + "   ?s a <"+type.replaceAll("\\s", "")+"> . "
	    + "   ?s ?typePred ?o"
	    + "}" ;
	Query query = QueryFactory.create(queryString);
	QueryExecution qExec = QueryExecutionFactory.sparqlService(endpoint, query );
	qExec.setTimeout(10, TimeUnit.MINUTES);
	try {
	    ResultSet res = qExec.execSelect();
	    while (res.hasNext()) {
		String predicate = res.next().get("typePred").toString();
		if (!predicate.equals("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"))
		    typePredicates.add(predicate);
	    }
	}
	catch (Exception e) {
	    log.warn("[Error executing SPARQL query for {}]", endpoint);
	    log.warn("[SPARQL query: {}]", queryString);
	    throw e;
	}
	qExec.close();
	return typePredicates;
    }
    
    public static long getOccurences(String predicate, String type, String endpoint)  {
	long predicateOccurences = 0;
	String queryString = ""
	    + "SELECT (COUNT (DISTINCT ?s) as ?occurences) \n"
	    + "WHERE { \n"
	    + "   ?s a <"+type.replaceAll("\\s", "")+"> . "
	    + "   ?s <"+predicate+"> ?o"
	    + "}" ;
	Query query = QueryFactory.create(queryString);
	QueryExecution qExec = QueryExecutionFactory.sparqlService(endpoint, query);
	qExec.setTimeout(10, TimeUnit.MINUTES);
	try {
	    ResultSet res = qExec.execSelect();
	    while (res.hasNext())
		predicateOccurences = Long.parseLong(res.next().get("occurences").asLiteral().getString());
	}
	catch (Exception e) {
	    log.warn("[Error executing SPARQL query for {}]", endpoint);
	    log.warn("[SPARQL query: {}]", queryString);
	    throw e;
	}
	qExec.close();
	return predicateOccurences;
    }
    
    public double calculateRelationshipSpecialty(String endpoint, long numOfTriples, long numOfSubjects) {
	Set<String> predicates = getRelationshipPredicates(endpoint);
	//log.info("Number of predicates in {}: {}", endpoint, predicates.size());
	long datasetSize = numOfTriples;
	long subjects = numOfSubjects;
	Kurtosis kurt = new Kurtosis();
	double relationshipSpecialty = 0 ;
	int i = 1;
	for (String predicate:predicates){
	    //log.info("Processing predicate {} in {}", predicate, endpoint);
	    double [] occurences = getOccurences(predicate, endpoint, subjects);
	    double kurtosis = kurt.evaluate(occurences);
	    //long tpSize = getPredicateSize(predicate, endpoint, namedGraph);
	    long tpSize = getPredicateSize(predicate, endpoint);
	    relationshipSpecialty = relationshipSpecialty + (tpSize*kurtosis/datasetSize);
	    i++;
	}
	return relationshipSpecialty;
    }
    
    public static Set<String> getRelationshipPredicates(String endpoint)  {
	Set<String> predicates =new HashSet<String>() ;
	String queryString ;
	queryString = "SELECT DISTINCT ?p WHERE {?s ?p ?o . FILTER isIRI(?o) } " ;
	Query query = QueryFactory.create(queryString);
	QueryExecution qExec = QueryExecutionFactory.sparqlService(endpoint, query);
	qExec.setTimeout(10, TimeUnit.MINUTES);
	try {
	    ResultSet res = qExec.execSelect();
	    while(res.hasNext())
		predicates.add(res.next().get("p").toString());
	}
	catch (Exception e) {
	    log.warn("[Error executing SPARQL query for {}]", endpoint);
	    log.warn("[SPARQL query: {}]", queryString);
	    throw e;
	}
	return predicates;
    }
    
    public static double[] getOccurences(String predicate, String endpoint ,long subjects) {
	double [] occurences = new double[(int) subjects+1];
	String queryString ;
	queryString = "SELECT (count(?o) as ?occ) WHERE { ?res <"+predicate+"> ?o . } Group by ?res" ;
	Query query = QueryFactory.create(queryString);
	QueryExecution qExec = QueryExecutionFactory.sparqlService(endpoint, query );
	qExec.setTimeout(10, TimeUnit.MINUTES);
	try {
	    ResultSet res = qExec.execSelect();
	    int i = 0;
	    while (res.hasNext()) {
		occurences[i] = res.next().get("occ").asLiteral().getDouble();
		i++;
	    }
	    if (i == 0)
		occurences[0] = 1;
	}
	catch (Exception e) {
	    log.warn("[Error executing SPARQL query for {}]", endpoint);
	    log.warn("[SPARQL query: {}]", queryString);
	    throw e;
	}
	return occurences ;
    }
    
    public static long getPredicateSize(String predicate, String endpoint)  {
	long count = 0;
	String queryString ="";
	queryString = ""
	    + "SELECT (COUNT (*) as ?total) \n"
	    + "WHERE { \n"
	    + "   ?s <"+predicate+"> ?o"
	    + "}";
	Query query = QueryFactory.create(queryString);
	QueryExecution qExec = QueryExecutionFactory.sparqlService(endpoint, query );
	qExec.setTimeout(10, TimeUnit.MINUTES);
	try {
	    ResultSet res = qExec.execSelect();
	    while(res.hasNext())
		count = Long.parseLong(res.next().get("total").asLiteral().getString());
	}
	catch (Exception e) {
	    log.warn("[Error executing SPARQL query for {}]", endpoint);
	    log.warn("[SPARQL query: {}]", queryString);
	    throw e;
	}
	return count;
    }
    
    
}
