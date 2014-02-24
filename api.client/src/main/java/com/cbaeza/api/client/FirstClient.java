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
	private static final char[] HEXADECIMAL_ALPHABET = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	public final static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {

			MessageDigest hash = MessageDigest.getInstance("SHA-1");
			String password = convertToHex(hash.digest("test".getBytes("UTF-8")));

			HttpPost httpPost = new HttpPost("http://localhost:8181/server-api/rest/users/authenticate/dummy/" + password);//a94a8fe5ccb19ba61c4c0873d391e987982fbbd3");
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

			String responseBody = httpclient.execute(httpPost, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		} finally {
			httpclient.close();
		}
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
