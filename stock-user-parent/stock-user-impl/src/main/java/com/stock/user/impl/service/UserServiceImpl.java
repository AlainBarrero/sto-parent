package com.stock.user.impl.service;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.user.api.exception.InvalidCredentialsException;
import com.stock.user.api.exception.UserException;
import com.stock.user.api.model.User;
import com.stock.user.api.service.UserService;
import com.stock.user.impl.internal.model.UserEntity;
import com.stock.user.impl.internal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

	@Override
	public User login(String code, String password) throws InvalidCredentialsException, UserException {
		
		UserEntity userEntity = null;

        try {
            userEntity = userRepository.findFirstByCodeAndPassword(code, password);
        } catch (PersistenceException exception) {
            throw new UserException("Invalid data base query", exception);
        }

        if (userEntity != null) {
            return modelMapper.map(userEntity, User.class);
        } else {
            throw new InvalidCredentialsException("Invalid credentials");
        }
		
	}

}
