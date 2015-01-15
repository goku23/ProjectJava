package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

import presenter.Presenter;

public class SelectGameWindow extends BasicWindow {
	
	//private Image image;

	public SelectGameWindow(Presenter presenter, int width, int height, String title) {
		super(presenter, width, height, title);		
		display.loadFont("resources/Resident_Evil_Large.ttf");
	}

	@Override
	void initWidgets() {
		shell.setLayout(new GridLayout(2, false));
		Font font1 = new Font(display, "Resident Evil",50 ,SWT.BOLD);
		
		 Label title = new Label(shell, SWT.CENTER);
		 title.setText("\nWelcome To My Project\nPlease Select A Game"); 
		 title.setFont(font1);
		 //place title in the window
		 GridData gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		 gridData.horizontalSpan=2;	
		 title.setLayoutData(gridData);
		///////
		//image button ski
		 Image imageSki = new Image(display,"resources/ski.jpg");
		 Button imageButton = new Button(shell, SWT.PUSH);
		 imageButton.setImage(imageSki);
		 imageButton.setSize(150,150);
		 imageButton.setLayoutData(new GridData(GridData.CENTER, GridData.CENTER, true, true));
		 imageButton.addSelectionListener(new SelectionListener() {
			
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					// Choose window according to the game (using a factory)
						MazeProperties window = new MazeProperties(presenter, display, 400, 300, "Maze Properties");
						window.run();
						shell.setVisible(false);
				}
			
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		 
		 /*Label titleSki = new Label(shell, SWT.CENTER);
		 titleSki.setText("SKI");
		 GridData gridDataSki = new GridData(GridData.CENTER, GridData.HORIZONTAL_ALIGN_CENTER, true, false);
		 gridDataSki.horizontalSpan=1;	
		 title.setLayoutData(gridDataSki);*/

			//image button maze
		 Image imageMaze = new Image(display,"resources/maze.jpg");
		 Button imageMazeBu = new Button(shell, SWT.PUSH);
		 imageMazeBu.setImage(imageMaze);
		 imageMazeBu.setSize(150,150);
		 imageMazeBu.setLayoutData(new GridData(GridData.CENTER, GridData.CENTER, true, true));
		 imageMazeBu.addSelectionListener(new SelectionListener() {
			
				@Override
				//opennig to window sp
				public void widgetSelected(SelectionEvent arg0) {
					// Choose window according to the game (using a factory)
						MazeProperties window = new MazeProperties(presenter, display, 400, 300, "Maze Properties");
						window.run();
						
				}
							
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		 
		 	Button exit = new Button(shell, SWT.PUSH);
		 	exit.setText("click here to exit");
		 	exit.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		 	 GridData gridData2 = new GridData(GridData.CENTER, GridData.CENTER, true, false);
			 gridData2.horizontalSpan=2;	
			 exit.setLayoutData(gridData2);
		 	 exit.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					shell.close();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			} );
		 
		 
		/////// 
		
		/*final Combo combo = new Combo(shell, SWT.READ_ONLY);	
		combo.setText("Please Select Game");
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		//combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
	    String items[] = { "Ski", "Maze" };
	    combo.setItems(items);
	    
	    Image image = new Image(display,"resources/eldar.jpg");
	    Rectangle rect = image.getBounds();
	    shell.setSize(rect.width, rect.height);
	     
	    
	    Button btnSelectModel = new Button(shell, SWT.PUSH);
	   // btnSelectModel.setText("Start");
	    btnSelectModel.setImage(new Image(display,"resources/start.jpg"));
	    btnSelectModel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
	    
	    Label label = new Label(shell, SWT.IMAGE_JPEG);
	    // lstActions = new List(shell, SWT.BORDER | SWTV_SCROLL);
	    Rectangle rect = label.getBounds();
		label.setText("BlaBla");
		label.setImage(new Image(display,"resources/eldar.jpg"));
		label.setSize(rect.width, rect.height);
	    
	    btnSelectModel.addSelectionListener(new SelectionListener() {
			
		
			public void widgetSelected(SelectionEvent arg0) {
				// Choose window according to the game (using a factory)
				String selectedGame = combo.getText();
				if (selectedGame.equals("Maze")) {
					UIView window = new SkiGameWindow(presenter, display, 400, 300, "Ski Game");
					window.run();
					MazeProperties window = new MazeProperties(presenter, display, 400, 300, "Maze Properties");
					window.run();
				}
				else { 
					UIView window = new MazeGameWindow(presenter, display, 400, 300, "Maze Game");
					window.run();
				}
				shell.setVisible(false);
				
			}
			
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}*/
	}
}
