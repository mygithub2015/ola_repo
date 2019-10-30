package com.ola.mtracks.enums;


public enum Genre {
	Jazz("Jazz"), Classical("Classical"), Rock("Rock"), Pop("Pop"), Hip_Hop("Hip Hop"), Soul("Soul"), Disco("Disco"), Instrumental("Instrumental");
	
	private String genre;
	
	private Genre(String genre) {
		this.genre=genre;
	}
	
	public String getGenre() {
		return this.genre;
	}

}
