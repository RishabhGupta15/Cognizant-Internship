package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
	@Query(value="select * from menu_item where me_active='Yes' and me_date_of_launch<CURDATE()", nativeQuery=true)
	List<MenuItem> findCustomerMenuItems();
}
