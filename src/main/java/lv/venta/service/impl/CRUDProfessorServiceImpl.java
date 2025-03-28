package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Degree;
import lv.venta.model.Professor;
import lv.venta.repo.IProfessorRepo;
import lv.venta.service.ICRUDProfessorService;


@Service
public class CRUDProfessorServiceImpl implements ICRUDProfessorService{

	@Autowired
	private IProfessorRepo profRepo;
	
	@Override
	public ArrayList<Professor> retrieveAll() throws Exception {
		if(profRepo.count() == 0)
		{
			throw new Exception("Nav neviena profesora DB");
		}
		
		return (ArrayList<Professor>) profRepo.findAll();
	}

	@Override
	public Professor retreiveById(int id) throws Exception {
		if(id < 0)
		{
			throw new Exception("Id nevar būt negatīvs");
		}
		
		if(!profRepo.existsById(id))
		{
			throw new Exception("Professors ar tādu id neeksistē");
		}
		
		Professor retrievedProduct = profRepo.findById(id).get();
		return retrievedProduct;
	}

	@Override
	public void deleteByID(int id) throws Exception {
		Professor professorForDelete = retreiveById(id);
		profRepo.delete(professorForDelete);
	
	}

	@Override
	public void create(String name, String surname, Degree degree) throws Exception {
		if(name == null || surname == null || degree == null)
		{
			throw new Exception("Ievades parametri nav pareizi");
		}
		
		if(profRepo.existsByNameAndSurnameAndDegree(name, surname, degree))
		{
			throw new Exception("Tāds profesors jau eksistē");
		}
		
		Professor newProfessor = new Professor(name, surname, degree);
		profRepo.save(newProfessor);
		
	}

	@Override
	public void updateById(int id, String name, String surname, Degree degree) throws Exception {
		if(name == null || surname == null || degree == null)
		{
			throw new Exception("Ievades parametri nav pareizi");
		}
		Professor retrievedProf = retreiveById(id);
		retrievedProf.setName(name);
		retrievedProf.setSurname(surname);
		retrievedProf.setDegree(degree);
		profRepo.save(retrievedProf);
		
		
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
