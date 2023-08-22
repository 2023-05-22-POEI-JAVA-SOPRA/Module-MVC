package fr.tpwebshopmvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan({"fr.tpwebshopmvc.service","fr.tpwebshopmvc.repository","fr.tpwebshopmvc.model","fr.tpwebshopmvc.controller"})
class TpwebshopmvcApplicationTests {

	@Test
	void contextLoads() {
	}

}
