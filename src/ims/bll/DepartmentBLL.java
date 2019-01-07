package ims.dal;

import ims.dto.*;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DepartmentBLL {
	private DepartmentDAL dal;
	
	public DepartmentBLL() {
		dal = new DepartmentDAL();
	}

	public List<Department> listAll()  {
		return dal.list();
	}
	
	public void save(Department dep) throws Exception {
		dal.save(dep);
	}
	
	public void delete(Department dep) throws Exception {
		dal.delete(dep);
	}

}
