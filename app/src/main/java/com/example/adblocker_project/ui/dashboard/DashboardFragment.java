package com.example.adblocker_project.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adblocker_project.R;

public class DashboardFragment extends Fragment {

    RecyclerView recyclerView;
    MyListAdapter rvAdapter;
    EditText itemEditText;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = ViewModelProviders.of(this)
                .get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView = (RecyclerView)root.findViewById(R.id.recyclerView);
        itemEditText = (EditText) root.findViewById(R.id.editText);

        //Setting the layout and Adapter for RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        rvAdapter = new MyListAdapter();
        recyclerView.setAdapter(rvAdapter);

//        public void onAddButtonClicked(View view) {
//
//            try {
//                int IntegerFormat = Integer.valueOf(itemEditText.getText().toString());
//                itemList.add(IntegerFormat);
//                rvAdapter.notifyItemInserted(itemList.size() - 1);
//                itemEditText.setText("");
//            } catch(NumberFormatException e) {
//                Toast.makeText(getApplicationContext(), "The field is empty",
//                        Toast.LENGTH_SHORT).show();
//            }
//        }

        return root;
    }
}
