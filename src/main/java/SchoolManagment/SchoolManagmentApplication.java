package SchoolManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("SchoolManagment")
public class SchoolManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagmentApplication.class, args);
	}

}
