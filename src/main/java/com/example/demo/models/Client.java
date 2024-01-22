package com.example.demo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "clients")
public class Client {

    @Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36)
    private String id;

    @Schema(defaultValue = "Hanner")
    @Column(name = "name")
    private String name;

    @Schema(defaultValue = "De La Hoz")
    @Column(name = "lastname")
    private String lastname;

    @Schema(defaultValue = "23")
    @Column(name = "age")
    private Integer age;

}
