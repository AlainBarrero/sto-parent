package com.stock.user.api.service;

import com.stock.user.api.exception.InvalidCredentialsException;
import com.stock.user.api.exception.UserException;
import com.stock.user.api.model.User;

public interface UserService {
	
	/**
     * Realizar el login correspondiente al usuario correspondiente a las credenciales
     * proporcionadas
     * 
     * @param code Código del usuario
     * @param password Password del usuario
     * @return Datos del usuario autenticado
     * @throws InvalidCredentialsException Lanzado cuando las credenciales proporcionadas sean
     *         incorrectas
     * @throws UserException Lanzada cuando exista algún problema durante el procesado
     */
    User login(String code, String password) throws InvalidCredentialsException, UserException;

}
