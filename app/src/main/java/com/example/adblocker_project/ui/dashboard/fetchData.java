package com.example.adblocker_project.ui.dashboard;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData  extends AsyncTask<Void, Void, Void> {
     String data = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://192.168.0.212/admin/api.php?list=black&auth=5d9f7e5ddf10edf982ec633865fd5267701851da575772732323f513b6f211bc");
            HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line!=null){
                line = bufferedReader.readLine();
                data = data + line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        DashboardFragment.personNames.add(this.data);
    }
}
