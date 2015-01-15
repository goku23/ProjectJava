package view;


import model.Solution;
import model.algorithm.SearchDomain;

public interface View {
	void start();
	void displayCurrentState(SearchDomain searchDomain);
	void displaySolution(Solution solution); 
	String getUserAction();
	void updateBoard(int[][] gameBoard);
}
