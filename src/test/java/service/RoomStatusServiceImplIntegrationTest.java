package service;

import com.maksymmylytiuk.hotel.dao.RoomDao;
import com.maksymmylytiuk.hotel.dao.RoomStatusDao;
import com.maksymmylytiuk.hotel.model.Room;
import com.maksymmylytiuk.hotel.model.RoomStatus;
import com.maksymmylytiuk.hotel.model.RoomType;
import com.maksymmylytiuk.hotel.service.RoomService;
import com.maksymmylytiuk.hotel.service.RoomServiceImpl;
import com.maksymmylytiuk.hotel.service.RoomStatusService;
import com.maksymmylytiuk.hotel.service.RoomStatusServiceImpl;
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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class RoomStatusServiceImplIntegrationTest {

    @TestConfiguration
    static class RoomStatusServiceImplTestContextConfiguration {

        @Bean
        public RoomStatusService roomStatusService() {
            return new RoomStatusServiceImpl();
        }
    }

    @Autowired
    private RoomStatusService roomStatusService;

    @MockBean
    private RoomStatusDao roomStatusDao;

    @Before
    public void setUp() {
        Mockito.when(roomStatusDao.getOne(1L))
                .thenReturn(RoomStatus.builder()
                        .id(1L)
                        .name("FREE").build());
    }

    @Test
    public void whenGetById_thenReturnOneObject() {
        RoomStatus roomStatus = roomStatusDao.getOne(1L);

        assertThat(roomStatus)
                .isEqualTo(RoomStatus.builder()
                        .id(1L)
                        .name("FREE").build());
    }
}
