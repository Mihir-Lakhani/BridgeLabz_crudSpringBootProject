package in.mihirlakhani.crudSpringBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class CrudSpringBootProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudSpringBootProjectApplication.class, args);

		System.out.println("Server is On");

    }

}
