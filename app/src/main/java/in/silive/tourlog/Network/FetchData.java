package in.silive.tourlog.Network;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import in.silive.tourlog.Utils.Config;

/**
 * Created by akriti on 3/3/17.
 */

public class FetchData extends AsyncTask<Void, Void, String> {

    public String request_url;
    public URL sURL;
    public HttpURLConnection sHttpURLConnection;
    public Context scontext;
    public BufferedReader sBufferedReader;
    public ProgressDialog sprogressDialog;
    public String sJsonResponse;
    int anInt;

    public FetchData(int in, Context scontext, String req_url) {
        this.anInt = in;
        this.scontext = scontext;
        this.request_url = req_url;
        this.sprogressDialog = new ProgressDialog(scontext);
    }

    @Override
    protected String doInBackground(Void... voids) {
        boolean c = new CheckNetworkConnection(scontext).check_connection();
        if (c) {
            try {
                sURL = new URL("http://dev-api.shortfundly.com/" + request_url);
                sHttpURLConnection = (HttpURLConnection) sURL.openConnection();
                Log.d("TAG", "url : " + sURL);
                Log.d("TAG", "connection");
                sHttpURLConnection.setRequestMethod("GET");
                sHttpURLConnection.setRequestProperty("X-API-Key", Config.API_KEY);
                Log.d("TAG", "connection req property get");
                sHttpURLConnection.connect();
                Log.d("TAG", "connection estb");
                sBufferedReader = new BufferedReader(new InputStreamReader(sHttpURLConnection.getInputStream()));
                Log.d("TAG", "buff readr");
                HttpHandler sh = new HttpHandler();
                sJsonResponse = sh.makeServiceCall("http://api.shortfundly.com/" + request_url);
                Log.d("FetchData", "Recieved" + sJsonResponse);
            } catch (Exception e) {
                Log.d("TAG", "NO connection");

                e.printStackTrace();
            }
        } else {
            Toast.makeText(scontext, "No connection", Toast.LENGTH_SHORT).show();
        }

        return sJsonResponse;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        parseData(s);
        //sprogressDialog.dismiss();

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       /* sprogressDialog.setMessage("Loading");
        sprogressDialog.show();*/
    }


    public void parseData(String s) {

        try {
            Log.d("TAG", "try-block parsing");
            JSONObject jsonObject = new JSONObject(s);
            JSONArray sjsonArray = jsonObject.getJSONArray("results");

            Log.d("TAG", "JSON array fetched");
            for (int i = 0; i < sjsonArray.length(); i++) {
                JSONObject s_list = sjsonArray.getJSONObject(i);

                Log.d("TAG", "Item added");

            }


        } catch (Exception e) {
            Log.d("TAG", "Printing stack trace : " + "\n\n");
            e.printStackTrace();
            Log.d("TAG", "Parsing not working");
        }
    }

}
