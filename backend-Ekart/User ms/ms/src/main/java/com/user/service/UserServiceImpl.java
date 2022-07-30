package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo repo;
	@Override
	public UserDto addData(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=UserDto.prepareEntity(userDto);
		repo.saveAndFlush(user);
		User u=repo.getByName(userDto.getName());
		UserDto userDTO=UserDto.prepareDto(u);
		return userDTO;
	}
	@Override
	public UserDto getUser(int id) {
		// TODO Auto-generated method stub
		Optional<User> user=Optional.ofNullable(repo.getById(id));
		User user1=user.get();
		return UserDto.prepareDto(user1);
	}
	@Override
	public void updateData(UserDto userDto) {
		// TODO Auto-generated method stub
		int id=userDto.getId();
		Optional<User> u=Optional.ofNullable(repo.getById(id));
		User user=u.get();
		if(user==null) {
			repo.saveAndFlush(UserDto.prepareEntity(userDto));
		}
		else {
			user.setCity(userDto.getCity());
			user.setCountry(userDto.getCountry());
			user.setState(userDto.getState());
			user.setPincode(userDto.getPincode());
			repo.save(user);
		}
	}
	@Override
	public List<UserDto> fetchAllUsers() {
		// TODO Auto-generated method stub
		List<UserDto> users=new ArrayList<>();
		List<User> user=repo.findAll();
		for(User u: user) {
			users.add(UserDto.prepareDto(u));
		}
		return users;
	}
}
