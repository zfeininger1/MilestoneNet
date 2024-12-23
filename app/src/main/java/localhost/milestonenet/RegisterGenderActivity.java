package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterGenderActivity extends AppCompatActivity {
    Button nextButton;
    EditText gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_gender);

        nextButton = findViewById(R.id.nextButton);
        gender = findViewById(R.id.gender);

        nextButton.setOnClickListener(view -> {
            Intent previousIntent = getIntent();
            users user = (users) previousIntent.getSerializableExtra("newUser");
            user.setGender(gender.getText().toString());
            // Start the main activity
            Intent intent = new Intent(RegisterGenderActivity.this, RegisterDrugsActivity.class);
            intent.putExtra("newUser", user);
            startActivity(intent);
        });
    }
}
