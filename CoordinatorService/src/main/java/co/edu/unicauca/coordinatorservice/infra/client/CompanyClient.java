package co.edu.unicauca.coordinatorservice.infra.client;

import co.edu.unicauca.coordinatorservice.infra.config.FeignAuthForwardInterceptor;
import co.edu.unicauca.coordinatorservice.infra.dto.CompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "company-service",
        url = "http://localhost:8081",
        configuration = FeignAuthForwardInterceptor.class
)
public interface CompanyClient {

    @GetMapping("/api/company/{nit}")
    ResponseEntity<CompanyDTO> getCompanyByNit(@PathVariable Long nit);
}
