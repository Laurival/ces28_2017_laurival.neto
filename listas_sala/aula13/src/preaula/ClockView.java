package preaula;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockView implements Observer{
	private Clock clock = new Clock(); 
	
	public ClockView() {
		clock.addObserver(this);
		this.mountDisplay();
	}

	@Override
	public void update(Observable clock, Object arg1) {
	
		System.out.println("Hora: " + arg1);
		label.setText((String) arg1);
	}

	public void mountDisplay() {
		JPanel panel = new JPanel();

		panel.add(label);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		label.setFont(new Font("Arial", Font.ITALIC, 25));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(panel);

		frame.setResizable(false);
		frame.setBounds(200, 200, 500, 110);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		label.setText(getTime());
	}

	private JLabel label = new JLabel();
	private static JFrame frame = new JFrame("Clock :D");

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ClockView clView = new ClockView();
				Thread th = new Thread(clView);
				th.start();

			}
		});
	}


}
