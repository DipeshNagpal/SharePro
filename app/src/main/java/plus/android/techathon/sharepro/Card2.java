package plus.android.techathon.sharepro;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by root on 27/9/15.
 */
public class Card2 extends ActionBarActivity {
    String name, position, company, contact, email, linkedin, twitter, facebook ;
    TextView t1,t2,t3,t4,t5,t6,t7 ;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card2);
        t1 = (TextView) findViewById(R.id.company) ;
        t2 = (TextView) findViewById(R.id.name) ;
        t3 = (TextView) findViewById(R.id.position) ;
        t4 = (TextView) findViewById(R.id.emailid) ;
        t5 = (TextView) findViewById(R.id.phone) ;
        t6 = (TextView) findViewById(R.id.twitter) ;
        t7 = (TextView) findViewById(R.id.facebook) ;
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        position = bundle.getString("position");
        company = bundle.getString("company");
        email = bundle.getString("email");
        linkedin = bundle.getString("linkedin");
        contact = bundle.getString("phone");
        twitter = bundle.getString("twitter");
        facebook = bundle.getString("facebook");
        t1.setText(company);
        t2.setText(name);
        t3.setText(position);
        t4.setText(email);
        t5.setText(contact);
        t6.setText(twitter);
        t7.setText(facebook);
    }
}
