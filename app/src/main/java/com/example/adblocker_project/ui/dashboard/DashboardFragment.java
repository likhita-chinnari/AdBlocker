package com.example.adblocker_project.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adblocker_project.R;

import java.util.ArrayList;
import java.util.Arrays;

//public class DashboardFragment extends Fragment {
//
//
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.fragment_dashboard);
//
//        // Lookup the recyclerview in activity layout
//        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
//
//        // Initialize contacts
//        contacts = Contact.createContactsList(20);
//        // Create adapter passing in the sample user data
//        ContactsAdapter adapter = new ContactsAdapter(contacts);
//        // Attach the adapter to the recyclerview to populate items
//        rvContacts.setAdapter(adapter);
//        // Set layout manager to position the items
//        rvContacts.setLayoutManager(new LinearLayoutManager(this));
//        // That's all!
//
//        //1. Enter the text and get it
//        //2. Null or empty check
//        //3. Add the string to the ContactsAdapter array list
//        //4. Pass the list to the recycler view
//
//
//    }
//}

public class DashboardFragment extends Fragment{
    View root;
    public static ArrayList<String> personNames = new ArrayList<>(Arrays.asList(" "));
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = ViewModelProviders.of(this)
                .get(DashboardViewModel.class);
        root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // fetching and displaying database info---------------------------------------------------
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        fetchData process = new fetchData();
         process.execute();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CustomAdapter customAdapter = new CustomAdapter(personNames);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
        //---------------------------------------------------------------------------------------
        //adding edittext value to database-----------------------------------------
        final EditText ed = (EditText) root.findViewById(R.id.editText2);
        final RequestQueue queue = Volley.newRequestQueue(getActivity());
        final String url ="http://192.168.0.212/admin/api.php?list=black&add=me.com&auth=5d9f7e5ddf10edf982ec633865fd5267701851da575772732323f513b6f211bc";
        Button bt = (Button) root.findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String temp = ed.getText().toString();
                ed.setText("");
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(stringRequest);
            }
        });

        return root;
    }
    //-----------------------------------------------------------------------------------------------

}
