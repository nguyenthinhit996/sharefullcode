package com.minahotel.sourcebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minahotel.sourcebackend.pojo.Ticketcheckoutroom;

@Repository
public interface TicketcheckoutroomRepository extends CrudRepository<Ticketcheckoutroom, Long>{

	String queryFindObjectById = "select * from Ticketcheckoutroom c where c.idticketcheckoutroom like :idticketcheckoutroom";
	@Query(value = queryFindObjectById, nativeQuery = true )
	public List<Ticketcheckoutroom> findObjectById(@Param("idticketcheckoutroom") String idticketcheckoutroom);
	
	@Query(value = queryFindObjectById, nativeQuery = true )
	public Optional<Ticketcheckoutroom> findObjectByIdOnlyOne(@Param("idticketcheckoutroom") String idticketcheckoutroom);
	
	String queryGetRoomClean = "select * from Ticketcheckoutroom c where c.status = 'clean'";
	@Query(value = queryGetRoomClean, nativeQuery = true )
	public List<Ticketcheckoutroom> findRoomCheckoutCleaning();
	
	
	String queryFindObjectByDay = "select * from Ticketcheckoutroom c where c.timeendrent like :timeendrent";
	@Query(value = queryFindObjectByDay, nativeQuery = true )
	public List<Ticketcheckoutroom> findObjectByIdOnlyOneByDay(@Param("timeendrent") String timeendrent);
}
