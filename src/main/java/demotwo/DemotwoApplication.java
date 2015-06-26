package demotwo;

import static org.elasticsearch.index.query.QueryBuilders.*;

import org.elasticsearch.index.query.FuzzyLikeThisFieldQueryBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

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
    
	@Bean
	CommandLineRunner example(MovieRepository movieRepo, ElasticsearchTemplate template) {
		return (args) -> {
			System.err.println("zzzzzzz this works zzzzzzzzzzzzzzzzzzzzzzzz");
		
			movieRepo.findByTitleIgnoringCase("The").forEach(System.err::println);
			
			System.err.println("zzzzzz another way zzzzzzzzzzzzz");
			
			SearchQuery query = new NativeSearchQueryBuilder().withQuery(
				 fuzzyLikeThisFieldQuery("director").likeText("tarantula")).build();
			template.queryForList(query, Movie.class).forEach(System.err::println);
			
			
			
		};

	}
}
