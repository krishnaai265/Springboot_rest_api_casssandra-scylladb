package guru.springframework.services;


import guru.springframework.domain.Employee;
import guru.springframework.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        Employee savedEmployee=employeeRepository.findById(employee.getId()).orElseThrow(
                ()-> new RuntimeException(String.format("Employee not found for id %s", employee.getId())));
        savedEmployee.setEmployeeName(employee.getEmployeeName());
        savedEmployee.setEmployeeTeam(employee.getEmployeeTeam());
        savedEmployee.setEmployeeDesignation(employee.getEmployeeDesignation());
        savedEmployee.setExperience(employee.getExperience());
        employeeRepository.save(savedEmployee);
        return savedEmployee;
    }


    public List<Employee> getAllEmployees(){
        List<Employee> products = new ArrayList<>();
        employeeRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
        //return employeeRepository.findAll();
    }

    public List<Optional<Employee>> getEmployeeByName(String name){
        return employeeRepository.findByName(name);

    }

    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }

}
