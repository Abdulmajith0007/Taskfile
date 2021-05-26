package com.menu.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.menu.model.Menu;
@EnableJpaRepositories
@Repository
public interface MenuRepos extends JpaRepository<Menu, Long>
{

	
	public Menu findByName(String name);
	public Menu findByNameAndParent(String name,int parent );
}
