/*package view;

import model.Solution;
import model.algorithm.SearchDomain;
import model.Solution;
import model.algorithm.SearchDomain;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;

import presenter.Presenter;

public class SkiGameWindow1 extends UIView {

		public SkiGameWindow1(Presenter presenter, Display display, int width,
				int height, String title) {
			super(presenter, display, width, height, title);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		void initWidgets() {
			shell.setLayout(new GridLayout(2, false));
			
			Button start = new Button(shell, SWT.PUSH);
			start.setText("Start");
			start.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		
			final Ski ski = new Ski(shell, SWT.BALLOON);
			ski.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,1,2));
		
			Button stop = new Button(shell, SWT.PUSH);
			stop.setText("Stop");
			stop.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		
			start.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				ski.start();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		stop.addSelectionListener((new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				ski.stop();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}));
		
	}

		@Override
		public void start() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displayCurrentState(SearchDomain searchDomain) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displaySolution(Solution solution) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getUserAction() {
			// TODO Auto-generated method stub
			return null;
		}


}
*/