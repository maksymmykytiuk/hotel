package com.maksymmylytiuk.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 64)
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "country")
    private Set<Guest> guests;
}
