package com.ola.mtracks.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="playlist")
@Data
public class Playlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy="playList")
	private User user;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Playlist_Tracks", 
        joinColumns = { @JoinColumn(name = "playlist_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "track_id") })
	private Set<Tracks> tracks;
	
	@ManyToOne
	@JoinColumn(name="tag_id")
	private Tags tag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Tracks> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Tracks> tracks) {
		this.tracks = tracks;
	}

	public Tags getTag() {
		return tag;
	}

	public void setTag(Tags tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", user=" + user + ", tracks=" + tracks + ", tag=" + tag + "]";
	}
	
	
}
