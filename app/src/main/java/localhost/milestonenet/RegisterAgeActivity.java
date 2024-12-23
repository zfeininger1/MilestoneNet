package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterAgeActivity extends AppCompatActivity {
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_age);

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterAgeActivity.this, RegisterGenderActivity.class);
            startActivity(intent);
        });
    }
}
