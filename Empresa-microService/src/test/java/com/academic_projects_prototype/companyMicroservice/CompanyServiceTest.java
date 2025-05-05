package com.academic_projects_prototype.companyMicroservice;

import com.academic_projects_prototype.companyMicroservice.entities.Company;
import com.academic_projects_prototype.companyMicroservice.entities.IndustrialSector;
import com.academic_projects_prototype.companyMicroservice.repositories.CompanyRepository;
import com.academic_projects_prototype.companyMicroservice.services.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;

    @Test
    void testGetCompanyById_WhenCompanyExists() {
        // Arrange
        Long companyId = 1L;
        Company mockCompany = new Company(companyId, 123456789L, "Company A", "123456789", "www.companya.com",
                IndustrialSector.TECHNOLOGY, "email@companya.com", "password123");
        when(companyRepository.findById(companyId)).thenReturn(Optional.of(mockCompany));

        // Act
        Company result = companyService.getCompanyById(companyId);

        // Assert
        assertNotNull(result);
        assertEquals("Company A", result.getName());
        verify(companyRepository, times(1)).findById(companyId);
    }

    @Test
    void testGetCompanyById_WhenCompanyDoesNotExist() {
        // Arrange
        Long companyId = 1L;
        when(companyRepository.findById(companyId)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> companyService.getCompanyById(companyId));
        assertEquals("No existe una empresa con el id 1", exception.getMessage());
        verify(companyRepository, times(1)).findById(companyId);
    }

    @Test
    void testCreateCompany() {
        // Arrange
        Company newCompany = new Company(null, 987654321L, "New Company", "987654321", "www.newcompany.com",
                IndustrialSector.HEALTHCARE, "email@newcompany.com", "securepassword");
        Company savedCompany = new Company(2L, 987654321L, "New Company", "987654321", "www.newcompany.com",
                IndustrialSector.HEALTHCARE, "email@newcompany.com", "securepassword");
        when(companyRepository.save(newCompany)).thenReturn(savedCompany);

        // Act
        Company result = companyService.createCompany(newCompany);

        // Assert
        assertEquals(2L, result.getId());
        assertEquals("New Company", result.getName());
        verify(companyRepository, times(1)).save(newCompany);
    }

    @Test
    void testUpdateCompany_WhenItExists() {
        // Arrange
        Company existingCompany = new Company(1L, 123456789L, "Old Company", "12345678", "www.oldcompany.com",
                IndustrialSector.AGRICULTURE, "oldemail@oldcompany.com", "oldpassword");
        Company updatedCompanyDetails = new Company(1L, 123456789L, "Updated Company", "87654321", "www.updatedcompany.com",
                IndustrialSector.AGRICULTURE, "email@updatedcompany.com", "newpassword");

        when(companyRepository.existsById(existingCompany.getId())).thenReturn(true);
        when(companyRepository.save(updatedCompanyDetails)).thenReturn(updatedCompanyDetails);

        // Act
        Company result = companyService.updateCompany(updatedCompanyDetails);

        // Assert
        assertEquals("Updated Company", result.getName());
        assertEquals("www.updatedcompany.com", result.getWebsite());
        assertEquals("newpassword", result.getPassword());
        verify(companyRepository, times(1)).save(updatedCompanyDetails);
    }

    @Test
    void testUpdateCompany_WhenItDoesNotExist() {
        // Arrange
        Company updatedCompanyDetails = new Company(1L, 123456789L, "Updated Company", "87654321", "www.updatedcompany.com",
                IndustrialSector.AGRICULTURE, "email@updatedcompany.com", "newpassword");
        when(companyRepository.existsById(updatedCompanyDetails.getId())).thenReturn(false);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> companyService.updateCompany(updatedCompanyDetails));
        assertEquals("La empresa con id: 1 no fue encontrada", exception.getMessage());
        verify(companyRepository, never()).save(updatedCompanyDetails);
    }
}