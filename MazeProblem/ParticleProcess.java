package MazeProblem_v3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ParticleProcess extends Observable {

	private MazeFull maze;

	private double c1;
	private double c2;
	private double w = 0.799;

	private int gBest_x;
	private int gBest_y;

	private int start_x;
	private int start_y;
	private int end_x;
	private int end_y;

	public static boolean findExit = false;
	public static boolean showFinal = false;

	private int particleSize = 30;

	private ArrayList<Particle> particles; // store all particles

	private ArrayList<Integer> finalPath_x; // store success
																// path from
																// start to end
	private ArrayList<Integer> finalPath_y;

	Random generator = new Random();

	private ArrayList<Timer> timers; // store each timer for
															// one particle

	public int globalIterator;

	public int eachIterator = 0;

	public ParticleProcess() {

		// construct maze
		maze = new MazeFull(17, 16, 0, 0, 16, 15);
		finalPath_x = new ArrayList<>();
		 finalPath_y = new ArrayList<>();
		 timers = new ArrayList<>();

		// store maze information and gbest which equals to start point
		start_x = maze.getStartX();
		start_y = maze.getStartY();
		end_x = maze.getEndX();
		end_y = maze.getEndY();
		gBest_x = start_x;
		gBest_y = start_y;

		c1 = (double) 1 / maze.getMazeRowNum();
		c2 = (double) 1 / maze.getMazeColNum();


		// construct particles
		initialParticles();

		// construct timers
		initialTimers();

		this.addObserver(MazeAPP.canvas);

	}

	public void runTimers(int time) {

		for (int i = 0; i < particleSize; i++) {
			timers.get(i).schedule(new timerTask(particles.get(i), i), 0, time);
		}

	}

	class timerTask extends TimerTask {

		Particle particle;
		int num;

		int iterator = 0;

		public timerTask(Particle particle, int num) {
			this.particle = particle;
			this.num = num;
		}

		public Timer getTimer(int count) {
			return timers.get(count);
		}

		@Override
		public void run() {
			if (!findExit) {
				processParticles(particle);
				iterator++;

//				System.out.println(
//						"eachIterator: " + eachIterator + "    " + particle.getName() + " selfite:" + iterator);

				setChanged();
				notifyObservers(particles);
				eachIterator = 0;

				eachIterator++;

			} else {
				if (particle.isFinished() == true) {
					getTimer(num).cancel();
					printFinalPath(particle);
					showFinal = true;
					setChanged();
					notifyObservers(particles);

					globalIterator = iterator;
				} else {
					getTimer(num).cancel();
					System.out.println(particle.getName() + " is exited");
				}

			}
		}
	}

	public void initialTimers() {
		Timer timer0 = new Timer();
		Timer timer1 = new Timer();
		Timer timer2 = new Timer();
		Timer timer3 = new Timer();
		Timer timer4 = new Timer();
		Timer timer5 = new Timer();
		Timer timer6 = new Timer();
		Timer timer7 = new Timer();
		Timer timer8 = new Timer();
		Timer timer9 = new Timer();
		Timer timer10 = new Timer();
		Timer timer11 = new Timer();
		Timer timer12 = new Timer();
		Timer timer13 = new Timer();
		Timer timer14 = new Timer();
		Timer timer15 = new Timer();
		Timer timer16 = new Timer();
		Timer timer17 = new Timer();
		Timer timer18 = new Timer();
		Timer timer19 = new Timer();
		Timer timer20 = new Timer();
		Timer timer21 = new Timer();
		Timer timer22 = new Timer();
		Timer timer23 = new Timer();
		Timer timer24 = new Timer();
		Timer timer25 = new Timer();
		Timer timer26 = new Timer();
		Timer timer27 = new Timer();
		Timer timer28 = new Timer();
		Timer timer29 = new Timer();

		timers.add(timer0);
		timers.add(timer1);
		timers.add(timer2);
		timers.add(timer3);
		timers.add(timer4);
		timers.add(timer5);
		timers.add(timer6);
		timers.add(timer7);
		timers.add(timer8);
		timers.add(timer9);
		timers.add(timer10);
		timers.add(timer11);
		timers.add(timer12);
		timers.add(timer13);
		timers.add(timer14);
		timers.add(timer15);
		timers.add(timer16);
		timers.add(timer17);
		timers.add(timer18);
		timers.add(timer19);
		timers.add(timer20);
		timers.add(timer21);
		timers.add(timer22);
		timers.add(timer23);
		timers.add(timer24);
		timers.add(timer25);
		timers.add(timer26);
		timers.add(timer27);
		timers.add(timer28);
		timers.add(timer29);

	}

	public void initialParticles() {
		particles = new ArrayList<>();

		// create 30 particles, they all sit on (0,0), velocity x, y are random
		// from -1,0,1
		for (int i = 0; i < particleSize; i++) {
			Particle particle = new Particle();
			particle.setLocation_x(start_x);
			particle.setLocation_y(start_y);
			particle.setVelocity_x(0);
			particle.setVelocity_y(generator.nextInt(2));
			particle.setFitness(calFitness(start_x, start_y));
			particle.setpBest_x(start_x);
			particle.setpBext_y(start_y);
			particles.add(particle);
			particle.setName(i);
			particle.setFinished(false);
		}

	}

	// calculate fitness score of particle
	public double calFitness(int location_x, int location_y) {

		double fitness = (double) 1 / (Math.abs(end_x - location_x) + Math.abs(end_y - location_y) + 1);
		return fitness;
	}

	// ----calculate gbest
	public void calGBext_x() {

		double fitness = particles.get(0).getFitness();

		for (int i = 0; i < particleSize; i++) {
			if (particles.get(i).getFitness() > fitness) {
				fitness = particles.get(i).getFitness();
				gBest_x = i;
			}
		}

	}

	public void calGBext_y() {

		double fitness = particles.get(0).getFitness();

		for (int i = 0; i < particleSize; i++) {
			if (particles.get(i).getFitness() > fitness) {
				fitness = particles.get(i).getFitness();
				gBest_y = i;
			}
		}

	}
	// ------- calculate gbest end

	// ------ update velocity and position

	// transfer 0~2.9 to -1,0,1
	public double transferVelocity(double i) {

		if (i < 1) {
			i = -1;
		}

		if (i >= 1 && i < 2) {
			i = 0;
		}

		if (i >= 2) {
			i = 1;
		}

		return i;
	}

	// transfer -1~1 to -1,0,1
	public int transferV(double i) {
		int j = 0;
		if (i < 0) {
			j = -1;
		}
		if (i == 0) {
			j = 0;
		}
		if (i > 0) {
			j = 1;
		}
		return j;
	}

	// calculate next velocity and position
	public void updateVelocityAndPosition(Particle particle) {

		boolean xOk = true;
		boolean yOK = true;

		int particleCurrentX = particle.getCurrent_x();
		int particleCurrentY = particle.getCurrent_y();

		// update velocity of particle
		double velocity_x_double = w * particle.getVelocity_x()
				+ c1 * (particle.getpBest_x() - particleCurrentX) * Math.random()
				+ c1 * (gBest_x - particleCurrentX) * Math.random()
				+ transferVelocity(Math.random() * 3) * Math.random();

		int velocity_x = transferV(velocity_x_double);

		double velocity_y_double = w * particle.getVelocity_y()
				+ c2 * (particle.getpBext_y() - particleCurrentY) * Math.random()
				+ c2 * (gBest_y - particleCurrentY) * Math.random()
				+ transferVelocity(Math.random() * 3) * Math.random();

		int velocity_y = transferV(velocity_y_double);

		// predict location if next velocity blocks, then the velocity is 0 or
		// exceed the maze
		int predictLocation_x = particleCurrentX + velocity_x;
		if (predictLocation_x < 0) {
			predictLocation_x = 0;
			velocity_x = 0;
		}
		if (predictLocation_x > maze.getMazeRowNum() - 1) {
			predictLocation_x = maze.getMazeRowNum() - 1;
			velocity_x = 0;
		}
		// test x position
		if (maze.getMaze().get(particleCurrentY).getRow().get(predictLocation_x).getState() == 1) {
			velocity_x = 0;
			predictLocation_x = particleCurrentX + velocity_x;
			xOk = false;
		}

		int predictLocation_y = particleCurrentY + velocity_y;
		if (predictLocation_y < 0) {
			predictLocation_y = 0;
			velocity_y = 0;
		}
		if (predictLocation_y > maze.getMazeColNum() - 1) {
			predictLocation_y = maze.getMazeColNum() - 1;
			velocity_y = 0;
		}
		// test y position
		if (maze.getMaze().get(predictLocation_y).getRow().get(particleCurrentX).getState() == 1) {
			velocity_y = 0;
			predictLocation_y = particleCurrentY + velocity_y;
			yOK = false;
		}

		// test the final position
		if (maze.getMaze().get(predictLocation_y).getRow().get(predictLocation_x).getState() == 1) {
			if (!xOk) {
				velocity_x = 0;
				predictLocation_x = particleCurrentX + velocity_x;
			}

			if (!yOK) {
				velocity_y = 0;
				predictLocation_y = particleCurrentY + velocity_y;
			}

			if (xOk && yOK) {
				double ran = Math.random();
				if (ran >= 0.5) {
					velocity_x = 0;
					predictLocation_x = particleCurrentX + velocity_x;
				} else {
					velocity_y = 0;
					predictLocation_y = particleCurrentY + velocity_y;
				}
			}
		}

		particle.setVelocity_x(velocity_x);
		particle.setVelocity_y(velocity_y);

		particle.setLocation_x(predictLocation_x);
		particle.setLocation_y(predictLocation_y);

	}

	// ---------- update end

	// --------- update pbest
	public void updatePBest(Particle particle) {
		if (calFitness(particle.getCurrent_x(), particle.getCurrent_y()) > particle.getFitness()) {
			particle.setpBest_x(particle.getCurrent_x());
			particle.setpBext_y(particle.getCurrent_y());
			particle.setFitness(calFitness(particle.getCurrent_x(), particle.getCurrent_y()));
		}
	}
	// ---------- update end

	// update particle
	public void updateParticle(Particle particle) {
		updateVelocityAndPosition(particle);
		updatePBest(particle);
	}

	// process pso
	public void processParticles(Particle particle) {

		updateParticle(particle);

		// test find the exit
		if (particle.getFitness() == 1) {
			findExit = true;
			particle.setFinished(true);
		}

		eachIterator++;
		// printParticles(particle, particle.getName());

		calGBext_x();
		calGBext_y();

	}

	public void printRoute(Particle particle) {
		ArrayList<Integer> success_x = particle.getLocation_x();
		ArrayList<Integer> succexx_y = particle.getLocation_y();
		for (int j = 0; j < success_x.size(); j++) {
			System.out.println("route: " + "<" + success_x.get(j) + " ," + succexx_y.get(j) + ">");
		}
	}

	public void printParticles(Particle particle, int name) {

		System.out.print("particles[" + name + "]: " + particle.getCurrent_x() + " " + particle.getCurrent_y() + " ");
		System.out.print("velocity_x: " + particle.getVelocity_x() + " velocity_y: " + particle.getVelocity_y()
				+ " pbest_x: " + particle.getpBest_x() + " pbest_y: " + particle.getpBext_y() + " fitness: "
				+ particle.getFitness() + "\n");

		System.out.println("\n\n");
	}

	// print the successful path from start to end
	public void printFinalPath(Particle particle) {
		ArrayList<Integer> success_x = particle.getLocation_x();
		ArrayList<Integer> succexx_y = particle.getLocation_y();

		// delete no value method
		for (int i = 0; i < success_x.size(); i++) {
			int same = i;

			for (int j = i + 1; j < success_x.size(); j++) {
				if (success_x.get(j) == success_x.get(i) && succexx_y.get(j) == succexx_y.get(i)) {
					same = j;
				}
			}

			MazeCavans.finalPath_x.add(success_x.get(same));
			MazeCavans.finalPath_y.add(succexx_y.get(same));
			
			finalPath_x.add(success_x.get(same));
			finalPath_y.add(succexx_y.get(same));
			i = same;

		}

		// console output final path
		for (int i = 0; i < finalPath_x.size(); i++) {
			System.out.println("Final Path: " + finalPath_x.get(i) + " " + finalPath_y.get(i));
		}

	}

	public ArrayList<Particle> getParticles() {
		return particles;
	}

	public ArrayList<Integer> getFinalPath_x() {
		return finalPath_x;
	}

	public ArrayList<Integer> getFinalPath_y() {
		return finalPath_y;
	}

	// public static void main(String[] args) {
	// ParticleProcess particleProcess = new ParticleProcess();
	// particleProcess.runTimers(1000);
	//
	// }

}
