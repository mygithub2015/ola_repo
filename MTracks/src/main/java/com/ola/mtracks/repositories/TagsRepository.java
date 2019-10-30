package com.ola.mtracks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ola.mtracks.models.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {

}
