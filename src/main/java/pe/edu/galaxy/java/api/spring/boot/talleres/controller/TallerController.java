package pe.edu.galaxy.java.api.spring.boot.talleres.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;
import pe.edu.galaxy.java.api.spring.boot.talleres.model.Taller;
import pe.edu.galaxy.java.api.spring.boot.talleres.service.TallerService;

@Data
@RestController
@RequestMapping("/talleres/v1")
public class TallerController {	
	
	@Autowired
	private TallerService tallerService;
	
	@GetMapping("/{id}")
	public Taller getTaller(@PathVariable Long id) {
		return this.getTallerService().getTaller(id);	
	}
	
	@GetMapping
	@RequestMapping("/listado")
	public List<Taller> getTalleres() {
		return this.getTallerService().getTalleres();		
	}
	
	@PostMapping
	public Taller insertar(@RequestBody Taller taller) {
		return this.getTallerService().grabar(taller);		
	}
	
	@PutMapping("/{id}")
	public Taller actualizar(@PathVariable Long id,@RequestBody Taller taller) {
		taller.setId(id);
		return tallerService.grabar(taller);
	}
	
	@DeleteMapping("/{id}")
	public Taller eliminar(@PathVariable Long id) {
		return tallerService.eliminar(id);
	}
	
}
