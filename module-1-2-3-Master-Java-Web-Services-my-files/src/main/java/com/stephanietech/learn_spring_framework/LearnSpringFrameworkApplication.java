package com.stephanietech.learn_spring_framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.stephanietech.learn_spring_framework.enterprise.example.web.MyWebController;
import com.stephanietech.learn_spring_framework.game.GameRunner;


@SpringBootApplication
@ComponentScan("com.stephanietech.learn_spring_framework")
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context 
			= SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
//		MarioGame game = new MarioGame();
//		SuperContraGame game = new SuperContraGame();

//		GamingConsole game = new MarioGame();
//		GameRunner runner = new GameRunner(game);
		
//		context.getBeansOfType((Class<T>) Gamerunner.class);

		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
