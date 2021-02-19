package com.tim.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//------Model------
@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=5)
	private String title;
	
	@Size(min=5)
	private String artist;
	
	@Min(1)
	@Max(10)
	private Integer rating;
	
	private String songUrl;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	
	//------Constructors------
	
//	******Empty constructor MUST be present ******
	public Song() {
	}
//	******Empty constructor MUST be present ******


	public Song( String title,String artist,Integer rating) {

		this.title = title;
		this.artist = artist;
		this.rating = rating;

	}


//	//------Getters and Setters------
	
	
//	******ID getter/setter MUST be present ******
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
//	******ID getter/setter MUST be present ******

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
//	######These must be present for these fields to update automatically######
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
//	######These must be present for these fields to update automatically######


	public String getSongUrl() {
		return songUrl;
	}


	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}
	
	
	
	
}
