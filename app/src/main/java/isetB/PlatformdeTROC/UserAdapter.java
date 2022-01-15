package isetB.PlatformdeTROC;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;


public class UserAdapter extends ArrayAdapter<user> {
    Activity context;
    private ArrayList<user> listuser;
    private DatabaseHelper db;
    public  UserAdapter(Activity context, ArrayList<user> listStudent) {
        super(context, R.layout.user_item, listStudent);
        this.context = context;
        this.listuser = listuser;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, null, true);

        TextView t1 = view.findViewById(R.id.text_nomm);

        TextView t2 = view.findViewById(R.id.text_email);
        TextView t3 = view.findViewById(R.id.text_pwd);
        ImageView im1 = view.findViewById(R.id.edit_user);
        ImageView im2 = view.findViewById(R.id.delete_user);
        t1.setText(String.valueOf(listuser.get(position).getNom()));
        t2.setText(listuser.get(position).getEMAIL());
        t3.setText(listuser.get(position).getPASSWORD());
        user  u = listuser.get(position);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(context);
                View subView = inflater.inflate(R.layout.user_item, null);
                EditText n = subView.findViewById(R.id.edit_nom);
                EditText e = subView.findViewById(R.id.edit_email);
                EditText p = subView.findViewById(R.id.edit_pwd);

                n.setText(u.getNom());
                e.setText(u.getEMAIL());
                p.setText(u.getPASSWORD());
                AlertDialog.Builder a = new AlertDialog.Builder(context);
                a.setTitle("Edit new Student");
                a.setView(subView);
                a.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = n.getText().toString();
                        String email = e.getText().toString();
                        String pwd = p.getText().toString();
                        // Student s = new Student(name, phone);
                        db = new DatabaseHelper(context);
                        db.updateuser(new user(u.getId(),name,email,pwd));
                        context.finish();
                        context.startActivity(context.getIntent());
                    }
                });
                a.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "task canceld ", Toast.LENGTH_SHORT).show();
                    }
                });
                a.show();

            }
        });
        return view;
    }
}


