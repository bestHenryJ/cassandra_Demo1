package com.example.springcassdemo.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @PrimaryKey
    private int id;
    private String name;
    private String address;
    private int age;
}
