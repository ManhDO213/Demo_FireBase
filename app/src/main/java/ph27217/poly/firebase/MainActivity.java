package ph27217.poly.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText edtId, edtUsername, edtPasswd, edtEmail;
    private Button btnSend, btnEdit, btnDelete;
    private TextView tv1;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtId = findViewById(R.id.edtId);
        edtUsername = findViewById(R.id.edtUsername);
        edtPasswd = findViewById(R.id.edtPasswd);
        edtEmail = findViewById(R.id.edtEmail);
        btnSend = findViewById(R.id.btnSend);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        tv1 = findViewById(R.id.tv1);


        firebaseDatabase = FirebaseDatabase.getInstance();


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = firebaseDatabase.getReference("listUser/1");

                int id = Integer.parseInt(edtId.getText().toString());
                String username = edtUsername.getText().toString();
                String passwd = edtPasswd.getText().toString();
                String email = edtEmail.getText().toString();
                users users = new users(id, username, passwd, email);
//                reference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
////                        String s = snapshot.getValue(String.class);
////                        tv1.setText(s);
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        Log.e("error", "onCancelled: " + error.toString());
//                    }
//                });
                // add - du lieu
                reference.setValue(users);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ph27217.poly.firebase.users users1 = snapshot.getValue(ph27217.poly.firebase.users.class);
                        tv1.setText(users1.getUsername());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}