package com.maksymmylytiuk.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.maksymmylytiuk.hotel.util.deserializer.GuestDeserializer;
import com.maksymmylytiuk.hotel.util.deserializer.RoomTypeDeserializer;
import com.maksymmylytiuk.hotel.util.serializer.GuestSerializer;
import com.maksymmylytiuk.hotel.util.serializer.RoomTypeSerializer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Long id;

    @Column(name = "floor", nullable = false, length = 10)
    private Integer floor;

    @Column(name = "price_per_night", scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    @JsonSerialize(using = RoomTypeSerializer.class)
    @JsonDeserialize(using = RoomTypeDeserializer.class)
    private RoomType roomType;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private Set<Reception> rooms;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", floor=" + floor +
                ", price=" + price +
                '}';
    }
}
