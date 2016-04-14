package plus.android.techathon.sharepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by root on 26/9/15.
 */
public class Registeration extends ActionBarActivity {
    Button b1, b2  ;
    TextView t1 ;
    EditText pass ;
    String strOtp ;
    public static final String PREFS_NAME = "MyPrefsFile";
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        b2 = (Button) findViewById(R.id.btnRegister) ;
        pass = (EditText) findViewById(R.id.Password) ;
        t1 = (TextView) findViewById(R.id.register_error) ;
        b1 = (Button) findViewById(R.id.btnLinkToLoginScreen) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registeration.this, MainActivity.class) ;
                startActivity(i) ;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost("http://sharepro.herokuapp.com/getOTP/" + pass.getText().toString());
                    String json = "";
                    StringEntity stringEntity = new StringEntity(json) ;
                    post.setEntity(stringEntity) ;
                    post.setHeader("Accept", "application/json") ;
                    post.setHeader("Content-type", "application/json") ;
                    HttpResponse httpResponse = client.execute(post) ;
                    String t = EntityUtils.toString(httpResponse.getEntity());
                    t1.setText(t) ;
                    Intent i = new Intent(Registeration.this, Otp.class) ;
                    startActivity(i) ;
                    finish();
//                    Intent i = new Intent(getApplicationContext(), Otp.class) ;
//                    //Create the bundle
//                    Bundle bundle = new Bundle();
//                    //Add your data to bundle
//                    bundle.putString("semester", semester) ;
//                    //Add the bundle to the intent
//                    i.putExtras(bundle);
//                    //Fire that second activity
//                    startActivity(i) ;
//                    try {
//                        JSONObject jsonObject = new JSONObject(json);
//                        String data = jsonObject.getString("data");
//                        JSONObject jsonObject1 = new JSONObject(data);
//                        strOtp = jsonObject1.getString("OTP"); }


                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
