package view;



import model.Solution;
import model.algorithm.SearchDomain;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import presenter.Presenter;

public class MazeProperties extends MazePropertiesView{
	
	private Presenter presenter;
	private String userAction;

	public MazeProperties(Presenter presenter, Display display, int width,
			int height, String title) {
		super(presenter, display, width, height, title);
		this.presenter = presenter;
		// TODO Auto-generated constructor stub
	}

	@Override
	void initWidgets() {
		
		shell.setLayout(new GridLayout(1, false));
		
		final Combo combo = new Combo(shell, SWT.READ_ONLY);	
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		//combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
	    String items[] = { "BFS", "A-Star" };
	    combo.setItems(items);
	    
	    Button btnSelectModel = new Button(shell, SWT.PUSH);
	    btnSelectModel.setText("Start");
	    btnSelectModel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
	    
	    

	    btnSelectModel.addSelectionListener(new SelectionListener() {
			
		
	    	public void widgetSelected(SelectionEvent arg0) {	
				userAction = "SelectDomain maze"; 
				MazeProperties.this.setChanged();
				MazeProperties.this.notifyObservers();	
				
				userAction = "SelectAlgorithm " + combo.getText();
				MazeProperties.this.setChanged();
				MazeProperties.this.notifyObservers();	
				
					
				/*userAction = "SolveDomain";
				SkiGameWindow.this.setChanged();
				SkiGameWindow.this.notifyObservers();*/
				
				/*String selectedGame = combo.getText();
				 if (selectedGame.equals("BFS"||"A-Star")) {*/
				/*BasicWindow s1 = new SkiGameWindow(presenter, display, 10, 10,"Ski Game");
				s1.run;*/
				//UIView window = new SkiGameWindow(presenter, display, 400, 300, "Ski Game");	
				//Display display = new Display();
				String algorithmName = combo.getText();
					MazeGameWindow1 m = new MazeGameWindow1(presenter,null,400,400,"Maze Game", algorithmName);
					m.run();
				
				
				
			}
			
		
			public void widgetDefaultSelected(SelectionEvent arg0) {
								
			}
		});
	}
}


	