package pe.edu.galaxy.java.api.spring.boot.talleres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="ESTADO")
	private String estado;

}
