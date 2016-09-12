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
		//	@NamedQuery(name = "Movie.findAll",query="SELECT u FROM Movie u ORDER BY u.imdbID ASC"),
			@NamedQuery(name = "Movie.findByID", query = "Select u from Movie u where u.imdbID=:pID"),
			@NamedQuery(name = "Movie.searchInMovies", query = "Select u from Movie u where u.title like :searchText"),	
			@NamedQuery(name = "Movie.topMovies", query="Select u from Movie u where u.type =:ptype order by u.imdbRating desc"),
			@NamedQuery(name = "Movie.searchByType", query="Select u from Movie u where u.type =:pType order by u.imdbRating desc"),
			@NamedQuery(name = "Movie.searchByYear", query="Select u from Movie u where u.year =:pYear order by u.imdbRating desc"),
			@NamedQuery(name = "Movie.searchByGenre", query="Select u from Movie u where u.genre like :pgenre order by u.imdbRating desc"),
			@NamedQuery(name = "Movie.sortByVotes", query="Select u from Movie u order by u.imdbVotes desc"),
			@NamedQuery(name = "Movie.sortByYear", query="Select u from Movie u order by u.year desc"),
			@NamedQuery(name = "Movie.sortByRating", query="Select u from Movie u order by u.imdbRating desc"),	
		}
)

public class Movie {

	@Id
	@Column(unique=true)
	private String imdbID;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Year")
	private int year;
	
	@Column(name="Rated")
	private String rated;
	
	@Column(name="Released")
	private String released;
	
	@Column(name="Runtime")
	private String runtime;
	
	@Column(name="Genre")
	private String genre;
	
	@Column(name="Director")
	private String director;
	
	@Column(name="Actors")
	private String actors;
	
	@Column(name="Writer")
	private String writer;
	
	@Column(name="Plot",length=1000)
	private String plot;
	
	@Column(name="Language")
	private String language;
	
	@Column(name="Country")
	private String country;
	
	@Column(name="Awards")
	private String awards;
	
	@Column(name="Poster")
	private String poster;

	private int metascore;
	
	private float imdbRating;

	private long imdbVotes;
	
	@Column(name="Type")
	private String type;
	
	
	
	public String getImdbID() {
		return imdbID;
	}
	
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	@JsonProperty("Title")
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonProperty("Year")
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	@JsonProperty("Rated")
	public String getRated() {
		return rated;
	}
	
	public void setRated(String rated) {
		this.rated = rated;
	}
	@JsonProperty("Released")
	public String getReleased() {
		return released;
	}
	
	public void setReleased(String released) {
		this.released = released;
	}
	@JsonProperty("Runtime")
	public String getRuntime() {
		return runtime;
	}
	
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	@JsonProperty("Genre")
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
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
	@JsonProperty("Writer")
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@JsonProperty("Plot")
	public String getPlot() {
		return plot;
	}
	
	public void setPlot(String plot) {
		this.plot = plot;
	}
	@JsonProperty("Language")
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	@JsonProperty("Country")
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	@JsonProperty("Awards")
	public String getAwards() {
		return awards;
	}
	
	public void setAwards(String awards) {
		this.awards = awards;
	}
	@JsonProperty("Poster")
	public String getPoster() {
		return poster;
	}
	
	public void setPoster(String poster) {
		this.poster = poster;
	}
	@JsonProperty("Metascore")
	public int getMetascore() {
		return metascore;
	}
	
	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}
	
	public float getImdbRating() {
		return imdbRating;
	}
	
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	public long getImdbVotes() {
		return imdbVotes;
	}
	
	public void setImdbVotes(long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	@JsonProperty("Type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Movie [imdbID=" + imdbID + ", title=" + title + ", year="
				+ year + ", rated=" + rated + ", released=" + released
				+ ", runtime=" + runtime + ", genre=" + genre + ", director="
				+ director + ", actors=" + actors + ", writer=" + writer
				+ ", plot=" + plot + ", language=" + language + ", country="
				+ country + ", awards=" + awards + ", poster=" + poster
				+ ", metascore=" + metascore + ", imdbRating=" + imdbRating
				+ ", imdbVotes=" + imdbVotes + ", type=" + type + "]";
	}
	
	
	
}
