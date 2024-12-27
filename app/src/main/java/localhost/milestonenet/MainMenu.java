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
            Log.d("LOGERROR", String.valueOf(item.getItemId()));
            if (item.getItemId() == 2131231331) {
                selectedFragment = new ManageFragment();
            } else if (item.getItemId() == 2131231332) {
                selectedFragment = new PurchasesFragment();
            } else if (item.getItemId() == 2131230976) {
                selectedFragment = new MainDisplayFragment();
            } else if (item.getItemId() == 2131231333) {
                selectedFragment = new SocialFragment();
            } else if (item.getItemId() == 2131231330) {
                Log.d("LOGERROR", "logout");
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