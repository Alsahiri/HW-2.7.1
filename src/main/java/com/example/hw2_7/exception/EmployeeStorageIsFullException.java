package com.example.hw2_7.exception;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}