package plus.android.techathon.sharepro;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by root on 26/9/15.
 */
public class Sbc2 extends ActionBarActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8 ;
    Button b1 ;
    String cardlayout ;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbc2);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        e1 = (EditText) findViewById(R.id.fullName) ;
        e2 = (EditText) findViewById(R.id.position) ;
        e3 = (EditText) findViewById(R.id.company) ;
        e4 = (EditText) findViewById(R.id.phone) ;
        e5 = (EditText) findViewById(R.id.email) ;
        e6 = (EditText) findViewById(R.id.linkedin) ;
        e7 = (EditText) findViewById(R.id.twitter) ;
        e8 = (EditText) findViewById(R.id.facebook) ;
        b1 = (Button) findViewById(R.id.createcard) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Bundle bundle = getIntent().getExtras();
                    cardlayout = bundle.getString("cardlayout");
                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost("http://sharepro.herokuapp.com/insertCard/" + e4.getText().toString() + "/" + cardlayout + "/" + e4.getText().toString() + "/" + e1.getText().toString() + "/" + e5.getText().toString() + "/" + e2.getText().toString() + "/" + e3.getText().toString() + "/" + e8.getText().toString() + "/" + e6.getText().toString() + "/" + e7.getText().toString());
                    String json = "";
                    StringEntity stringEntity = new StringEntity(json);
                    post.setEntity(stringEntity);
                    post.setHeader("Accept", "application/json");
                    post.setHeader("Content-type", "application/json");
                    HttpResponse httpResponse = client.execute(post);
                    String t = EntityUtils.toString(httpResponse.getEntity());
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(cardlayout.equals("1")) {
                    Intent i = new Intent(Sbc2.this, Card1.class);
                    i.putExtra("name", e1.getText().toString()) ;
                    i.putExtra("position", e2.getText().toString()) ;
                    i.putExtra("company", e3.getText().toString()) ;
                    i.putExtra("phone", e4.getText().toString()) ;
                    i.putExtra("email", e5.getText().toString()) ;
                    i.putExtra("linkedin", e6.getText().toString()) ;
                    i.putExtra("twitter", e7.getText().toString()) ;
                    i.putExtra("facebook", e8.getText().toString()) ;
                    startActivity(i);
                }
                if(cardlayout.equals("2")) {
                    Intent i = new Intent(Sbc2.this, Card2.class);
                    i.putExtra("name", e1.getText().toString()) ;
                    i.putExtra("position", e2.getText().toString()) ;
                    i.putExtra("company", e3.getText().toString()) ;
                    i.putExtra("phone", e4.getText().toString()) ;
                    i.putExtra("email", e5.getText().toString()) ;
                    i.putExtra("linkedin", e6.getText().toString()) ;
                    i.putExtra("twitter", e7.getText().toString()) ;
                    i.putExtra("facebook", e8.getText().toString()) ;
                    startActivity(i);
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
