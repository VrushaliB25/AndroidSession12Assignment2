package example.com.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Age = "ageKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);


        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = ed1.getText().toString();
                String ph  = ed2.getText().toString();
                String age  = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Phone, ph);
                editor.putString(Age, age);
                editor.commit();
                Toast.makeText(MainActivity.this,"Data is successfully saved.",Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences(MyPREFERENCES, 0); // 0 - for private mode


                // getting values from stored preferences
// If any value is not present in the preferences file, then the second parameter will be the default value - //In this case null
                String n = sharedpreferences.getString(Name, "");
                String ph= sharedpreferences.getString(Phone,"");
                String age=sharedpreferences.getString(Age,"");

               // Toast.makeText(MainActivity.this, n,Toast.LENGTH_LONG).show();
                TextView YourTextView = (TextView) findViewById(R.id.textView3);
                YourTextView.setText(n +"\n"+ ph +"\n"+age);
            }
        });

    }

}