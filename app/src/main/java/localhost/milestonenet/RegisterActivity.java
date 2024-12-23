package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Button nextButton;
    EditText firstName;
    EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nextButton = findViewById(R.id.nextButton);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);

        nextButton.setOnClickListener(view -> {
            // Start the main activity
            Intent intent = new Intent(RegisterActivity.this, RegisterAgeActivity.class);
            startActivity(intent);
        });
    }
}
