package com.flypass.prueba.controller;

import com.flypass.prueba.dto.RequestTransactionCreateDTO;
import com.flypass.prueba.general.Constants;
import com.flypass.prueba.service.RentalPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(Constants.ROOT_ENDPOINT + "/" )
public class RentalPropertiesController {

    @Autowired
    private RentalPropertiesService rentalPropertiesService;

    @PostMapping(Constants.CREATE_PROPERTIE)
    public ResponseEntity<String> createPropertie(@RequestBody RequestTransactionCreateDTO requestTransactionCreate) {
        try {
            rentalPropertiesService.createPropertie(requestTransactionCreate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Propiedad creada exitosamente.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Fallo al crear transaccion.", e);
        }
    }
}
