package com.epam.labs.lab3_4.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsualPerson implements Person {
    @Id
    @Column
    private int id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    private int age;
    private float height;
    private boolean isProgrammer;

    @Singular
    private List<String> contacts;

    @Override
    public void sayHello(Person person) {
        System.out.println("hello");
    }
}
