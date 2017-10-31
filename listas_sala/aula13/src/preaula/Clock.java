package preaula;
import java.util.GregorianCalendar;
import java.util.Observable;

public class Clock extends Observable implements Runnable {

	public Clock() {
	}

	public String getTime() {
		String time = "";
		GregorianCalendar calendario = new GregorianCalendar();
		int h = calendario.get(GregorianCalendar.HOUR_OF_DAY);
		int m = calendario.get(GregorianCalendar.MINUTE);
		int s = calendario.get(GregorianCalendar.SECOND);
		time += ((h < 10) ? "0" : "") + h + ":";
		time += ((m < 10) ? "0" : "") + m + ":";
		time += ((s < 10) ? "0" : "") + s;
		return time;
	}

	@Override
	public void run() {
		while (true) {
			update();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void update() {
		setChanged();
		notifyObservers(this.getTime());
	}

}
