package com.example.chancay.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.chancay.model.Embarcacion;

@Repository
public interface EmbarcacionRepository extends JpaRepository<Embarcacion, Long> {
        
}
