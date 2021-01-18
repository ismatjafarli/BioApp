package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.bio.data.Bio;
import com.example.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Bio bio = new Bio();


//      private EditText enterHobbies;
//      private TextView hobbies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        enterHobbies = findViewById(R.id.enter_your_hobbies);
//        hobbies = findViewById(R.id.hobbies_text);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bio.setName("Ismat Jafarli");
        binding.setBio(bio);
        binding.doneButton.setOnClickListener(this::addHobbies);

    }

    public void addHobbies(View view) {
//        hobbies.setText(String.format("Hobbies: %s", enterHobbies.getText().toString().trim()));
//        hobbies.setVisibility(View.VISIBLE);

        bio.setHobbies(String.format("Hobbies: %s",
                binding.enterYourHobbies.getText().toString().trim()));
//        binding.hobbiesText.setText(String.format("Hobbies: %s",
//                binding.enterYourHobbies.getText().toString().trim()));
        binding.invalidateAll();
        binding.hobbiesText.setVisibility(View.VISIBLE);

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}