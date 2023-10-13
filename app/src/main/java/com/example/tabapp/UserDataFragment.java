package com.example.tabapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class UserDataFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_data, container, false);

        Bundle args = getArguments();
        if (args != null) {
            String username = args.getString("username", "");
            String password = args.getString("password", "");

            TextView usernameTextView = rootView.findViewById(R.id.usernameTextView);
            TextView passwordTextView = rootView.findViewById(R.id.passwordTextView);

            usernameTextView.setText("Nombre de Usuario: " + username);
            passwordTextView.setText("Contraseña: " + password);
        }

        return rootView;
    }
}
