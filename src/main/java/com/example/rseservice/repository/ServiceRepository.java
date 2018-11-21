package com.example.rseservice.repository;

import com.example.rseservice.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query(value = "SELECT * FROM serviceD WHERE client_id = ?1", name =
            "findAllByClient", nativeQuery = true)
    List<Service> findAllByClient(Long id);

    @Query(value = "SELECT * FROM service WHERE id = ?1 AND client_id = ?2", nativeQuery = true)
    Optional<Service> findByIdAndClientId(Long id, Long clientId);
}
