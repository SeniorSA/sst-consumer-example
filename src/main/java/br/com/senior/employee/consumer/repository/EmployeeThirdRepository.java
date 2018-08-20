package br.com.senior.employee.consumer.repository;

import br.com.senior.employee.consumer.entity.EmployeeThird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeThirdRepository extends JpaRepository<EmployeeThird, UUID> {

    List<EmployeeThird> findAllByOrderByDateWhenDesc();

}
