package com.ola.mtracks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ola.mtracks.models.Tracks;

public interface TracksRepository extends JpaRepository<Tracks, Long> {
	
	Tracks findBySinger(String singer);
	Tracks findByActor(String actor);
	Tracks findByActress(String actress);
	Tracks findByTrackTitle(String trackTitle);
	@Query(value="select no_of_plays from tracks t where t.id = ?1", nativeQuery = true)
	Long findNoOfPlayByTrackId(Long trackId);
	@Query(value="select likes from tracks t where t.id = ?1", nativeQuery = true)
	Long findNoOfLikesByTrackId(Long trackId);
	@Query(value="select no_of_plays from tracks t where t.track_title = ?1", nativeQuery = true)
	Long findNoOfPlayByTrackTitle(String trackTitle);
	@Query(value="select likes from tracks t where t.track_title = ?1", nativeQuery = true)
	Long findNoOfLikesByTrackTitle(String trackTitle);


}
