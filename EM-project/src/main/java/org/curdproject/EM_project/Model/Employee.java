package org.curdproject.EM_project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    private Long Id;
    private String name;
    private String phonenumber;
    private String emailId;

}
//  transferring data between Controller and Service layers.