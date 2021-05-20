package com.gn.repository;

import com.gn.model.Employee;

import java.util.List;

public interface EmpRepository {

	List<Employee> getAll();

}