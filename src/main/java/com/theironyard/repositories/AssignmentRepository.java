package com.theironyard.repositories;

import com.theironyard.entities.Assignment;
import org.springframework.data.repository.CrudRepository;


public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {

}