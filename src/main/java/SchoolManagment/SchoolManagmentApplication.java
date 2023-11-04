package SchoolManagment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ComponentScan("SchoolManagment")
public class SchoolManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagmentApplication.class, args);
	}

}
