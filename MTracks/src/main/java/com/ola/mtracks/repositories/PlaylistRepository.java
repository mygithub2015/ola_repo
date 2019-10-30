package com.ola.mtracks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ola.mtracks.models.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
	
	//@Query(value="select id, tag_id from playlist where tag_id=:tagId",nativeQuery = true)
	List<Playlist> findByTagId(Long tagId);
	List<Playlist> findByUserId(Long userId);
}
