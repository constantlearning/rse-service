package com.example.rseservice.repository;

import com.example.rseservice.domain.ServiceHistories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceHistoriesRepository extends JpaRepository<ServiceHistories, Long> {

    @Query(value = "SELECT * FROM service_histories WHERE service_id = ?1", name =
            "findAllByService", nativeQuery = true)
    List<ServiceHistories> findAllByService(Long id);
}
