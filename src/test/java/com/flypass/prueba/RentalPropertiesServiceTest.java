package com.flypass.prueba;

import com.flypass.prueba.dto.RequestPropertieCreateDTO;

import com.flypass.prueba.repository.RentalPropertiesRepository;
import com.flypass.prueba.service.RentalPropertiesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

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
        RequestPropertieCreateDTO requestPropertieCreate = new RequestPropertieCreateDTO();
        requestPropertieCreate.setName("Name");
        requestPropertieCreate.setAvailability(true);
        requestPropertieCreate.setPrice(BigDecimal.valueOf(56146.00));
        requestPropertieCreate.setUbication("Medellin");
        rentalPropertiesService.createPropertie(requestPropertieCreate);
    }
}
