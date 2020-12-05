package com.example.adblocker_project.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adblocker_project.MainActivity;
import com.example.adblocker_project.R;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    RecyclerView recyclerView;
    MyListAdapter rvAdapter;
    EditText itemEditText;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView = (RecyclerView)root.findViewById(R.id.recyclerView);
        itemEditText = (EditText) root.findViewById(R.id.editText);

        //Setting the layout and Adapter for RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        rvAdapter = new Adapter(rvAdapter);
        recyclerView.setAdapter(rvAdapter);

        public void onAddButtonClicked(View view) {

            try {
                int IntegerFormat = Integer.valueOf(itemEditText.getText().toString());
                itemList.add(IntegerFormat);
                rvAdapter.notifyItemInserted(itemList.size() - 1);
                itemEditText.setText("");
            } catch(NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "The field is empty",
                        Toast.LENGTH_SHORT).show();
            }
        }

        return root;
    }
}