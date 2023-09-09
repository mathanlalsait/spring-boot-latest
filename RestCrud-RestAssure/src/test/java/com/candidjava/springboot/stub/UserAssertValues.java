package com.candidjava.springboot.stub;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.candidjava.springboot.entity.User;

public class UserAssertValues 
{

	public static TypeSafeMatcher<User> isSameSide(final User expected) {
		return new TypeSafeMatcher<User>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("Expected data : ")
						.appendValue(expected.getName() + "," + expected.getId() + "," + expected.getEmail() + ","
								+ expected.getAge() + "," + expected.getCity() + "," + expected.getPassword());
			}

			@Override
			protected boolean matchesSafely(User actual) {
				return actual.getName().equals(expected.getName()) && 
						actual.getEmail().equals(expected.getEmail()) && 
						actual.getPassword().equals(expected.getPassword())&& 
						actual.getCity().equals(expected.getCity()) &&
						actual.getAge() == expected.getAge();
			}
		};
	}
}
