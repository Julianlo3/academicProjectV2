package co.edu.unicauca.studentservice.entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private Long code;
    private String name;
    private Long phone;
    private String email;
    private String password;

    public Student(Long id, Long code, String name, Long phone, String email, String password) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Student() {
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
