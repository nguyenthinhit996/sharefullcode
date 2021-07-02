package com.minahotel.sourcebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minahotel.sourcebackend.pojo.CheckingOutRoomDamaged;

@Repository
public interface CheckingOutRoomDamagedRepository extends CrudRepository<CheckingOutRoomDamaged, Long>{

	
	String queryFindObjectById = "select * from CheckingOutRoomDamaged c where c.idcheckingoutroomdamaded = :idcheckingoutroomdamaded";
	@Query(value = queryFindObjectById, nativeQuery = true )
	public List<CheckingOutRoomDamaged> findObjectById(@Param("idcheckingoutroomdamaded") String id);
	
	@Query(value = queryFindObjectById, nativeQuery = true )
	public Optional<CheckingOutRoomDamaged> findObjectByIdOnlyOne(@Param("idcheckingoutroomdamaded") String id);
	
	
	
	String queryFindObjectByIdCheckout = "select * from CheckingOutRoomDamaged c where c.idcheckoutroom = :idcheckoutroom";
	@Query(value = queryFindObjectByIdCheckout, nativeQuery = true )
	public Optional<CheckingOutRoomDamaged> getObjectByIdCheckOut(@Param("idcheckoutroom") String id);
	
	
	String queryFindObjectByIdCheckIn = "select * from CheckingOutRoomDamaged c where c.idticketbooking = :idticketbooking";
	@Query(value = queryFindObjectByIdCheckIn, nativeQuery = true )
	public Optional<CheckingOutRoomDamaged> getObjectByIdCheckIn(@Param("idticketbooking") String idticketbooking);
}
