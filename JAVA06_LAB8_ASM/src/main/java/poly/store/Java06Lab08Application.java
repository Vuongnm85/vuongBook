package poly.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"poly.store.service.AccountService","poly.store.service","poly.store.controller","poly.store.interceptor","poly.store"})
public class Java06Lab08Application {

	public static void main(String[] args) {
		SpringApplication.run(Java06Lab08Application.class, args);
	}

}
