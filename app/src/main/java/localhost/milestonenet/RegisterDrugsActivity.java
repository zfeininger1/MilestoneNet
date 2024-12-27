package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterDrugsActivity extends AppCompatActivity {
    Button registerButton;
    EditText drugName;
    DatabaseReference database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_drugs);

        registerButton = findViewById(R.id.registerButton);
        drugName = findViewById(R.id.drug);
        mAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(view -> {
            Intent previousIntent = getIntent();
            users user = (users) previousIntent.getSerializableExtra("newUser");
            user.setSubstancesStatus("Marijuana", true);
            user.setSubstancesStatus("Methamphetamine", true);
            user.setSubstancesStatus("Ketamine", true);
            user.setSubstancesStatus("Cocaine", true);
            user.setSubstancesStatus("Heroin", true);
            user.setSubstancesStatus("Alcohol", true);
            user.setSubstancesStatus("Psilocybin", true);
            user.setSubstancesStatus("LSD", true);
            database = FirebaseDatabase.getInstance().getReference("users").push();
            user.setId(database.getKey());
            database.setValue(user).addOnSuccessListener(aVoid -> {
                Toast.makeText(RegisterDrugsActivity.this, "Successfully registered!",
                        Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(e -> {
                Log.e("TAG:ERROR", e.getMessage(), e);
            });


            String email = user.getEmail();
            String password = user.getPassword();
            if (email.equals("") || email.equals(null)) {
                email = "1";
            }
            if (password.equals("") || password.equals(null)) {
                password = "1";
                email = "1";
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(RegisterDrugsActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("TAGERROR", "createdUserWithEmail:success");
                                Toast.makeText(RegisterDrugsActivity.this, "YOU HAVE BEEN SUCCESSFULLY REGISTERED!",
                                        Toast.LENGTH_SHORT).show();
                                // Start the main activity
                                Intent intent = new Intent(RegisterDrugsActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Log.d("LOGERROR", "createdUserWithEmail:failure");
                                Toast.makeText(RegisterDrugsActivity.this, "YOU HAVE FAILED TO REGISTER, ENTER A VALID EMAIL/PASSWORD",
                                        Toast.LENGTH_SHORT).show();
                                // Start the main activity
                                Intent intent = new Intent(RegisterDrugsActivity.this, StartingActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
        });
    }
}
