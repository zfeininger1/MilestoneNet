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

public class RegisterActivity extends AppCompatActivity {
    Button nextButton;
    EditText firstName;
    EditText lastName;
    DatabaseReference database;
    DatabaseReference newUserRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nextButton = findViewById(R.id.nextButton);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);

        nextButton.setOnClickListener(view -> {
//            users user = new users(null, "John", "Doe", "email@email.com",  "Male","30");
//            user.setSubstancesStatus("Heroin", true);
//            user.setSubstancesStatus("Cocaine", true);
//            database = FirebaseDatabase.getInstance().getReference("users").push();
//            user.setId(database.getKey());
//            database.setValue(user).addOnSuccessListener(aVoid -> {
//                Toast.makeText(RegisterActivity.this, "Success",
//                        Toast.LENGTH_SHORT).show();
//            }).addOnFailureListener(e -> {
//                Log.e("TAG:ERROR", e.getMessage(), e);
//            });
            users user = new users();
            user.setFirstName(firstName.getText().toString());
            user.setLastName(lastName.getText().toString());
            // Start the main activity
            Intent intent = new Intent(RegisterActivity.this, RegisterAgeActivity.class);
            intent.putExtra("newUser", user);
            startActivity(intent);
        });
    }
}
