package co.grandcircus.Lab26;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	@Autowired
	MovieRepository mr; 
	
	@GetMapping("/")
	public ArrayList<Movie> getAllMovies() {
		List<Movie> movies = mr.findAll();
		ArrayList<Movie> movie = new ArrayList<Movie>(); 
		for (int i = 0; i < movies.size(); i++) {
			movie.add(movies.get(i));
		}
		return movie; 
	}
	
	@GetMapping("/addMovie/{title}/{genre}/{director}")
	public ArrayList<Movie> addMovie(@PathVariable("title") String title, @PathVariable("genre") String genre, @PathVariable("director") String director) {
		mr.save(new Movie(title, genre, director));
		List<Movie> movies = mr.findAll();
		ArrayList<Movie> movie = new ArrayList<Movie>(); 
		for (int i = 0; i < movies.size(); i++) {
			movie.add(movies.get(i));
		}
		return movie; 
	} 
	
	@GetMapping("findMovie/{genre}")
	public ArrayList<Movie> findMovieByGenre(@PathVariable("genre") String genre) {
		List<Movie> movies = mr.findByGenre(genre);
		ArrayList<Movie> movie = new ArrayList<Movie>(); 
		for (int i = 0; i < movies.size(); i++) {
			movie.add(movies.get(i));
		}
		return movie; 
		
	}
	
	@GetMapping("/random")
	public Movie randomMovie() {
		List<Movie> movies = mr.findAll();
		Random rand = new Random(); 
		int i = rand.nextInt(movies.size()); 
		Movie m = movies.get(i); 
		return m; 
	}
	
	@GetMapping("/randomfromcategory/{genre}")
	public Movie randomFromCategory(@PathVariable("genre") String genre) { 
		List<Movie> movies = mr.findByGenre(genre);
		ArrayList<Movie> movie = new ArrayList<Movie>(); 
		for (int i = 0; i < movies.size(); i++) {
			movie.add(movies.get(i));
		}
		Random rand = new Random(); 
		int i = rand.nextInt(movie.size()); 
		Movie m = movie.get(i); 
		return m;
		
	}
	
	@GetMapping("/randomlist/{size}")
	public ArrayList<Movie> randomMovieList(@PathVariable("size") int size) { 
		List<Movie> movies = mr.findAll();
		if (size > movies.size()) {
			size = movies.size(); 
		}
		ArrayList<Movie> movie = new ArrayList<Movie>();
		Random rand = new Random(); 
		for (int i = 0; i < size; i++) {
			int j = rand.nextInt(movies.size()); 
			movie.add(movies.get(j)); 
			movies.remove(j);
		}
		
		return movie; 
	}
	
	@GetMapping("categories")
	public String[] getCategories() {
		List<Movie> movies = mr.findAll(); 
		String[] categories = new String[movies.size()];
		for (int i = 0; i < movies.size(); i++) {
			categories[i] = movies.get(i).getGenre();
		}
		return categories; 
	} 
	
	@GetMapping("/moviedetails/{title}")
	public String getDetails(@PathVariable("title") String title) {
		List<Movie> details = mr.findByTitle(title);
		return details.get(0).getDetails(); 
	}
	
	@GetMapping("/moviekeyword/{title}")
	public ArrayList<Movie> getMoviesByKeyWord(@PathVariable("title") String title) {
		List<Movie> details = mr.findAll();
		ArrayList<Movie> movie = new ArrayList<Movie>();
		for (int i = 0; i < details.size(); i++) {
			if (details.get(i).getTitle().contains(title)) {
				movie.add(details.get(i));
			}
		}
		return movie; 
	}
	
	
	
	

	
}
