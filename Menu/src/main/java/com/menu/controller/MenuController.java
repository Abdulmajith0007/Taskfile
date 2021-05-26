package com.menu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menu.model.Menu;
import com.menu.repos.MenuRepos;

@RestController
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private MenuRepos menuRepos;
	
	
//To view allMenu API
	@GetMapping("/allmenu")
	public List<Menu> getAllMenu()
	{         
		return menuRepos.findAll();
			
	}
	
	//To Add New menu or Categories API
	@PostMapping("/addmenu")
	public Menu addMenu(@RequestBody Menu menu)
	{
		Menu addmenu= menuRepos.save(menu);
		
		return addmenu;
	}
	
	//Delete the Menu or Categories API
	@DeleteMapping("/delete/{name}")
	public void deleteMenu(@PathVariable(value = "name") String name) {
		Menu id=menuRepos.findByName(name);
		menuRepos.deleteById(id.getId());
	}
	
	
	//Delete subMenu APi
	@DeleteMapping("/delete/{name}/{parent}")
	public void deleteMenu(@PathVariable String name, @PathVariable int parent ) {
		Menu id=menuRepos.findByNameAndParent(name , parent );
		menuRepos.deleteById(id.getId());
	
	}
	
	//update Both menu and sub menu By hitting there respective ID
	@PutMapping("/update/{id}")
	public void updateMenu(@PathVariable(value = "id") long id, @RequestBody Menu menu )
	{
		Optional<Menu> findid=menuRepos.findById(id);
		if (findid.isPresent()) {
		      Menu menu1 = findid.get();
		      
		      menu1.setName(menu.getName());
		      menu1.setparent(menu.getparent());
		      menuRepos .save(menu1);
		
		
		}
	
	
}}
