package com.ola.mtracks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.mtracks.models.Tracks;
import com.ola.mtracks.repositories.TracksRepository;
@Service
public class TracksServiceImpl implements ITracksService {

	@Autowired
	private TracksRepository tracksRepository;
	@Override
	public Tracks addTracks(Tracks tracks) {
		return this.tracksRepository.save(tracks);
	}

	@Override
	public Tracks getTracks(Long tracksId) {
		return this.tracksRepository.getOne(tracksId);
	}

	@Override
	public Tracks updateTracks(Tracks tracks) {
		return this.tracksRepository.save(tracks);
	}

	@Override
	public void deleteTracks(Long tracksId) {
		 this.tracksRepository.deleteById(tracksId);
	}

	@Override
	public Tracks findTracksBySinger(String singer) {
		return this.tracksRepository.findBySinger(singer);
	}

	@Override
	public Tracks findTracksByTrackTitle(String trackTitle) {
		return this.tracksRepository.findByTrackTitle(trackTitle);
	}

	@Override
	public Tracks findTracksByActor(String actor) {
		return this.tracksRepository.findByActor(actor);
	}

	@Override
	public Tracks findTracksByActress(String actress) {
		return this.tracksRepository.findByActress(actress);
	}

	@Override
	public Long findNoOfPlayByTrackId(Long trackId) {
		return this.tracksRepository.findNoOfPlayByTrackId(trackId);
	}

	@Override
	public Long findNoOfLikesByTrackId(Long trackId) {
		return this.tracksRepository.findNoOfLikesByTrackId(trackId);
	}

	@Override
	public Long findNoOfPlayByTrackTitle(String trackTitle) {
		return this.tracksRepository.findNoOfPlayByTrackTitle(trackTitle);
	}

	@Override
	public Long findNoOfLikesByTrackTitle(String trackTitle) {
		return this.tracksRepository.findNoOfLikesByTrackTitle(trackTitle);
	}

	@Override
	public List<Tracks> findAllTracks() {
		return this.tracksRepository.findAll();
	}

}
