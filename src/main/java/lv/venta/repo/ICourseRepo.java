package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer> {

	public abstract ArrayList<Course> findByGradesStudentStId(int id);

	public abstract ArrayList<Course> findByProfessorPId(int id);
	
}
