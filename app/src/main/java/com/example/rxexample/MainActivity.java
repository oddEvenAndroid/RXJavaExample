package com.example.rxexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rxexample.customDataType.CustomDataTypeRXActivity;

public class MainActivity extends AppCompatActivity {

	Button btn_DisposableRX, btn_FilterRx, btn_DisposableObserver, btn_CustomDataType;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_DisposableRX = findViewById(R.id.btn_DisposableRX);
		btn_FilterRx = findViewById(R.id.btn_FilterRx);
		btn_DisposableObserver = findViewById(R.id.btn_DisposableObserver);
		btn_CustomDataType = findViewById(R.id.btn_CustomDataType);

		btn_DisposableRX.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, DisposableRXActivity.class));
			}
		});

		btn_FilterRx.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, RXFilterActivity.class));
			}
		});

		btn_DisposableObserver.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, DisposableObserverRX.class));
			}
		});

		btn_CustomDataType.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, CustomDataTypeRXActivity.class));
			}
		});


	}


}
