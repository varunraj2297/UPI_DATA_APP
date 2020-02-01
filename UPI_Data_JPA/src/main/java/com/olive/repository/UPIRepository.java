package com.olive.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.olive.entity.UPIEntity;

@Repository
public interface UPIRepository extends JpaRepository<UPIEntity, Long> {

	@Query(value = "from UPIEntity", 
		   countQuery = "select count(upi) from UPIEntity upi")
	public Page<UPIEntity> findAllUPIData(Pageable pageable);

}