package Util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class TwitterUtil {
    private static final String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAMNlRAEAAAAAGvhVUO4aPIf%2F5CeWXFKvmaLUIQQ%3DpgumI8KAugMd8FwM2MSxl3wPWdS26bs7JVvAQr0wfQuDeHmWWC";
    
    public Integer getComplaintCount(String query) throws URISyntaxException, IOException, ParseException {
        Integer complaintCount = 0;
        
        DateUtil dateUtil = new DateUtil();
        String searchResponse = null;

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();

        URIBuilder uriBuilder = new URIBuilder("https://api.twitter.com/2/tweets/search/recent");
        ArrayList<NameValuePair> queryParameters;
        queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("query", query));
        queryParameters.add(new BasicNameValuePair("tweet.fields", "author_id"));
        queryParameters.add(new BasicNameValuePair("max_results", "100"));
        queryParameters.add(new BasicNameValuePair("start_time", dateUtil.getISODate()));
        uriBuilder.addParameters(queryParameters);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", String.format("Bearer %s", BEARER_TOKEN));
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            searchResponse = EntityUtils.toString(entity, "UTF-8");
        }
        
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(searchResponse);
        object = (JSONObject) object.get("meta");
        
        try {
            complaintCount = ((Long) object.get("result_count")).intValue();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return complaintCount;
    } 
}