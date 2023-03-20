package net.mobicon.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.mobicon.Entity.Project;
import net.mobicon.Repository.ProjectRepository;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    // Get all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    // Get a project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            return new ResponseEntity<Project>(project.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new project
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        try {
            Project newProject = projectRepository.save(project);
            return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update a project by ID
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        Optional<Project> projectData = projectRepository.findById(id);
        if (projectData.isPresent()) {
            Project updatedProject = projectData.get();
            updatedProject.setName(project.getName());
            updatedProject.setOwnerClient(project.getOwnerClient());
            updatedProject.setOwnerConsultant(project.getOwnerConsultant());
            updatedProject.setStartDate(project.getStartDate());
            updatedProject.setEndDate(project.getEndDate());
            updatedProject.setStatus(project.getStatus());
            updatedProject.setClient(project.getClient());
            updatedProject.setEmployees(project.getEmployees());
            return new ResponseEntity<Project>(projectRepository.save(updatedProject), HttpStatus.OK);
        } else {
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a project by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable Long id) {
        try {
            projectRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
