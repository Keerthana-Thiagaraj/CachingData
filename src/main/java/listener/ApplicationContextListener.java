package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cache.GetCacheData;

public class ApplicationContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		

		try {
			System.out.println("loading user data");
			GetCacheData.loadData();
		} catch (Exception e) {
			System.out.println("Error in loading user info");
		}

	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}
}