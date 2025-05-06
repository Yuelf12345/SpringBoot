package com.example.yue.mapper;

import com.example.yue.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // spring的bean
public interface UserMapper extends CrudRepository<User, Integer> {
}
