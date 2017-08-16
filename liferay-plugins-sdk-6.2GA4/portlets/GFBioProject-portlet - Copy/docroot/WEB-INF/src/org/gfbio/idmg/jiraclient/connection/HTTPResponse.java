package org.gfbio.idmg.jiraclient.connection;

public class HTTPResponse {

	private Integer responseCode;
    private String responseMessage;
    private String location;
    private String response;

    public HTTPResponse(Integer responseCode, String response) {
        this.responseCode = responseCode;
        this.response = response;
    }

    public HTTPResponse(Integer responseCode, String responseMessage, String response) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.response = response;
    }
    
    public HTTPResponse(Integer responseCode, String responseMessage, String location, String response) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.location = location;
        this.response = response;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
