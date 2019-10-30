package com.ola.mtracks.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tracks")
@Data
public class Tracks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="track_title")
	private String trackTitle;
	@ManyToMany(mappedBy="tracks")
	private Set<Playlist> playList;
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
	
	

}
