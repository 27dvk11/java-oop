package ims.dal;

import ims.dto.*;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DepartmentDAL extends BaseDAL{
    public long save(Department dep) throws Exception {
	session.beginTransaction();
	Long id = (Long) session.save(dep);
        session.getTransaction().commit();
        return id;
    }
	
    public void delete(Department dep) throws Exception {
	session.beginTransaction();
	session.delete(dep);
	session.getTransaction().commit();
    }
        
    public List<Department> list() {
        List<Department> result = new ArrayList<Department>();         
        result = session.createQuery("FROM Department").list();
        return result;
    }
}