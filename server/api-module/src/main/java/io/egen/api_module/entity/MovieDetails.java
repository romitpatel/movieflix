package io.egen.api_module.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries(
		{
			@NamedQuery(name = "MovieDetails.findByID", query = "Select u from MovieDetails u where u.imdbID=:pID"),
		}
)
public class MovieDetails {
	
	@Id
	@Column(unique=true)
	private String imdbID;
	
	@Column(name="Director")
	private String director;
	
	@Column(name="Actors")
	private String actors;
	
	@Column(name="Plot")
	private String plot;
	
	private float imdbRating;

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	@JsonProperty("Director")
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	@JsonProperty("Actors")
	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	@JsonProperty("Plot")
	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	
}
	
	
		