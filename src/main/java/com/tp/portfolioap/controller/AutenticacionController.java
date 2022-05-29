package com.tp.portfolioap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tp.portfolioap.model.UsuarioDTO;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {
	/*Login de paso, falto implementar jwt por falta de tiempo :( */
	private final String USUARIO="lauc";
	private final String CONTRASEÑA="PortfolioAP";

	
	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody UsuarioDTO usuarioDTO ){
		if(usuarioDTO.getUsuario() == null || usuarioDTO.getContraseña() == null) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);	
		}
		if(usuarioDTO.getUsuario().toLowerCase().equals(USUARIO) && usuarioDTO.getContraseña().equals(CONTRASEÑA)) {
		return new ResponseEntity<>(true, HttpStatus.OK);	
		}
		return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);		
	}
	
}
