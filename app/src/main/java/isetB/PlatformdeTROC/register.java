package isetB.PlatformdeTROC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class register extends AppCompatActivity {
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginbtn = findViewById(R.id.loginbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(register.this, "Your Account Add With Success", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(register.this, Acceuil.class);
                startActivity(i);
            }
        });

    }
}
