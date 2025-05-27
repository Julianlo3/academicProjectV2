package co.edu.unicauca.coordinatorservice.infra.dto;

import co.edu.unicauca.coordinatorservice.entities.CoordinatorStatus;

public class CoordinatorResponse {
    private Long id;
    private Long code;
    private String name;
    private String phone;
    private String email;
    private String degreeProgram;
    private CoordinatorStatus status;

    public CoordinatorResponse(Long id, Long code, String name, String phone, String email, String degreeProgram, CoordinatorStatus status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public void setDegreeProgram(String degreeProgram) {
        this.degreeProgram = degreeProgram;
    }

    public CoordinatorStatus getStatus() {
        return status;
    }

    public void setStatus(CoordinatorStatus status) {
        this.status = status;
    }
}
