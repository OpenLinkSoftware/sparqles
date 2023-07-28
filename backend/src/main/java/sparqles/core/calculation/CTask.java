package sparqles.core.calculation;

import sparqles.avro.Endpoint;
import sparqles.avro.EndpointResult;
import sparqles.core.EndpointTask;
import sparqles.avro.calculation.CResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CTask extends EndpointTask<CResult> {
    private static final Logger log = LoggerFactory.getLogger(CTask.class);
    
    public CTask(Endpoint ep) {
	super(ep);
    }
    
    @Override
    public CResult process(EndpointResult epr) {
	CResult result = new CResult();
	result.setEndpointResult(epr);
	log.debug("execute {}", _epURI);

	//TODO:
	result.setTriples(0);
	result.setEntities(0);
	result.setClasses(0);
	result.setProperties(0);
	result.setDistinctSubjects(0);
	result.setDistinctObjects(0);
	java.util.List<java.lang.CharSequence> list = new java.util.ArrayList<java.lang.CharSequence>();
	result.setExampleResources(list);
	result.setVoID("test");
	result.setSD("");
	result.setCoherence(0.5);
	result.setRS(0.3);
	
	log.info("executed {}", this);
	
	return result;
    }

}
