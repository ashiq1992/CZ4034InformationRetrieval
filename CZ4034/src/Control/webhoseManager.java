package Control;

import java.io.IOException;
import java.util.ArrayList;
//solr imports to get the data
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import Model.Webhose;

public class webhoseManager {

	public webhoseManager(){
		
	}
	
	//get the searched results and passess it to the servlet
	public ArrayList<Webhose> getwebhoseResult(String searchInput ,String queryParameters) {
	String urlString = "http://localhost:8983/solr/webhose";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	
	SolrQuery query = new SolrQuery();

	query.set("q","text:("+searchInput+") ");
	query.set("{!func}mul(tf(text,"+searchInput+"),idf(text,"+searchInput+"))","");

	query.addSort("score", ORDER.desc);
	query.setRows(5000);
	QueryResponse qResponse = null;
	try {
		qResponse = solr.query(query);
	} catch (SolrServerException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	 

	SolrDocumentList docList = qResponse.getResults();
	
	
	
	ArrayList<Webhose> webhose = new ArrayList<Webhose>();
	for(int i=0;i<docList.size();i++)
	{
		Webhose webhoseModel = new Webhose();

		webhoseModel.setUrl(docList.get(i).getFieldValue("url").toString());
		if(docList.get(i).getFieldValue("author")==null) {
			webhoseModel.setAuthor("");
		}
		else {
			webhoseModel.setAuthor(docList.get(i).getFieldValue("author").toString());
		}
		String[] text=docList.get(i).getFieldValue("text").toString().split(".");
		//System.out.println(docList.get(i).getFieldValue("text").toString());
		webhoseModel.setText(docList.get(i).getFieldValue("text").toString());
		if(docList.get(i).getFieldValue("title")==null) {
			webhoseModel.setTitle("Nill");
		}
		else {
			webhoseModel.setTitle(docList.get(i).getFieldValue("title").toString());
		}
		System.out.println((docList.get(i).getFieldValue("author")));
		//webhoseModel.setAuthor("Test");
		
		webhose.add(webhoseModel);
	}
	
	return webhose;
	}
	protected class QESXMLResponseParser extends XMLResponseParser {
	    public QESXMLResponseParser() {
	        super();
	    }

	    @Override
	    public String getContentType() {
	        return "text/xml; charset=UTF-8";
	    }
	}
	public static void main(String arg[]) {
		webhoseManager temp=new webhoseManager();
		ArrayList<Webhose> webhose =temp.getwebhoseResult("air india worst customer service", "");
		for (int i=0;i<webhose.size();i++) {
			System.out.println(webhose.get(i).getText());
		}
	}

}
