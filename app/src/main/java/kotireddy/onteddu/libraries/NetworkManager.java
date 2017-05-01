package kotireddy.onteddu.libraries;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;


public class NetworkManager {

    private static String TAG = NetworkManager.class.getSimpleName();
    private static NetworkManager instance;
    private static Context context;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    private NetworkManager(Context context) {

        if (!ObjectUtil.objectNotNull(context)) {
            return;
        }

        NetworkManager.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized NetworkManager getInstance(Context context) {

        Log.d(TAG, "get Instance");

        if (instance == null) {
            if (ObjectUtil.objectNotNull(context)) {
                instance = new NetworkManager(context);
            }
        }

        return instance;
    }

    public RequestQueue getRequestQueue() {

        Log.d(TAG, "get Request Queue");

        // getApplicationContext() is key, it keeps you from leaking the
        // Activity or BroadcastReceiver if someone passes one in.
        if (ObjectUtil.objectNotNull(context)) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {

        Log.d(TAG, "add To Request Queue");

        if (ObjectUtil.objectNotNull(req)) {
            getRequestQueue().add(req);
        }
    }
}
