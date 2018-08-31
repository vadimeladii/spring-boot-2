package md.springboot.webservice.config.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"md.springboot.webservice", "md.springboot.business", "md.springboot.repository"})
@EntityScan({"md.springboot.repository"})
@EnableJpaRepositories({"md.springboot.repository"})
public class SpringBoot2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Application.class, args);
    }
}
