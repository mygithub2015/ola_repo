package com.ola.mtracks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.mtracks.models.Playlist;
import com.ola.mtracks.repositories.PlaylistRepository;
@Service
public class PlaylistServiceImpl implements IPlaylistService {

	@Autowired
	private PlaylistRepository playListRepository;
	
	@Override
	public Playlist addPlaylist(Playlist playList) {
		return this.playListRepository.save(playList);
	}

	@Override
	public Playlist getPlaylist(Long playlistId) {
		return this.playListRepository.getOne(playlistId);
	}

	@Override
	public Playlist updatePlaylist(Playlist playList) {
		return this.playListRepository.save(playList);
	}

	@Override
	public void deletePlaylist(Long playlistId) {
		 this.playListRepository.deleteById(playlistId);
	}

	

	@Override
	public List<Playlist> findAllPlaylists() {
		return this.playListRepository.findAll();
	}

	@Override
	public List<Playlist> getPlaylistByTagId(Long tagId) {
		return this.playListRepository.findByTagId(tagId);

	}

}
