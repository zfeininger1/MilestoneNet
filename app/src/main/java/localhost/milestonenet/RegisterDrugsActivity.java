package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterDrugsActivity extends AppCompatActivity {
    Button registerButton;
    EditText drugName;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_drugs);

        registerButton = findViewById(R.id.registerButton);
        drugName = findViewById(R.id.drug);

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
                Toast.makeText(RegisterDrugsActivity.this, "Success",
                        Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(e -> {
                Log.e("TAG:ERROR", e.getMessage(), e);
            });

            // Start the main activity
            Intent intent = new Intent(RegisterDrugsActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
