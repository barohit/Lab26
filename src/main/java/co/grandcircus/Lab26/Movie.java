package co.grandcircus.Lab26;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer movieId; 
	private String title; 
	private String genre; 
	private String director;
	private String details; 

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String title, String genre, String director) {
		super();
		this.title = title;
		this.genre = genre;
		this.director = director;
	}

	public Movie(Integer movieId, String title, String genre, String director) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.director = director;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	} 
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	

}
