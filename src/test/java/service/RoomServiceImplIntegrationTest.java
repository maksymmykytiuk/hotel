package service;

import com.maksymmylytiuk.hotel.dao.ReceptionDao;
import com.maksymmylytiuk.hotel.dao.RoomDao;
import com.maksymmylytiuk.hotel.model.Reception;
import com.maksymmylytiuk.hotel.model.Room;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import com.maksymmylytiuk.hotel.model.RoomType;
import com.maksymmylytiuk.hotel.service.ReceptionService;
import com.maksymmylytiuk.hotel.service.ReceptionServiceImpl;
import com.maksymmylytiuk.hotel.service.RoomService;
import com.maksymmylytiuk.hotel.service.RoomServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class RoomServiceImplIntegrationTest {

    @TestConfiguration
    static class RoomServiceImplTestContextConfiguration {

        @Bean
        public RoomService roomService() {
            return new RoomServiceImpl();
        }
    }

    @Autowired
    private RoomService roomService;

    @MockBean
    private RoomDao roomDao;

    @Before
    public void setUp() {
        Mockito.when(roomDao.getOne(1L))
                .thenReturn(Room.builder()
                        .id(1L)
                        .floor(5)
                        .price(BigDecimal.TEN)
                        .roomType(RoomType.builder()
                                .id(1L)
                                .name("ROOM").build()).build());
    }

    @Test
    public void whenGetById_thenReturnOneObject() {
        Room room = roomService.getById(1L);

        assertThat(room)
                .isEqualTo(Room.builder()
                        .id(1L)
                        .floor(5)
                        .price(BigDecimal.TEN)
                        .roomType(RoomType.builder()
                                .id(1L)
                                .name("ROOM").build()).build());
    }
}
