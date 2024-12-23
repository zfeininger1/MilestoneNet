package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterAgeActivity extends AppCompatActivity {
    Button nextButton;
    EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_age);

        nextButton = findViewById(R.id.nextButton);
        age = findViewById(R.id.age);

        nextButton.setOnClickListener(view -> {
            Intent previousIntent = getIntent();
            users user = (users) previousIntent.getSerializableExtra("newUser");
            user.setAge(age.getText().toString());

            Intent intent = new Intent(RegisterAgeActivity.this, RegisterGenderActivity.class);
            intent.putExtra("newUser", user);
            startActivity(intent);
        });
    }
}
