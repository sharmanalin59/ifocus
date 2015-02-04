package org.dao;

import java.util.List;

import org.domain.EmployeeManagerArchieve;

public interface EmployeeManagerArchieveDAO {
public void createEmployeeMAnagerArchieve(EmployeeManagerArchieve employeeManagerArchieve);
public List<EmployeeManagerArchieve> getAll(Integer userId,Integer managerId);
public void modifyEmployeeMAnagerArchieve(EmployeeManagerArchieve employeeManagerArchieve);
}
