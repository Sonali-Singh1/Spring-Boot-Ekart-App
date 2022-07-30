package com.user.service;

import java.util.List;

import com.user.dto.UserDto;

public interface UserService {

	UserDto addData(UserDto user);

	UserDto getUser(int id);

	void updateData(UserDto user);

	List<UserDto> fetchAllUsers();

}
