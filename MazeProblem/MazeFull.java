package MazeProblem_v3;

import java.util.ArrayList;

public class MazeFull {

	private ArrayList<MazeRow> maze;
	private int mazeRowNum; // M*N rowNum = M
	private int mazeColNum; // M*N colNum = N

	private int start_x; // start point x
	private int start_y; // start point y
	private int end_x; // end point x
	private int end_y; // end point y

	// set M N start point and end point
	public MazeFull(int rowNum, int colNum, int start_x, int start_y, int end_x, int end_y) {
		this.mazeRowNum = rowNum;
		this.mazeColNum = colNum;
		maze = new ArrayList<>();
		initialMaze();
		setBlock();
		setStartEnd(start_x, start_y, end_x, end_y);
	}

	public void initialMaze() {
		for (int i = 0; i < mazeColNum; i++) {
			MazeRow mazeRow = new MazeRow(mazeRowNum);
			for (int j = 0; j < mazeRowNum; j++) {
				mazeRow.getRow().get(j).setMazeX(i);
				mazeRow.getRow().get(j).setMazeY(j);
			}
			maze.add(mazeRow);
		}
	}

	// set block which maze cell cannot go !!!need change here, this is just
	// test
	public void setBlock() {
		//set first line
		maze.get(0).getRow().get(1).setState(1);
		maze.get(0).getRow().get(3).setState(1);
		maze.get(0).getRow().get(11).setState(1);
		maze.get(0).getRow().get(13).setState(1);
		
		//set second line
		maze.get(1).getRow().get(1).setState(1);
		maze.get(1).getRow().get(3).setState(1);
		maze.get(1).getRow().get(5).setState(1);
		maze.get(1).getRow().get(7).setState(1);
		maze.get(1).getRow().get(8).setState(1);
		maze.get(1).getRow().get(9).setState(1);
		maze.get(1).getRow().get(11).setState(1);
		maze.get(1).getRow().get(13).setState(1);
		maze.get(1).getRow().get(15).setState(1);
		maze.get(1).getRow().get(16).setState(1);
		
		//set third line
		maze.get(2).getRow().get(1).setState(1);
		maze.get(2).getRow().get(5).setState(1);
		maze.get(2).getRow().get(7).setState(1);
		maze.get(2).getRow().get(9).setState(1);
		
		//set fourth line
		maze.get(3).getRow().get(1).setState(1);
		maze.get(3).getRow().get(3).setState(1);
		maze.get(3).getRow().get(5).setState(1);
		maze.get(3).getRow().get(7).setState(1);
		maze.get(3).getRow().get(9).setState(1);
		maze.get(3).getRow().get(10).setState(1);
		maze.get(3).getRow().get(11).setState(1);
		maze.get(3).getRow().get(12).setState(1);
		maze.get(3).getRow().get(13).setState(1);
		maze.get(3).getRow().get(14).setState(1);
		maze.get(3).getRow().get(15).setState(1);
		
		//set fifth line
		maze.get(4).getRow().get(1).setState(1);
		maze.get(4).getRow().get(3).setState(1);
		maze.get(4).getRow().get(5).setState(1);
		maze.get(4).getRow().get(7).setState(1);
		maze.get(4).getRow().get(9).setState(1);
		maze.get(4).getRow().get(11).setState(1);
		
		//set sixth line
		maze.get(5).getRow().get(1).setState(1);
		maze.get(5).getRow().get(2).setState(1);
		maze.get(5).getRow().get(3).setState(1);
		maze.get(5).getRow().get(5).setState(1);
		maze.get(5).getRow().get(7).setState(1);
		maze.get(5).getRow().get(9).setState(1);
		maze.get(5).getRow().get(13).setState(1);
		maze.get(5).getRow().get(14).setState(1);
		maze.get(5).getRow().get(15).setState(1);
		
		//set seventh line
		maze.get(6).getRow().get(5).setState(1);
		maze.get(6).getRow().get(7).setState(1);
		maze.get(6).getRow().get(9).setState(1);
		maze.get(6).getRow().get(11).setState(1);
		maze.get(6).getRow().get(15).setState(1);
		
		//set eighth line
		maze.get(7).getRow().get(0).setState(1);
		maze.get(7).getRow().get(1).setState(1);
		maze.get(7).getRow().get(3).setState(1);
		maze.get(7).getRow().get(4).setState(1);
		maze.get(7).getRow().get(5).setState(1);
		maze.get(7).getRow().get(7).setState(1);
		maze.get(7).getRow().get(9).setState(1);
		maze.get(7).getRow().get(11).setState(1);
		maze.get(7).getRow().get(12).setState(1);
		maze.get(7).getRow().get(13).setState(1);
		maze.get(7).getRow().get(14).setState(1);
		maze.get(7).getRow().get(15).setState(1);
		
		//set ninth line
		maze.get(8).getRow().get(3).setState(1);
		maze.get(8).getRow().get(5).setState(1);
		maze.get(8).getRow().get(7).setState(1);
		maze.get(8).getRow().get(13).setState(1);
		maze.get(8).getRow().get(15).setState(1);
		
		//set tenth line
		maze.get(9).getRow().get(0).setState(1);
		maze.get(9).getRow().get(2).setState(1);
		maze.get(9).getRow().get(3).setState(1);
		maze.get(9).getRow().get(5).setState(1);
		maze.get(9).getRow().get(6).setState(1);
		maze.get(9).getRow().get(7).setState(1);
		maze.get(9).getRow().get(8).setState(1);
		maze.get(9).getRow().get(9).setState(1);
		maze.get(9).getRow().get(10).setState(1);
		maze.get(9).getRow().get(11).setState(1);
		maze.get(9).getRow().get(12).setState(1);
		maze.get(9).getRow().get(13).setState(1);
		maze.get(9).getRow().get(15).setState(1);
		maze.get(9).getRow().get(16).setState(1);
		
		//set eleventh line
		maze.get(10).getRow().get(8).setState(1);
		
		//set 12th line
		maze.get(11).getRow().get(0).setState(1);
		maze.get(11).getRow().get(1).setState(1);
		maze.get(11).getRow().get(2).setState(1);
		maze.get(11).getRow().get(3).setState(1);
		maze.get(11).getRow().get(5).setState(1);
		maze.get(11).getRow().get(6).setState(1);
		maze.get(11).getRow().get(7).setState(1);
		maze.get(11).getRow().get(8).setState(1);
		maze.get(11).getRow().get(9).setState(1);
		maze.get(11).getRow().get(10).setState(1);
		maze.get(11).getRow().get(11).setState(1);
		maze.get(11).getRow().get(12).setState(1);
		maze.get(11).getRow().get(13).setState(1);
		maze.get(11).getRow().get(15).setState(1);
		maze.get(11).getRow().get(16).setState(1);
		
		//set 13th line
		maze.get(12).getRow().get(3).setState(1);
		maze.get(12).getRow().get(7).setState(1);
		
		//set 14th line
		maze.get(13).getRow().get(0).setState(1);
		maze.get(13).getRow().get(1).setState(1);
		maze.get(13).getRow().get(5).setState(1);
		maze.get(13).getRow().get(7).setState(1);
		maze.get(13).getRow().get(8).setState(1);
		maze.get(13).getRow().get(10).setState(1);
		maze.get(13).getRow().get(11).setState(1);
		maze.get(13).getRow().get(12).setState(1);
		maze.get(13).getRow().get(13).setState(1);
		maze.get(13).getRow().get(15).setState(1);
		
		//set 15th line
		maze.get(14).getRow().get(3).setState(1);
		maze.get(14).getRow().get(5).setState(1);
		maze.get(14).getRow().get(13).setState(1);
		maze.get(14).getRow().get(15).setState(1);
		
		//set 16th line
		maze.get(15).getRow().get(1).setState(1);
		maze.get(15).getRow().get(3).setState(1);
		maze.get(15).getRow().get(5).setState(1);
		maze.get(15).getRow().get(6).setState(1);
		maze.get(15).getRow().get(7).setState(1);
		maze.get(15).getRow().get(8).setState(1);
		maze.get(15).getRow().get(9).setState(1);
		maze.get(15).getRow().get(10).setState(1);
		maze.get(15).getRow().get(11).setState(1);
		maze.get(15).getRow().get(13).setState(1);
		maze.get(15).getRow().get(15).setState(1);
		
		
		
		
		



	}

	public void setStartEnd(int start_x, int start_y, int end_x, int end_y) {
		this.start_x = start_x;
		this.start_y = start_y;
		this.end_x = end_x;
		this.end_y = end_y;
		maze.get(start_x).getRow().get(start_y).setState(0);
		maze.get(end_y).getRow().get(end_x).setState(0);
	}

	public int getStartX() {
		return start_x;
	}

	public int getStartY() {
		return start_y;
	}

	public int getEndX() {
		return end_x;
	}

	public int getEndY() {
		return end_y;
	}

	public ArrayList<MazeRow> getMaze() {
		return maze;
	}

	public int getMazeRowNum() {
		return mazeRowNum;
	}

	public void setMazeRowNum(int mazeRowNum) {
		this.mazeRowNum = mazeRowNum;
	}

	public int getMazeColNum() {
		return mazeColNum;
	}

	public void setMazeColNum(int mazeColNum) {
		this.mazeColNum = mazeColNum;
	}

	public void printMaze() {
		for (int i = 0; i < maze.size(); i++) {
			for (int j = 0; j < maze.get(i).getRow().size(); j++) {
				System.out.print(maze.get(i).getRow().get(j).getState());
			}
			System.out.println("");
		}
	}

}
