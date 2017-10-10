package SingletonMethod;

public class ApplicationThreads {
	private String name;

	private ApplicationThreads(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private static boolean flag = false;
	private static ApplicationThreads instance = null;
	public static synchronized ApplicationThreads getApplication(String name) {
		if (flag == false) {
			flag = true;
			instance = new ApplicationThreads(name);
		}
		return instance;
	}

	public static ApplicationThreads application1, application2;

	public static void main(String[] args) throws Throwable {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				application1 = ApplicationThreads.getApplication("João");
				System.out.println(application1.getName());
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				application2 = ApplicationThreads.getApplication("Maria");
				System.out.println(application2.getName());
			}
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		if (application1 == application2) {
			System.out.println("Deu bom " + application1.getName() + " " + application2.getName());
		} else {
			System.out.println("Deu ruim " + application1.getName() + " " + application2.getName());
		}
	}
} // class: Application
