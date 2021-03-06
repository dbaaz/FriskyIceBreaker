package com.frisky.icebreaker.ui.profile;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.frisky.icebreaker.R;

public class ViewProfileActivity extends AppCompatActivity {

    ImageButton mEditButton;
    ViewPager mProfileImagePager;
    PagerAdapter mProfileImageAdapter;
    TextView mUserNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEditButton = findViewById(R.id.button_edit);
        mEditButton.setVisibility(View.GONE);

        mUserNameText = findViewById(R.id.text_name);

        mProfileImagePager = findViewById(R.id.pager_profile_images);
        mProfileImageAdapter = new ProfileImageAdapter(this);
        mProfileImagePager.setAdapter(mProfileImageAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra("name")){
            String name = getIntent().getStringExtra("name");
            getSupportActionBar().setTitle(name);
            mUserNameText.setText(name);
        }

        FloatingActionButton fab = findViewById(R.id.fab_ping);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Initiate 'Ping' from this.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
