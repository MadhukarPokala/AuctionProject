package com.auction.model;


import com.auction.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    private Boolean active;

    @ManyToOne(optional = false)
    @JoinColumn(name = "postedBy", nullable = false)
    @JsonIgnore
    private User postedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Job job = (Job) o;
        return id != null && Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @JsonGetter("posted by")
    protected String getBrandName() {
        return postedBy.getFullName();
    }

}
