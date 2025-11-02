package project.mars7invite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Mars7InviteApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mars7InviteApplication.class, args);
    }

}
