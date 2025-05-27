package co.edu.unicauca.coordinatorservice.infra.dto;

public class CoordinatorRequest {
    private Long code;
    private String name;
    private String phone;
    private String email;
    private String degreeProgram;

    public CoordinatorRequest(Long code, String name, String phone, String email, String degreeProgram) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.degreeProgram = degreeProgram;
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
}
