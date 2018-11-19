package com.example.rseservice.repository;

import com.example.rseservice.domain.ServiceD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceD, Long> {

    @Query(value = "SELECT * FROM serviceD WHERE client_id = ?1", name =
            "findAllByClient", nativeQuery = true)
    List<ServiceD> findAllByClient(Long id);
}
