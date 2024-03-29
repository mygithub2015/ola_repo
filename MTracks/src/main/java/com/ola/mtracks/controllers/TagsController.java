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

import com.ola.mtracks.dto.TagsDto;
import com.ola.mtracks.dto.UserDto;
import com.ola.mtracks.models.Tags;
import com.ola.mtracks.models.User;
import com.ola.mtracks.service.ITagsService;

@RestController
@RequestMapping("tags")
public class TagsController {
	
	@Autowired
	private ITagsService tagsService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/add")
	public TagsDto addTags(@RequestBody TagsDto tagsDto) throws ParseException {
	
		Tags tags = convertToEntity(tagsDto);
		Tags createdTags = this.tagsService.addTags(tags);
		return convertToDto(createdTags);
	}
	
	@GetMapping("/get/{tagsId}")
	public TagsDto retrieveTags(@PathVariable Long tagsId) {
		Tags fetchedTags= this.tagsService.getTags(tagsId);
		return convertToDto(fetchedTags);
		
	}
	
	@GetMapping("/get/all")
	public List<TagsDto> findAllTags(){
		List<Tags> tags = this.tagsService.findAllTags();
		return tags.stream().map(t->convertToDto(t)).collect(Collectors.toList());
	}
	@PutMapping("/update")
	public TagsDto updateTags(@RequestBody TagsDto tagsDto) throws ParseException {
		Tags tags = convertToEntity(tagsDto);
		Tags updatedTags= this.tagsService.updateTags(tags);
		return convertToDto(updatedTags);
		
	}
	
	@DeleteMapping("/delete/{tagsdId")
	public String deleteTags(@PathVariable Long tagsId) {
		this.tagsService.deleteTags(tagsId);
		return "Tags with id: "+tagsId+" got deleted successfully!";

	}
	
	private TagsDto convertToDto(Tags tags) {
	    TagsDto tagsDto = modelMapper.map(tags, TagsDto.class);
	    //tagsDto.setGenre(tags.getGenre().getGenre());
	    return tagsDto;
	}
	
	private Tags convertToEntity(TagsDto tagsDto) throws ParseException {
	    Tags tags = modelMapper.map(tagsDto, Tags.class);
	   // tags.setGenre(Genre.valueOf(tagsDto.getGenre()));
	    return tags;
	}

}
