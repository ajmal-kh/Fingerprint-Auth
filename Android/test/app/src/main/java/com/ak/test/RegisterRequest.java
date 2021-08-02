package com.ak.test;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL ="https://httpsajmalappcom.000webhostapp.com/register2.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String username, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
