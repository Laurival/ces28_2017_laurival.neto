package mvp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvp.presenter.PersonDetailPresenterImpl;

public class ViewListener implements ActionListener {
	
	PersonDetailView _view;
	PersonDetailPresenterImpl _presenter;
	
	public ViewListener(PersonDetailView view, PersonDetailPresenterImpl presenter){
		_view = view;
		_presenter = presenter;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_presenter.changedButtonPressed(_view.getNameFromTextField());
	}
	

}
