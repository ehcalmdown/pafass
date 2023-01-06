package vttp2022.paf.assessment.eshop.respositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.models.CustomerRowMapper;


@Repository
public class CustomerRepository {
	@Autowired
	private JdbcTemplate template;

	

	// You cannot change the method's signature
	public Optional<Customer> findCustomerByName(String name) {
		// TODO: Task 3
		//part a
		
		List<Customer> c = template.query(Queries.SQL_FIND_CUSTOMERS_BY_NAME,  new CustomerRowMapper(),
		new Object[] { name });
		
		System.out.println(c);
		if(c != null){
			// return Optional.of(c); //not working
			return null;
		}
		return Optional.empty();
	}

	

}
