package com.ola.mtracks.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ola.mtracks.enums.Genre;

import lombok.Data;

@Entity
@Table(name="tags")
@Data
public class Tags {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@OneToMany(mappedBy="tag")
	private Set<Playlist> playList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Set<Playlist> getPlayList() {
		return playList;
	}

	public void setPlayList(Set<Playlist> playList) {
		this.playList = playList;
	}
	
	

}
