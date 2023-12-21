package rudachenko.roman.myrestaurant.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import rudachenko.roman.myrestaurant.R;

public class SplashScreenActivity extends AppCompatActivity {
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Button button = findViewById(R.id.buttonRegistration);
        TextView textView = findViewById(R.id.textSignIn);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(SplashScreenActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });

        textView.setOnClickListener(v -> {
            Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        setAnim(textView, button);
    }

    private void setAnim(TextView textView, Button button){
        anim = AnimationUtils.loadAnimation(this,R.anim.anim);
        textView.startAnimation(anim);
        button.startAnimation(anim);
    }
}