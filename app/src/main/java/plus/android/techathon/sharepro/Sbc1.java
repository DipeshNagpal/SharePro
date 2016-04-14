package plus.android.techathon.sharepro;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * Created by root on 26/9/15.
 */
public class Sbc1 extends ActionBarActivity {
    CardView cv1, cv2 ;
    ActionBar actionBar ;
    String cardlayout ;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.sbc1);
        cv1 = (CardView) findViewById(R.id.card1) ;
        cv2 = (CardView) findViewById(R.id.card2) ;
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardlayout = "1" ;
                Intent i = new Intent(Sbc1.this, Sbc2.class) ;
                i.putExtra("cardlayout", cardlayout);
                startActivity(i);
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardlayout = "2" ;
                Intent i = new Intent(Sbc1.this, Sbc2.class) ;
                i.putExtra("cardlayout", cardlayout);
                startActivity(i);
            }
        });
//        flipCard();
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
//    private void flipCard()
//    {
//        View rootLayout = (View) findViewById(R.id.mainview);
//        View cardFace = (View) findViewById(R.id.card1);
//        View cardBack = (View) findViewById(R.id.cardback1);
//        View cardFace1 = (View) findViewById(R.id.card2);
//        View cardBack1 = (View) findViewById(R.id.cardback2);
//
//        FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);
//
//        if (cardFace.getVisibility() == View.GONE)
//        {
//            flipAnimation.reverse();
//        }
//        rootLayout.startAnimation(flipAnimation);
//    }
}
