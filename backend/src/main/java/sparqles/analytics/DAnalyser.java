package sparqles.analytics;

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
import sparqles.avro.analytics.Profile;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import org.apache.jena.rdf.model.*;
//import org.apache.jena.sparql.resultset.JSONOutput;

public class DAnalyser extends Analytics<DResult> {
	private static final Logger log = LoggerFactory.getLogger(DAnalyser.class);

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
			"LIMIT 1";

	public DAnalyser(MongoDBManager db) {
		super(db);
	}

	@Override
	public boolean analyse(DResult pres) {
		log.info("[Analytics] {}",pres);

		Endpoint ep = pres.getEndpointResult().getEndpoint();

		DiscoverabilityView dview= getView(ep);
		EPView epview=getEPView(ep);
		Profile pview = getProfileView(ep);

		String endpointURL = ep.getUri().toString();

		List<EPViewDiscoverabilityData> lvoid = new ArrayList<EPViewDiscoverabilityData>();
		List<EPViewDiscoverabilityData> lsd = new ArrayList<EPViewDiscoverabilityData>();

		String serverName = "missing";
		for(DGETInfo info : pres.getDescriptionFiles()){
			if(info.getOperation().toString().equals(DTask.EPURL)){
				if(!info.getResponseServer().toString().equalsIgnoreCase("missing")){
					serverName = info.getResponseServer().toString();
				}

				EPViewDiscoverabilityData d = new EPViewDiscoverabilityData("HTTP Get", info.getVoiDpreds().size()!=0);
				lvoid.add(d);
				
				d = new EPViewDiscoverabilityData("HTTP Get", info.getSPARQLDESCpreds().size() != 0);
				lsd.add(d);
			}
			if(info.getOperation().toString().equalsIgnoreCase("wellknown")){
				if(!info.getResponseServer().toString().equalsIgnoreCase("missing")){
					serverName = info.getResponseServer().toString();
				}
				
				EPViewDiscoverabilityData d = new EPViewDiscoverabilityData("/.well-known/void", info.getVoiDpreds().size()!=0);
				lvoid.add(d);
				
				d = new EPViewDiscoverabilityData("/.well-known/void", info.getSPARQLDESCpreds().size() != 0);
				lsd.add(d);
			}
			if(info.getSPARQLDESCpreds().size() >0 ){
				dview.setSD(true);
			}
			if(info.getVoiDpreds().size() >0 ){
				dview.setVoID(true);
			}
		}
		log.info("Setting server name to {}",serverName);
		dview.setServerName(serverName);
		EPViewDiscoverability depview = epview.getDiscoverability();
		
		depview.setServerName(dview.getServerName());
		depview.setVoIDDescription(lvoid);
		
		for(QueryInfo info: pres.getQueryInfo()){

			if(info.getOperation().equals("query-self")){
				EPViewDiscoverabilityData d = new EPViewDiscoverabilityData("SPARQL Endpoint content", info.getResults().size()!=0);
				lvoid.add(d);
			}
		}

		//		
		//		

		
		//		d = new EPViewDiscoverabilityData("HTTP Get", pres.getGetResult().getSPARQLDESCterms()!=0);
		//		l.add(d);
		//		d = new EPViewDiscoverabilityData("SPARQL Endpoint content", pres.getVoidResult().getSPARQLFile().size()!=0);
		//		l.add(d);


		//		depview.setSDDescription(l);

		if (dview.getVoID() == false) {
		    log.info("[CHECK if VoiD has been generated {}]",pres);
		    //TODO
		    

		    // if VoID has to be generated
		    if (true) { 
			log.info("[GENERATION of VoiD] {}",pres);

			// Code for generating a VoID and SPARQL Service Description profile for the endpoint.
			// author: Milos Jovanovik (@mjovanovik)

			int triples = 0;
			int entities = 0;
			int classes = 0;
			int properties = 0;
			int distinctSubjects = 0;
			int distinctObjects = 0;
			String exampleResource = "";
			double coherence = 0.0;

			/*
			Query query1 = QueryFactory.create(queryPingEndpoint);
			QueryExecution qexec1 = QueryExecutionFactory.sparqlService(endpointURL, query1);
			Boolean ping = false;
			try {
			    ping = qexec1.execAsk();
			    log.info("[Ping value is {}]", ping);
			}
			catch (Exception e) {
			    log.info("[Error executing SPARQL query for {}]", endpointURL);
			    log.info("[Error details: {}]", e.toString());
			}
			*/

			// Check if the endpoint is accessible or not.
			// If not, there's no need to try and generate a VoID profile for it.
			Boolean ping = false;

			for(QueryInfo info: pres.getQueryInfo()){
			    if("query-self".contentEquals(info.getOperation())){
				if (info.getException() == null)
				    ping = true;
			    }
			}

			// If the endpoint is accessible, try to gather VoID statistics and generate the profile.
			if (ping) {
			    log.info("[Ping value is {}]", ping);
			    RDFNode n = executeQuery(endpointURL, queryNumberOfTriples);
			    if (n != null)
				triples = ((Literal)n).getInt();
			    n = executeQuery(endpointURL, queryNumberOfEntities);
			    if (n != null)
				entities = ((Literal)n).getInt();
			    n = executeQuery(endpointURL, queryNumberOfClasses);
			    if (n != null)
				classes = ((Literal)n).getInt();
			    n = executeQuery(endpointURL, queryNumberOfProperties);
			    if (n != null)
				properties = ((Literal)n).getInt();
			    n = executeQuery(endpointURL, queryNumberOfSubjects);
			    if (n != null)
				distinctSubjects = ((Literal)n).getInt();
			    n = executeQuery(endpointURL, queryNumberOfObjects);
			    if (n != null)
				distinctObjects = ((Literal)n).getInt();
			    n = executeQuery(endpointURL, queryExampleResource);
			    if (n != null)
				exampleResource = ((Resource)n).toString();
				coherence = calculateCoherence(endpointURL);

			    Model model = ModelFactory.createDefaultModel();
			    
			    Resource endpointEntity = model.createResource(endpointURL);
			    Resource endpointEntityDescription = model.createResource(endpointURL + "/profile");
			    
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
								    .addProperty(voidtriples, Integer.toString(triples))));
			    
			    // construct the VoID Profile in RDF
			    endpointEntityDescription.addProperty(RDF.type, voidDatasetDescription);
			    endpointEntityDescription.addProperty(dctermsTitle, "Automatically constructed VoID description for a SPARQL Endpoint");
			    endpointEntityDescription.addProperty(dctermsCreator, sparqlesEntity);
			    endpointEntityDescription.addProperty(dctermsDate, currentDateLiteral);
			    endpointEntityDescription.addProperty(foafprimaryTopic, endpointEntity);
			    
			    endpointEntity.addProperty(RDF.type, voidDataset);
			    endpointEntity.addProperty(voidsparqlEndpoint, endpointEntity);
			    if (exampleResource != "") endpointEntity.addProperty(voidexampleResource, model.createResource(exampleResource));
				// VoID supports multiple example resources in the profile.
				// We currently add only one, for simplicity.
				// TODO: Add more example resources.
			    // endpointEntity.addProperty(voidexampleResource, //example resource 2);
			    // endpointEntity.addProperty(voidexampleResource, //example resource 3);
			    endpointEntity.addProperty(voidtriples, Integer.toString(triples));
			    endpointEntity.addProperty(voidentities, Integer.toString(entities));
			    endpointEntity.addProperty(voidclasses, Integer.toString(classes));
			    endpointEntity.addProperty(voidproperties, Integer.toString(properties));
			    endpointEntity.addProperty(voiddistinctSubjects, Integer.toString(distinctSubjects));
			    endpointEntity.addProperty(voiddistinctObjects, Integer.toString(distinctObjects));

				// add the Coherence value for the endpoint
				endpointEntity.addProperty(coherenceValue, Double.toString(coherence));

				// the profile has been generated, now we persist it
			    java.io.StringWriter stringModel = new java.io.StringWriter() ;
			    model.write(stringModel, "TURTLE");

			    pview.setVoID(stringModel.toString());
			    pview.setSD("test2");
			    pview.setLastUpdate(System.currentTimeMillis());
			    
			    dview.setGeneratedVoID(true);
			}
			else {
			    dview.setGeneratedVoID(false);
			}			
		    }
		}
		else {
		    dview.setGeneratedVoID(false);
		}
		

		dview.setLastUpdate(pres.getEndpointResult().getEnd());

		_db.update(dview);
		_db.update(epview);
		_db.update(pview);
		return true;

		//		SummaryStatistics askStatsCold = new SummaryStatistics();
		//		SummaryStatistics askStatsWarm = new SummaryStatistics();
		//		SummaryStatistics joinStatsCold = new SummaryStatistics();
		//		SummaryStatistics joinStatsWarm = new SummaryStatistics();
		//
		//		//prepare eppview data
		//		EPViewPerformance eppview = epview.getPerformance();
		//		EPViewPerformanceData askCold = new EPViewPerformanceData("Cold ASK Tests","#1f77b4", new ArrayList<EPViewPerformanceDataValues>());
		//		EPViewPerformanceData askWarm = new EPViewPerformanceData("WARM ASK Tests","#2ca02c", new ArrayList<EPViewPerformanceDataValues>());
		//		EPViewPerformanceData joinCold = new EPViewPerformanceData("Cold JOIN Tests","#1f77b4", new ArrayList<EPViewPerformanceDataValues>());
		//		EPViewPerformanceData joinWarm = new EPViewPerformanceData("Warm JOIN Tests","#2ca02c", new ArrayList<EPViewPerformanceDataValues>());
		//		
		//		ArrayList<EPViewPerformanceData> askdata= new ArrayList<EPViewPerformanceData>();
		//		askdata.add(askCold);
		//		askdata.add(askWarm);
		//		ArrayList<EPViewPerformanceData> joindata= new ArrayList<EPViewPerformanceData>();
		//		joindata.add(joinCold);
		//		joindata.add(joinWarm);
		//		
		//		eppview.setAsk(askdata);
		//		eppview.setJoin(joindata);
		//		
		//		
		//		Map<CharSequence, PSingleResult> map = pres.getResults();
		//		int limit =0 ;
		//		
		//		for(Entry<CharSequence, PSingleResult> ent: map.entrySet()){
		//			PSingleResult res = ent.getValue();
		//			if(ent.getKey().toString().startsWith("ASK")){
		//				askStatsCold.addValue(res.getCold().getClosetime()/(double)1000);
		//				askStatsWarm.addValue(res.getWarm().getClosetime()/(double)1000);
		//				
		//				String key = ent.getKey().toString().replaceAll("ASK",	"").toLowerCase();
		//				
		//				
		//				askCold.getData().add(new EPViewPerformanceDataValues(key,res.getCold().getClosetime()/(double)1000));
		//				askWarm.getData().add(new EPViewPerformanceDataValues(key,res.getWarm().getClosetime()/(double)1000));
		//			}else if(ent.getKey().toString().startsWith("JOIN")){
		//				joinStatsCold.addValue(res.getCold().getClosetime()/(double)1000);
		//				joinStatsWarm.addValue(res.getCold().getClosetime()/(double)1000);
		//		
		//				String key = ent.getKey().toString().replaceAll("JOIN",	"").toLowerCase();
		//				
		//				joinCold.getData().add(new EPViewPerformanceDataValues(key,res.getCold().getClosetime()/(double)1000));
		//				joinWarm.getData().add(new EPViewPerformanceDataValues(key,res.getWarm().getClosetime()/(double)1000));
		//			}else if(ent.getKey().toString().startsWith("LIMIT")){
		//				int sol = res.getCold().getSolutions();
		//				if(Math.max(limit, sol)==sol){
		//					limit = sol;
		//				}
		//				sol = res.getWarm().getSolutions();
		//				if(Math.max(limit, sol)==sol){
		//					limit = sol;
		//				}
		//			}
		//		}
		//		
		//		
		//		//Update pview data
		//		pview.setAskMeanCold(askStatsCold.getMean());
		//		pview.setAskMeanWarm(askStatsWarm.getMean());
		//		pview.setJoinMeanCold(joinStatsCold.getMean());
		//		pview.setJoinMeanWarm(joinStatsWarm.getMean());
		//		
		//		
		//		System.out.println(pview);
		//		System.out.println(epview);
		//		_db.update(pview);
		//		_db.update(epview);
		//		
		//		return true;
	}
    
	public RDFNode executeQuery(String endpointURL, String queryText) {
		Query query = QueryFactory.create(queryText);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpointURL, query);
		RDFNode node = null;
		try {
		    ResultSet results = qexec.execSelect();
		    if(results.hasNext()){
			QuerySolution thisRow = results.next();
			node = ((RDFNode) thisRow.get("value"));
		    }
		}
		catch (Exception e) {
		    log.info("[Error executing SPARQL query for {}]", endpointURL);
		    log.info("[Error details: {}]", e.toString());
		}
		qexec.close() ;
		return node;
	}

	public double calculateCoherence(String endpointUrl) {
		Set<String> types = getRDFTypes(endpointUrl);
		double weightedDenomSum = getTypesWeightedDenomSum(types, endpointUrl);
		double structuredness = 0;
		for(String type:types) {
			long occurenceSum = 0;
			Set<String> typePredicates = getTypePredicates(type, endpointUrl);
			long typeInstancesSize = getTypeInstancesSize(type, endpointUrl);
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
		ResultSet res = qExec.execSelect();
		while (res.hasNext())
			types.add(res.next().get("type").toString());
		return types;
	}

	public static double getTypesWeightedDenomSum(Set<String> types, String endpoint) {
		double sum = 0 ;
		for (String type:types)
		{
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
		ResultSet res= qExec.execSelect();
		while(res.hasNext())
			typeInstancesSize = Long.parseLong(res.next().get("cnt").asLiteral().getString());
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
		ResultSet res= qExec.execSelect();
		while(res.hasNext())
		{
			String predicate = res.next().get("typePred").toString();
			if (!predicate.equals("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"))
				typePredicates.add(predicate);
		}
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
		ResultSet res= qExec.execSelect();
		while(res.hasNext())
			predicateOccurences = Long.parseLong(res.next().get("occurences").asLiteral().getString());
		return predicateOccurences;
	}

	private DiscoverabilityView getView(Endpoint ep) {
		DiscoverabilityView view =null;
		List<DiscoverabilityView> views = new ArrayList<DiscoverabilityView>();
		if (_db  != null){
			views = _db.getResults(ep,DiscoverabilityView.class, DiscoverabilityView.SCHEMA$);
		}
		if(views.size()!=1){
			Log.warn("We have {} FeatureView, expected was 1",views.size());
		}
		if(views.size()==0){
			view = new DiscoverabilityView();
			view.setEndpoint(ep);
			view.setSD(false);
			view.setVoID(false);
			view.setServerName("missing");
			view.setLastUpdate(-1L);
			if (_db  != null)
				_db.insert(view);
		}else{
			view = views.get(0);
		}
		return view;
	}

    	private Profile getProfileView(Endpoint ep) {
		Profile view =null;
		List<Profile> views = new ArrayList<Profile>();
		if (_db  != null){
			views = _db.getResults(ep,Profile.class, Profile.SCHEMA$);
		}
		if(views.size()!=1){
			Log.warn("We have {} Profiles, expected was 1",views.size());
		}
		if(views.size()==0){
			view = new Profile();
			view.setEndpoint(ep);
			view.setSD("");
			view.setVoID("");
			view.setLastUpdate(-1L);
			if (_db  != null)
				_db.insert(view);
		}else{
			view = views.get(0);
		}
		return view;
	}
}
