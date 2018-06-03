package com.bassanidevelopment.santiago.hci_movil.API;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;


import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class APIController {



    private String baseUrl;
    private RequestQueue queue;
    private String headers;

    public APIController(String baseUrl, String headers, Context context)
    {

        this.baseUrl = baseUrl;
        this.headers = headers;
        this.queue = Volley.newRequestQueue(context);

    }


    public JSONObject getRequest(String query )
    {
        RequestFuture<JSONObject> requestFuture= RequestFuture.newFuture();
        JSONObject response = null;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, this.baseUrl+query,
                                new JSONObject(), requestFuture,requestFuture);
        queue.add(request);

        try {
            response = requestFuture.get(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch(ExecutionException e)
        {
            e.printStackTrace();
        }
        catch(TimeoutException e)
        {
            e.printStackTrace();
        }
        return response;
    }

    public JSONObject putRequest(String query , JSONObject model)
    {
        RequestFuture<JSONObject> requestFuture= RequestFuture.newFuture();
        JSONObject response = null;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, this.baseUrl+query,
                model, requestFuture,requestFuture);
        queue.add(request);

        try {
            response = requestFuture.get(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch(ExecutionException e)
        {
            e.printStackTrace();
        }
        catch(TimeoutException e)
        {
            e.printStackTrace();
        }
        return response;
    }


    public JSONObject postRequest(String query , JSONObject model)
    {
        RequestFuture<JSONObject> requestFuture = RequestFuture.newFuture();
        JSONObject response = null;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, this.baseUrl+query,
                model, requestFuture,requestFuture);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, this.baseUrl+query, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        queue.add(jsonObjectRequest);

        try {
            response = requestFuture.get(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch(ExecutionException e)
        {
            e.printStackTrace();
        }
        catch(TimeoutException e)
        {
            e.printStackTrace();
        }
        return response;
    }


    public JSONObject deleteRequest(String query)
    {
        RequestFuture<JSONObject> requestFuture= RequestFuture.newFuture();
        JSONObject response = null;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, this.baseUrl+query,
                new JSONObject(), requestFuture,requestFuture);
        queue.add(request);

        try {
            response = requestFuture.get(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch(ExecutionException e)
        {
            e.printStackTrace();
        }
        catch(TimeoutException e)
        {
            e.printStackTrace();
        }
        return response;
    }




}
