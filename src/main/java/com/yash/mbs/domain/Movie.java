package com.yash.mbs.domain;

public class Movie {
	private Integer id;
	private String title;
	private String production;
	private String actors;
	public Movie(Integer id, String title, String production, String actors) {
		super();
		this.id = id;
		this.title = title;
		this.production = production;
		this.actors = actors;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	
	
}
