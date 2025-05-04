package co.edu.unicauca.adminmicroservice.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatorDecisionDTOTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void validDTO_NoValidationErrors() {
        CoordinatorDecisionDTO dto = new CoordinatorDecisionDTO();
        dto.setCoordinatorEmail("valid@unicauca.edu.co");
        dto.setStatus("APPROVED");

        Set<ConstraintViolation<CoordinatorDecisionDTO>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void invalidEmail_ValidationFails() {
        CoordinatorDecisionDTO dto = new CoordinatorDecisionDTO();
        dto.setCoordinatorEmail("invalid-email");
        dto.setStatus("APPROVED");

        Set<ConstraintViolation<CoordinatorDecisionDTO>> violations = validator.validate(dto);
        assertEquals(1, violations.size());
        assertEquals("El email del coordinador debe ser válido", violations.iterator().next().getMessage());
    }

    @Test
    void rejectedWithoutReason_ValidationFails() {
        CoordinatorDecisionDTO dto = new CoordinatorDecisionDTO();
        dto.setCoordinatorEmail("valid@unicauca.edu.co");
        dto.setStatus("REJECTED");
        dto.setReason(null);

        Set<ConstraintViolation<CoordinatorDecisionDTO>> violations = validator.validate(dto);
        assertEquals(1, violations.size());
        assertEquals("La razón es obligatoria cuando se rechaza", violations.iterator().next().getMessage());
    }
}