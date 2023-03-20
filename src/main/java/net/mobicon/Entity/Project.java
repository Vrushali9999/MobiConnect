package net.mobicon.Entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "projects")
public class Project {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "name" , nullable = false)
    private String name;
	

	@Column(name = "owner_Client" , nullable = false)
    private String ownerClient;
	

	@Column(name = "owner_Consultant" , nullable = false)
    private String ownerConsultant;
	
	

	@Column(name = "start_date" , nullable = false)
    private LocalDate startDate;
	

	@Column(name = "end_date" , nullable = false)
    private LocalDate endDate;
	

	@Column(name = "status" , nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;


    @ManyToMany(mappedBy = "projects",fetch = FetchType.LAZY)
    private Set<Employee> employees;


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


	public String getOwnerClient() {
		return ownerClient;
	}


	public void setOwnerClient(String ownerClient) {
		this.ownerClient = ownerClient;
	}


	public String getOwnerConsultant() {
		return ownerConsultant;
	}


	public void setOwnerConsultant(String ownerConsultant) {
		this.ownerConsultant = ownerConsultant;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	public Project(String name, String ownerClient, String ownerConsultant, LocalDate startDate, LocalDate endDate,
			String status, Client client, Set<Employee> employees) {
		super();
		this.name = name;
		this.ownerClient = ownerClient;
		this.ownerConsultant = ownerConsultant;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.client = client;
		this.employees = employees;
	}


	public Project() {
		
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
