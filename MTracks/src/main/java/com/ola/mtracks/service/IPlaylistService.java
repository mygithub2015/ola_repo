package com.ola.mtracks.service;

import java.util.List;

import com.ola.mtracks.models.Playlist;

public interface IPlaylistService {
	
	Playlist addPlaylist(Playlist playlist);
	Playlist getPlaylist(Long playlistId);
	Playlist updatePlaylist(Playlist playlist);
	void deletePlaylist(Long playlistId);
	List<Playlist> getPlaylistByTagId(Long tagId);
	List<Playlist> findAllPlaylists();

}
