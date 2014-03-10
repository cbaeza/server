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
 * Since: 10.03.14
 */
public class RequestUtils {

    private static final char[] HEXADECIMAL_ALPHABET = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static void authenticate(String userID, String password) {

        MessageDigest hash = null;
        try {
            hash = MessageDigest.getInstance("SHA-1");
            password = RequestUtils.convertToHex(hash.digest("test".getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpPost httpPost = new HttpPost(Endpoints.HOST + Endpoints.APP + String.format(Endpoints.USER_AUTHENTICATE, userID, password.toString()));

        httpPost.addHeader("Accept", "application/json");
        System.out.println("Executing request " + httpPost.getRequestLine());

        // Create a custom response handler
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

            public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };

        String responseBody = null;
        try {
            responseBody = httpclient.execute(httpPost, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------");
        System.out.println(responseBody);
    }


    public static String convertToHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = HEXADECIMAL_ALPHABET[(0xF0 & data[i]) >>> 4];
            out[j++] = HEXADECIMAL_ALPHABET[0x0F & data[i]];
        }
        return new String(out);
    }
}
