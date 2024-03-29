package com.ola.mtracks.dto;

import com.ola.mtracks.models.Tags;

public class PlaylistDto {

	private Long id;
	
	private Tags tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "PlaylistDto [id=" + id + ", tags=" + tags + "]";
	}

	

	
	
	
}
