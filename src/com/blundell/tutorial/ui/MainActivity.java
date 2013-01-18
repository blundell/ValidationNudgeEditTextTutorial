package com.blundell.tutorial.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blundell.tutorial.R;
import com.blundell.tutorial.ui.widget.ValidationEditText;
import com.blundell.tutorial.util.EmailAddressValidator;

public class MainActivity extends Activity {

	private ValidationEditText emailAddressInputEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		emailAddressInputEditText = (ValidationEditText) findViewById(R.id.main_et_email_address);
		emailAddressInputEditText.setValidator(new EmailAddressValidator());
	}

	public void onDoneClicked(View btn) {
		if (emailAddressInputEditText.hasValidInput()) {
			Toast.makeText(this, "Success! Carry on with app...", Toast.LENGTH_LONG).show();
		}
	}

}
