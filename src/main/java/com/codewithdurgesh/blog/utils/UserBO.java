package com.codewithdurgesh.blog.utils;

public class UserBO {

	public static void validate(User u) throws InvalidPasswordException {

		if (u != null) {

			if (u.getPassword() != null && u.getPassword().length() > 0) {

				String password = u.getPassword();

				// validate password has minimum 10 & maximum 20 char
				if (password.length() >= 10 && password.length() <= 20) {

					// validate at least one digit is present or not
					boolean digitFlag = false;
					for (int i = 0; i <= 9; i++) {
						if (password.contains(Integer.toString(i))) {
							digitFlag = true;
							break;
						}

					}
					if (!digitFlag)
						throw new InvalidPasswordException("Should contain at least one digit");

					// validate at least one special char
					String specialChars = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
					boolean specialCharFlag = false;
					for (int i = 0; i < password.length(); i++) {
						if (specialChars.contains(Character.toString(password.charAt(i)))) {
							specialCharFlag = true;
							break;
						}
					}
					if (!specialCharFlag)
						throw new InvalidPasswordException("It should contain at least one special character");

				} else {
					throw new InvalidPasswordException("Should be minimum of 10 characters and maximum of 20");
				}
				
				System.out.println("Valid Password");
			}

		}

	}

}
