package com.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Hero;
import com.cg.service.IHeroService;

@RestController
public class HeroRestController {
	
	@Autowired
	private IHeroService service;
	
	@GetMapping(value="/hello")
	public String sayHello()
	{
		return "Hello Heo World";
	}

	// URL: http://localhost:1201/add
		@PostMapping(value = "/add", consumes = "application/json")
		public String addHero(@RequestBody Hero hero){
			service.add(hero);
			return "Hero added to clan";
		}
		
		// URL: http://localhost:1201/get?id=123
		@GetMapping(value = "/get", produces = "application/json")
		public Hero getHero(@RequestParam("id") int id) {
			return service.get(id);
		}
		
		// URL: http://localhost:1201/list
		@GetMapping(value = "/list", produces = "application/json")
		public List<Hero> listHeroes() {
			return service.list();
		}
		
		// URL: http://localhost:1201/universe/marvel
		@GetMapping(value = "/universe/{univ}", produces = "application/json")
		public List<Hero> byUniverse(@PathVariable("univ") String universe) {
			return service.heroesByUniverse(universe);
		}
}
