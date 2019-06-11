package co.grandcircus.Lab26;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findByGenre(String genre);
	

	// String[] findGenre(String genre);
	
	List<Movie> findByTitle(String title);

	
}
