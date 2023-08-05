package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.Tournaments;
import com.example.demo.service.ServiceCric;

@Controller
public class TournamentController {
	@Autowired
	private ServiceCric service;

	/*
	 * @PostMapping("/admin") public String admin(@ModelAttribute Tournaments t,
	 * Model m) { service.addTournament(t); List<Tournaments>
	 * tournaments=trepo.findAll(); m.addAttribute("tournaments",tournaments);
	 * return "admin_dashboard"; }
	 */
	@GetMapping("/info")
	public String info() {
		return "info";
	}

	@GetMapping("/tournaments")
	public String tour() {
		return "tournaments";
	}

	/*
	 * @GetMapping("/teams") public String teams() { return "teams"; }
	 */
	@PostMapping("/tournaments")
	public String tournament(@ModelAttribute Tournaments t, Model m) {
		service.addTournament(t);
		boolean tourAdded = true;
		m.addAttribute("added", tourAdded);

		return "tournaments";

	}

	/*
	 * @PostMapping("/info") public String info(@ModelAttribute Tournaments t,Model
	 * m) { service m.addAttribute("",) return "info"; }
	 * 
	 */
}
