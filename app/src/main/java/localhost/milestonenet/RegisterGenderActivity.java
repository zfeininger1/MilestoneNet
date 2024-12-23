package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterGenderActivity extends AppCompatActivity {
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_gender);

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(view -> {
            // Start the main activity
            Intent intent = new Intent(RegisterGenderActivity.this, RegisterDrugsActivity.class);
            startActivity(intent);
        });
    }
}
