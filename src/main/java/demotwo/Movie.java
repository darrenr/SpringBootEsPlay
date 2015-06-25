package demotwo;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "movies", type = "movie", shards = 1, replicas = 0, refreshInterval = "-1")
public class Movie {
	private Long id;
	private String title;
	private String director;
	
	Movie() {
		
	}
	
	public Movie(Long id, String title, String director) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
	}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director="
				+ director + "]";
	}
	
}
