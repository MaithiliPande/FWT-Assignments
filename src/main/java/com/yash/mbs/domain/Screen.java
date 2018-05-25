package com.yash.mbs.domain;

public class Screen {
	
	private Integer id;
	private String name;
	private Movie movie;
	
	public Screen(Integer id, String name, Movie movie) {
		super();
		this.id = id;
		this.name = name;
		this.movie = movie;
	}
	public Screen(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	

}
