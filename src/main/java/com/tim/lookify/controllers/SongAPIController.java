
package com.tim.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tim.lookify.models.Song;
import com.tim.lookify.services.SongService;

@RestController
public class SongAPIController {
	@Autowired
	private SongService songService;
//	******Dashboard******	
//	@GetMapping("/")
//	public String index() {
//		return "index.jsp";
//	}
	
//	******Create******	
	@PostMapping("api/songs/new")
	public Song newSong(@RequestParam(value = "title") String title,
						@RequestParam(value = "artist") String artist,
						@RequestParam(value = "rating") Integer rating) {
		Song song = new Song(title, artist, rating);
		return songService.createSong(song);
	}
	
	
	@PostMapping("api/songs")
	public String create(@Valid @ModelAttribute("song")Song song, 
							BindingResult result) {
		if(result.hasErrors()){
			return "new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
//	******READ******
//	------ALL------
	@GetMapping("api/songs")
	public List<Song> songsApi() {
		return songService.allSongs();
	}
//	------ONE------
	@GetMapping("api/songs/{id}")
	public Song showOneSong(@PathVariable("id") Long id) {
		Song song = songService.findSong(id);
		return song;
	}
	
//	******Delete/Destroy******
	@DeleteMapping("api/songs/{id}")
	public void deleteSong(@PathVariable("id")Long id) {
		songService.deleteSong(id);
		
	}
	

	
	
}
