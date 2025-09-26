package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;
import lv.venta.service.IFilterService;

@RestController
@RequestMapping("/filter")
public class FilterController {

	@Autowired
	private IFilterService filtService;
	
	@GetMapping("/grades/student/{id}")//localhost:8080/filter/grades/student/1
	public ResponseEntity<?> getControllerGetAllGradesForStudent(@PathVariable (name = "id") int id) {
		try {
			ArrayList<Grade> filteredGrades = filtService.selectGradesByStudentId(id);
			ResponseEntity<ArrayList<Grade>> response = new ResponseEntity<ArrayList<Grade>>(filteredGrades, HttpStatusCode.valueOf(200));
			return response;
		}catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(500));
			return response;
		}
	}

	@GetMapping("/courses/student/{id}")//localhost:8080/filter/courses/student/1
	public ResponseEntity<?> getControllerGetAllCoursesForStudent(@PathVariable(name = "id") int id) {
		try {
			ArrayList<Course> filteredCourses = filtService.selectCoursesByStudentId(id);
			ResponseEntity<ArrayList<Course>> response = new ResponseEntity<ArrayList<Course>>(filteredCourses, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(500));
			return response;

		}
		
	}
	
	@GetMapping("/courses/professor/{id}")//localhost:8080/filter/courses/professor/1
	public ResponseEntity<?> getControllerGetAllCoursesForProfessor(@PathVariable(name = "id") int id) {
		try {
			ArrayList<Course> filteredCourses = filtService.selectCoursesByProfessorId(id);
			ResponseEntity<ArrayList<Course>> response = new ResponseEntity<ArrayList<Course>>(filteredCourses, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(500));
			return response;
			
		}
		
	}
	
	@GetMapping("/grades/avg/course/{id}")//localhost:8080/filter/grades/avg/course/1
	public ResponseEntity<?> getControllerGetAvgGradeInCourse(@PathVariable(name = "id") int id) {
		try {
			float avgGrade = filtService.calculateAVGGradeInCourseId(id);
			ResponseEntity<Float> response = new ResponseEntity<Float>(avgGrade, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(500));
			return response;

		}
		
	}
	
	@GetMapping("/students/failed")//localhost:8080/filter/students/failed
	public ResponseEntity<?> getControllergetFailedStudents() {
		try {
			ArrayList<Student> failedStudents = filtService.selectAllStudentsWithFailedGrades();
			ResponseEntity<ArrayList<Student>> response = new ResponseEntity<ArrayList<Student>>(failedStudents, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(500));
			return response;
		}
	}
	
	@GetMapping("/professors/degree/phd")//localhost:8080/filter/professors/degree/phd
	public ResponseEntity<?> getControllerGetProfessorsWithPHD() {
		try {
			ArrayList<Professor> professorWithPHD = filtService.selectAllProfessorsByDegree(Degree.doktora);
			ResponseEntity<ArrayList<Professor>> response = new ResponseEntity<ArrayList<Professor>>(professorWithPHD, HttpStatusCode.valueOf(200));
			return response;
		}catch (Exception e) {
			ResponseEntity<String> response = new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(500));
			return response;
		}
	}
	
}
