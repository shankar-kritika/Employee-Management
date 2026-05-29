package com.kritika.employee_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getAllEmployees(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }

    public Page<Employee> searchByDepartment(String department, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findByDepartmentContainingIgnoreCase(department, pageable);
    }

    public Page<Employee> searchByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = getEmployeeById(id);
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setSalary(updatedEmployee.getSalary());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        getEmployeeById(id);
        employeeRepository.deleteById(id);
    }
}