package view;

//import model.Solution;
import model.Solution;
import model.algorithm.SearchDomain;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;

import presenter.Presenter;

public class MazeGameWindow1 extends UIView {
	
	private String userAction;
	String algorithm;
	int[][] mazeBoard;	
	
	
	
		public MazeGameWindow1(Presenter presenter, Display display, int width,
				int height, String title, String algorithm) {
			super(presenter, display, width, height, title);
			this.algorithm = algorithm;
		}
		
		@Override
		void initWidgets() {
			
			userAction = "SelectDomain maze"; 
			MazeGameWindow1.this.setChanged();
			MazeGameWindow1.this.notifyObservers();	
			
			
			userAction = "SelectAlgorithm " + algorithm;
			MazeGameWindow1.this.setChanged();
			MazeGameWindow1.this.notifyObservers();	
			
			
			shell.setLayout(new GridLayout(2, false));
			
			Button start = new Button(shell, SWT.PUSH);
			start.setText("Start");
			start.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		
			
			final Maze maze = new Maze (shell, SWT.BORDER, mazeBoard);
			maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,1,2));
		
			Button stop = new Button(shell, SWT.PUSH);
			stop.setText("Stop");
			stop.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		
			start.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				maze.start();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		stop.addSelectionListener((new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				maze.stop();
				
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
		public void updateBoard(int[][] gameBoard) {
			this.mazeBoard= gameBoard;
			
		}

			

		@Override
		public String getUserAction() {
			// TODO Auto-generated method stub
			return userAction;
		}

	

}
