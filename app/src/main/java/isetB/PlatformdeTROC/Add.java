package isetB.PlatformdeTROC;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Add extends AppCompatActivity {

    Button Add;
    TextView signin;
    EditText e1 , e2 ,  e3, e4  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        signin=findViewById(R.id.signin);
        e1 =findViewById(R.id.username);
        e2 =findViewById(R.id.password);
        e3 =findViewById(R.id.R);
        e4 = findViewById(R.id.email);
        Add= findViewById(R.id.add);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences p =getSharedPreferences("MyInfo2" , MODE_PRIVATE);
                SharedPreferences.Editor editor=p.edit();

                String add= e1.getText().toString();
                editor.putString("N", add);

                String username= e2.getText().toString();
                editor.putString("L", username);

                String R= e3.getText().toString();
                editor.putString("E", R);
        Add.setOnClickListener(new View.OnClickListener() {
@Override

public void onClick(View v) {
        Toast.makeText(Add.this, " Add Your Account Here ", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Add.this, user.class);
        startActivity(i);
        }
        });

        String email = e4.getText().toString();
                editor.putString("P", email);


    }});
    }}
