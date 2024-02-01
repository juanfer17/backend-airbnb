package com.flypass.prueba.repository;

import com.flypass.prueba.entity.RentalPropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalPropertiesRepository  extends JpaRepository<RentalPropertiesEntity, Long> {

}