package com.softgyan.springboot.dao;

import com.softgyan.springboot.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
