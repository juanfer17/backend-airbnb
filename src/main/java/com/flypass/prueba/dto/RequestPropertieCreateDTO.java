package com.flypass.prueba.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestPropertieCreateDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "La ubicación no puede estar vacía")
    @Pattern(regexp = "^(Medellin|Bogota|Cali|Cartagena)$", message = "Ubicación no válida")
    private String ubication;

    @NotNull(message = "La disponibilidad no puede estar vacía")
    private Boolean availability;

    private String imgUrl;

    @NotNull(message = "El precio no puede estar vacío")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    private BigDecimal price;
}
