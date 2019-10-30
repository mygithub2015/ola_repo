package com.ola.mtracks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ola.mtracks.models.Tracks;
import com.ola.mtracks.service.ITracksService;

@RestController
@RequestMapping("tracks")
public class TracksController {

	@Autowired
	private ITracksService tracksService;

	@PostMapping("/add")
	public Tracks addTracks(@RequestBody Tracks tracks) {
		return this.tracksService.addTracks(tracks);
	}

	@GetMapping("/get/{tracksId}")
	public Tracks retreiveTracks(Long tracksId) {
		return this.tracksService.getTracks(tracksId);
	}
	

	@PutMapping("/update")
	public Tracks updateTracks(@RequestBody Tracks tracks) {
		return this.tracksService.updateTracks(tracks);
	}

	@DeleteMapping("/delete/{tracksId}")
	public String deleteTracks(Long tracksId) {
		this.tracksService.deleteTracks(tracksId);
		return "Tracks with id: " + tracksId + " got deleted successfully!";

	}

	@GetMapping("/find/singers/{singer}")
	public Tracks findTracksBySinger(@PathVariable String singer) {

		return this.tracksService.findTracksBySinger(singer);

	}

	@GetMapping("/find/actors/{actor}")
	public Tracks findTracksByActor(@PathVariable String actor) {

		return this.tracksService.findTracksByActor(actor);

	}

	@GetMapping("/find/actresses/{actress}")
	public Tracks findTracksByActress(@PathVariable String actress) {

		return this.tracksService.findTracksByActress(actress);

	}

	@GetMapping("/find/titles/{trackTitle}")
	public Tracks findTracksByTrackTitle(@PathVariable String trackTitle) {

		return this.tracksService.findTracksByTrackTitle(trackTitle);

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
}