package demotwo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

public class AnotherRunnerDbQuery {

	@Bean
	CommandLineRunner doit(MovieRepository movieRepo, ElasticsearchTemplate template) {

		return (args) -> {
			System.out.print("fooooooooooooooooooooo why doesn't this work");
			movieRepo.findByTitleIgnoringCase("The").forEach(System.err::println);
		};
	}
}
