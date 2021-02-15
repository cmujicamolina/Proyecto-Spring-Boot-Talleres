package pe.edu.galaxy.java.api.spring.boot.talleres.service;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.java.api.spring.boot.talleres.model.Taller;
import pe.edu.galaxy.java.api.spring.boot.talleres.repository.TallerRepository;

@Service
public class TallerServiceImpl implements TallerService {
	
	@Autowired
	private TallerRepository tallerRepository;

	@Override
	public Taller getTaller(Long id) {		
		return tallerRepository.findById(id).orElse(null);
		/*
		 * return Taller.builder() .id(id) .nombre("Spring boot")
		 * .descripcion("Ejemplos basicos") .build();
		 */
	}

	@Override
	public List<Taller> getTalleres() {
		
		return tallerRepository.findAllCustom();
		//return tallerRepository.findAll();
		/*
		List<Taller> talleres = new ArrayList<Taller>();

		talleres.add(Taller.builder()
				.id(1L)
				.nombre("Spring boot")
				.descripcion("Ejemplos básicos")
				.build());
		talleres.add(Taller.builder()
				.id(2L)
				.nombre("Angular 11")
				.descripcion("Arquitectura y mejoras")
				.build());
		return talleres;*/
	}

	@Override
	public Taller grabar(Taller taller) {
		//Update/put
		if (taller.getId()>0) {
			Taller oTaller= this.getTaller(taller.getId());
			BeanUtils.copyProperties(taller, oTaller);
		}
		
		return tallerRepository.save(taller);
	}
	
	@Override
	public Taller eliminar(Long id) {
		//Update/put
		//tallerRepository.delete(this.getTaller(id)); //Borrado fisico
		//Borrado logico
		Taller oTaller = this.getTaller(id);
		oTaller.setEstado("0");
		return tallerRepository.save(oTaller);
	}

}
