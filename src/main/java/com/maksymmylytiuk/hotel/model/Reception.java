package com.maksymmylytiuk.hotel.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.maksymmylytiuk.hotel.util.deserializer.DateDeserializer;
import com.maksymmylytiuk.hotel.util.deserializer.GuestDeserializer;
import com.maksymmylytiuk.hotel.util.deserializer.RoomDeserializer;
import com.maksymmylytiuk.hotel.util.deserializer.RoomStatusDeserializer;
import com.maksymmylytiuk.hotel.util.serializer.DateSerializer;
import com.maksymmylytiuk.hotel.util.serializer.GuestSerializer;
import com.maksymmylytiuk.hotel.util.serializer.RoomSerializer;
import com.maksymmylytiuk.hotel.util.serializer.RoomStatusSerializer;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "reception")
public class Reception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reception_id")
    private Long id;

    @Column(name = "period_from", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date from;

    @Column(name = "period_to", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date to;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_status_id")
    @JsonSerialize(using = RoomStatusSerializer.class)
    @JsonDeserialize(using = RoomStatusDeserializer.class)
    private RoomStatus roomStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    @JsonSerialize(using = GuestSerializer.class)
    @JsonDeserialize(using = GuestDeserializer.class)
    private Guest guest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    @JsonSerialize(using = RoomSerializer.class)
    @JsonDeserialize(using = RoomDeserializer.class)
    private Room room;

    @Override
    public String toString() {
        return "Reception{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
