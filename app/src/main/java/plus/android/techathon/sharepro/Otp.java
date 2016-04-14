package plus.android.techathon.sharepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by root on 26/9/15.
 */
public class Otp extends ActionBarActivity {
    EditText e1 ;
    Button b1 ;
    TextView t1 ;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.otp);
        e1 = (EditText) findViewById(R.id.registerOtp) ;
        b1 = (Button) findViewById(R.id.OtpConfirm) ;
        t1 = (TextView) findViewById(R.id.register_error) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().equals(null))
                {
                    t1.setText("OTP cannot be Null");
                }
                Intent i = new Intent(Otp.this, Home.class) ;
                startActivity(i);
                finish();
            }
        });
    }
}
