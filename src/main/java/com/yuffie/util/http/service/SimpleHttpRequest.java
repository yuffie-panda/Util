package com.yuffie.util.http.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.yuffie.util.http.entity.ResponseEntity;

/**
 * 简单Http POST和GET请求封装(Package the simple HTTP REQUEST, include POST and GET)
 * 
 * @author Yuffie
 * @modifiedDate 2015-4-21
 * 
 */
public class SimpleHttpRequest {
	
	/**
	 * http POST
	 * 
	 * @param url
	 * @param args
	 * 			request param
	 * @return ResponseEntity
	 */
	public ResponseEntity httpPost(String url, String args) {
		return httpPost(url, args, "");
	}
	
	/**
	 * http GET
	 * 
	 * @param url
	 * 			include http path and http query
	 * @return ResponseEntity
	 */
	public ResponseEntity httpGet(String url) {
		return httpGet(url, "");
	}
	
	/**
	 * http POST
	 * 
	 * @param url
	 * @param args
	 * 			request param
	 * @param contenttype
	 * @return ResponseEntity
	 */
	public ResponseEntity httpPost(String url, String args, String contenttype) {
		try {
			HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(
					url).openConnection();
			httpURLConnection.setRequestMethod("POST");
			if (contenttype != null && !contenttype.equals("")) {
				httpURLConnection.setRequestProperty("Content-Type", contenttype);
			}
			if (args != null && !args.equals("")) {
				httpURLConnection.setDoOutput(true);
				httpURLConnection.getOutputStream().write(args.getBytes());
			}
			int responseCode = httpURLConnection.getResponseCode();
			BufferedInputStream bis = new BufferedInputStream(
					httpURLConnection.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					bis, "UTF-8"));
			StringBuffer strbuf = new StringBuffer();
			String str = null;
			while ((str = reader.readLine()) != null) {
				strbuf.append(str);
			}
			ResponseEntity entity = new ResponseEntity();
			entity.setResponseCode(responseCode);
			entity.setResponseData(strbuf.toString());
			return entity;
		} catch (Exception ex) {
			return new ResponseEntity();
		}
	}
	
	/**
	 * http GET
	 * 
	 * @param url
	 * 			include http path and http query
	 * @param contenttype
	 * @return ResponseEntity
	 */
	public ResponseEntity httpGet(String url, String contenttype) {
		try {
			HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(
					url).openConnection();
			httpURLConnection.setRequestMethod("GET");
			if (contenttype != null && !contenttype.equals("")) {
				httpURLConnection.setRequestProperty("Content-Type", contenttype);
			}
			int responseCode = httpURLConnection.getResponseCode();
			BufferedInputStream bis = new BufferedInputStream(
					httpURLConnection.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					bis, "UTF-8"));
			StringBuffer strbuf = new StringBuffer();
			String str = null;
			while ((str = reader.readLine()) != null) {
				strbuf.append(str);
			}
			ResponseEntity entity = new ResponseEntity();
			entity.setResponseCode(responseCode);
			entity.setResponseData(strbuf.toString());
			return entity;
		} catch (Exception ex) {
			return new ResponseEntity();
		}
	}
}
