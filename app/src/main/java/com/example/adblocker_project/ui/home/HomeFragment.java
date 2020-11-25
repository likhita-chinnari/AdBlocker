package com.example.adblocker_project.ui.home;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.adblocker_project.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

import static android.content.ContentValues.TAG;
import static android.content.Context.CONNECTIVITY_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public static final int timeout = 3000;
    public static final String TAG = "HomeFragment";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        Button button = (Button) root.findViewById(R.id.button2);
        EditText txtname = root.findViewById(R.id.editText);
        final String name  =  txtname.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isConnected(name,10000))
                    Toast.makeText(getActivity(),"Connected", Toast.LENGTH_SHORT).show();
                 else
                    Toast.makeText(getActivity(),"Unable to Connect", Toast.LENGTH_SHORT).show();

            }
        });



        return root;
    }

    public boolean isConnected(String url, int timeout) {
//        try {
//            URL serverURL = new URL(url);
//            URLConnection urlconn = serverURL.openConnection();
//            urlconn.setConnectTimeout(timeout);
//            urlconn.connect();
//            return true;
//        } catch (IOException e) {
//            Log.e(TAG, e.getLocalizedMessage(), e);
//        } catch (IllegalStateException e) {
//            Log.e(TAG, e.getLocalizedMessage(), e);
//        }
//        return false;
        boolean reachable = true;

        try {
            reachable = InetAddress.getByName(url).isReachable(10000);
        } catch (IOException e) {
            e.printStackTrace();
            reachable = false;
        }

        return reachable;
    }

}