package view;

import model.Solution;
import model.algorithm.Action;
import model.algorithm.SearchDomain;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

import presenter.Presenter;

public class MazeGameWindow extends UIView {
	
	public MazeGameWindow(Presenter presenter, Display display, int width, int height, String title) {
		super(presenter, display, width, height, title);
		this.presenter=presenter;

	}
	
	
	private Presenter presenter;
	private String userAction;
	private List lstActions;	
	
	@Override
	void initWidgets() {
		
		shell.setLayout(new GridLayout(2, false));
		
		Label lblAlgorithm = new Label(shell, SWT.NONE);
		lblAlgorithm.setText("Choose algorithm: ");
		
		final Combo combo = new Combo(shell, SWT.READ_ONLY);	
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
	    String items[] = { "BFS", "A-Star" };
	    combo.setItems(items);
		
		Button btnSearch = new Button(shell, SWT.PUSH);
		//Maze maze = new Maze(shell, SWT.BORDER);
		btnSearch.setText("Start");
		btnSearch.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		
		
		
		
		lstActions = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		lstActions.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
				
		btnSearch.addSelectionListener(new SelectionListener() {
			
			
			public void widgetSelected(SelectionEvent arg0) {	
				userAction = "SelectDomain maze"; 
				MazeGameWindow.this.setChanged();
				MazeGameWindow.this.notifyObservers();	
				
				userAction = "SelectAlgorithm " + combo.getText();
				MazeGameWindow.this.setChanged();
				MazeGameWindow.this.notifyObservers();	
				
					
				/*userAction = "SolveDomain";
				SkiGameWindow.this.setChanged();
				SkiGameWindow.this.notifyObservers();*/
				
				/*String selectedGame = combo.getText();
				 if (selectedGame.equals("BFS"||"A-Star")) {*/
				/*BasicWindow s1 = new SkiGameWindow(presenter, display, 10, 10,"Ski Game");
				s1.run;*/
				//UIView window = new SkiGameWindow(presenter, display, 400, 300, "Ski Game");	
				//Display display = new Display();
				MazeGameWindow1 m = new MazeGameWindow1(presenter,null,400,400,"Maze Game",combo.getText());
				m.run();
				
				
				
			}
			
		
			public void widgetDefaultSelected(SelectionEvent arg0) {
								
			}
		});
	}
	
	
/*	public void createMazeGame(SearchDomain searchDomain){ 
		MazeGameWindow1 m = new MazeGameWindow1(presenter,null,400,400,"Maze Game",searchDomain);
		m.run();
	}*/

	
	public void start() {		
		run();
	}

	
	public void displayCurrentState() {
		// TODO Auto-generated method stub
		
	}

	public void displaySolution(Solution solution) {
		for (final Action a : solution.getActions()) {
			
			this.shell.getDisplay().syncExec(new Runnable() {
				
				
				public void run() {					
					lstActions.add(a.toString());
				}
			});						
		}		
	}

	
	public String getUserAction() {		
		return userAction;
	}


	@Override
	public void displayCurrentState(SearchDomain searchDomain) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateBoard(int[][] gameBoard) {
		// TODO Auto-generated method stub
		
	}




}
