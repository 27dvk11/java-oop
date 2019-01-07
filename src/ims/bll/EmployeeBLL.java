package ims.bll;

import ims.dal.EmployeeDAL;
import ims.dto.Employee;
import java.util.List;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NAT
 */
public class EmployeeBLL {
	private EmployeeDAL dal;
	
	public EmployeeBLL() {
		dal = new EmployeeDAL();
	}

	public List<Employee> listAll()  {
		return dal.list();
	}
	
	public Integer save(Employee emp) throws Exception {		            
            return dal.save(emp);		                          
	}
	
	public void delete(Employee emp) throws Exception {
		dal.delete(emp);
	}
}