package pe.edu.galaxy.java.api.spring.boot.talleres.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.java.api.spring.boot.talleres.model.Taller;

@Repository
public interface TallerRepository extends JpaRepository<Taller, Long>{
	
	//JPQL
	@Query("select t from Taller t where t.estado='1'")
	List<Taller> findAllCustom();

	@Query("select t from Taller t where upper(t.nombre) like upper(:nombre) and t.estado='1'")
	List<Taller> buscar(@Param("nombre") String nombre);
}
