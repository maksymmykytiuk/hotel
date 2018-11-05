package service;

import com.maksymmylytiuk.hotel.dao.ReceptionDao;
import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.model.Room;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import com.maksymmylytiuk.hotel.service.ReceptionService;
import com.maksymmylytiuk.hotel.service.ReceptionServiceImpl;
import org.hibernate.mapping.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ReceptionServiceImplIntegrationTest {

    @TestConfiguration
    static class ReceptionServiceImplTestContextConfiguration {

        @Bean
        public ReceptionService ReceptionService() {
            return new ReceptionServiceImpl();
        }
    }

    private List<Reception> receptions = new ArrayList<>();

    private List<Reception> withStatusBooked = new ArrayList<>();

    @Autowired
    private ReceptionService receptionService;

    @MockBean
    private ReceptionDao receptionDao;

    @Before
    public void setUp() {
        receptions.add(
                Reception.builder()
                        .id(1L)
                        .room(Room.builder()
                                .id(1L)
                                .build())
                        .from(new Date(1526763600000L))//2018 05 20
                        .to(new Date(1527195600000L))//2018 05 25
                        .roomStatus(RoomStatus.builder()
                                .id(1L)
                                .name("BOOKED").build()).build());

        receptions.add(
                Reception.builder()
                        .id(2L)
                        .room(Room.builder()
                                .id(2L)
                                .build())
                        .from(new Date(1529874000000L))//2018 06 25
                        .to(new Date(1530133200000L))//2018 06 28
                        .roomStatus(RoomStatus.builder()
                                .id(1L)
                                .name("BOOKED").build()).build());

        receptions.add(
                Reception.builder()
                        .id(3L)
                        .room(Room.builder()
                                .id(1L)
                                .build())
                        .from(new Date(1529874000000L))//2018 06 25
                        .to(new Date(1530133200000L))//2018 06 28
                        .roomStatus(RoomStatus.builder()
                                .id(2L)
                                .name("CHECKED_IN").build()).build());


        Mockito.when(receptionDao.findAll())
                .thenReturn(receptions);



        withStatusBooked.add(
                Reception.builder()
                        .id(1L)
                        .room(Room.builder()
                                .id(1L)
                                .build())
                        .from(new Date(1526763600000L))//2018 05 20
                        .to(new Date(1527195600000L))//2018 05 25
                        .roomStatus(RoomStatus.builder()
                                .id(1L)
                                .name("BOOKED").build()).build());

        withStatusBooked.add(
                Reception.builder()
                        .id(2L)
                        .room(Room.builder()
                                .id(2L)
                                .build())
                        .from(new Date(1529874000000L))//2018 06 25
                        .to(new Date(1530133200000L))//2018 06 28
                        .roomStatus(RoomStatus.builder()
                                .id(1L)
                                .name("BOOKED").build()).build());

        Mockito.when(receptionDao.findAllByRoomStatusId(1L))
                .thenReturn(withStatusBooked);

        Mockito.when(receptionDao.getAllByStatusAndPeriod(1L, new Date(1526331600000L), new Date(1527627600000L)))//2018 05 15 - 2018 05 30
                .thenReturn(Collections.singletonList(Reception.builder()
                        .id(1L)
                        .room(Room.builder()
                                .id(1L)
                                .build())
                        .from(new Date(1526763600000L))//2018 05 20
                        .to(new Date(1527195600000L))//2018 05 25
                        .roomStatus(RoomStatus.builder()
                                .id(1L)
                                .name("BOOKED").build()).build()));

        Mockito.when(receptionDao.getOne(1L))
                .thenReturn( Reception.builder()
                        .id(1L)
                        .room(Room.builder()
                                .id(1L)
                                .build())
                        .from(new Date(1526763600000L))//2018 05 20
                        .to(new Date(1527195600000L))//2018 05 25
                        .roomStatus(RoomStatus.builder()
                                .id(1L)
                                .name("BOOKED").build()).build());
    }

    @Test
    public void whenGetAll_thenReturnAllList() {
        List<Reception> foundReceptions = receptionService.getAll();

        assertThat(foundReceptions)
                .isEqualTo(receptions);
    }

    @Test
    public void whenFindAllByRoomStatusBooked_thenReturnList(){
        List<Reception> foundReception = receptionService.getAllByStatusId(1L);

        assertThat(foundReception)
                .isEqualTo(withStatusBooked);
    }

    @Test
    public void whenFindAllByRoomStatusBookedAndPeriod_thenReturnList(){
        List<Reception> foundReception = receptionService.getAllByStatusAndPeriod(RoomStatus.builder().id(1L).name("BOOKED").build(),
                new Date(1526331600000L), new Date(1527627600000L));

        assertThat(foundReception)
                .isEqualTo(Collections.singletonList(Reception.builder()
                        .id(1L)
                        .room(Room.builder()
                                .id(1L)
                                .build())
                        .from(new Date(1526763600000L))//2018 05 20
                        .to(new Date(1527195600000L))//2018 05 25
                        .roomStatus(RoomStatus.builder()
                                .id(1L)
                                .name("BOOKED").build()).build()));
    }

    @Test
    public void whenGetById_thenReturnOneObject(){
        Reception reception = receptionService.getById(1L);

        assertThat(reception)
                .isEqualTo(Reception.builder()
                        .id(1L)
                        .room(Room.builder()
                                .id(1L)
                                .build())
                        .from(new Date(1526763600000L))//2018 05 20
                        .to(new Date(1527195600000L))//2018 05 25
                        .roomStatus(RoomStatus.builder()
                                .id(1L)
                                .name("BOOKED").build()).build());
    }
}
