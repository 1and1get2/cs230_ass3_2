import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MyTimer extends JPanel {

	/**
	 * Create the panel.
	 */
	public MyTimer() {
		setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton btnCountUp = new JButton("Count Up");
		btnCountUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "MyTimerUp");
			}
		});
		add(btnCountUp);
		
		JButton btnCountDown = new JButton("Count Down");
		btnCountDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "NotYet");
			}
		});
		add(btnCountDown);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "startScreen");
			}
		});
		add(btnBack);

	}

}
