package com.ola.mtracks.dto;


public class PlaylistDto {

	private Long id;
	
	private Long tagsId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTagsId() {
		return tagsId;
	}

	public void setTagsId(Long tagsId) {
		this.tagsId = tagsId;
	}

	@Override
	public String toString() {
		return "PlaylistDto [id=" + id + ", tagsId=" + tagsId + "]";
	}

	
	
	
}
