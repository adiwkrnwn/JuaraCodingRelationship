package com.juaracoding.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.juaracoding.model.CustomerCustomeNameModel;
import com.juaracoding.model.CustomerCustomeNoHp;
import com.juaracoding.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
	
	@Query(value = "SELECT `first_name`,`last_name` FROM `customer`", nativeQuery = true)
	List<CustomerCustomeNameModel> getAllDataFullName();
	
	@Query(value = "SELECT `no_hp` FROM `customer`", nativeQuery = true)
	List<CustomerCustomeNoHp> getDataCustomerNoHp();
	
	
	@Query(value = "SELECT * From `customer` WHERE customer_id >?1 "
			+ " AND first_name LIKE %?2% ", 
			nativeQuery = true)
	List<CustomerModel> getDataById(long customer_id, String firstname);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE `customer` SET `address`=?1 "
			+ "WHERE customer_id=?2", nativeQuery = true)
	void updateCustomer(String address, long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE `customer` SET `address`=?1 ,"
			+ "`email`=?2 WHERE customer_id>?3 AND no_hp LIKE %?4", nativeQuery = true)
	void updateEmailAlamat(String address, String email, long customer_id, String no_hp);
	
	CustomerModel findByUsername(String username);
	
	
	
}

