package isetB.PlatformdeTROC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Inscription extends AppCompatActivity {
    Button registerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        registerbtn = findViewById(R.id.registerbtn);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(Inscription.this, " Add Your Account Here ", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Inscription.this, register.class);
                startActivity(i);
            }
        });

    }

}