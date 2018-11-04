package com.maksymmylytiuk.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "room_type")
public class RoomType {

    @Id
    @GeneratedValue
    @Column(name = "room_type_id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 64)
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "roomType" )
    private Set<Room> rooms;
}
