package sbk.unisannio.com.socialbikekeeper;

/**
 * Created by Admin on 03/11/2017.
 */


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

class Invia extends AsyncTask<String, String,String> {
    String result=null;
    InputStream is;
    StringBuilder sb;

    String url;

    public Invia(String url) {
        this.url=url;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse resp;
        try {
            resp = httpclient.execute(new HttpGet(url));
            HttpEntity entity = resp.getEntity();
            is = entity.getContent();
            if (is!=null) {
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    is.close();
                    result=sb.toString();
                }catch(Exception e){
                    Log.e("TEST", "Errore nel convertire il risultato "+e.toString());
                }
            }
        }
        catch(Exception e){
            Log.e("TEST","errore nella p... "+e.toString());
        }
        return result;
    }

}