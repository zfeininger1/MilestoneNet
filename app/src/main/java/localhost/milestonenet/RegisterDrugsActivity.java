package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterDrugsActivity extends AppCompatActivity {
    Button registerButton;
    EditText drugName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_drugs);

        registerButton = findViewById(R.id.registerButton);
        drugName = findViewById(R.id.drug);

        registerButton.setOnClickListener(view -> {
            // Start the main activity
            Intent intent = new Intent(RegisterDrugsActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
