package com.ola.mtracks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ola.mtracks.models.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
	
	//@Query(value="select id, tag_id from playlist where tag_id=:tagId",nativeQuery = true)
	Playlist findByTagId(Long tagId);

}
