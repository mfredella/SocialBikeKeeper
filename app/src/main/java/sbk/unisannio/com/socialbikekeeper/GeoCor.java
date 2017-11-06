package sbk.unisannio.com.socialbikekeeper;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GeoCor extends AsyncTask<String, Void, String>{

	//	private String res[];
	public GeoCor(String value1, String value2) {
		// TODO Auto-generated constructor stub
		value1=this.value1;
		value2=this.value2;
	}
	protected String value1,value2;

	@Override
	protected String doInBackground(String... params) {
		try {
			URL url=new URL((String) params[0]);
			HttpURLConnection con= (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			int statuscode=con.getResponseCode();
			if(statuscode==HttpURLConnection.HTTP_OK)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuilder sb=new StringBuilder();
				String line=br.readLine();
				while(line!=null)
				{
					sb.append(line);
					line=br.readLine();
				}
				String json=sb.toString();
				Log.d("JSON",json);
				JSONObject root=new JSONObject(json);
				JSONArray array_rows=root.getJSONArray("rows");
				Log.d("JSON","array_rows:"+array_rows);
				JSONObject object_rows=array_rows.getJSONObject(0);
				Log.d("JSON","object_rows:"+object_rows);
				JSONArray array_elements=object_rows.getJSONArray("elements");
				Log.d("JSON","array_elements:"+array_elements);
				JSONObject  object_elements=array_elements.getJSONObject(0);
				Log.d("JSON","object_elements:"+object_elements);
				JSONObject object_duration=object_elements.getJSONObject("duration");
				JSONObject object_distance=object_elements.getJSONObject("distance");

				Log.d("JSON","object_duration:"+object_duration);
				Log.d("JSON","object_duration:"+object_duration.getString("value"));
				//  setDouble(object_duration.getString("value")+","+object_distance.getString("value"));
				setValue1(object_duration.getString("value"));
				setValue2(object_distance.getString("value"));
				return object_duration.getString("value")+","+object_distance.getString("value");

			}
		} catch (MalformedURLException e) {
			Log.d("error", "error1");
		} catch (IOException e) {
			Log.d("error", "error2");
		} catch (JSONException e) {
			Log.d("error","error3");
		}


		return null;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue2() {

		return value2;
	}
}