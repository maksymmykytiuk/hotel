package service;

import com.maksymmylytiuk.hotel.dao.ReceptionDao;
import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.model.Room;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import com.maksymmylytiuk.hotel.service.ReceptionService;
import com.maksymmylytiuk.hotel.service.ReceptionServiceImpl;
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

    private Reception re1, re2, re3, re4;
    private Room r1, r2;
    private RoomStatus rs1, rs2;

    @Autowired
    private ReceptionService receptionService;

    @MockBean
    private ReceptionDao receptionDao;

    @Before
    public void setUp() {

        rs1 = new RoomStatus();
        rs1.setId(1L);
        rs1.setName("BOOKED");

        rs2 = new RoomStatus();
        rs2.setId(2L);
        rs2.setName("CHECKED_IN");

        r1 = new Room();
        r1.setId(1L);

        r2 = new Room();
        r2.setId(2L);

        re1 = new Reception();
        re1.setId(1L);
        re1.setRoom(r1);
        re1.setFrom(new Date(1526763600000L));//2018 05 20
        re1.setTo(new Date(1527195600000L));//2018 05 25
        re1.setRoomStatus(rs1);

        re2 = new Reception();
        re2.setId(2L);
        re2.setRoom(r2);
        re2.setFrom(new Date(1529874000000L));//2018 05 20
        re2.setTo(new Date(1530133200000L));//2018 05 25
        re2.setRoomStatus(rs1);

        re3 = new Reception();
        re3.setId(1L);
        re3.setRoom(r1);
        re3.setFrom(new Date(1529874000000L));//2018 05 20
        re3.setTo(new Date(1530133200000L));//2018 05 25
        re3.setRoomStatus(rs2);

        re4 = new Reception();
        re4.setId(1L);
        re4.setRoom(r1);
        re4.setFrom(new Date(1526763600000L));//2018 05 20
        re4.setTo(new Date(1527195600000L));//2018 05 25
        re4.setRoomStatus(rs1);

        receptions.add(re1);
        receptions.add(re2);
        receptions.add(re3);

        Mockito.when(receptionDao.findAll())
                .thenReturn(receptions);


        withStatusBooked.add(re1);
        withStatusBooked.add(re2);

        Mockito.when(receptionDao.findAllByRoomStatusId(1L))
                .thenReturn(withStatusBooked);

        Mockito.when(receptionDao.getAllByStatusAndPeriod(1L, new Date(1526331600000L), new Date(1527627600000L)))//2018 05 15 - 2018 05 30
                .thenReturn(Collections.singletonList(re1));

        Mockito.when(receptionDao.getOne(1L))
                .thenReturn(re4);
    }

    @Test
    public void whenGetAll_thenReturnAllList() {
        List<Reception> foundReceptions = receptionService.getAll();

        assertThat(foundReceptions)
                .isEqualTo(receptions);
    }

    @Test
    public void whenFindAllByRoomStatusBooked_thenReturnList() {
        List<Reception> foundReception = receptionService.getAllByStatusId(1L);

        assertThat(foundReception)
                .isEqualTo(withStatusBooked);
    }

    @Test
    public void whenFindAllByRoomStatusBookedAndPeriod_thenReturnList() {
        List<Reception> foundReception = receptionService.getAllByStatusAndPeriod(rs1,
                new Date(1526331600000L), new Date(1527627600000L));

        assertThat(foundReception)
                .isEqualTo(Collections.singletonList(re1));
    }

    @Test
    public void whenGetById_thenReturnOneObject() {
        Reception reception = receptionService.getById(1L);

        assertThat(reception)
                .isEqualTo(re1);
    }
}
