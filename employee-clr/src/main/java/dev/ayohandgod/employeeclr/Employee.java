package dev.ayohandgod.employeeclr;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private Position position;

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

    public String getPosition() {
        return position.toString();
    }

    public void setPosition(String position) {
        this.position = Position.valueOf(position);
    }

    public static void main(String[] args) {
        try(BufferedReader reader = Files.newBufferedReader(Path.of("testFile.txt")) ;
            BufferedWriter writer = Files.newBufferedWriter(Path.of("testFile.txt"), StandardOpenOption.APPEND)) {
                System.out.println(reader.readLine());
                writer.append("\nNew Line just added");
                System.out.println("\n"+reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
