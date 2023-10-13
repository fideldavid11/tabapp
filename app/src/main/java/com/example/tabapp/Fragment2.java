package com.example.tabapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        usernameEditText = rootView.findViewById(R.id.usernameEditText);
        passwordEditText = rootView.findViewById(R.id.passwordEditText);
        submitButton = rootView.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    // Muestra una alerta si los campos están vacíos
                    Toast.makeText(getActivity(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Pasa los datos a la siguiente pestaña (UserDataFragment)
                    UserDataFragment userDataFragment = new UserDataFragment();
                    Bundle args = new Bundle();
                    args.putString("username", username);
                    args.putString("password", password);
                    userDataFragment.setArguments(args);

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, userDataFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        return rootView;
    }
}
