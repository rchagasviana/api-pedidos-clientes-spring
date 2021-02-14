package com.treinamentoSpring.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.treinamentoSpring.api.entidades.Usuario;
import com.treinamentoSpring.api.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {

		Usuario usuario01 = new Usuario(null, "Rafael", "rafael@gmail.com", "111-111", "123456");
		Usuario usuario02 = new Usuario(null, "Rafael2", "rafael02@gmail.com", "222-222", "123456");

		usuarioRepository.saveAll(Arrays.asList(usuario01, usuario02));

	}

}
