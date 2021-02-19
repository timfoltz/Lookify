package com.tim.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tim.lookify.models.Song;
import com.tim.lookify.services.SongService;

@Controller
public class SongController {
	@Autowired
	private SongService songService;
//	******root******	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
//	******Create******	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@PostMapping("/songs")
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
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
//	------ONE------
	@GetMapping("/songs/{id}")
	public String showOneSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song",song);
		return "show.jsp";
	}
//	------SOME------
	@RequestMapping("/search")
	public String search(@RequestParam(value="search") String search, 
							Model model, RedirectAttributes redirectAttributes) {
		List<Song> searchResult = songService.someSongs(search);
		
			model.addAttribute("result",searchResult);
			return "search.jsp";

		
	}
	
//	******Delete/Destroy******
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id")Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	

	
	
}
