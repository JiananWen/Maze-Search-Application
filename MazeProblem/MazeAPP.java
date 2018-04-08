package MazeProblem_v3;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MazeAPP implements ActionListener {

	private Logger log = Logger.getLogger(MazeAPP.class.getName());
	private JFrame frame = null;
	private JPanel mainPanel = null;

	private JButton startBtn = null;
	private JButton stopBtn = null;
	private JComboBox<String> ruleBox = null;
	private JLabel numInform = null;

	private String[] rule = { "all", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
			"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29" };

	public static MazeCavans canvas = null;

	private Thread canvansThread;

	public MazeAPP() {
		log.info("App started");
		initGUI();

	}

	private void initGUI() {
		frame = new JFrame();

		frame.setSize(425, 460);
		frame.setTitle("Maze");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		frame.setLayout(new BorderLayout());
		frame.add(getMainPanel(), BorderLayout.NORTH);

		canvas = new MazeCavans();

		frame.add(canvas, BorderLayout.CENTER);

		frame.setVisible(true);
	}

	public JPanel getMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());

		startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log.info("Start buttom was pressed - anonymous inner");
				MazeCavans.stop = false;
				ParticleProcess.findExit = false;
				MazeCavans.firstShow = false;
				ParticleProcess.showFinal = false;
				canvansThread = new Thread(canvas);

				ParticleProcess particleProcess = new ParticleProcess();
				particleProcess.runTimers(100);

				canvansThread.start();
			}
		});

		stopBtn = new JButton("Stop");
		stopBtn.addActionListener(this);

		// set particle choose
		ruleBox = new JComboBox<String>(rule);
		ruleBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (ruleBox.getSelectedItem() == "all") {
					MazeCavans.chooseAll = true;
					log.info("all was choosed");

				}
				if (ruleBox.getSelectedItem() == "0") {
					MazeCavans.ruleNum = 0;
					MazeCavans.chooseAll = false;
					log.info("particle0 was choosed");
				}

				if (ruleBox.getSelectedItem() == "1") {
					MazeCavans.ruleNum = 1;
					MazeCavans.chooseAll = false;
					log.info("particle1 was choosed");
				}

				if (ruleBox.getSelectedItem() == "2") {
					MazeCavans.ruleNum = 2;
					MazeCavans.chooseAll = false;
					log.info("particle2 was choosed");
				}

				if (ruleBox.getSelectedItem() == "3") {
					MazeCavans.ruleNum = 3;
					MazeCavans.chooseAll = false;
					log.info("particle3 was choosed");
				}

				if (ruleBox.getSelectedItem() == "4") {
					MazeCavans.ruleNum = 4;
					MazeCavans.chooseAll = false;
					log.info("particle4 was choosed");
				}

				if (ruleBox.getSelectedItem() == "5") {
					MazeCavans.ruleNum = 5;
					MazeCavans.chooseAll = false;
					log.info("particle5 was choosed");
				}

				if (ruleBox.getSelectedItem() == "6") {
					MazeCavans.ruleNum = 6;
					MazeCavans.chooseAll = false;
					log.info("particle6 was choosed");
				}

				if (ruleBox.getSelectedItem() == "7") {
					MazeCavans.ruleNum = 7;
					MazeCavans.chooseAll = false;
					log.info("particle7 was choosed");
				}

				if (ruleBox.getSelectedItem() == "8") {
					MazeCavans.ruleNum = 8;
					MazeCavans.chooseAll = false;
					log.info("particle8 was choosed");
				}

				if (ruleBox.getSelectedItem() == "9") {
					MazeCavans.ruleNum = 9;
					MazeCavans.chooseAll = false;
					log.info("particle9 was choosed");
				}

				if (ruleBox.getSelectedItem() == "10") {
					MazeCavans.ruleNum = 10;
					MazeCavans.chooseAll = false;
					log.info("particle10 was choosed");
				}

				if (ruleBox.getSelectedItem() == "11") {
					MazeCavans.ruleNum = 11;
					MazeCavans.chooseAll = false;
					log.info("particle11 was choosed");
				}

				if (ruleBox.getSelectedItem() == "12") {
					MazeCavans.ruleNum = 12;
					MazeCavans.chooseAll = false;
					log.info("particle12 was choosed");
				}

				if (ruleBox.getSelectedItem() == "13") {
					MazeCavans.ruleNum = 13;
					MazeCavans.chooseAll = false;
					log.info("particle13 was choosed");
				}

				if (ruleBox.getSelectedItem() == "14") {
					MazeCavans.ruleNum = 14;
					MazeCavans.chooseAll = false;
					log.info("particle14 was choosed");
				}

				if (ruleBox.getSelectedItem() == "15") {
					MazeCavans.ruleNum = 15;
					MazeCavans.chooseAll = false;
					log.info("particle15 was choosed");
				}

				if (ruleBox.getSelectedItem() == "16") {
					MazeCavans.ruleNum = 16;
					MazeCavans.chooseAll = false;
					log.info("particle16 was choosed");
				}

				if (ruleBox.getSelectedItem() == "17") {
					MazeCavans.ruleNum = 17;
					MazeCavans.chooseAll = false;
					log.info("particle17 was choosed");
				}

				if (ruleBox.getSelectedItem() == "18") {
					MazeCavans.ruleNum = 18;
					MazeCavans.chooseAll = false;
					log.info("particle18 was choosed");
				}

				if (ruleBox.getSelectedItem() == "19") {
					MazeCavans.ruleNum = 19;
					MazeCavans.chooseAll = false;
					log.info("particle19 was choosed");
				}

				if (ruleBox.getSelectedItem() == "20") {
					MazeCavans.ruleNum = 20;
					MazeCavans.chooseAll = false;
					log.info("particle20 was choosed");
				}

				if (ruleBox.getSelectedItem() == "21") {
					MazeCavans.ruleNum = 21;
					MazeCavans.chooseAll = false;
					log.info("particle21 was choosed");
				}

				if (ruleBox.getSelectedItem() == "22") {
					MazeCavans.ruleNum = 22;
					MazeCavans.chooseAll = false;
					log.info("particle22 was choosed");
				}

				if (ruleBox.getSelectedItem() == "23") {
					MazeCavans.ruleNum = 23;
					MazeCavans.chooseAll = false;
					log.info("particle23 was choosed");
				}

				if (ruleBox.getSelectedItem() == "24") {
					MazeCavans.ruleNum = 24;
					MazeCavans.chooseAll = false;
					log.info("particle24 was choosed");
				}

				if (ruleBox.getSelectedItem() == "25") {
					MazeCavans.ruleNum = 25;
					MazeCavans.chooseAll = false;
					log.info("particle25 was choosed");
				}

				if (ruleBox.getSelectedItem() == "26") {
					MazeCavans.ruleNum = 26;
					MazeCavans.chooseAll = false;
					log.info("particle26 was choosed");
				}

				if (ruleBox.getSelectedItem() == "27") {
					MazeCavans.ruleNum = 27;
					MazeCavans.chooseAll = false;
					log.info("particle27 was choosed");
				}

				if (ruleBox.getSelectedItem() == "28") {
					MazeCavans.ruleNum = 28;
					MazeCavans.chooseAll = false;
					log.info("particle28 was choosed");
				}

				if (ruleBox.getSelectedItem() == "29") {
					MazeCavans.ruleNum = 29;
					MazeCavans.chooseAll = false;
					log.info("particle29 was choosed");
				}

			}
		});

		numInform = new JLabel("Please choose a particle:");

		mainPanel.add(startBtn);
		mainPanel.add(stopBtn);
		mainPanel.add(numInform);
		mainPanel.add(ruleBox);

		return mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == stopBtn) {
			System.out.println("Stop was pressed");
			MazeCavans.stop = true;
			ParticleProcess.findExit = true;
		}

	}

	public static void main(String[] args) {
		MazeAPP mazeAPP = new MazeAPP();
		System.out.println(mazeAPP + "is running");
	}

}
