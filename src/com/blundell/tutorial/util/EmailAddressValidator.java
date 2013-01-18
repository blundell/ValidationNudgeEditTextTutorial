package com.blundell.tutorial.util;

import com.blundell.tutorial.ui.widget.ValidationEditText.Validator;

/**
 * This is an Email Address Validator, you can validate anything that goes into an EditText just implement Validator
 * 
 * @author Blundell
 * 
 */
public class EmailAddressValidator implements Validator {

	/**
	 * Simple validation for Tutorial. If it has an @ sign then it is a valid email address
	 */
	@Override
	public boolean validate(String input) {
		if (input.contains("@")) {
			return true;
		}
		return false;
	}

}
