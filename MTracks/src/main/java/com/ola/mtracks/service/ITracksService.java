package com.ola.mtracks.service;

import java.util.List;

import com.ola.mtracks.models.Tracks;

public interface ITracksService {
	Tracks addTracks(Tracks tracks);
	Tracks getTracks(Long tracksId);
	Tracks updateTracks(Tracks tracks);
	void deleteTracks(Long tracksId);
	Tracks findTracksBySinger(String singer);
	Tracks findTracksByTrackTitle(String trackTitle);
	Tracks findTracksByActor(String actor);
	Tracks findTracksByActress(String actress);
	Long findNoOfPlayByTrackId(Long trackId);
	Long findNoOfLikesByTrackId(Long trackId);
	Long findNoOfPlayByTrackTitle(String trackTitle);
	Long findNoOfLikesByTrackTitle(String trackTitle);
	List<Tracks> findAllTracks();

}
