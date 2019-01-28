package br.com.senior.employee.consumer.repository;

import br.com.senior.employee.consumer.client.esocial4integration.LayoutThird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@Repository
public interface LayoutThirdRepository extends JpaRepository<LayoutThird, UUID> {

    List<LayoutThird> findAllByOrderByDateWhenDesc();

}
