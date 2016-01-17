package myself.powerdotstry2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomePage2 extends AppCompatActivity {


    public void initiateMain(View view){

        SharedPreferences sharedPref = this.getSharedPreferences("abcd", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putInt(getString(R.string.textViewNumObjects), 10);

        int numObjects;
        try {
            numObjects = Integer.parseInt(
                    ((EditText)findViewById(R.id.editTextNumObjects)).getText().toString()
            );
        } catch (NumberFormatException e) {
            numObjects = Integer.parseInt(getString(R.string.defaultNumObjects));
        }
        editor.putInt(getString(R.string.aeigjeigo), numObjects );
        editor.commit();

        int fps;
        try {
            fps = Integer.parseInt(
                    ((EditText)findViewById(R.id.editTextFPS)).getText().toString()
            );
        } catch (NumberFormatException e) {
            fps = Integer.parseInt(getString(R.string.defaultFPS));
        }
        editor.putInt(getString(R.string.aerthujyu), fps );
        editor.commit();

        //int highScore = sharedPref.getInt(getString(R.string.aeigjeigo), 8008135);
        //Log.d("highScore!!", Integer.toString(highScore));

        Intent intent = new Intent(this, Main.class);
        intent.putExtra("Intent Text", "Intent Message");
        startActivity(intent);
    }

//    public void methodTestAngle(View view){
//        TextView arijgtn = (TextView)findViewById(R.id.arhjyrs);
//
//        int numberToTry;
//        try {
//            String aegar = ((EditText)findViewById(R.id.arhjyrs)).getText().toString();
//            numberToTry = Integer.parseInt(aegar);
//        } catch (NumberFormatException e) {
//            numberToTry = 45;
//        }
//
////        arijgtn.setText(angleTable.sin(numberToTry) + " | " + Double.toString(Math.sin((double) numberToTry)) );
//        arijgtn.setText(angleTable.cos((float)numberToTry) + " | " + Double.toString(Math.cos((double) numberToTry)) );
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);

        ((TextView)findViewById(R.id.editTextNumObjects)).setHint(getString(R.string.defaultQueryString) + " " + getString(R.string.defaultNumObjects));
        ((TextView)findViewById(R.id.editTextFPS)).setHint(getString(R.string.defaultQueryString) + " " +getString(R.string.defaultFPS));
    }
}
