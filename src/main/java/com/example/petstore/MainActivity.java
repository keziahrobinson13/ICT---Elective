package com.example.petstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Name, Surname, Pet_Name, Previous_Diagnosis, Previous_Prescriptions, Account_Number;
    Database db;
    Button btnAddData;
    Button btnViewData;
    Button btnUpdateData;
    Button btnDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



     db=new Database(this);
     btnAddData = (Button) findViewById(R.id.btnAddData);
     btnViewData = (Button) findViewById(R.id.btnViewData);
     btnUpdateData = (Button) findViewById(R.id.btnUpdataData);
     btnDeleteData = (Button) findViewById(R.id.btnDeleteData);
     AddData();
     UpdateData();
     DeleteData();
    }

    private void DeleteData() {
    btnDeleteData.setOnClickListener((v) -> {
        Integer deletedRows = db.deleteData(Name.getText().toString());
        if ( deletedRows > 0 ){
            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
        }
        else
        {
           Toast.makeText(MainActivity.this, "Data not deleted", Toast.LENGTH_SHORT).show();
        }
    }
    );

    }


    private void UpdateData() {
        btnUpdateData.setOnClickListener((v) -> {
                    boolean IsUpdate = db.updateData(Name.getText().toString(), Surname.getText().toString(), Pet_Name.getText().toString(), Previous_Diagnosis.getText().toString(), Previous_Prescriptions.getText().toString(), Account_Number.getText().toString());
                    if (IsUpdate == true) {
                        Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
                );
    }



    private void AddData() {

        btnAddData.setOnClickListener((v) -> {
            boolean IsInserted = db.insertData(Name.getText().toString(),
            Surname.getText().toString(),
            Pet_Name.getText().toString(),
            Previous_Diagnosis.getText().toString(),
            Previous_Prescriptions.getText().toString(),
            Account_Number.getText().toString());

            if (IsInserted==true)
            {
                Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
            }
            else
                {
               Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }


        });
    }
}