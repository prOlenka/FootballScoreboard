package football.scoreboard.lib;

import org.springframework.boot.SpringApplication;

public class TestLibApplication {

	public static void main(String[] args) {
		SpringApplication.from(LibApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
