package com.tp.portfolioap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tp.portfolioap.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
