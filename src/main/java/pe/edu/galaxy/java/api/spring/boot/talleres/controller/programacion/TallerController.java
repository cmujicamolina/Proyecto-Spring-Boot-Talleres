package pe.edu.galaxy.java.api.spring.boot.talleres.controller.programacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.java.api.spring.boot.talleres.controller.commons.ResponseREST;
import pe.edu.galaxy.java.api.spring.boot.talleres.controller.constants.ResponseConstants;
import pe.edu.galaxy.java.api.spring.boot.talleres.controller.generic.GenericController;
import pe.edu.galaxy.java.api.spring.boot.talleres.model.Taller;
import pe.edu.galaxy.java.api.spring.boot.talleres.service.TallerService;

//@Slf4j
@RestController
@RequestMapping("/talleres/v1")
public class TallerController extends GenericController{	
	
	@Autowired
	private TallerService tallerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Taller> getTaller(@PathVariable Long id) {
		
		if (id<=0) {
			return ResponseEntity.badRequest().build();
		}
		Taller taller=this.tallerService.getTaller(id);
		if (taller==null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(taller);
	}
	/*
	@GetMapping("/{anio}/nroExp")
	public ResponseEntity<Taller> getExpediente(@PathVariable Short anio,@PathVariable String nroExp) {
		return null;
	}
	
	@GetMapping("/buscarReclamos")
	public ResponseEntity<Taller> getReclamos(@RequestParam Short anio,
			@RequestParam String nroExp,
			@RequestParam String resumen) {
		return null;
	}*/
	
	@GetMapping
	public ResponseEntity<ResponseREST> getTalleres() {
		List<Taller> lst=this.tallerService.getTalleres();
		if(lst.isEmpty()) {
			ResponseREST res= ResponseREST.builder()
								.mensaje(ResponseConstants.MSG_CONS_SIN_CONT)
								.estado(HttpStatus.NO_CONTENT)
								.error(HttpStatus.NO_CONTENT.toString())
								.build();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(res);
		}
		ResponseREST res= ResponseREST.builder()
				.mensaje(ResponseConstants.MSG_CONS_EXITO)
				.estado(HttpStatus.OK)
				.error(HttpStatus.OK.toString())
				.registro(lst)
				.build();
		return ResponseEntity.ok(res);		
	}
	
	@GetMapping
	@RequestMapping("/buscar")
	public ResponseEntity<List<Taller>> getTalleres(@RequestParam String nombre) {
		Taller taller= Taller.builder().nombre(nombre).build();
		List<Taller> lst=this.tallerService.buscar(taller);	
		if(lst.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(lst);	
	}
	
	@PostMapping
	public ResponseEntity<ResponseREST> insertar(@Validated  @RequestBody Taller taller, BindingResult result) {
		if (result.hasErrors()) {
			return super.getBadRequest(result);
		}
		
		Taller oTaller=tallerService.grabar(taller);
		if (oTaller!=null) {			
			return super.getCreatedRequest(oTaller);
		}		
		return super.getErrorRequest();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseREST> actualizar(@PathVariable Long id,@Validated @RequestBody Taller taller,  BindingResult result) {
		if (id<=0) {
			return ResponseEntity.badRequest().build();
		}
		taller.setId(id);
		
		if (result.hasErrors()) {
			return super.getBadRequest(result);
		}
		
		Taller oTaller=tallerService.grabar(taller);
		if (oTaller!=null) {
			return super.getOKRequest(oTaller);
		}
		return super.getErrorRequest();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseREST> eliminar(@PathVariable Long id) {
		if (id<=0) {
			return ResponseEntity.badRequest().build();
		}
		Taller oTaller=tallerService.eliminar(id);
		if (oTaller!=null) {
			return super.getOKRequest(oTaller);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();			
	}
	
}
