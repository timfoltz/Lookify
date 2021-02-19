package com.tim.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.lookify.models.Song;
import com.tim.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
//	******Create******
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
//	******Read ONE******
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		return optionalSong != null ? optionalSong.get(): null;
	}
//	******Read ALL******	
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
//	******Read ALL******
	public List<Song> someSongs(String search){
		return songRepository.findByArtistContaining(search);
	}
	
//	******Update******
	public void updateSong(Song song) {
		songRepository.save(song);
	}
//	******Destroy/Delete******	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
}
