package com.minahotel.sourcebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minahotel.sourcebackend.pojo.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

	String queryFindObjectById = "select * from Room c where c.idroom = :idroom";
	@Query(value = queryFindObjectById, nativeQuery = true )
	public List<Room> findObjectById(@Param("idroom") String idroom);
	
	@Query(value = queryFindObjectById, nativeQuery = true )
	public Optional<Room> findObjectByIdOnlyOne(@Param("idroom") int idroom);
}
