package ims.dal;

import ims.dto.Employee;
import ims.dto.*;

import java.util.ArrayList;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NAT
 */
public class EmployeeDAL extends BaseDAL {
    public EmployeeDAL(){
        super();
    }
            
    public Integer save(Object obj) throws Exception {
	session.beginTransaction();
	Integer id = (Integer) session.save(obj);
        session.getTransaction().commit();
        return id;
    }
	
    public void delete(Object obj) throws Exception {
	session.beginTransaction();
	session.delete(obj);
	session.getTransaction().commit();
    }
        
    public List<Employee> list() {
        List<Employee> result = new ArrayList<Employee>();
        result = session.createQuery("FROM Employee").list();
        return result;
    }
}
