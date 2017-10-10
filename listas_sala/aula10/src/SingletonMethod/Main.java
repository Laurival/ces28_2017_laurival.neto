package SingletonMethod;

import SingletonMethod.ApplicationPool.Application;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ApplicationPool applicationPool = new ApplicationPool();
		long start = System.currentTimeMillis();
		Application application1 = applicationPool.getInstance();
		Application application2 = applicationPool.getInstance();
		long current = System.currentTimeMillis();
		System.out.println("Time = " + (current - start));
		Application application3 = applicationPool.getInstance();
		current = System.currentTimeMillis();
		System.out.println("Time = " + (current - start));
		try{
			Application application4 = applicationPool.getInstance();
			System.out.println("Não tem exceção");
		} catch(Exception e) {
			System.out.println("Tem uma exceção");
		}
		start = System.currentTimeMillis();
		applicationPool.freeInstance(application1);
		application1 = applicationPool.getInstance();
		current = System.currentTimeMillis();
		System.out.println("Time = " + (current - start));
	}

}
