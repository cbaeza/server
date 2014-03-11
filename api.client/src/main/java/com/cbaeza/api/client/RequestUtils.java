package com.cbaeza.api.client;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.cbaeza.model.commons.ws.authentication.WSAuthentication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * User: cbaeza Since: 10.03.14
 */
public class RequestUtils {

	private static final char[] HEXADECIMAL_ALPHABET = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
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
					WSAuthentication wsAuthentication = fromJson(entity.getContent(), WSAuthentication.class);
					return entity != null ? toJson(wsAuthentication) : null;
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
		System.out.println("\n----------------------------------------");
		System.out.println(responseBody);
		System.out.println("----------------------------------------\n");

	}

	public static <T> T fromJson(String json, Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(json.getBytes("UTF-8"), clazz);
		} catch (IOException e) {
			throw new RuntimeException("Exception deserializing object with of class: " + clazz + " and json: " + json);
		}
	}

	public static <T> T fromJson(InputStream inputStream, Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(inputStream, clazz);
		} catch (IOException e) {
			throw new RuntimeException("Exception deserializing object with of class: " + clazz + " and strem: " + inputStream);
		}
	}

	public static String toJson(Object o) {
		try {
			return new ObjectMapper().writeValueAsString(o);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Exception serializing object: " + o);
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
