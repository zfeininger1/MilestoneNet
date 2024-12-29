package localhost.milestonenet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PurchasesFragment extends Fragment {

    boolean alcohol;
    boolean cocaine;
    boolean heroin;
    boolean ketamine;
    boolean lsd;
    boolean marijuana;
    boolean meth;
    boolean psilocybin;
    boolean xanax;
    Spinner drugSelector;

    public PurchasesFragment() {
        // Required empty public constructor
    }

    public static PurchasesFragment newInstance(String param1, String param2) {
        PurchasesFragment fragment = new PurchasesFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // Enables options menu in this fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_purchases, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Purchases");
        toolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_add) {
                showPopupWindow();
                return true;
            }
            return false;
        });
    }

    private void showPopupWindow() {
        // Inflate the custom layout
        View popupView = getLayoutInflater().inflate(R.layout.popup_layout, null);


        // Create the AlertDialog and set the custom view
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(requireContext());
        builder.setTitle("Add Item")
                .setView(popupView);
//                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

        // Show the dialog
        android.app.AlertDialog dialog = builder.create();
        dialog.show();

        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users");

// Query to find the user by email
        usersRef.orderByChild("email").equalTo(userEmail).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<String> availableDrugs = new ArrayList<>();
                    // The email exists in the database, retrieve the user's data
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        String userId = userSnapshot.getKey();  // User's ID
                        String email = userSnapshot.child("email").getValue(String.class);
                        alcohol = userSnapshot.child("allSubstanceStatus").child("Alcohol").getValue(Boolean.class);
                        cocaine = userSnapshot.child("allSubstanceStatus").child("Cocaine").getValue(Boolean.class);
                        heroin = userSnapshot.child("allSubstanceStatus").child("Heroin").getValue(Boolean.class);
                        ketamine = userSnapshot.child("allSubstanceStatus").child("Ketamine").getValue(Boolean.class);
                        lsd = userSnapshot.child("allSubstanceStatus").child("LSD").getValue(Boolean.class);
                        marijuana = userSnapshot.child("allSubstanceStatus").child("Marijuana").getValue(Boolean.class);
                        meth = userSnapshot.child("allSubstanceStatus").child("Methamphetamine").getValue(Boolean.class);
                        psilocybin = userSnapshot.child("allSubstanceStatus").child("Psilocybin").getValue(Boolean.class);
                        xanax = userSnapshot.child("allSubstanceStatus").child("Xanax").getValue(Boolean.class);

                        // Retrieve any other information associated with the user
                        if (alcohol) availableDrugs.add("Alcohol");
                        if (cocaine) availableDrugs.add("Cocaine");
                        if (heroin) availableDrugs.add("Heroin");
                        if (ketamine) availableDrugs.add("Ketamine");
                        if (lsd) availableDrugs.add("LSD");
                        if (marijuana) availableDrugs.add("Marijuana");
                        if (meth) availableDrugs.add("Methamphetamine");
                        if (psilocybin) availableDrugs.add("Psilocybin");
                        if (xanax) availableDrugs.add("Xanax");

                        // Add more fields as necessary
                    }
                    drugSelector = popupView.findViewById(R.id.drug_selector_spinner);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, availableDrugs);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    drugSelector.setAdapter(adapter);
                } else {
                    Log.d("LOGERROR", "No user found with the provided email.");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle possible errors
                Log.d("LOGERROR", "Error fetching user data: " + databaseError.getMessage());
            }
        });



        // Set an onClickListener for the button inside the popup
        Button popupButton = popupView.findViewById(R.id.popup_button);
        popupButton.setOnClickListener(v -> {
            String selectedDrug =  (String) drugSelector.getSelectedItem();
            Log.d("LOGERROR", selectedDrug);
            // Handle button click here
            // For example, dismiss the dialog
            dialog.dismiss();
            // Or perform other actions
        });
    }
}
