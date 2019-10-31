package com.ola.mtracks.controllers;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ola.mtracks.dto.PlaylistDto;
import com.ola.mtracks.dto.UserDto;
import com.ola.mtracks.models.Playlist;
import com.ola.mtracks.models.Tags;
import com.ola.mtracks.models.User;
import com.ola.mtracks.service.IPlaylistService;
import com.ola.mtracks.service.ITagsService;

@RestController
@RequestMapping("playlist")
public class PlaylistController {
	
	@Autowired
	private IPlaylistService playlistService;
	@Autowired
	private ITagsService tagsService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/add")
	public PlaylistDto addPlaylist(@RequestBody PlaylistDto playlistDto) throws ParseException {
		Playlist playlist = convertToEntity(playlistDto);
		Playlist createdPlaylist = this.playlistService.addPlaylist(playlist);
		return convertToDto(createdPlaylist);
	}
	
	@GetMapping("/get/{playlistId}")
	public PlaylistDto retrievePlaylist(@PathVariable Long playlistId) {
		Playlist fetchedPlaylist = this.playlistService.getPlaylist(playlistId);
		return convertToDto(fetchedPlaylist);
	}
	
	@GetMapping("/explore")
	public List<PlaylistDto> findAllPlaylists(){
		List<Playlist> playlists = this.playlistService.findAllPlaylists();
		return playlists.stream().map(p->convertToDto(p)).collect(Collectors.toList());
	}
	
	@PutMapping("/update")
	public PlaylistDto updatePlaylist(@RequestBody PlaylistDto playlistDto) throws ParseException {
		Playlist playlist = convertToEntity(playlistDto);
		Playlist updatedPlaylist = this.playlistService.updatePlaylist(playlist);
		return convertToDto(updatedPlaylist);
	}
	
	@DeleteMapping("/delete/{playlistId}")
	public String deletePlaylist(@PathVariable Long playlistId) {
		this.playlistService.deletePlaylist(playlistId);
		return "Playlist with id: "+playlistId+" got deleted successfully!";

	}
	
	@GetMapping("/get/tags/{tagsId}")
	public List<PlaylistDto> findPlaylistByTags(@PathVariable Long tagsId) {
		List<Playlist> fetchedPlaylist = this.playlistService.getPlaylistByTagId(tagsId);
		return fetchedPlaylist.stream().map(i->convertToDto(i)).collect(Collectors.toList());
	}
	
	private PlaylistDto convertToDto(Playlist playlist) {
		PlaylistDto playlistDto = modelMapper.map(playlist, PlaylistDto.class);
		//playlistDto.setTagsId(playlist.getTag().getId());
		playlistDto.setTags(playlist.getTag());
	    return playlistDto;
	}
	
	private Playlist convertToEntity(PlaylistDto playlistDto) throws ParseException {
		Playlist playlist = modelMapper.map(playlistDto, Playlist.class);
		playlist.setTag(playlistDto.getTags());
	    return playlist;
	}

}
