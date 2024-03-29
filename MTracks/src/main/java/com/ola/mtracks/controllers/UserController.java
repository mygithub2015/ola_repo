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

import com.ola.mtracks.dto.UserDto;
import com.ola.mtracks.models.Playlist;
import com.ola.mtracks.models.User;
import com.ola.mtracks.service.IPlaylistService;
import com.ola.mtracks.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPlaylistService playlistService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/add")
	public UserDto addUser(@RequestBody UserDto userDto) throws ParseException {
		User user = convertToEntity(userDto);
		User userCreated = this.userService.addUser(user);
		return convertToDto(userCreated);
		
	}
	
	@GetMapping("/find/{userId}")
	public UserDto retreiveUser(@PathVariable Long userId) {
		User userFetched = this.userService.getUser(userId);
		return convertToDto(userFetched);
	}
	
	@GetMapping("/find/all")
	public List<UserDto> findAllUsers(){
		List<User> users = this.userService.findAllUsers();
		return users.stream().map(u->convertToDto(u)).collect(Collectors.toList());
	}
	@PutMapping("/update")
	public UserDto updateUser(@RequestBody UserDto userDto) throws ParseException {
		User user = convertToEntity(userDto);
		User userUpdated = this.userService.updateUser(user);
		return convertToDto(userUpdated);
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		this.userService.deleteUser(userId);
		return "User with id: "+userId+" got deleted successfully!";
	}
	
	private UserDto convertToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		//userDto.setGender(user.getGender().getGender());
		userDto.setPlayListId(user.getPlayList().getId());
	    return userDto;
	}
	
	private User convertToEntity(UserDto userDto) throws ParseException {
		User user = modelMapper.map(userDto, User.class);
		Playlist playlist = this.playlistService.getPlaylist(userDto.getPlayListId());
		user.setPlayList(playlist);
		//user.setGender(Gender.valueOf(userDto.getGender()));
	    return user;
	}


}
