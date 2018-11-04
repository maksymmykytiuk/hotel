package com.maksymmylytiuk.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue
    @Column(name = "guest_id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "middle_name", nullable = false, length = 64)
    private String middleName;

    @Column(name = "second_name", nullable = false, length = 64)
    private String secondName;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "phone", unique = true, nullable = false, length = 20)
    private String phone;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "guest")
    private Set<Reception> rooms;

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone +
                '}';
    }
}
