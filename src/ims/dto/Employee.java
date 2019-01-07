package ims.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.persistence.*;
/**
 *
 * @author NAT
 */
@Entity
@Table(name = "employee")
public class Employee {

	private int id; 	
	private String full_name; 	
	private int age;                
	private Department department;

	public Employee(){ }
	public Employee(String fname, int age, Department dep) {		
		this.full_name = fname; 
		this.age = age;
                this.department = dep;
	}
                
        @Id
	@Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int  getId(){
            return id;
        }
	public void  setId(int id){
            this.id=id;
        }
        @Column(name = "full_name")
	public String  getFullName(){
            return full_name ;
        }
	public void setFullName(String full_name){ 
            this.full_name=full_name; 
        }
        @Column(name = "age")
	public int  getAge(){	
            return age; 
        }
	public void  setAge(int age){ 
            this.age=age; 
        }
        @ManyToOne 
        @JoinColumn(name="dep_id")
        public Department getDepartment(){
            return department;
        }
	public void setDepartment(Department dep){
            this.department=dep;
        }
}
