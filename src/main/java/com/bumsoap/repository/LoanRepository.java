package com.bumsoap.repository;

import com.bumsoap.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {

	@PreAuthorize("hasRole('MANAGER')")
	List<Loans> findByCustomerIdOrderByStartDtDesc(long customerId);

}
