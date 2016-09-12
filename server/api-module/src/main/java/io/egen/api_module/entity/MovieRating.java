package io.egen.api_module.entity;

import java.util.UUID;

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
			@NamedQuery(name = "MovieRating.findAvgRatingByMovieID", query = "SELECT AVG(u.rating) FROM MovieRating u WHERE u.imdbID =:pID"),
		}
)
public class MovieRating {
	

	@Id
	private String rID;
	private String ratedBy;
	private String rating;
	private String imdbID;
	
	public MovieRating(){
		rID = UUID.randomUUID().toString();
	}

	public String getrID() {
		return rID;
	}

	public void setrID(String rID) {
		this.rID = rID;
	}

    @JsonProperty("RatedBy")
	public String getRatedBy() {
		return ratedBy;
	}

	public void setRatedBy(String ratedBy) {
		this.ratedBy = ratedBy;
	}
	
	@JsonProperty("Rating")
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	
	
	
}
