package com.brq.ms04.repositories;

import com.brq.ms04.models.USDBRLModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//* o JPA é do spring e faz insert
@Repository
public interface USDBRLRepository
        extends JpaRepository<USDBRLModel, Integer> {
}