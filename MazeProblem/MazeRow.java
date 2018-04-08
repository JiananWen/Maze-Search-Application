package MazeProblem_v3;

import java.util.ArrayList;


public class MazeRow {
	
	private ArrayList<MazeCell> mazeRow;
	
	public MazeRow(int i){
		mazeRow = new ArrayList<>();
		initialRow(i);
	}
	
	public void initialRow(int length){
		for(int i=0;i<length;i++){
			MazeCell aCell = new MazeCell();
			mazeRow.add(aCell);
		}
		
	}
	
	public ArrayList<MazeCell> getRow(){
		return mazeRow;
	}
	

}
