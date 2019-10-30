package com.ola.mtracks.dto;

import java.util.Set;

import com.ola.mtracks.models.Playlist;

public class TracksDto {
	
	private Long id;
	private String trackTitle;
	private Set<Playlist> playList;
	private String singer;
	private String actor;
	private String actress;
	private long noOfPlays;
	private long likes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrackTitle() {
		return trackTitle;
	}
	
	public Set<Playlist> getPlayList() {
		return playList;
	}
	public void setPlayList(Set<Playlist> playList) {
		this.playList = playList;
	}
	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public long getNoOfPlays() {
		return noOfPlays;
	}
	public void setNoOfPlays(long noOfPlays) {
		this.noOfPlays = noOfPlays;
	}
	public long getLikes() {
		return likes;
	}
	public void setLikes(long likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "TracksDto [id=" + id + ", trackTitle=" + trackTitle + ", playList=" + playList + ", singer=" + singer
				+ ", actor=" + actor + ", actress=" + actress + ", noOfPlays=" + noOfPlays + ", likes=" + likes + "]";
	}
	
	
	

}
