package localhost.milestonenet;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartingActivity extends AppCompatActivity {
    Button getStartedButton;
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        // Enable fullscreen and allow drawing behind system bars
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            );
        }

        getStartedButton = findViewById(R.id.getStartedButton);
        signInButton = findViewById(R.id.signInButton);

        getStartedButton.setOnClickListener(view -> {
            // Start the main activity
            Intent intent = new Intent(StartingActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        signInButton.setOnClickListener(view -> {
            // Start the main activity; need to change to sign in
            Intent intent = new Intent(StartingActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
