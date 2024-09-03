package com.spring.DeployApp;

import com.spring.DeployApp.services.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeployAppApplication  implements CommandLineRunner {


	private final DataService dataService;

	@Value("${my.variable}")
	private String myVariable;

    public DeployAppApplication(DataService dataService) {
        this.dataService = dataService;
    }

    public static void main(String[] args) {
		SpringApplication.run(DeployAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(myVariable);
		System.out.println(dataService.getData());
	}
}
