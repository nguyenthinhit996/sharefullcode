package com.minahotel.sourcebackend.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minahotel.sourcebackend.pojo.Dailyworking;


@Repository
public interface DailyworkingRepository extends CrudRepository<Dailyworking, Long>{


	String queryFindObjectById = "select * from Dailyworking c where c.idtoday = :idtoday and c.idstaffwork like :idstaffwork";
	@Query(value = queryFindObjectById, nativeQuery = true )
	public List<Dailyworking> findObjectById(@Param("idtoday") String idtoday, @Param("idstaffwork") String idstaffwork );
	
	@Query(value = queryFindObjectById, nativeQuery = true )
	public Optional<Object> findObjectByIdOnlyOne(@Param("idtoday") String idtoday, @Param("idstaffwork") String idstaffwork );
	
	String queryFindObjectByIDDay = "select * from Dailyworking c where c.idtoday = :idtoday";
	@Query(value = queryFindObjectByIDDay, nativeQuery = true )
	public List<Object> findObjectByIdDay(@Param("idtoday") LocalDate idtoday);

	String queryFindObjectByIdAll = "select * from Dailyworking";
	@Query(value = queryFindObjectByIdAll, nativeQuery = true )
	public List<Object> queryFindObjectByIdAll();
}
