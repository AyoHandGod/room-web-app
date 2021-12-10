package dev.ayohandgod.employeeclr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class EmployeeClrApplication {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeClrApplication.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            LOG.info("Starting the Application");

            ResponseEntity<List<Employee>> employees = restTemplate
                    .exchange("http://localhost:8080/api/employees", HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<Employee>>() {
                            });

            employees.getBody().forEach(e -> {
                LOG.info(e.getLastName() + ", " + e.getFirstName());
            });
            LOG.info("Closing out this application.");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeClrApplication.class, args);
    }

}
