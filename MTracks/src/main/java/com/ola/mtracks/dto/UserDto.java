package com.ola.mtracks.dto;

public class UserDto {
	
	private Long id;
	private String username;
	private String emailId;
	private int age;
	private String gender; 
	private Long playListId;
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getPlayListId() {
		return playListId;
	}
	public void setPlayListId(Long playListId) {
		this.playListId = playListId;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", emailId=" + emailId + ", age=" + age + ", gender="
				+ gender + ", playListId=" + playListId + "]";
	}
	
	
	
	

}
