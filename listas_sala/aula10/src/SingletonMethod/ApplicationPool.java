package SingletonMethod;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class ApplicationPool {
	
	public static final int MAX_INTANCES = 3;
	private Queue<Application> pool;
	private Set<Application> used;
	
	public ApplicationPool() throws InstantiationException, IllegalAccessException {
		pool = new ArrayBlockingQueue<Application>(MAX_INTANCES);
		used = new HashSet<Application>(MAX_INTANCES);
		pool.add(new Application());
		pool.add(new Application());
	}
	
	public Application getInstance() throws InstantiationException, IllegalAccessException {
		if (!pool.isEmpty()) {
			Application application = pool.remove();
			used.add(application);
			return application;
		} else if (used.size() < MAX_INTANCES) {
			Application application = new Application();
			used.add(application);
			return application;
		} else {
			throw new InstantiationException("Can not exceed maximum number of instances");
		}
	}
	
	public void freeInstance(Application application) {
		if (used.contains(application)) {
			pool.add(application);
			used.remove(application);
		}
	}
	
	public class Application {
		
		private Application() {
			try {
				Thread.sleep(3000); // 3 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
