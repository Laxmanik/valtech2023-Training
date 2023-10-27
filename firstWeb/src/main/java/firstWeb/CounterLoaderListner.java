package firstWeb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CounterLoaderListner implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("Context Destroyed...");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("Context Initialized...");
	}

}
