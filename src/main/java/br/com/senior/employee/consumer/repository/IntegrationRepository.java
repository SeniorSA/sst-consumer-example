package br.com.senior.employee.consumer.repository;

import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@Repository
public interface IntegrationRepository extends PagingAndSortingRepository<IntegrationEntity, UUID> {

    List<IntegrationEntity> findAllByOrderByReceiptDateDesc();

}
