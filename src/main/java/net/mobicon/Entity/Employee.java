package net.mobicon.Entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;
	    
		@Column(name = "name" , nullable = false)
	    private String name;
		
		@Column(name = "email" , nullable = false)
	    private String email;
		
		@Column(name = "contact" , nullable = false)
	    private String contact;
		
		@Column(name = "gender" , nullable = false)
	    private String gender;
		
		@Column(name = "date_of_birth)" , nullable = false)
	    private LocalDate dateOfBirth;
		
		@Column(name = "designation" , nullable = false)
	    private String designation;
		
		@Column(name = "address" , nullable = false)
	    private String address;
		
		@Column(name = "work_location" , nullable = false)
	    private String workLocation;
		
		@Column(name = "date_of_join" , nullable = false)
	    private LocalDate dateOfJoin;
		
		@Column(name = "date_of_exit" , nullable = false)
	    private LocalDate dateOfExit;
		
		@Column(name = "manager" , nullable = false)
	    private String manager;
		
		@Column(name = "total_leaves" , nullable = false)
	    private int totalLeaves;
		
		@Column(name = "leave_balance" , nullable = false)
	    private int leaveBalance;

		
		
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JoinTable(name = "EmployeeProject_Table",
	            joinColumns = {
	                    @JoinColumn(name = "employee_id",referencedColumnName = "id")
	            },
	            inverseJoinColumns = {
	                    @JoinColumn(name = "project_id",referencedColumnName = "id")
	            })
	    private Set<Project> projects;



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getContact() {
			return contact;
		}



		public void setContact(String contact) {
			this.contact = contact;
		}



		public String getGender() {
			return gender;
		}



		public void setGender(String gender) {
			this.gender = gender;
		}



		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}



		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}



		public String getDesignation() {
			return designation;
		}



		public void setDesignation(String designation) {
			this.designation = designation;
		}



		public String getAddress() {
			return address;
		}



		public void setAddress(String address) {
			this.address = address;
		}



		public String getWorkLocation() {
			return workLocation;
		}



		public void setWorkLocation(String workLocation) {
			this.workLocation = workLocation;
		}



		public LocalDate getDateOfJoin() {
			return dateOfJoin;
		}



		public void setDateOfJoin(LocalDate dateOfJoin) {
			this.dateOfJoin = dateOfJoin;
		}



		public LocalDate getDateOfExit() {
			return dateOfExit;
		}



		public void setDateOfExit(LocalDate dateOfExit) {
			this.dateOfExit = dateOfExit;
		}



		public String getManager() {
			return manager;
		}



		public void setManager(String manager) {
			this.manager = manager;
		}



		public int getTotalLeaves() {
			return totalLeaves;
		}



		public void setTotalLeaves(int totalLeaves) {
			this.totalLeaves = totalLeaves;
		}



		public int getLeaveBalance() {
			return leaveBalance;
		}



		public void setLeaveBalance(int leaveBalance) {
			this.leaveBalance = leaveBalance;
		}



		public Set<Project> getProjects() {
			return projects;
		}



		public void setProjects(Set<Project> projects) {
			this.projects = projects;
		}



		public Employee(String name, String email, String contact, String gender, LocalDate dateOfBirth,
				String designation, String address, String workLocation, LocalDate dateOfJoin, LocalDate dateOfExit,
				String manager, int totalLeaves, int leaveBalance, Set<Project> projects) {
			super();
			this.name = name;
			this.email = email;
			this.contact = contact;
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.designation = designation;
			this.address = address;
			this.workLocation = workLocation;
			this.dateOfJoin = dateOfJoin;
			this.dateOfExit = dateOfExit;
			this.manager = manager;
			this.totalLeaves = totalLeaves;
			this.leaveBalance = leaveBalance;
			this.projects = projects;
		}



		public Employee() {
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
