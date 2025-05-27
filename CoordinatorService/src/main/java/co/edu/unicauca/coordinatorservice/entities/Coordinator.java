package  co.edu.unicauca.coordinatorservice.entities;

import co.edu.unicauca.coordinatorservice.entities.state.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long code;
    private String  name;
    private String  phone;
    private String  email;
    private String  degreeProgram;
    private CoordinatorStatus status;
    @JsonIgnore
    @Transient
    private ICoordinatorState state;

    public Coordinator() {
        this.state = new Pending();
        this.status = CoordinatorStatus.PENDING;
    }

    public Coordinator(Long code, String name, String phone, String email, String degreeProgram) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.state = new Pending();
        this.status = CoordinatorStatus.PENDING;
    }

    // Getters y setters
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

    public ICoordinatorState getState() {
        return state;
    }

    // Metodos de estado
    public void changeState(ICoordinatorState newState) {
        this.state = newState;
    }

    public void verify() throws Exception {
        this.state.verify(this);
    }

    public void reject() throws Exception {
        this.state.reject(this);
    }
}
