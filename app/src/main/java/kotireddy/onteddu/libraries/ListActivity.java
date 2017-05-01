package kotireddy.onteddu.libraries;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.json.JSONObject;

import java.io.StringReader;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = ListActivity.class.getSimpleName();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final Gson gson = new Gson();

        final MainModel mainModel = new MainModel();

        if (mainModel.getDataModels() == null) {
            final ProgressDialog progress = new ProgressDialog(this);
            progress.setMessage("Downloading Data :) ");
            progress.setIndeterminate(true);
            progress.show();
            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, "https://data.cityofchicago.org/resource/x8fc-8rcq.json", null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.i(TAG, "onResponse: "+response);
                            if (progress != null)
                                progress.dismiss();
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i(TAG, "onErrorResponse: "+error.getMessage());
                            String json = error.getMessage().substring(30).trim();
                            Log.i(TAG, "onErrorResponse: "+json);
                            JsonReader reader = new JsonReader(new StringReader(json));
                            reader.setLenient(true);
                            DataModel dataModels[] = gson.fromJson(reader,DataModel[].class);
                            mainModel.setDataModels(dataModels);
                            setRecyclerView(dataModels);
                            if (progress != null)
                                progress.dismiss();
                        }
                    });
            NetworkManager.getInstance(this).addToRequestQueue(jsObjRequest);
        }

    }

    private void setRecyclerView(DataModel[] dataModels) {

        assert recyclerView != null;
        Adapter adapter = new Adapter(dataModels,this);
        recyclerView.setAdapter(adapter);
    }
}
