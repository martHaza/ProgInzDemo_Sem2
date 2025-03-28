package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer> {

	public abstract ArrayList<Grade> findByStudentStId(int id);

	@Query(nativeQuery = true, value = "SELECT avg(grvalue) FROM grade_table WHERE cid = ?")
	public abstract float calculateAvgGradeInCourse(int id);
	
}
