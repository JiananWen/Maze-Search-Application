package MazeProblem_v3;

public class MazeCell {

	private int state = 0;
	private int maze_x;
	private int maze_y;
	
	public MazeCell() {
	}

	public MazeCell(int state, int x, int y) {
		this.state = state;
		this.maze_x = x;
		this.maze_y = y;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public void setMazeX(int x){
		this.maze_x = x;
	}
	
	public int getMazeX(){
		return maze_x;
	}
	
	public void setMazeY(int y){
		this.maze_y = y;
	}

	public int getMazeY(){
		return maze_y;
	}
}
