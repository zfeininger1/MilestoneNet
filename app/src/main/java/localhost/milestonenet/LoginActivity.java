package localhost.milestonenet;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static String TAG = "ShoppingList";
    private FirebaseAuth mAuth;
    private Button signInButton;
//    private Button regButton;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        signInButton = findViewById(R.id.loginButton);
//        regButton =  findViewById(R.id.registerButton);

        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (email.equals("") || email.equals(null)) {
                    email = "1";
                }
                if (password.equals("") || password.equals(null)) {
                    password = "1";
                    email = "1";
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(v.getContext(), MainMenu.class);
                                    intent.putExtra("user", user);
                                    v.getContext().startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

//        regButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = editTextEmail.getText().toString();
//                String password = editTextPassword.getText().toString();
//                if (email.equals("") || email.equals(null)) {
//                    email = "1";
//                }
//                if (password.equals("") || password.equals(null)) {
//                    password = "1";
//                    email = "1";
//                }
//
//                mAuth.createUserWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    Log.d(TAG, "createdUserWithEmail:success");
//                                    Toast.makeText(LoginActivity.this, "YOU HAVE BEEN SUCCESSFULLY REGISTERED!",
//                                            Toast.LENGTH_SHORT).show();
//                                    DatabaseReference userCountRef = FirebaseDatabase.getInstance().getReference("message");
//                                    userCountRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                                        @Override
//                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                            Integer currentValue = dataSnapshot.getValue(Integer.class);
//                                            if (currentValue != null) {
//                                                int newValue = currentValue + 1;
//                                                userCountRef.setValue(newValue);
//
//                                            }
//                                        }
//
//                                        @Override
//                                        public void onCancelled(@NonNull DatabaseError error) {
//
//                                        }
//                                    });
//                                } else {
//                                    Log.d(TAG, "createdUserWithEmail:failure");
//                                    Toast.makeText(LoginActivity.this, "YOU HAVE FAILED TO REGISTER, ENTER A VALID EMAIL/PASSWORD",
//                                            Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//            }
//        });

    }
}