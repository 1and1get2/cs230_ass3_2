import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NotFunc extends JPanel {

	/**
	 * Create the panel.
	 */
	public NotFunc() {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnSorrynotImplementedYet = new JButton("sorry,not implemented yet (not enough time ; < )");
		btnSorrynotImplementedYet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "startScreen");
			}
		});
		add(btnSorrynotImplementedYet, BorderLayout.CENTER);

	}

}
