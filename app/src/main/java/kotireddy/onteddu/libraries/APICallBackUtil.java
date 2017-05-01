package kotireddy.onteddu.libraries;

import org.json.JSONObject;


public interface APICallBackUtil {
    void onSuccess(JSONObject response) ;
    void onFailure(Exception error);
    void onFinish();
}
