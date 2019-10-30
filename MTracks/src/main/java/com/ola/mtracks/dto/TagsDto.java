package com.ola.mtracks.dto;

public class TagsDto {
	private Long id;
	
	private String genre;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "TagsDto [id=" + id + ", genre=" + genre + "]";
	}
	
	

}
