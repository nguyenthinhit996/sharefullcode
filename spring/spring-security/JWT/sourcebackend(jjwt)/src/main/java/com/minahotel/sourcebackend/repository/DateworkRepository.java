package com.minahotel.sourcebackend.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minahotel.sourcebackend.pojo.Datework;

@Repository
public interface DateworkRepository extends CrudRepository<Datework, Long>{

	String queryFindObjectById = "select * from Datework c where c.iddatework like :iddatework";
	@Query(value = queryFindObjectById, nativeQuery = true )
	public List<Datework> findObjectById(@Param("iddatework") String id);
	
	@Query(value = queryFindObjectById, nativeQuery = true )
	public Optional<Datework> findObjectByIdOnlyOne(@Param("iddatework") LocalDate id);
	
}
