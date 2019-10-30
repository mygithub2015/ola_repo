package com.ola.mtracks.controllers;

import java.text.ParseException;

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

import com.ola.mtracks.dto.TracksDto;
import com.ola.mtracks.models.Tracks;
import com.ola.mtracks.service.ITracksService;

@RestController
@RequestMapping("tracks")
public class TracksController {

	@Autowired
	private ITracksService tracksService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/add")
	public TracksDto addTracks(@RequestBody TracksDto tracksDto) throws ParseException {
		Tracks tracks = convertToEntity(tracksDto);
		Tracks createdTracks = this.tracksService.addTracks(tracks);
		return convertToDto(createdTracks);
	}

	@GetMapping("/get/{tracksId}")
	public TracksDto retreiveTracks(Long tracksId) {
		Tracks fetchedTracks = this.tracksService.getTracks(tracksId);
		return convertToDto(fetchedTracks);
	}
	

	@PutMapping("/update")
	public TracksDto updateTracks(@RequestBody TracksDto tracksDto) throws ParseException {
		Tracks tracks = convertToEntity(tracksDto);
		Tracks updatedTracks = this.tracksService.addTracks(tracks);
		return convertToDto(updatedTracks);
	}

	@DeleteMapping("/delete/{tracksId}")
	public String deleteTracks(Long tracksId) {
		this.tracksService.deleteTracks(tracksId);
		return "Tracks with id: " + tracksId + " got deleted successfully!";

	}

	@GetMapping("/find/singers/{singer}")
	public TracksDto findTracksBySinger(@PathVariable String singer) {

		Tracks fetchedTracks = this.tracksService.findTracksBySinger(singer);
		return convertToDto(fetchedTracks);

	}

	@GetMapping("/find/actors/{actor}")
	public TracksDto findTracksByActor(@PathVariable String actor) {

		Tracks fetchedTracks = this.tracksService.findTracksByActor(actor);
		return convertToDto(fetchedTracks);

	}

	@GetMapping("/find/actresses/{actress}")
	public TracksDto findTracksByActress(@PathVariable String actress) {
		
		Tracks fetchedTracks = this.tracksService.findTracksByActress(actress);
		return convertToDto(fetchedTracks);


	}

	@GetMapping("/find/titles/{trackTitle}")
	public TracksDto findTracksByTrackTitle(@PathVariable String trackTitle) {

		Tracks fetchedTracks = this.tracksService.findTracksByTrackTitle(trackTitle);
		return convertToDto(fetchedTracks);

	}
	
	@GetMapping("/find/no_of_plays/{trackId}")
	public Long findNoOfPlayByTrackId(@PathVariable Long trackId) {
		
		return this.tracksService.findNoOfPlayByTrackId(trackId);
	}
	
	@GetMapping("/find/no_of_plays/{trackTitle}")
	public Long findNoOfPlayByTrackTitle(@PathVariable String trackTitle) {
		
		return this.tracksService.findNoOfPlayByTrackTitle(trackTitle);
	}
	
	@GetMapping("/find/no_of_likes/{trackId}")
	public Long findNoOfLikesByTrackId(@PathVariable Long trackId) {
		
		return this.tracksService.findNoOfLikesByTrackId(trackId);
	}
	
	@GetMapping("/find/no_of_likes/{trackTitle}")
	public Long findNoOfLikesByTrackTitle(@PathVariable String trackTitle) {
		
		return this.tracksService.findNoOfLikesByTrackTitle(trackTitle);
	}
	
	private TracksDto convertToDto(Tracks tracks) {
		TracksDto tracksDto = modelMapper.map(tracks, TracksDto.class);
		//tracksDto.setGender(user.getGender().getGender());
	    return tracksDto;
	}
	
	private Tracks convertToEntity(TracksDto tracksDto) throws ParseException {
		Tracks tracks = modelMapper.map(tracksDto, Tracks.class);
		//user.setGender(Gender.valueOf(tracksDto.getGender()));
	    return tracks;
	}
}
