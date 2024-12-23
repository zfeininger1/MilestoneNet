package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(view -> {
            // Start the main activity
            Intent intent = new Intent(RegisterActivity.this, RegisterDrugsActivity.class);
            startActivity(intent);
        });
    }
}
