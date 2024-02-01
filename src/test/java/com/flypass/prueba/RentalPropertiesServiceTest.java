package com.flypass.prueba;

import com.flypass.prueba.dto.RequestTransactionCreateDTO;
import com.flypass.prueba.entity.RentalPropertiesEntity;
import com.flypass.prueba.repository.RentalPropertiesRepository;
import com.flypass.prueba.service.RentalPropertiesService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Date;

public class RentalPropertiesServiceTest {

    @Mock
    private RentalPropertiesRepository rentalPropertiesRepository;

    @InjectMocks
    private RentalPropertiesService rentalPropertiesService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.rentalPropertiesService = new RentalPropertiesService(rentalPropertiesRepository);
    }
    @Test
    public void createPropertie() {
        RequestTransactionCreateDTO requestTransactionCreate = new RequestTransactionCreateDTO();
        requestTransactionCreate.setName("Name");
        requestTransactionCreate.setAvailability(true);
        requestTransactionCreate.setPrice(BigDecimal.valueOf(56146.00));
        requestTransactionCreate.setUbication("Medellin");
        rentalPropertiesService.createPropertie(requestTransactionCreate);
    }
}
