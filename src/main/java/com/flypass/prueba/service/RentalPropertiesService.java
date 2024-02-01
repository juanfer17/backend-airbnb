package com.flypass.prueba.service;

import com.flypass.prueba.dto.RequestTransactionCreateDTO;
import com.flypass.prueba.entity.RentalPropertiesEntity;
import com.flypass.prueba.repository.RentalPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalPropertiesService {

    @Autowired
    private RentalPropertiesRepository rentalPropertiesRepository;
    public void createPropertie(RequestTransactionCreateDTO requestTransactionCreateDTO) {
        RentalPropertiesEntity rentalProperties = new RentalPropertiesEntity();
        rentalProperties.setName(requestTransactionCreateDTO.getName());
        rentalProperties.setUbication(requestTransactionCreateDTO.getUbication());
        rentalProperties.setPrice(requestTransactionCreateDTO.getPrice());
        rentalProperties.setImgUrl(requestTransactionCreateDTO.getImgUrl());
        rentalProperties.setAvailability(true);
        rentalPropertiesRepository.save(rentalProperties);
    }
}
