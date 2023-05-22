package br.edu.ifsp.dmo.app13_lista_de_tarefas.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.dmo.app13_lista_de_tarefas.R;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.mvp.TaskDetailsMVP;
import br.edu.ifsp.dmo.app13_lista_de_tarefas.presenter.TaskDetailsPresenter;

public class TasksDetailsActivity extends AppCompatActivity implements TaskDetailsMVP.View, View.OnClickListener {

    private TaskDetailsMVP.Presenter presenter;
    private EditText titleEditText;
    private EditText descriptionEditText;
    private EditText creationDateEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtask);
        presenter = new TaskDetailsPresenter(this);
        findViews();
        setListener();
        setToolbar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.verifyUpdate();
    }

    @Override
    protected void onDestroy() {
        presenter.deatach();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if(v == saveButton){
            presenter.saveTask(
                    titleEditText.getText().toString(),
                    descriptionEditText.getText().toString(),
                    creationDateEditText.getText().toString());
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void updateUI(String title, String description, String creationDate) {
        titleEditText.setText(title);
        descriptionEditText.setText(description);
        creationDateEditText.setText(creationDate);
    }

    @Override
    public Bundle getBundle() {
        return getIntent().getExtras();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void close() {
        presenter.deatach();
        finish();
    }

    private void findViews(){
        titleEditText = findViewById(R.id.edittext_title_details);
        descriptionEditText = findViewById(R.id.edittext_description_details);
        creationDateEditText = findViewById(R.id.edittext_date_details);
        saveButton = findViewById(R.id.button_save_task);
    }

    private void setListener(){
        saveButton.setOnClickListener(this);
    }

    private void setToolbar(){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}