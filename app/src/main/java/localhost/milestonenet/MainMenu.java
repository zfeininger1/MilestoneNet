package localhost.milestonenet;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigationview);
        replaceFragment(new MainDisplayFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            Log.d("LOGERROR", String.valueOf(item.getTitle()));
            if (String.valueOf(item.getTitle()).equals("Manage")) {
                selectedFragment = new ManageFragment();
            } else if (String.valueOf(item.getTitle()).equals("Purchases")) {
                selectedFragment = new PurchasesFragment();
            } else if (String.valueOf(item.getTitle()).equals("Home")) {
                selectedFragment = new MainDisplayFragment();
            } else if (String.valueOf(item.getTitle()).equals("Social")) {
                selectedFragment = new SocialFragment();
            } else if (String.valueOf(item.getTitle()).equals("Logout")) {
                Log.d("LOGERROR", "this needs to work ");
                finish();
            }
            if (selectedFragment != null) {
                replaceFragment(selectedFragment);
            }
            return true;
        });

    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView4, fragment)
                .commit();
    }
}