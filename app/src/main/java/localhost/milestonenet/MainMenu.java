package localhost.milestonenet;

import android.os.Bundle;

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

//        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//            Fragment selectedFragment = null;
//            switch (item.getItemId()) {
//                case R.id.manage:
//                    selectedFragment = new ManageFragment();
//                    break;
//                case R.id.purchases:
//                    selectedFragment = new PurchasesFragment();
//                    break;
//                case R.id.home:
//                    selectedFragment = new MainDisplayFragment();
//                    break;
//                case R.id.social:
//                    selectedFragment = new SocialFragment();
//                    break;
////                case R.id.logout:
//                    //logout
//            }
//            if (selectedFragment != null) {
//                replaceFragment(selectedFragment);
//            }
//            return true;
//        });

    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView4, fragment)
                .commit();
    }
}