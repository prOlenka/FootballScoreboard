package football.scoreboard.lib;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class LibApplicationTests {

	@Test
	void contextLoads() {
	}

}
