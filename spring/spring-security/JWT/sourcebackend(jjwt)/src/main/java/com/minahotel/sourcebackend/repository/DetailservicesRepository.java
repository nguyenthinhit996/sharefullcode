package com.minahotel.sourcebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minahotel.sourcebackend.pojo.Detailservices;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;

@Repository
public interface DetailservicesRepository extends CrudRepository<Detailservices, Long>{

	String queryFindObjectById = "select * from Detailservices c where c.idticketbooking like :idticketbooking and c.idproduct like :idproduct";
	@Query(value = queryFindObjectById, nativeQuery = true )
	public List<Detailservices> findObjectById(@Param("idticketbooking") String idticketbooking, @Param("idproduct") String idproduct );
	
	@Query(value = queryFindObjectById, nativeQuery = true )
	public Optional<Detailservices> findObjectByIdOnlyOne(@Param("idticketbooking") String idticketbooking, @Param("idproduct") String idproduct );
	
	String queryFindObjectByIdTicket = "select * from Detailservices c where c.idticketbooking like :idticketbooking and c.status NOT LIKE 'Cancel'";
	@Query(value = queryFindObjectByIdTicket, nativeQuery = true )
	public List<Detailservices> findObjectByIdTicket(@Param("idticketbooking") String idticketbooking);
	
	
	String deleteObjectByIdTicketAndIdProduct = "Delete from Detailservices c where c.idticketbooking like :idticketbooking and c.idproduct like :idproduct";
	@Query(value = deleteObjectByIdTicketAndIdProduct, nativeQuery = true )
	public List<Detailservices> deleteObjectByIdTicketAndIdProduct(@Param("idticketbooking") String idticketbooking, @Param("idproduct") String idproduct );
}
