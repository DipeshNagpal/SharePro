package plus.android.techathon.sharepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by root on 27/9/15.
 */
public class Card1 extends ActionBarActivity {
    String name, position, company, contact, email, linkedin, twitter, facebook;
    TextView t1, t2, t3, t4, t5;
    Button b1, b2, b3, b4;
    EditText e1, e2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card1);
        e1 = (EditText) findViewById(R.id.receivecards);
        e2 = (EditText) findViewById(R.id.sendcards);
        b3 = (Button) findViewById(R.id.receiveok);
        b4 = (Button) findViewById(R.id.sendok);
        t1 = (TextView) findViewById(R.id.name);
        t2 = (TextView) findViewById(R.id.position);
        t3 = (TextView) findViewById(R.id.phone);
        t4 = (TextView) findViewById(R.id.Email);
        t5 = (TextView) findViewById(R.id.company);
        b1 = (Button) findViewById(R.id.share);
        b2 = (Button) findViewById(R.id.receive);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        position = bundle.getString("position");
        company = bundle.getString("company");
        email = bundle.getString("email");
        linkedin = bundle.getString("linkedin");
        contact = bundle.getString("phone");
        twitter = bundle.getString("twitter");
        facebook = bundle.getString("facebook");
        t1.setText(name);
        t2.setText(position);
        t3.setText(contact);
        t4.setText(email);
        t5.setText(company);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e2.setVisibility(View.VISIBLE);
                b4.setVisibility(View.VISIBLE);
                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }


        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setVisibility(View.VISIBLE);
                b3.setVisibility(View.VISIBLE);
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Card1.this, Receivecards.class) ;
                        startActivity(i);
                    }
                });
            }
        });
    }
}