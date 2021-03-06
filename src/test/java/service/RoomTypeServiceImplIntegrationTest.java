package service;

import com.maksymmylytiuk.hotel.dao.RoomTypeDao;
import com.maksymmylytiuk.hotel.model.RoomType;
import com.maksymmylytiuk.hotel.service.RoomTypeService;
import com.maksymmylytiuk.hotel.service.RoomTypeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class RoomTypeServiceImplIntegrationTest {

    @TestConfiguration
    static class RoomTypeServiceImplTestContextConfiguration {

        @Bean
        public RoomTypeService roomTypeService() {
            return new RoomTypeServiceImpl();
        }
    }

    private RoomType rt;

    @Autowired
    private RoomTypeService roomTypeService;

    @MockBean
    private RoomTypeDao roomTypeDao;

    @Before
    public void setUp() {
        rt = new RoomType();
        rt.setId(1L);
        rt.setName("ROOM");

        Mockito.when(roomTypeDao.getOne(1L))
                .thenReturn(rt);
    }

    @Test
    public void whenGetById_thenReturnOneObject() {
        RoomType roomType = roomTypeDao.getOne(1L);

        assertThat(roomType)
                .isEqualTo(rt);
    }
}
