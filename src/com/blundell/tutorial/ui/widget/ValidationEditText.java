package com.blundell.tutorial.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.*;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This EditText will check its input from the user against the Validator you use with setValidator()
 * 
 * If it is valid input the method will return true
 * 
 * If it is invalid input the method will return false and 'shake' the EditText
 * 
 * @author Blundell
 * 
 */
public class ValidationEditText extends EditText {

	private Validator validator;

	public interface Validator {
		boolean validate(String input);
	}

	public ValidationEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public ValidationEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ValidationEditText(Context context) {
		super(context);
		init();
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public boolean hasValidInput() {
		if (validator == null) {
			throw new InstantiationError("Please set a validator first, using setValidator()");
		}
		boolean valid = validator.validate(getText().toString());

		if (!valid) {
			notifyUser();
		}

		return valid;
	}

	private void notifyUser() {
		// From XML Animation (recommended)
//		Animation shake = AnimationUtils.loadAnimation(getContext(), R.anim.shake);
		// Programmatic Animation
		Animation shake = new TranslateAnimation(0, 5, 0, 0);
		shake.setInterpolator(new CycleInterpolator(5));
		shake.setDuration(300);

		startAnimation(shake);
	}

	/**
	 * Optional - but recommended
	 * 
	 * This will check the input when he user hits the 'done' button on the keyboard
	 */
	private void init() {
		setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (EditorInfo.IME_ACTION_DONE == actionId) {
					hasValidInput();
				}
				return false;
			}
		});
	}

}
