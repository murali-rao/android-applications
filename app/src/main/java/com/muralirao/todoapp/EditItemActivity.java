package com.muralirao.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    EditText editText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String text = getIntent().getStringExtra("text");
        position = getIntent().getIntExtra("id",0);

        editText = (EditText)findViewById(R.id.editText);
        editText.setText(text);

        editText.setSelection(text.length());
        editText.requestFocus();

    }

    public void save(View view) {
        Intent data = new Intent();
        data.putExtra("itemText",editText.getText().toString());
        data.putExtra("itemId",position);
        data.putExtra("code", 200);
        setResult(RESULT_OK, data);
        finish();
    }
}
