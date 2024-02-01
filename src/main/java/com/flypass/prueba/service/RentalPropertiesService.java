package com.flypass.prueba.service;

import com.flypass.prueba.dto.RequestTransactionCreateDTO;
import com.flypass.prueba.entity.RentalPropertiesEntity;
import com.flypass.prueba.repository.RentalPropertiesRepository;
import jakarta.validation.Valid;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RentalPropertiesService {

    private final  RentalPropertiesRepository rentalPropertiesRepository;

    public RentalPropertiesService(RentalPropertiesRepository rentalPropertiesRepository) {
        this.rentalPropertiesRepository = rentalPropertiesRepository;
    }

    @Valid
    public void createPropertie(RequestTransactionCreateDTO requestTransactionCreateDTO) {
        validateProperty(requestTransactionCreateDTO);
        RentalPropertiesEntity rentalProperties = new RentalPropertiesEntity();
        rentalProperties.setName(requestTransactionCreateDTO.getName());
        rentalProperties.setUbication(requestTransactionCreateDTO.getUbication());
        rentalProperties.setPrice(requestTransactionCreateDTO.getPrice());
        rentalProperties.setImgUrl(requestTransactionCreateDTO.getImgUrl());
        rentalProperties.setAvailability(true);
        rentalPropertiesRepository.save(rentalProperties);
    }

    private void validateProperty(RequestTransactionCreateDTO requestTransactionCreateDTO) {
        try {
            validateUniqueName(requestTransactionCreateDTO);
        } catch (ConstraintViolationException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validateUniqueName(RequestTransactionCreateDTO requestTransactionCreateDTO) {
        RentalPropertiesEntity existingProperty = rentalPropertiesRepository.findByName(requestTransactionCreateDTO.getName());
        if (existingProperty != null) {
            throw new IllegalArgumentException("Ya existe una propiedad registrada con el mismo nombre");
        }
    }

    public List<RentalPropertiesEntity> filterPropertiesByAvailabilityAndPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        try {
            return rentalPropertiesRepository.findByAvailabilityIsTrueAndPriceBetween(minPrice, maxPrice);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error al realizar la solicitud", e);
        }
    }


}
