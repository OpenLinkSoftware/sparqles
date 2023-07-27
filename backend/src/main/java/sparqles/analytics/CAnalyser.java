package sparqles.analytics;

import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sparqles.avro.Endpoint;
import sparqles.avro.analytics.CalculationView;
import sparqles.avro.calculation.CResult;
import sparqles.core.calculation.CTask;
import sparqles.utils.MongoDBManager;


public class CAnalyser extends Analytics<CResult> {
	private static final Logger log = LoggerFactory.getLogger(CAnalyser.class);


	public CAnalyser(MongoDBManager db) {
		super(db);
	}

	@Override
	public boolean analyse(CResult pres) {
		log.info("[Analytics] {}",pres.getEndpointResult().getEndpoint());

		Endpoint ep = pres.getEndpointResult().getEndpoint();

		CalculationView cview= getView(ep);

		cview.setVoID(pres.getVoID()!="");
		cview.setSD(pres.getSD()!="");
		cview.setCoherence(pres.getCoherence());
		cview.setRS(pres.getRS());

		cview.setLastUpdate(pres.getEndpointResult().getEnd());
		
		_db.update(cview);
		
		return true;
	}
    
    	private CalculationView getView(Endpoint ep) {
		CalculationView view = null;
		List<CalculationView> views = new ArrayList<CalculationView>();
		if (_db  != null){
			views = _db.getResults(ep,CalculationView.class, CalculationView.SCHEMA$);
		}
		if(views.size()!=1){
			log.warn("We have {} CalculationView, expected was 1",views.size());
		}
		if(views.size()==0){
			view = new CalculationView();
			view.setEndpoint(ep);
			view.setSD(false);
			view.setVoID(false);
			view.setCoherence(-1.0);
			view.setRS(-1.0);
			view.setLastUpdate(-1L);
			if (_db  != null)
				_db.insert(view);
		}else{
			view = views.get(0);
		}
		return view;
	}
}
