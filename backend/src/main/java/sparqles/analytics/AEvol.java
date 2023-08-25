package sparqles.analytics;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import sparqles.avro.Endpoint;
import sparqles.core.SPARQLESProperties;
import sparqles.paper.objects.AMonth;
import sparqles.paper.objects.AvailEpFromList;
import sparqles.utils.MongoDBManager;

import com.google.gson.Gson;
import com.mongodb.MongoClient;

public class AEvol  {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new AEvol(args);
	}
	
	public AEvol(String[] args) {
		try {
			Gson gson = new Gson();
			
			SPARQLESProperties.init(new java.io.File("src/main/resources/sparqles_docker.properties"));

			//read the list of endpoints
			MongoDBManager dbm = new MongoDBManager();
			Collection<Endpoint> eps = dbm.get(Endpoint.class, Endpoint.SCHEMA$);
			
			
			//check if there is any stat to run or if it is up to date
			//open connection to mongodb aEvol collection			
			Jongo jongo = new Jongo(new MongoClient(SPARQLESProperties.getDB_HOST()+":"+SPARQLESProperties.getDB_PORT()).getDB(SPARQLESProperties.getDB_NAME()));
			MongoCollection amonthsColl = jongo.getCollection(MongoDBManager.COLL_AMONTHS);
			//get last month
			AMonth lastMonth = amonthsColl.findOne().orderBy("{date: -1}").as(AMonth.class);
			Calendar cal = Calendar.getInstance();
			Calendar calNow = Calendar.getInstance();
			if (lastMonth == null) {
			    cal.setTimeInMillis((dbm.getFirstAvailabitlityTime()/1000) * 1000);
			    cal.set(Calendar.DAY_OF_MONTH, 1);
			    cal.set(Calendar.HOUR, 0);
			    cal.set(Calendar.MINUTE, 0);
			    cal.set(Calendar.SECOND, 0);
			}
			else {
			    cal.setTime(lastMonth.getDate());
			    cal.add(Calendar.MONTH, 1);
			}
		    
		    //in case there is at least a full new month to process
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(calNow.get(Calendar.MONTH)>cal.get(Calendar.MONTH)){
				//get the end of the month
				Calendar calEnd = (Calendar) cal.clone();
				calEnd.add(Calendar.MONTH, 1);
				System.out.println("Computing month aggregation from date ["+sdf.format(cal.getTime())+" to "+sdf.format(calEnd.getTime())+"[");
								
				//String json = readUrl("https://sparqles.demo.openlinksw.com/api/endpoint/lis");
				//AvailEpFromList[] epArray = gson.fromJson(json, AvailEpFromList[].class);
				MongoCollection atasksColl = jongo.getCollection(MongoDBManager.COLL_AVAIL);
//				System.out.println(atasksColl.count("{'endpointResult.start': {$gt : #}}", cal.getTimeInMillis()));
				
				AMonth newMonth = new AMonth();
				newMonth.setDate(cal.getTime());
				
				//for each endpoint in the collection
				for (Endpoint e : eps) {
					//get number of avail and unavail tests
					long nbAvail = atasksColl.count("{'endpointResult.endpoint.uri': '"+e.getUri()+"', 'isAvailable':true, 'endpointResult.start': {$gte : "+cal.getTimeInMillis()+", $lt : "+calEnd.getTimeInMillis()+"}}}");
					long nbUnavail = atasksColl.count("{'endpointResult.endpoint.uri': '"+e.getUri()+"', 'isAvailable':false, 'endpointResult.start': {$gte : "+cal.getTimeInMillis()+", $lt : "+calEnd.getTimeInMillis()+"}}}");
					newMonth.addEndpoint(nbAvail, nbUnavail);
				}
				
				//add the new month to the collection
				amonthsColl.insert(newMonth);
				
				//increment the month to process
				cal.add(Calendar.MONTH, 1);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
}
