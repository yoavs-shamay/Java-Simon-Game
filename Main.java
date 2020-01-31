import javax.swing.*;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public Main() {
		setTitle("Simon");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new Symon();
		add(panel);
		requestFocus();
		setVisible(true);
	}
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}
}
