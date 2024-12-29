package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
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
    CheckBox alcohol;
    CheckBox cocaine;
    CheckBox heroin;
    CheckBox ketamine;
    CheckBox lsd;
    CheckBox marijuana;
    CheckBox meth;
    CheckBox psilocybin;
    CheckBox xanax;
    DatabaseReference database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_drugs);

        registerButton = findViewById(R.id.registerButton);
        alcohol = findViewById(R.id.checkBox2);
        cocaine = findViewById(R.id.checkBox3);
        heroin = findViewById(R.id.checkBox4);
        ketamine = findViewById(R.id.checkBox5);
        lsd = findViewById(R.id.checkBox6);
        marijuana = findViewById(R.id.checkBox7);
        meth = findViewById(R.id.checkBox8);
        psilocybin = findViewById(R.id.checkBox9);
        xanax = findViewById(R.id.checkBox10);
        mAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(view -> {
            Intent previousIntent = getIntent();
            users user = (users) previousIntent.getSerializableExtra("newUser");
            user.setSubstancesStatus("Marijuana", marijuana.isChecked());
            user.setSubstancesStatus("Methamphetamine", meth.isChecked());
            user.setSubstancesStatus("Ketamine", ketamine.isChecked());
            user.setSubstancesStatus("Cocaine", cocaine.isChecked());
            user.setSubstancesStatus("Heroin", heroin.isChecked());
            user.setSubstancesStatus("Alcohol", alcohol.isChecked());
            user.setSubstancesStatus("Psilocybin", psilocybin.isChecked());
            user.setSubstancesStatus("LSD", lsd.isChecked());
            user.setSubstancesStatus("Xanax", xanax.isChecked());
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
