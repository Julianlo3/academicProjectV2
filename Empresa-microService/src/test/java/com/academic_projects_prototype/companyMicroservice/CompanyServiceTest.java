package com.academic_projects_prototype.companyMicroservice;


import com.academic_projects_prototype.companyMicroservice.repositories.CompanyRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {
    @Mock
    private CompanyRepository companyRepository;
}
