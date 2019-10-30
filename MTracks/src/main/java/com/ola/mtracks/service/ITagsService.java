package com.ola.mtracks.service;

import java.util.List;

import com.ola.mtracks.models.Tags;

public interface ITagsService {

	Tags addTags(Tags tag);
	Tags getTags(Long tagsId);
	Tags updateTags(Tags tag);
	void deleteTags(Long tagsId);
	List<Tags> findAllTags();

}
