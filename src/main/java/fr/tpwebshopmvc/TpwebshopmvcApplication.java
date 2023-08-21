package fr.tpwebshopmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan({"fr.tpwebshopmvc.service","fr.tpwebshopmvc.repository","fr.tpwebshopmvc.model","fr.tpwebshopmvc.controller"})
public class TpwebshopmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpwebshopmvcApplication.class, args);
	}

}
