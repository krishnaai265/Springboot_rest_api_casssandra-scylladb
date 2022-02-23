package guru.springframework.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;


//@Document("Employee")
@Table("employee")
public class Employee implements Serializable {
    @PrimaryKey
    public String id;
 //   @Field(name="name")
    private String EmployeeName;
 //   @Field(name="des")
 public Designation EmployeeDesignation;
 //   @Field(name="team")
 public String EmployeeTeam;
 //   @Field(name="exp")
 public Integer Experience;

    public Employee(String id, String EmployeeName, Designation EmployeeDesignation, String EmployeeTeam, int Experience) {
        this.id = id;
        this.EmployeeName = EmployeeName;
        this.EmployeeDesignation = EmployeeDesignation;
        this.EmployeeTeam = EmployeeTeam;
        this.Experience = Experience;
    }

    public String getId() {
        return id;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public Designation getEmployeeDesignation() {
        return EmployeeDesignation;
    }

    public String getEmployeeTeam() {
        return EmployeeTeam;
    }

    public int getExperience() {
        return Experience;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.EmployeeName = employeeName;
    }

    public void setEmployeeDesignation(Designation employeeDesignation) {
        this.EmployeeDesignation = employeeDesignation;
    }

    public void setEmployeeTeam(String employeeTeam) {
        this.EmployeeTeam = employeeTeam;
    }

    public void setExperience(int experience) {
        this.Experience = experience;
    }
}
