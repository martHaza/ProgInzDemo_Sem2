package lv.venta.repo;


import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Degree;
import lv.venta.model.Professor;

public interface IProfessorRepo extends CrudRepository<Professor, Integer> {

	public abstract boolean existsByNameAndSurnameAndDegree(String name, String surname, Degree degree);
	
}