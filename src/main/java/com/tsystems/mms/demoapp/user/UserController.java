package com.tsystems.mms.demoapp.user;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.mms.demoapp.dto.UserCreationCommand;
import com.tsystems.mms.demoapp.dto.UserCreationCommandValidator;
import com.tsystems.mms.demoapp.dto.UserItem;
import com.tsystems.mms.demoapp.dto.UserUpdateCommand;

/**
 * RESTful API controller for managing users.
 */
@RestController
@RequestMapping("/api/v1.0/users")
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
  private final UserService userService;
  private UserCreationCommandValidator userCreationCommandValidator;

  public UserController(UserService userService, UserCreationCommandValidator userCreationCommandValidator) {
    this.userService = userService;
    this.userCreationCommandValidator = userCreationCommandValidator;
  }
  
  @InitBinder("userCreationCommand")
  public void init(WebDataBinder binder) {
      binder.addValidators(userCreationCommandValidator);
  }
  

  /**
   * Finds all users.
   * @return A list of users.
   */
  @GetMapping()
  public ResponseEntity<List<UserItem>> getUsers() {

    LOGGER.info("Get all users from the database");
    return ResponseEntity.ok(userService.getAll());
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<UserItem> getUserById(@PathVariable Long id) {

    LOGGER.info("Get user with id " + id);
    return new ResponseEntity<UserItem>(userService.getById(id),HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity<Void> saveUser(@Valid @RequestBody UserCreationCommand command){
	  userService.saveUser(command);
	  return new ResponseEntity<>(HttpStatus.CREATED);
  }
  
  @PutMapping("/update/{id}")
  public ResponseEntity<Void> updateUser(@RequestBody UserUpdateCommand command, @PathVariable Long id ){
	  userService.updateUser(command, id);
	  return new ResponseEntity<>(HttpStatus.CREATED);
  }
  
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id ){
	  userService.deleteUser(id);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}