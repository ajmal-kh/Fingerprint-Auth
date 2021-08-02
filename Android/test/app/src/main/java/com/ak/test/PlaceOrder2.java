package com.ak.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class PlaceOrder2 extends AppCompatActivity {
    private EditText etFirst,etLast,etMobile,etAltMobile,etPin,etHouse,etRoad,etLandmark,etCity,etState;
    private Button btnOrder;
    DatabaseReference databaseReference;
    //myorder
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_order2);
        etFirst = (EditText) findViewById(R.id.etFirst);
        etLast = (EditText) findViewById(R.id.etLast);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etAltMobile = (EditText) findViewById(R.id.etAltMobile);
        etPin = (EditText) findViewById(R.id.etPin);
        etHouse = (EditText) findViewById(R.id.etHouse);
        etRoad = (EditText) findViewById(R.id.etRoad);
        etLandmark = (EditText) findViewById(R.id.etLandmark);
        etCity = (EditText) findViewById(R.id.etCity);
        etState = (EditText) findViewById(R.id.etState);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        databaseReference = FirebaseDatabase.getInstance().getReference("PopularProduct2");

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUsers();
            }
        });
    }
    public void addUsers(){
        String first = etFirst.getText().toString().trim();
        String last = etLast.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String altMobile = etAltMobile.getText().toString().trim();
        String pin = etPin.getText().toString().trim();
        String house = etHouse.getText().toString().trim();
        String road = etRoad.getText().toString().trim();
        String landmark = etLandmark.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        String state = etState.getText().toString().trim();
        if(TextUtils.isEmpty(first))  {
            etFirst.setError("required");
        }else if(first.length()>10){
            etFirst.setError("should be less than 10");
        }else if(last.length()>10){
            etLast.setError("should be less than 10");
        }else if (TextUtils.isEmpty(last)){
            etLast.setError("required");
        }else if (TextUtils.isEmpty(mobile)){
            etMobile.setError("required");
        }else if(mobile.length()>10 || mobile.length()<10){
            etMobile.setError("enter valid 10 digit mobile number");
        }else if (TextUtils.isEmpty(pin)){
            etPin.setError("required");
        }else if(pin.length()>10){
            etPin.setError("enter valid pin number");
        }else if (TextUtils.isEmpty(house)){
            etHouse.setError("required");
        }else if (TextUtils.isEmpty(road)){
            etRoad.setError("required");
        }else if (TextUtils.isEmpty(city)){
            etCity.setError("required");
        }
        else {
            String id = databaseReference.push().getKey();
            User user = new User(id,first,last,mobile,altMobile,pin,house,road,landmark,city,state);
            databaseReference.child(id).setValue(user);
            Toast.makeText(PlaceOrder2.this,"Order Successfull",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PlaceOrder2.this,OrderSuccessfull2.class);
            startActivity(intent);
            //myorder
        }

    }
}
