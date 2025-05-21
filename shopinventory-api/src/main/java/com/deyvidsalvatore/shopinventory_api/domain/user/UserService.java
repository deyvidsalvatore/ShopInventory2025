package com.deyvidsalvatore.shopinventory_api.domain.user;

import static com.deyvidsalvatore.shopinventory_api.domain.mapper.ObjectMapper.parseListObjects;
import static com.deyvidsalvatore.shopinventory_api.domain.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deyvidsalvatore.shopinventory_api.domain.exceptions.ResourceNotFoundException;
import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UpdateUserPasswordDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UserCreateDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UserUpdateDTO;
import com.deyvidsalvatore.shopinventory_api.web.UserWebController;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(UserService.class.getName());

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public Page<UserDTO> findAll(Pageable pageable) {
		logger.info("UserService ::: findAll ~> Fetching all users");
		var userPage = userRepository.findAll(pageable);
		var dtoList = parseListObjects(userPage.getContent(), UserDTO.class);
		dtoList.forEach(this::addHateoasLink);
		return new PageImpl<>(dtoList, pageable, userPage.getTotalElements());
	}

	public UserDTO findById(Long id) {
		logger.info("UserService ::: findById ~> Fetching one user with ID {}", id);
		var entity = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		var dto = parseObject(entity, UserDTO.class);
		this.addHateoasLink(dto);
		return dto;
	}

	public UserDTO create(UserCreateDTO dto) {
		logger.info("UserService ::: create ~> Creating new user");
		UserModel entity = parseObject(dto, UserModel.class);
		entity.setRoleId((short) 1);
		entity.setImageUrl("profile-default.jpg");
		entity.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
		entity.setRegisteredAt(new Date());
		entity = this.userRepository.save(entity);
		return parseObject(entity, UserDTO.class);
	}

	public UserDTO update(Long id, UserUpdateDTO dto) {
		var entity = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		logger.info("UserService ::: update ~> Updating one user with ID {}", id);
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setMiddleName(dto.getMiddleName());
		entity.setUsername(dto.getUsername());
		entity.setMobile(dto.getMobile());
		entity.setEmail(dto.getEmail());
		entity = userRepository.save(entity);
		var result = parseObject(entity, UserDTO.class);
		this.addHateoasLink(result);
		return result;
	}

	public void updatePassword(Long userId, UpdateUserPasswordDTO dto) {
		logger.info("UserService ::: updatePassword ~> Updating password for user with ID {}", userId);

		var user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		if (!passwordEncoder.matches(dto.getOldPassword(), user.getPasswordHash())) {
			throw new IllegalArgumentException("Current password is incorrect");
		}

		user.setId(userId);
		user.setPasswordHash(passwordEncoder.encode(dto.getNewPassword()));
		this.userRepository.save(user);
	}

	public void delete(Long userId) {
		logger.info("UserService ::: delete ~> Deleting user with ID {}", userId);
		var user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		this.userRepository.delete(user);
	}
	
	private void addHateoasLink(UserDTO dto) {
        dto.add(linkTo(methodOn(UserWebController.class).findById(dto.getId())).withSelfRel().withType("GET"));
    }

}
