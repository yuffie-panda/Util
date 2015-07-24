package com.yuffie.util.http.entity;

/**
 * http response Entity
 * <p>用来组织需要的Http请求的返回值(To generate the http response data which needed)
 * <p><Strong>参数(params)：</Strong>responseData, responseCode
 * 
 * @author Yuffie
 * 
 */
public class ResponseEntity {

	// response data
	private String responseData;

	// http status, default -1
	private int responseCode = -1;

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
}