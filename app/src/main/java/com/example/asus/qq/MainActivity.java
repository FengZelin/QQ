package com.example.asus.qq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView name;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon = findViewById(R.id.image);
        name = findViewById(R.id.name);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI umShareAPI = UMShareAPI.get(MainActivity.this);
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        String screen_name = map.get("screen_name");
                        String profile_image_url = map.get("profile_image_url");
                        name.setText(screen_name);
                        Glide.with(MainActivity.this).load(profile_image_url).into(icon);
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
