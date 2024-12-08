package org.curdproject.EM_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EMP_DB")  // create the corresponding table in the database and manage it
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String phonenumber;
    private String emailId;

}
