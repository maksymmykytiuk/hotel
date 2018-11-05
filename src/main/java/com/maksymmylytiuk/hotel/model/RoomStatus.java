package com.maksymmylytiuk.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
@Data
@Table(name = "room_status")
public class RoomStatus {

    @Id
    @JsonProperty
    @GeneratedValue
    @Column(name = "room_status_id")
    private Long id;

    @JsonProperty
    @Column(name = "name", unique = true, nullable = false, length = 64)
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "roomStatus")
    private Set<Reception> rooms;

    @Override
    public String toString() {
        return "RoomStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
