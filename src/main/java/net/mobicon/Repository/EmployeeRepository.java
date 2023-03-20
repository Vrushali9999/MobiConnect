package net.mobicon.Repository;



import org.springframework.data.repository.CrudRepository;

import net.mobicon.Entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
