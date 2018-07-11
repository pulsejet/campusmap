package com.mrane.data;

 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
 
public class ServiceHandler {

    public final static int GET = 1;

    /**
     * Making service call
     * @url - url to make request
     * @method - http request method
     * */
    public String makeServiceCall(String url, int method) {
        return this.makeServiceCall(url, method, null);
    }
 
    /**
     * Making service call
     * @url - url to make request
     * @method - http request method
     * @params - http request params
     * */
    public String makeServiceCall(String url, int method,
            Object params) {
        return "BLAHBLAH";
    }
}