package com.example.hw2_7;

import com.example.hw2_7.exception.EmployeeAlreadyAddedException;
import com.example.hw2_7.exception.EmployeeNotFoundException;
import com.example.hw2_7.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    Map<String, Employee> employees = new HashMap<>();
    @Override
    public void addEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник у нас работает");
        } else {
            employees.put(employee.getFullName(), employee);
        }
    }
    @Override
    public void removeEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Работник не найден");
        }
    }
    @Override
    public void findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            System.out.println("Такой сотрудник у нас работает");
        } else {
            throw new EmployeeNotFoundException("Работник не найден");
        }
    }
}