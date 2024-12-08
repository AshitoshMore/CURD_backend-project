package org.curdproject.EM_project.Repository;

import org.curdproject.EM_project.Entity.EmployeeEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryEmployee extends JpaRepository<EmployeeEntity,Long> {

}
//These interfaces provide built-in methods like save(), findById(), and delete() for interacting with the database.