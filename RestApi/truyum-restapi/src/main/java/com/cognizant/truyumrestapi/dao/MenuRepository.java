package com.cognizant.truyumrestapi.dao;

import com.cognizant.truyumrestapi.entity.MenuItem;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository  extends CrudRepository<MenuItem, Long> {
}
