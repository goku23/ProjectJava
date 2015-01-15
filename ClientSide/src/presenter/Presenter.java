package presenter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import presenter.UserCommands.Command;
import view.MyConsoleView;
import view.SelectGameWindow;
import view.View;


import model.Model;
import model.MyModel;
import model.Solution;

public class Presenter implements Observer{
	
	private Model model; // the current model
	private View view;
	private UserCommands commands;
	private ArrayList<Model> models;// all running models
	int[][] gameBoard;

	public Presenter(Model model, View view)
	{
		gameBoard =new int[10][10];
		this.model = model;
		this.view = view;
		commands = new UserCommands();
		models = new ArrayList<Model>();
		models.add(model);
	}
	
	public Presenter(Model model) {
		gameBoard =new int[10][10];
		this.model = model;
		this.view = null;
		commands = new UserCommands();
		models = new ArrayList<Model>();
		models.add(model);
	}

	public void setView(View view) {
		this.view = view;
	}
	
	public void updateGames() {
		for (int i=0;i<10;i++)
			for (int j=0;j<10;j++)
				if (model.getDomain().getMap()[i][j]==null)
					 gameBoard[i][j]=0;
				else
					 gameBoard[i][j]=(int)model.getDomain().getMap()[i][j].getCost();
	}
	
	public void update(Observable observable, Object arg1) {
		
	
		if(observable instanceof Model)
		{
			if ((int)arg1==1){
				Solution solution = ((Model)observable).getSolution();
				view.displaySolution(solution);
			}
			else
				updateGames();
				view.updateBoard(gameBoard);
				//view.displayCurrentState(((Model) observable).getDomain());
		}
		
		else if (observable == view)
		{
			String action = view.getUserAction();
			String[] arr = action.split(" ");
			String commandName = arr[0];
			String args = null;
			if (arr.length > 1)
				args = arr[1]; 
			
			Command command = commands.selectCommand(commandName);
			Model m = command.doCommand(model, args);
			
			// Check if we got a new model from the command
			if (m != model) {
				this.model = m;
				models.add(m);
				m.addObserver(this);
			}
			
		}
	}

	public static void main(String[] args) {
		MyModel model = new MyModel();
		//MyConsoleView view = new MyConsoleView();
		//Presenter presenter = new Presenter(model, view);
		Presenter presenter = new Presenter(model);
		SelectGameWindow view = new SelectGameWindow(presenter, 700, 550, "Select game");
		
		model.addObserver(presenter);
		//view.addObserver(presenter);
		
		//view.start();
		view.run();
	}
	
}
