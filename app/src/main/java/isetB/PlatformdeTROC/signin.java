package isetB.PlatformdeTROC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class signin extends Activity {
   private String username ="asma";
   private String password ="1234";
    MaterialButton loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialButton  loginbtn =  findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (loginbtn.equals(loginbtn)){

                    Intent intent=new Intent(signin.this, Add.class);
                    startActivity(intent);
                }else
                    Toast.makeText(signin.this, "vérifiez votre password" , Toast.LENGTH_SHORT).show();
            }});
    }

}
