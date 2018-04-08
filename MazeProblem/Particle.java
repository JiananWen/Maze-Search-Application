package MazeProblem_v3;

import java.util.ArrayList;

public class Particle {

	private double fitness; // store particle fitness value
	private ArrayList<Integer> location_x = new ArrayList<>(); // store particle
																// location for
																// x
	private ArrayList<Integer> location_y = new ArrayList<>(); // store particle
																// location for
																// y
	private int velocity_x; // particle velocity x
	private int velocity_y; // particle velocity y

	private int pBest_x; // store particle best x
	private int pBext_y; // store particle best y
	
	private int name;
	private boolean finished;

	public Particle() {

	}

	public Particle(double fitness, ArrayList<Integer> location_x, ArrayList<Integer> location_y, int velocity_x,
			int velocity_y, int name, boolean finished) {
		super();
		this.fitness = fitness;
		this.location_x = location_x;
		this.location_y = location_y;
		this.velocity_x = velocity_x;
		this.velocity_y = velocity_y;
		this.name = name;
		this.finished = finished;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public ArrayList<Integer> getLocation_x() {
		return location_x;
	}

	public int getCurrent_x() {
		return location_x.get(location_x.size() - 1);
	}

	public void setLocation_x(int location_x) {
		this.location_x.add(location_x);
	}

	public ArrayList<Integer> getLocation_y() {
		return location_y;
	}

	public int getCurrent_y() {
		return location_y.get(location_y.size() - 1);
	}

	public void setLocation_y(int location_y) {
		this.location_y.add(location_y);
	}

	public int getVelocity_x() {
		return velocity_x;
	}

	public void setVelocity_x(int velocity_x) {
		this.velocity_x = velocity_x;
	}

	public int getVelocity_y() {
		return velocity_y;
	}

	public void setVelocity_y(int velocity_y) {
		this.velocity_y = velocity_y;
	}

	public int getpBest_x() {
		return pBest_x;
	}

	public void setpBest_x(int pBest_x) {
		this.pBest_x = pBest_x;
	}

	public int getpBext_y() {
		return pBext_y;
	}

	public void setpBext_y(int pBext_y) {
		this.pBext_y = pBext_y;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	

}
