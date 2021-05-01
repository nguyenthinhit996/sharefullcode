package com.minahotel.sourcebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minahotel.sourcebackend.pojo.Ticketbooking;

@Repository
public interface TicketbookingRepository extends CrudRepository<Ticketbooking, Long>{

	String queryFindObjectById = "select * from Ticketbooking c where c.idticketbooking = :idticketbooking ";
	@Query(value = queryFindObjectById, nativeQuery = true )
	public List<Ticketbooking> findObjectById(@Param("idticketbooking") String idticketbooking);
	
	@Query(value = queryFindObjectById, nativeQuery = true )
	public Optional<Ticketbooking> findObjectByIdOnlyOne(@Param("idticketbooking") String idticketbooking);

	String queryFindObjectByIdPerform = "select * from Ticketbooking c where c.status = 'on'";
	@Query(value = queryFindObjectByIdPerform, nativeQuery = true )
	public List<Ticketbooking> findObjectByIdPerform();
	
	String queryFindObjectByNumberRoom = "select * from Ticketbooking c where c.numberroom like :numberroom and c.status = 'on'";
	@Query(value = queryFindObjectByNumberRoom, nativeQuery = true )
	public List<Ticketbooking> findObjectByNumberRoom(@Param("numberroom") String numberroom);
}
