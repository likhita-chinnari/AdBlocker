package com.example.adblocker_project.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adblocker_project.R;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends Fragment {

    public static final int timeout = 3000;
    public static final String TAG = "HomeFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        Button button = (Button) root.findViewById(R.id.button2);
        final EditText etIPAddress = root.findViewById(R.id.editText);
        final TextView status = (TextView) root.findViewById(R.id.connection_status);
        final TextView textView = (TextView) root.findViewById(R.id.connection_status);
        final RequestQueue queue = Volley.newRequestQueue(getActivity());
        String ipAddress = etIPAddress.getText().toString();
        /*
        TODO: `url` variable cannot be final as it won't work with providing input dynamically
        */
        final String url = "http://192.168.0.212/admin/api.php";
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String status = response.getString("status");
                                    if (status.equals("enabled")){
                                        textView.setText(R.string.server_active);
                                    } else {
                                        textView.setText(R.string.server_inactive);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error

                                Toast.makeText(getContext(),
                                        "Trouble connectiong, Try again later",
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                queue.add(jsonObjectRequest);
            }
        });
        return root;
    }
}