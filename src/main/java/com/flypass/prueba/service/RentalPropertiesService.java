package com.flypass.prueba.service;

import com.flypass.prueba.dto.RequestPropertieCreateDTO;
import com.flypass.prueba.entity.RentalPropertiesEntity;
import com.flypass.prueba.repository.RentalPropertiesRepository;
import jakarta.validation.Valid;
import org.hibernate.exception.ConstraintViolationException;
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
    public void createPropertie(RequestPropertieCreateDTO requestPropertieCreateDTO) {
        validateProperty(requestPropertieCreateDTO);
        RentalPropertiesEntity rentalProperties = new RentalPropertiesEntity();
        rentalProperties.setName(requestPropertieCreateDTO.getName());
        rentalProperties.setUbication(requestPropertieCreateDTO.getUbication());
        rentalProperties.setPrice(requestPropertieCreateDTO.getPrice());
        rentalProperties.setImgUrl(requestPropertieCreateDTO.getImgUrl());
        rentalProperties.setAvailability(true);
        rentalPropertiesRepository.save(rentalProperties);
    }

    private void validateProperty(RequestPropertieCreateDTO requestPropertieCreateDTO) {
        try {
            validateUniqueName(requestPropertieCreateDTO);
        } catch (ConstraintViolationException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validateUniqueName(RequestPropertieCreateDTO requestPropertieCreateDTO) {
        RentalPropertiesEntity existingProperty = rentalPropertiesRepository.findByName(requestPropertieCreateDTO.getName());
        if (existingProperty != null) {
            throw new IllegalArgumentException("Ya existe una propiedad registrada con el mismo nombre");
        }
    }

    public List<RentalPropertiesEntity> filterPropertiesByAvailabilityAndPrice(Integer minPrice, Integer maxPrice) {
        try {
            return rentalPropertiesRepository.findByAvailabilityIsTrueAndPriceBetween(BigDecimal.valueOf(minPrice),BigDecimal.valueOf(maxPrice));
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error al realizar la solicitud", e);
        }
    }


}
