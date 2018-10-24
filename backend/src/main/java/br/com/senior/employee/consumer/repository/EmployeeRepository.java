package br.com.senior.employee.consumer.repository;

import br.com.senior.employee.consumer.entity.EmployeeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, UUID> {

    List<EmployeeEntity> findAllByOrderByReceiptDateDesc();

}
