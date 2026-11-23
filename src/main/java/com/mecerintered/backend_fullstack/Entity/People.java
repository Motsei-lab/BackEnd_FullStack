package com.mecerintered.backend_fullstack.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="people")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstName",nullable = false)
    private String name;

    @Column(name="emails",unique = true)
    private String email;
}
