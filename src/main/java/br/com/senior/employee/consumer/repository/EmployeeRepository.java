package br.com.senior.employee.consumer.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.senior.employee.consumer.client.esocial4integration.DeficiencyEntity;
import br.com.senior.employee.consumer.client.esocial4integration.EmployeeEntity;

@CrossOrigin
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, UUID> {

}
