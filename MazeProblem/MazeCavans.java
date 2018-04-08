package MazeProblem_v3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class MazeCavans extends JPanel implements Runnable, Observer {

	private static final long serialVersionUID = 1L;

	private ArrayList<Particle> particles = null;
	private ArrayList<Color> particleColors = null;

	public static ArrayList<Integer> finalPath_x;
	public static ArrayList<Integer> finalPath_y;

	private MazeFull maze;

	public static int ruleNum = 0;
	public static boolean chooseAll = true;
	public static boolean stop = false;
	public static boolean firstShow = true;

	public MazeCavans() {
		maze = new MazeFull(17, 16, 0, 0, 16, 15);
		particleColors = new ArrayList<>();	
		initialColors();
		repaint();
	}

	private void initialColors() {
		for (int i = 0; i < 30; i++) {

			Color color = new Color(255 - i * 8, 0, 0);
			particleColors.add(color);

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {

		particles = (ArrayList<Particle>) arg;
		if (!stop) {

			repaint();
		}

	}

	@Override
	public void run() {
		finalPath_x = new ArrayList<>();
		finalPath_y = new ArrayList<>();
		if (!ParticleProcess.findExit) {
			repaint();
		}

	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		int cellSize = 25; // the length of every cell
		int cellSize1 = 25; // the width between two cell

		// draw maze
		for (int i = 0; i < maze.getMazeColNum(); i++) {
			for (int j = 0; j < maze.getMazeRowNum(); j++) {

				if (maze.getMaze().get(i).getRow().get(j).getState() == 1) {
					Color color = new Color(0, 0, 0);
					paintCell(g2d, j * cellSize1, i * cellSize1, cellSize, color);
				} else {
					Color color = new Color(255, 255, 255);
					paintCell(g2d, j * cellSize1, i * cellSize1, cellSize, color);
				}

			}

		}
		if (!firstShow) {
			if(!ParticleProcess.showFinal){
				if (!chooseAll) {
					int x = particles.get(ruleNum).getCurrent_x();
					int y = particles.get(ruleNum).getCurrent_y();
					// Color color = new Color(255, 0, 0);
					// paintParticles(g2d, x, y, cellSize1, color);
					paintCell(g2d, x * cellSize1, y * cellSize1, cellSize1, particleColors.get(ruleNum));
				} else {
					if (!particles.isEmpty()) {
						for (int i = 0; i < particles.size(); i++) {
							int x = particles.get(i).getCurrent_x();
							int y = particles.get(i).getCurrent_y();

							paintParticles(g2d, x, y, cellSize1, particleColors.get(i));
						}
					}

				}
			}else{
				for(int k=0;k<finalPath_x.size();k++){
					int x = finalPath_x.get(k);
					int y = finalPath_y.get(k);
					Color color = new Color(0, 255, 0);
					paintCell(g2d, x * cellSize1, y * cellSize1, cellSize1, color);
				}
			}
			
		}

		// draw all particles

	}

	private void paintCell(Graphics2D g2d, int x, int y, int cellSize, Color blue) {
		g2d.setColor(blue);
		g2d.fillRect(x, y, cellSize, cellSize);

	}

	private void paintParticles(Graphics2D g2d, int x, int y, int cellSize, Color blue) {
		int x1 = 0;
		int y1 = 0;
		if (x == 0) {
			x1 = (int) (Math.random() * 19);
		}
		if (x > 0) {
			x1 = x * cellSize + (int) (Math.random() * 19);
		}

		if (y == 0) {
			y1 = (int) (Math.random() * 19);
		}

		if (y > 0) {
			y1 = y * cellSize + (int) (Math.random() * 19);
		}

		g2d.setColor(blue);
		g2d.fillOval(x1, y1, 5, 5);
	}

}
