package pe.edu.galaxy.java.api.spring.boot.talleres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name="Taller")
@Table(name="TALLER")
@NoArgsConstructor
@AllArgsConstructor
public class Taller {
	
	@Id
	@Column(name="ID_TALLER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTaller")
	@SequenceGenerator(name = "seqTaller", allocationSize = 1, sequenceName = "SEQ_TALLER")
	@Builder.Default
	private Long id=0L;
	
	@Size(min=5, max=220, message="El nombre  es requerido y debe ser mayor que 5 y máximo 220 carácteres")
	@Column(name="NOMBRE", length=220,nullable=false)
	private String nombre;
	
	@Size(min=10, max=280, message="La descripción es requerida y debe ser mayor que 10 y máximo 280 carácteres")
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Size(min=1, max=1, message="El estado es requerido y debe ser 0 o 1")
	@Column(name="ESTADO")
	@Builder.Default
	private String estado="1";

}
