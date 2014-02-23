package com.cbaeza.api.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.MessageDigest;

/**
 * User: cbaeza
 * Since: 23.02.14
 */
public class FirstClient {

    public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            final byte[] digest = md.digest("test".getBytes("UTF-8"));

            String password = new String(digest, "UTF-8");

            HttpPost httpPost = new HttpPost("http://localhost:8080/server-api/rest/users/authenticate/dummy/" + password);//a94a8fe5ccb19ba61c4c0873d391e987982fbbd3");
            httpPost.addHeader("Accept", "application/json");

            System.out.println("Executing request " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };

            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
    }

}
