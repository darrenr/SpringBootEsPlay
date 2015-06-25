package demotwo;

public interface MovieRepository extends org.springframework.data.elasticsearch.repository.ElasticsearchRepository<Movie, Long> {
	
	Iterable<Movie> findByTitleIgnoringCase(String title);
}
