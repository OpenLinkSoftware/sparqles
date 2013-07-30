package core.discovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.Endpoint;
import core.EndpointResult;
import core.Task;
import core.performance.PTask;

/**
 * DTaskGET: This task inspects the header and content after a HTTP GET on the endpoint URI. 
 * 
 * We perform the following checks:
 * 1) if the header contains any information about meta data for this endpoint
 * 2) if the endpoint returns any RDF content 
 * 3) if 2 succeeds, then check for vocabulary terms from either voiD or SPARQL1.1
 * @author UmbrichJ
 *
 */
public class DTask extends Task<DResult> {
	private static final Logger log = LoggerFactory.getLogger(DTask.class);
	
	public DTask(Endpoint ep) {
		super(ep);
	}
	
	@Override
	public DResult process(EndpointResult epr) {
		DResult result = new DResult();
		result.setEndpointResult(epr);
		
		log.debug("[RUN] {}", epr.getEndpoint().getUri().toString());
		
		int failures=0;
		GetResult res = SpecificDTask.newGetRun(epr.getEndpoint()).execute();
		result.setGetResult(res);
		
		try {
			Thread.sleep(WAITTIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		VoidResult vres= SpecificDTask.newSelfVoidRun(epr.getEndpoint()).execute();
		result.setVoidResult(vres);
		try {
			Thread.sleep(WAITTIME);
		} catch (InterruptedException e) {e.printStackTrace();}
		
		VoidResult vsres= SpecificDTask.newVoidStoreRun(epr.getEndpoint()).execute();
		result.setVoidStoreResult(vsres);
		
		
		if(res.getException()!=null)failures++;
		if(vres.getException()!=null)failures++;
		if(vsres.getException()!=null)failures++;
		
		if(failures==0)
			log.info("[SUCCESS] [SELECT] {}", epr.getEndpoint());
		else{
			Object [] s = { epr.getEndpoint().getUri().toString(), failures, 3}; 
			log.error("[RUN] {}: {}/{} failures",s);
		}
		return result;
	}
}