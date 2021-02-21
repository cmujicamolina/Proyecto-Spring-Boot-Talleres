package pe.edu.galaxy.java.api.spring.boot.talleres.controller.generic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import pe.edu.galaxy.java.api.spring.boot.talleres.controller.commons.ResponseREST;
import pe.edu.galaxy.java.api.spring.boot.talleres.controller.constants.ResponseConstants;

public class GenericController {

	protected String formatMapMessage(BindingResult result) {
		List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {
			Map<String, String> error = new HashMap<>();
			error.put(err.getField(), err.getDefaultMessage());
			return error;
		}

		).collect(Collectors.toList());
		return errors.toString();
	}

	protected ResponseEntity<ResponseREST> getBadRequest(BindingResult result) {
		ResponseREST res = ResponseREST.builder().mensaje(ResponseConstants.MSG_REG_ALERTA)
				.estado(HttpStatus.BAD_REQUEST).error(HttpStatus.BAD_REQUEST.toString())
				.detalle(this.formatMapMessage(result)).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	}

	protected ResponseEntity<ResponseREST> getCreatedRequest(Object obj) {
		ResponseREST res = ResponseREST.builder().mensaje(ResponseConstants.MSG_REG_EXITO).estado(HttpStatus.OK)
				.error(HttpStatus.OK.toString()).registro(obj).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}
	
	protected ResponseEntity<ResponseREST> getOKRequest(Object obj) {
		ResponseREST res = ResponseREST.builder()
				.mensaje(ResponseConstants.MSG_REG_EXITO)
				.estado(HttpStatus.OK)
				.error(HttpStatus.OK.toString())
				.registro(obj)
				.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	public ResponseEntity<ResponseREST> getErrorRequest() {
		ResponseREST res = ResponseREST.builder().mensaje(ResponseConstants.MSG_ERR_GENE)
				.estado(HttpStatus.INTERNAL_SERVER_ERROR).error(HttpStatus.INTERNAL_SERVER_ERROR.toString()).build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
	}
}
