package github.com.dpbm.rss;

import com.dpbm.rss.DioRssProjectApplication;
import com.dpbm.rss.exceptions.InsertWithId;
import com.dpbm.rss.model.User;
import com.dpbm.rss.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = DioRssProjectApplication.class)
class DioRssProjectApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void testAddUser() throws InsertWithId {

		User sample = new User();
		sample.setUsername("AAA");
		sample.setEmail("BBBB");

		User user = userService.saveUser(sample);


		assertThat(user.getId().isEmpty()).isFalse();
		assertThat(user.getEmail()).isEqualTo(sample.getEmail());
		assertThat(user.getUsername()).isEqualTo(sample.getUsername());
	}

}
