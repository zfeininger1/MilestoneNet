package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterAgeActivity extends AppCompatActivity {
    Button nextButton;
    NumberPicker age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_age);

        nextButton = findViewById(R.id.nextButton);
        age = findViewById(R.id.age);
        age.setMinValue(18);
        age.setMaxValue(100);
        age.setValue(18);
        age.setWrapSelectorWheel(false);

        nextButton.setOnClickListener(view -> {
            Intent previousIntent = getIntent();
            users user = (users) previousIntent.getSerializableExtra("newUser");
            assert user != null;
            user.setAge(String.valueOf(age.getValue()));

            Intent intent = new Intent(RegisterAgeActivity.this, RegisterGenderActivity.class);
            intent.putExtra("newUser", user);
            startActivity(intent);
        });
    }
}
