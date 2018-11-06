package service;

import com.maksymmylytiuk.hotel.HotelApplication;
import com.maksymmylytiuk.hotel.dao.GuestDao;
import com.maksymmylytiuk.hotel.model.Country;
import com.maksymmylytiuk.hotel.model.Guest;
import com.maksymmylytiuk.hotel.service.GuestService;
import com.maksymmylytiuk.hotel.service.GuestServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = HotelApplication.class)
public class GuestServiceIntegrationTest {

    @TestConfiguration
    static class GuestServiceImplTestContextConfiguration {
        @Bean
        public GuestService guestService() {
            return new GuestServiceImpl();
        }
    }

    @Autowired
    private GuestService guestService;

    @MockBean
    private GuestDao guestDao;

    @Before
    public void setUp() {
        Guest guest = new Guest();
        guest.setId(1L);
        guest.setFirstName("Ivan");

        Mockito.when(guestDao.getOne(1L))
               .thenReturn(guest);
    }

    @Test
    public void whenValidId_thenGuestShouldBeFound() {
        Long validId = 1L;
        Guest found = guestService.getById(validId);

        assertThat(found.getId()).isEqualTo(validId);
    }

    @Test
    public void whenInvalidId_thenGuestShouldNotBeFound() {
        Long invalidId = 100000L;
        Guest found = guestService.getById(invalidId);

        assertThat(found).isEqualTo(null);
    }

    @Test
    public void whenIdIsNegative_thenGuestShouldNotBeFound() {
        Long invalidId = -1L;
        Guest found = guestService.getById(invalidId);

        assertThat(found).isEqualTo(null);
    }
}
