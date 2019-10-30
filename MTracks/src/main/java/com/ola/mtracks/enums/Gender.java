package com.ola.mtracks.enums;

public enum Gender {
	
	Male("Male"), Female("Female"), Others("Others");
	
	private String gender;
	
	private Gender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return this.gender;
	}

}
