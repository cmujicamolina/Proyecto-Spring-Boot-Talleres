package pe.edu.galaxy.java.api.spring.boot.talleres.service;

import java.util.List;

import pe.edu.galaxy.java.api.spring.boot.talleres.model.Taller;

public interface TallerService {
	
	Taller getTaller(Long id);
	
	List<Taller> getTalleres();
	
	Taller grabar(Taller taller);
	
	Taller eliminar(Long id);
	
}
