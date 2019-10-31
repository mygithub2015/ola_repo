package com.ola.mtracks.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tracks")
@Data
public class Tracks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="track_title")
	private String trackTitle;
	@ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
        name = "Tracks_Playlist", 
        joinColumns = { @JoinColumn(name = "track_id", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "playlist_id", referencedColumnName = "id")})
//	@ManyToMany(mappedBy="tracks")
	private Set<Playlist> playList = new HashSet<>();
	@Column(name="singer")
	private String singer;
	@Column(name="actor")
	private String actor;
	@Column(name="actress")
	private String actress;
	@Column(name="no_of_plays")
	private long noOfPlays;
	@Column(name="likes")
	private long likes;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTrackTitle() {
		return trackTitle;
	}
	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}
	public Set<Playlist> getPlayList() {
		return playList;
	}
	public void setPlayList(Set<Playlist> playList) {
		this.playList = playList;
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
	
	

}
