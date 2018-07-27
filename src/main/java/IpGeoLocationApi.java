import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class IpGeoLocationApi {
    private String apiKey;

    IpGeoLocationApi(String apiKey) {
        this.apiKey = apiKey;
    }

    public Map getTimeZone(Map<String, String> parameters){
        return getIpGeoLocation(parameters, "/timezone");
    }

    public Map getTimeZone(){
        return getIpGeoLocation(null, "/timezone");
    }

    public Map getIpGeo(Map<String, String> parameters){
        return getIpGeoLocation(parameters, "/ipgeo");
    }

    public Map getIpGeo(){
        return getIpGeoLocation(null, "/ipgeo");
    }

    public Map getIpGeoLocation(Map<String, String> parameters, String subUrl){
        String query = buildQuery(parameters);
        if (query != null) {
            return openConnection(getIpGeoLocationURL()+subUrl+"?"+query);
        }
        return getBadRequestResponse();
    }

    public Map<String, String> openConnection(String link){
        URI uri = null;
        ClientResponse response = null;
        try {
            uri = getURI(link);
            Client client = Client.create();
            WebResource webResource = client.resource(uri);
            response = webResource.accept("application/json").get(ClientResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponse(response);
    }

    public URI getURI(String link){
        URL url = null;
        URI uri = null;
        try{
            url = new URL(link);
            uri = new URI(link);
        } catch(URISyntaxException e) {
            try {
                uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(),
                        url.getPort(), url.getPath(), url.getQuery(),
                        url.getRef());
            } catch(URISyntaxException e1) {
                e1.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return uri;
    }

    public Map<String, String> getResponse(ClientResponse response){
        Map<String, String> map = null;
        ObjectReader reader = new ObjectMapper().reader(Map.class);
        String output = response.getEntity(String.class);

        try {
            map = reader.readValue(output);
            map.put("status", String.valueOf(response.getStatus()));
            System.out.println(map.toString());
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public String buildQuery(Map<String, String> parameters){
        String query = "";
        String ip = null;
        String fields = null;
        String tz = null;
        if(parameters != null){
            ip = parameters.get("ip") != null ? parameters.get("ip") : "";
            fields = parameters.get("fields") !=null ? parameters.get("fields") : "";
            tz = parameters.get("tz") !=null ? parameters.get("tz") : "";
        }

        if(this.apiKey != null && this.apiKey.trim().length()>0){
            query = "apiKey="+this.apiKey;
            if(ip != null && ip.trim().length()>0){
                query = query + ("&ip="+ip);
            }
            if(fields != null && fields.trim().length()>0){
                query = query + ("&fields="+ fields);
            }
            if(tz != null && tz.trim().length()>0){
                query = query + ("&tz="+tz);
            }

        }
        return query;
    }

    public Map getBadRequestResponse(){
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "404");
        response.put("message", "Incorrect paramater");
        return response;
    }

    public String getIpGeoLocationURL(){
        return "https://api.ipgeolocation.io";
    }
}
