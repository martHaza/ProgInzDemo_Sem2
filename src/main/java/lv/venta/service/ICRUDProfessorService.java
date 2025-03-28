package lv.venta.service;

import lv.venta.model.Degree;
import lv.venta.model.Professor;


public interface ICRUDProfessorService extends ICRUDBase<Professor> {

	//R - retrieve all, R - retrieve by id, D - delete by id būs jau no ICRUDBASE 
	
		//C - create
		public abstract void create(String name, String surname, Degree degree) throws Exception;

		//U - update
		public abstract void updateById(int id, String name, String surname, Degree degree) throws Exception;
		
		//D - delete by ID
		public void deleteByID(int id) throws Exception;
}
