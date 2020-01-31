import java.awt.*;
import javax.swing.*;

import com.mgnt.utils.TimeUtils;

import java.awt.event.*;
import java.io.*;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class Symon extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1481133367803293109L;
	private JButton red,blue,yellow,green,start;
	private JLabel s,hs;
	private int score;
	private int highScore;
	private static Font font = new Font("Ariel", Font.BOLD, 25);
	private ClicksList clicks;
	public boolean mouseClicked = false;
	public MouseEvent ae;
	private volatile boolean waiting;
	private ListIterator<Integer> it;
	public Symon() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("highscore.txt"));
			highScore = Integer.parseInt(br.readLine());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clicks = new ClicksList();
		setLayout(null);
		red = new JButton();
		red.setSize(150, 150);
		red.setLocation(360, 75);
		red.setOpaque(true);
		red.setBackground(Color.RED);
		red.setBorderPainted(false);
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(waiting) {
					if(it.next() == 2) {
						red.setBackground(Color.LIGHT_GRAY);
						red.update(red.getGraphics());
						TimeUtils.sleepFor(1, TimeUnit.SECONDS);
						red.setBackground(Color.RED);
						red.update(red.getGraphics());
						TimeUtils.sleepFor(500, TimeUnit.MILLISECONDS);
						if(!it.hasNext()) {
							score++;
							s.setText("Score: " + score);
							s.update(s.getGraphics());
							s.repaint();
							start();
						}
					} else {
						lose();
					}
				}
			}
		});
		blue = new JButton();
		blue.setSize(150, 150);
		blue.setLocation(360, 360);
		blue.setBackground(Color.BLUE);
		blue.setOpaque(true);
		blue.setBorderPainted(false);
		blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(waiting) {
					if(it.next() == 4) {
						blue.setBackground(Color.LIGHT_GRAY);
						blue.update(blue.getGraphics());
						TimeUtils.sleepFor(1, TimeUnit.SECONDS);
						blue.setBackground(Color.BLUE);
						blue.update(blue.getGraphics());
						TimeUtils.sleepFor(500, TimeUnit.MILLISECONDS);
						if(!it.hasNext()) {
							score++;
							s.setText("Score: " + score);
							s.update(s.getGraphics());
							s.repaint();
							start();
						}
					} else {
						lose();
					}
				}
			}
		});
		yellow = new JButton();
		yellow.setSize(150, 150);
		yellow.setLocation(75, 75);
		yellow.setBackground(Color.YELLOW);
		yellow.setOpaque(true);
		yellow.setBorderPainted(false);
		yellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(waiting) {
					if(it.next() == 1) {
						yellow.setBackground(Color.LIGHT_GRAY);
						yellow.update(yellow.getGraphics());
						TimeUtils.sleepFor(1, TimeUnit.SECONDS);
						yellow.setBackground(Color.YELLOW);
				        yellow.update(yellow.getGraphics());
						TimeUtils.sleepFor(500, TimeUnit.MILLISECONDS);
						if(!it.hasNext()) {
							score++;
							s.setText("Score: " + score);
							s.update(s.getGraphics());
							s.repaint();
							start();
						}
					} else {
						lose();
					}
				}
			}
		});
		green = new JButton();
		green.setSize(150, 150);
		green.setLocation(75, 360);
		green.setBackground(Color.GREEN);
		green.setOpaque(true);
		green.setBorderPainted(false);
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(waiting) {
					if(it.next() == 3) {
						green.setBackground(Color.LIGHT_GRAY);
						green.update(green.getGraphics());
						TimeUtils.sleepFor(1, TimeUnit.SECONDS);
						green.setBackground(Color.GREEN);
						green.update(green.getGraphics());
						TimeUtils.sleepFor(500, TimeUnit.MILLISECONDS);
						if(!it.hasNext()) {
							score++;
							s.setText("Score: " + score);
							s.update(s.getGraphics());
							s.repaint();
							start();
						}
					} else {
						lose();
					}
				}
			}
		});
		start = new JButton("Start");
		start.setFont(new Font("Ariel",Font.PLAIN,25));
		start.setSize(125, 125);
		start.setLocation(230, 230);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				startGame();
			}
		});
		s = new JLabel("Score: " + score);
		s.setFont(font);
		s.setBounds(25, 1, 200, 35);
		hs = new JLabel("High score: " + highScore);
		hs.setFont(font);
		hs.setBounds(25, 30, 200, 35);
		waiting = false;
		add(red);
		add(blue);
		add(yellow);
		add(green);
		add(start);
		add(s);
		add(hs);
	}
	private void startGame() {
		remove(start);
		update(getGraphics());
		start();
	}
	private void start() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				waiting = false;
				clicks.addColor();
				it = clicks.iterator();
				while(it.hasNext()) {
					int i = it.next();
					switch(i) {
						case 1:
							yellow.setBackground(Color.GRAY);
							yellow.update(yellow.getGraphics());
							TimeUtils.sleepFor(1, TimeUnit.SECONDS);
							yellow.setBackground(Color.YELLOW);
					        yellow.update(yellow.getGraphics());
							TimeUtils.sleepFor(500, TimeUnit.MILLISECONDS);
							break;
						case 2:
							red.setBackground(Color.GRAY);
							red.update(red.getGraphics());
							TimeUtils.sleepFor(1, TimeUnit.SECONDS);
							red.setBackground(Color.RED);
							red.update(red.getGraphics());
							TimeUtils.sleepFor(500, TimeUnit.MILLISECONDS);
							break;
						case 3:
							green.setBackground(Color.GRAY);
							green.update(green.getGraphics());
							TimeUtils.sleepFor(1, TimeUnit.SECONDS);
							green.setBackground(Color.GREEN);
							green.update(green.getGraphics());
							TimeUtils.sleepFor(500, TimeUnit.MILLISECONDS);
							break;
						case 4:
							blue.setBackground(Color.GRAY);
							blue.update(blue.getGraphics());
							TimeUtils.sleepFor(1, TimeUnit.SECONDS);
							blue.setBackground(Color.BLUE);
							blue.update(blue.getGraphics());
							TimeUtils.sleepFor(500, TimeUnit.MILLISECONDS);
							break;
					}
				}
				it = clicks.iterator();
				waiting = true;
			}
		}).start();
		
	}
	public void lose() {
		if (score > highScore) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("highscore.txt"));
				bw.write("" + score);
				bw.close();
				highScore = score;
				hs.setText("High score: " + highScore);
				hs.update(hs.getGraphics());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		String[] options = { "Restart", "Close"};
		int answer = JOptionPane.showOptionDialog(this, "game over. your score is " + score, "simon",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (answer == 0) {
			restart();
		} else {
			System.exit(0);
		}
	}
	public void restart() {
		clicks = new ClicksList();
		score = 0;
		s.setText("Score: " + score);
		s.update(s.getGraphics());
		start();
	}
}