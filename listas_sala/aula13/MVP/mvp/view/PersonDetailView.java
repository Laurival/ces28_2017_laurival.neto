package mvp.view;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mvp.presenter.PersonDetailPresenterImpl;

@SuppressWarnings("serial")
public class PersonDetailView extends JPanel implements WindowListener, Observer{

	public PersonDetailView(PersonDetailPresenterImpl presenter) {
		this.setPresenter(presenter);
		this.createUI();
		this.bindUI();
		this.populateView(presenter.getName());
		this.display();
	}

	private void createUI() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.label = new JLabel();
		add(label, BorderLayout.NORTH);
	
		this.nameTextField = new JTextField();
		add(nameTextField);
		
		this.changeButton = new JButton(LABEL_CHANGE_BUTTON);
		add(changeButton);
	}
	
	private void bindUI() {
		this.changeButton.addActionListener(new ViewListener(this, _presenter));
	}
	
	private void populateView(String newName) {
		if (nameIsNonNullAndNonVoidString(newName))
			this.label.setText(LABEL + newName);
		else this.label.setText(LABEL + "...");
	}
	
	public String getNameFromTextField() {
		return nameTextField.getText();
	}
	
	public void display() {
		if (this.frame == null) {
			this.frame = new JFrame() {
				{
					setTitle(FRAME_TITLE );
					setLocationRelativeTo(null);
					setContentPane(PersonDetailView.this);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					addWindowListener(PersonDetailView.this);
					pack();
				}
			};
		}
		this.frame.setVisible(true);
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

	public PersonDetailPresenterImpl getPresenter() {
		return _presenter;
	}

	public void setPresenter(PersonDetailPresenterImpl presenter) {
		_presenter = presenter;
		presenter.addObserver(this);
	}

	public Boolean nameIsNonNullAndNonVoidString(String newName) {	
		if ((newName != null) & (!newName.equals("")))
				return true;
		return false;
	}

	private static final String LABEL = "The person name is ";
	private static final String LABEL_CHANGE_BUTTON = "Change";
	private static final String FRAME_TITLE = null;
	
	private PersonDetailPresenterImpl _presenter;

	private JLabel label;
	private JTextField nameTextField;
	private JButton changeButton;
	private JFrame frame;
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof String)
			this.populateView((String) arg);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		this.getPresenter().deleteObserver(this);
		if (this.getPresenter().countObservers() == 0)
			System.exit(0);
	}
}
