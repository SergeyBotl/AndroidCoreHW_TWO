package com.example.sergey.lesson12_newspaper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {
    private OnClickListener mOnClickListener;

    public interface OnClickListener {
        void onClickOnTitle();

        void onClickOnForgot();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, null);
        final EditText etUsername = (EditText) view.findViewById(R.id.et_username);
        final EditText etPassword = (EditText) view.findViewById(R.id.et_password);
        final TextView forgot = (TextView) view.findViewById(R.id.textViewForgotInLogin);
        final CheckBox cbShowPassword = (CheckBox) view.findViewById(R.id.cb_show_password);

        mOnClickListener = (OnClickListener) getActivity();
        cbShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // to encode password in dots
                    etPassword.setTransformationMethod(null);
                } else {
                    // to display the password in normal text
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        view.findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPassword.getText().length() > 0 && etUsername.getText().length() > 0) {
                    Toast.makeText(getContext(), "Username: " + etUsername.getText() + "\nPassword: " + etPassword.getText(), Toast.LENGTH_SHORT).show();
                    mOnClickListener.onClickOnTitle();
                } else {
                    Toast.makeText(getContext(), "Неверный логин или пароль", Toast.LENGTH_SHORT).show();

                }
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClickListener.onClickOnForgot();
            }
        });
        return view;

    }

}
