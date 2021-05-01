package com.minahotel.sourcebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.minahotel.sourcebackend.pojo.DetailRoom;
import com.minahotel.sourcebackend.pojo.Production;

 
public interface ProductionRepository extends CrudRepository<Production, Long>{


	String queryFindObjectById = "select * from Production c where c.idproduction like :idproduction";
	@Query(value = queryFindObjectById, nativeQuery = true )
	public List<Production> findObjectById(@Param("idproduction") String idproduction);
	
	@Query(value = queryFindObjectById, nativeQuery = true )
	public Optional<Production> findObjectByIdOnlyOne(@Param("idproduction") String idproduction);
	

}
