package fr.maboite.webshopspringboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.maboite.webshopspringboot.model.User;
import fr.maboite.webshopspringboot.repository.UserDAO;
import fr.maboite.webshopspringboot.service.UserService;

@SpringBootApplication
public class WebshopSpringbootApplication implements CommandLineRunner{
	
    @Autowired
    ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(WebshopSpringbootApplication.class, args);
	}

	@Override
    public void run(String...args) throws Exception {
    }

}
