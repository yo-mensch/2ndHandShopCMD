import model.Shop;
import model.User;
import org.junit.*;
import static org.junit.Assert.*;
import service.ShopService;

public class ShopServiceTest {
    private ShopService shopService;

    @Before
    public void setUp(){
        this.shopService = new ShopService();
    }

    @Test
    public void shouldAddUserToStore(){
        //Given
        User expectedUser = new User("test", "test", "test");
        //When
        //User actualUser = shopService.addUserToShop(expectedUser);
        //Then
        //assertEquals(expectedUser, actualUser);
    }
}
