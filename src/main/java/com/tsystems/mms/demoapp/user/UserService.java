package com.tsystems.mms.demoapp.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.mms.demoapp.dto.UserCreationCommand;
import com.tsystems.mms.demoapp.dto.UserItem;
import com.tsystems.mms.demoapp.dto.UserUpdateCommand;
import com.tsystems.mms.demoapp.exception_handling.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This service manages all user.
 */
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * Find all users from the database.
	 * 
	 * @return List of users.
	 */
	public List<UserItem> getAll() {
		return userRepository.findAll().stream().map(UserItem::new).collect(Collectors.toList());
	}

	public User saveUser(UserCreationCommand command) {
		User user = new User(command);
		return userRepository.save(user);
	}

	public UserItem getById(Long id) {
		return new UserItem(userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id)));
	}
	
	public void updateUser(UserUpdateCommand command, Long id) {
		User userForUpdate = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		
			userForUpdate.setEmail(command.getEmail());
			userForUpdate.setFirstName(command.getFirstName());
			userForUpdate.setSurname(command.getSurname());
		
		
	}
	
	public void deleteUser(Long id) {
		User userForDelete = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		
	
			userRepository.delete(userForDelete);
		
		
	}
	
	

}
