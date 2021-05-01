package com.minahotel.sourcebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minahotel.sourcebackend.pojo.Typeofroom;

@Repository
public interface TypeofroomRepository extends CrudRepository<Typeofroom, Long>{

	String queryFindObjectById = "select * from Typeofroom c where c.nametypeofroom like :nametypeofroom";
	@Query(value = queryFindObjectById, nativeQuery = true )
	public List<Typeofroom> findObjectById(@Param("nametypeofroom") String nametypeofroom);
	
	@Query(value = queryFindObjectById, nativeQuery = true )
	public Optional<Typeofroom> findObjectByIdOnlyOne(@Param("nametypeofroom") String nametypeofroom);
}
