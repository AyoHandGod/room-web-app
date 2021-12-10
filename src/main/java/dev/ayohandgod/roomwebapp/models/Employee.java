package dev.ayohandgod.roomwebapp.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="EMPLOYEE")
public class Employee {


    @Id
    @Column(name="EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="POSITION")
    @Enumerated(EnumType.STRING)
    Position position;

    public Employee() {}

    public Employee(String id, String firstName, String lastName, Position position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = Position.valueOf(position);
    }
}
