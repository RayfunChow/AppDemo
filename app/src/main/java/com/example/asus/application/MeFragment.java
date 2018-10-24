package com.example.asus.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MeFragment extends Fragment implements View.OnClickListener {

    private Button btnEditUserInfo;
    private Button btnSettings;
    private Button btnAbout;
    private Button btnExit;
    private Button[] buttons;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_me,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnEditUserInfo=getActivity().findViewById(R.id.btn_edit_user_info);
        btnSettings=getActivity().findViewById(R.id.btn_settings);
        btnAbout=getActivity().findViewById(R.id.btn_about_us);
        btnExit=getActivity().findViewById(R.id.btn_exit);

        buttons = new Button[]{btnEditUserInfo,btnSettings,btnAbout,btnExit};

        for(Button b: buttons)
            b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit_user_info:
                break;
            case R.id.btn_settings:
                break;
            case R.id.btn_about_us:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
            case R.id.btn_exit:
                getActivity().finish();
                break;
        }
    }
}
