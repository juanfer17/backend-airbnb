package com.flypass.prueba.controller;

import com.flypass.prueba.dto.RequestPropertieCreateDTO;
import com.flypass.prueba.entity.RentalPropertiesEntity;
import com.flypass.prueba.general.ApiResponse;
import com.flypass.prueba.general.Constants;
import com.flypass.prueba.service.RentalPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.ROOT_ENDPOINT + "/" )
public class RentalPropertiesController {

    @Autowired
    private RentalPropertiesService rentalPropertiesService;

    @PostMapping(Constants.CREATE_PROPERTIE)
    public ResponseEntity<String> createPropertie(@RequestBody RequestPropertieCreateDTO requestPropertieCreate) {
        try {
            rentalPropertiesService.createPropertie(requestPropertieCreate);
            return ResponseEntity.status(HttpStatus.CREATED).body("La solicitud fue exitosa.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error al realizar la solicitud.", e);
        }
    }
    @GetMapping(Constants.FILTER_PROPERTIES)
    public ResponseEntity<?> filterProperties(@RequestParam Integer minPrice,@RequestParam Integer maxPrice) {
        try {
            List<RentalPropertiesEntity> filteredProperties = rentalPropertiesService.filterPropertiesByAvailabilityAndPrice(minPrice, maxPrice);
            return ResponseEntity.ok(new ApiResponse("La solicitud fue exitosa", filteredProperties));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Ocurrió un error al realizar la solicitud", null));
        }
    }
}
