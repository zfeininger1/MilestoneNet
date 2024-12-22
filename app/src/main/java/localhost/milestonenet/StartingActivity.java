package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartingActivity extends AppCompatActivity {
    Button getStartedButton;
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        getStartedButton = findViewById(R.id.getStartedButton);
        signInButton = findViewById(R.id.signInButton);

        getStartedButton.setOnClickListener(view -> {
            // Start the main activity
            Intent intent = new Intent(StartingActivity.this, MainActivity.class);
            startActivity(intent);
        });

        signInButton.setOnClickListener(view -> {
            // Start the main activity; need to change to sign in
            Intent intent = new Intent(StartingActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
