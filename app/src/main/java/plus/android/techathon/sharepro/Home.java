package plus.android.techathon.sharepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 27/9/15.
 */
public class Home extends ActionBarActivity {
    Button b1 ;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home) ;
        b1 = (Button) findViewById(R.id.stdbusinesscard) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Sbc1.class) ;
                startActivity(i);
            }
        });
    }
}
