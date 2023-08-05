package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.demo.entity.Matches;
import com.example.demo.entity.Teams;
import com.example.demo.repository.MatchRepo;
import com.example.demo.service.ServiceCric;

@Controller
public class TeamController {

	@Autowired
	private ServiceCric service;

	@Autowired
	private MatchRepo mr;

	@GetMapping("/teams")
	public String teams(@ModelAttribute Teams tm, Model m) {
		List<Matches> match = mr.findAll();
		m.addAttribute("match", match);
		String res = tm.getName();
		if (res != null) {
			service.addTeams(tm);
			boolean added = true;
			m.addAttribute("added", added);
			return "teams";
		}
		return "teams";

	}
}
