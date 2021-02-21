package pe.edu.galaxy.java.api.spring.boot.talleres.controller.commons;

import java.util.Date;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseREST {
		@Builder.Default
	    private Date fechaHora= new Date(); //"2021-02-20T00:56:46.900+00:00"
	    private HttpStatus estado;    //"status": 400
	    private String error;     //"error": "Bad Request"
	    private Object mensaje;   //"[{descripcion=La descripción es requerida y debe ser mayor que 10 y máximo 280 carácteres}]"
	    private Object detalle;
	    //private String ruta;      //"path": "/talleres/v1/4"
	    
	    @JsonInclude(Include.NON_NULL) 
	    private Object registro;
}
