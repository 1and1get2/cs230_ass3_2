import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class MainFrame extends JFrame implements ComponentListener{
	public final static int  WINDOW_WIDTH = Position.WINDOW_WIDTH;
	public final static int WINDOW_HEIGHT = Position.WINDOW_HEIGHT; //height
	public static Position position = new Position();
	
	private JPanel contentPane;
	static CardLayout cardLayout = new CardLayout();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		this.addComponentListener(this);
		//setResizable(false);
		setTitle("            ----===  binary 0x63 0x6c 0x6f 0x63 0x6b   ===----  ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// Step 2: set the card layout as the layout of the content panel of the
		// MainFrame
		contentPane.setLayout(cardLayout);
		
		// Step 3: add a panel for each of your screens to the CardLayout
		// Note that you need to give each panel a name
		contentPane.add(new startScreen(), "startScreen");
		contentPane.add(new BinaryTime(), "BinaryTime");
		contentPane.add(new BinaryDate(), "BinaryDate");
		contentPane.add(new NotFunc(), "NotYet");
		contentPane.add(new WorldTimeConverter(), "WorldTimeConverter");
		contentPane.add(new MyTimer(), "MyTimer");
//		contentPane.add();
//		contentPane.add();
//		contentPane.add();
//		contentPane.add();
		
//		contentPane.add(new PlayerNumberSelection(), "PlayerNumberSelection");
//		contentPane.add(new GameModeSelectionPane(), "GameModeSelectionPane");
//		contentPane.add(new LawsuitPanel(), "LawsuitPanel");
		// add more panels here...

		// Step 4: choose a panel to show first
		cardLayout.show(contentPane, "WelcomePanel");
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("resized in MainFrame");
		Position.setSize(this.getWidth(), this.getHeight());
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
