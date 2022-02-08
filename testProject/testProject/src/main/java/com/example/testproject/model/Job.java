package com.example.testproject.model;


import com.example.testproject.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Job")
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String title;

    private String description;

    private String requirement;

    private Date dateCreated = new Date();

    private Double biddingValueInDollars;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = DateUtil.class)
    private Date expiryDate;

    @ManyToOne()
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    private User postedBy;

    private Boolean active;

}
