package com.example.noteapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID= "com.EXTRA_ID";
    public static final String EXTRA_TITLE = "com.EXTRA_TITLE";

    public static final String EXTRA_DESCRIPTION = "com.DESCRIPTION";

    public static final String EXTRA_PRIORITY = "com.PRIORITY";
    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerpriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerpriority = findViewById(R.id.number_picker_priority);
        numberPickerpriority.setMaxValue(10);
        numberPickerpriority.setMinValue(1);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_close_24);
        Intent intent =getIntent();
        if(intent.hasExtra(EXTRA_ID))
        {
            setTitle("Edit Note");
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            numberPickerpriority.setValue(1);

        }
        else
        {
         setTitle("Add Note");
        }
        setTitle("Add Note");
    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerpriority.getValue();
        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "please inseart a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);
        int id =getIntent().getIntExtra(EXTRA_ID,1);
        if(id != -1)
            data.putExtra(EXTRA_ID , id);

        setResult(RESULT_OK, data);
        finish();
    }


}
