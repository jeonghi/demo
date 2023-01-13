package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="User", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Entity(name="User")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private int age;
}
