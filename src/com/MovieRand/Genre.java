package com.MovieRand;

public class Genre {
	private int id = 0;
	private String name = null;
	private String url= null;
	
	Genre(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

}
