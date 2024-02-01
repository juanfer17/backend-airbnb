package com.flypass.prueba.repository;

import com.flypass.prueba.dto.RequestTransactionCreateDTO;
import com.flypass.prueba.entity.RentalPropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RentalPropertiesRepository  extends JpaRepository<RentalPropertiesEntity, Long> {

    RentalPropertiesEntity findByName(String propertieName);
    List<RentalPropertiesEntity> findByAvailabilityIsTrueAndPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}