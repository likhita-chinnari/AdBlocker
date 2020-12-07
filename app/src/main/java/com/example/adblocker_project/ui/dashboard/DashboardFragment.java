package com.example.adblocker_project.ui.dashboard;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adblocker_project.MainActivity;
import com.example.adblocker_project.R;
import com.example.adblocker_project.ui.notifications.NotificationsViewModel;

import java.lang.reflect.Array;
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
    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = ViewModelProviders.of(this)
                .get(DashboardViewModel.class);
         root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        Button bt = (Button) root.findViewById(R.id.button);
        final ArrayList<String> personNames = new ArrayList<>(Arrays.asList(" "));
        //"Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"
        final EditText ed = (EditText) root.findViewById(R.id.editText2);

        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String temp = ed.toString();
                personNames.add(temp);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(personNames);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
         return root;
    }


}
