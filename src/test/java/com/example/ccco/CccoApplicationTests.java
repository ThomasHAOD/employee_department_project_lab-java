package com.example.ccco;

import com.example.ccco.models.Department;
import com.example.ccco.models.Employee;
import com.example.ccco.models.Project;
import com.example.ccco.repositories.DepartmentRepository;
import com.example.ccco.repositories.EmployeeRepository;
import com.example.ccco.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CccoApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canSaveEmployeeAndDepartment(){
		Department department = new Department("DevOps");
		departmentRepository.save(department);
		Employee employee = new Employee("Steve", "Jones", department);
		Project project = new Project("Plan c", 7493);
		projectRepository.save(project);
		employee.addProject(project);
		employeeRepository.save(employee);


	}

}
