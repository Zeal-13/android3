package com.example.rmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConstraintLayoutActivity extends AppCompatActivity {
    private EditText editText;
    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        editText = findViewById(R.id.editText);
        returnButton = findViewById(R.id.returnButton);

        TextHolder textHolder = (TextHolder) getIntent().getSerializableExtra("textData");
        if (textHolder != null) {
            editText.setText(textHolder.getText());
        }

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnText();
            }
        });
    }

    private void returnText() {
        String text = editText.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("text", text);
        startActivity(intent);
    }
}