package ims.dto;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Set;
import javax.persistence.*;



@Entity
@Table(name = "department")
public class Department {
    
	private int id; 	
	private String full_name; 	       
        private Set<Employee> employee;
        
	public Department(){ 
        }
	public Department(String fname, int age) {		
		this.full_name = fname; 		
	}
        
        @Id 
	@Column(name = "dep_id")
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
        @OneToMany(mappedBy="department", cascade = CascadeType.ALL)
        public Set<Employee> getEmployee(){ 
            return employee;
        }
        public void setEmployee(Set<Employee> emps){ 
            this.employee = emps;
        }
        @Override
        public String toString()
        {
            return full_name;
        }
}
