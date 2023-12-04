package com.example.springcassdemo.repository;

import com.example.springcassdemo.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {

}
