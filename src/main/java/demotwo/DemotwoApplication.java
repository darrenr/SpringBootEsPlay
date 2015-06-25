package demotwo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemotwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotwoApplication.class, args);
    }
    
    @Bean
    InitializingBean seedDatabase(MovieRepository repo) {
    	return new InitializingBean() {

			@Override
			public void afterPropertiesSet() throws Exception {
				repo.deleteAll();
				repo.save(new Movie(1L, "The Thing", "John Carpenter"));
				repo.save(new Movie(2L, "Pulp Fiction", "Quentin Tarantino"));
				repo.save(new Movie(3L, "Jackie Brown", "Quentin Tarantino"));
			}
    		
    	};
    }
}
