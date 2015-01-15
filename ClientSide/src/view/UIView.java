package view;

import java.util.Observable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import presenter.Presenter;
import model.Solution;

public abstract class UIView extends Observable implements View, Runnable {
	protected Shell shell;
		
	public UIView(Presenter presenter, Display display, int width, int height,String title) {		
		shell=new Shell(display);
		shell.setSize(width, height);
		shell.setText(title);
		
		this.addObserver(presenter);
		presenter.setView(this);
	}
	
	abstract void initWidgets();
	
	
	public void run() {
	 	Menu menuBar = new Menu(shell, SWT.BAR);

	    // Create the File item's dropdown menu
	    Menu fileMenu = new Menu(menuBar);

	    // Create all the items in the bar menu
	    MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
	    fileItem.setText("File");
	    //fileItem.setText("About");
	    fileItem.setMenu(fileMenu);

	    // Create all the items in the File dropdown menu
	    MenuItem openItem = new MenuItem(fileMenu, SWT.NONE);
	    openItem.setText("Open");
	    openItem.addSelectionListener(new SelectionListener() {
			
			@Override
			//opennig to window sp
			public void widgetSelected(SelectionEvent arg2) {
				// Choose window according to the game (using a factory)
				FileDialog fd=new FileDialog(shell,SWT.OPEN);
				fd.setText("open");
				fd.setFilterPath("resources");
				String[] filterExt = { "*.xml", "*.*" };
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				shell.setVisible(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg2) {
				// TODO Auto-generated method stub
				
			}
		});
	    MenuItem saveAsItem = new MenuItem(fileMenu, SWT.NONE);
	    saveAsItem.setText("Save As..");

	    shell.setMenuBar(menuBar);
	
	/////
		
		
		initWidgets();
		shell.open();	
		
		// Display the main shell when this shell is closed
		shell.addDisposeListener(new DisposeListener() {
			
			
			public void widgetDisposed(DisposeEvent arg0) {
				// TODO Auto-generated method stub
				Shell mainShell = shell.getDisplay().getShells()[0];
				mainShell.setVisible(true);
			}
		});
		
		
	}
	
}
