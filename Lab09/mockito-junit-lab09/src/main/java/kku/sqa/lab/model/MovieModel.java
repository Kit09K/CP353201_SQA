package kku.sqa.lab.model;

public class MovieModel {
	String title;
	String playlist;
	
	public MovieModel() {}
	
	public MovieModel(String title, String playlist) {
		this.title = title;
		this.playlist = playlist;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	
	public String getPlaylist() {
		return this.playlist;
	}
}
