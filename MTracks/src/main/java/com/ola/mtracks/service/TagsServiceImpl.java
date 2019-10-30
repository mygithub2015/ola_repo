package com.ola.mtracks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ola.mtracks.models.Tags;
import com.ola.mtracks.repositories.TagsRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class TagsServiceImpl implements ITagsService {
	
	@Autowired
	private TagsRepository tagsRepository;

	@Override
	public Tags addTags(Tags tag) {
		return this.tagsRepository.save(tag);
	}

	@Override
	public Tags getTags(Long tagsId) {
		return this.tagsRepository.getOne(tagsId);
	}

	@Override
	public Tags updateTags(Tags tag) {
		
		return this.tagsRepository.save(tag);
	}

	@Override
	public void deleteTags(Long tagsId) {
		this.tagsRepository.deleteById(tagsId);
	}

	@Override
	public List<Tags> findAllTags() {
		return this.tagsRepository.findAll();
	}

}
