package com.minahotel.sourcebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minahotel.sourcebackend.pojo.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long>{

	String queryFindStaffById = "select * from Staff c where c.idstaff like :idstaff";
	@Query(value = queryFindStaffById, nativeQuery = true )
	public Optional<Staff> findStaffById(@Param("idstaff") String id);
	
	@Query(value = queryFindStaffById, nativeQuery = true )
	public Optional<Staff> findStaffByIdOnlyOne(@Param("idstaff") String id);
	
	String queryFindStaffByName = "select * from Staff c where c.username like :username";
	@Query(value = queryFindStaffByName , nativeQuery = true )
	public Optional<Staff> findStaffByName(@Param("username") String username);
	
}
