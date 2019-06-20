package com.demo.demoecommerceapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.demo.demoecommerceapp.R;
import com.demo.demoecommerceapp.Utilitiees.URLs;

import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        callApi();

        return rootView;
    }


    public void callApi() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URLs.server_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        getResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        // add it to the RequestQueue
        queue.add(jsonObjectRequest);

    }


    public void getResponse(JSONObject jsonObject){
        try {
            JSONObject responseJson = new JSONObject(jsonObject.toString());
            Log.e("TeamAFragment","getting responseObject "+responseJson.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
