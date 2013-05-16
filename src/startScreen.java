import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class startScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public startScreen() {
		Position position = new Position();
		
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCurrentDate = new JButton("current date");
		btnCurrentDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "BinaryDate");
			}
		});
		
		JButton btnAllDetailedClock = new JButton("all detailed clock");
		btnAllDetailedClock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "NotYet");
			}
		});
		add(btnAllDetailedClock);
		add(btnCurrentDate);
		
		JButton btnCurrentTime = new JButton("current time");
		btnCurrentTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "BinaryTime");
			}
		});
		add(btnCurrentTime);
		
		JButton btnCurrentDate_1 = new JButton("BinaryDateTime");
		btnCurrentDate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "NotYet");
			}
		});
		add(btnCurrentDate_1);
		
		JButton btnTimer = new JButton("timer");
		btnTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "MyTimer");
			}
		});
		add(btnTimer);
		
		JButton btnWTC = new JButton("world time converter");
		btnWTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "WorldTimeConverter");
			}
		});
		add(btnWTC);

	}

}
