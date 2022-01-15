package isetB.PlatformdeTROC;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
public class Acceuil extends AppCompatActivity implements View.OnClickListener {


   Button ech1 , ech2 , ech3,ech4 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);
        ech1.setOnClickListener(this);
        ech2.setOnClickListener(this);
        ech3.setOnClickListener(this);
        ech4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    }
}
