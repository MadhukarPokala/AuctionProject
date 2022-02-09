package com.auction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true,  nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    private Boolean enabled;

    private String fullName;


    @OneToMany(mappedBy = "postedBy", orphanRemoval = true)
    private Set<Job> jobList = new LinkedHashSet<>();

}
