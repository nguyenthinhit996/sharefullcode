package sharefullcode.dao;

import org.springframework.data.repository.CrudRepository;

import sharefullcode.pojo.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
