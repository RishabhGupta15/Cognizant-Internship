package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;
@Repository
public interface MenuItemRepository  extends JpaRepository<MenuItem, Integer>{

	//fetch data where active='Yes' and dateOfLaunch<CURRENT_DATE"
	List<MenuItem> findCustomerMenuItems();
}
