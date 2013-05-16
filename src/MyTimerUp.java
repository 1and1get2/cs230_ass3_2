import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class MyTimerUp extends JPanel implements ListSelectionListener,ActionListener{
	private JTextField txtCountUpTimer;
	private boolean status;
	private DefaultListModel /*ArrayList*/ listModel;
	private String title, appendex;
	private ClockListener cl = new ClockListener();
	private Timer t = new Timer(10, cl);
	private JList list;
	private JButton btnAdd, btnBack, btnStart, btnReset, btnClear;

	/**
	 * Create the panel.
	 */
	public MyTimerUp() {
		title = "Count Up Timer          current time: "; 
		status = false;
		listModel = new DefaultListModel()/*ArrayList<String>()*/;
//		resultList.addElement("no item yet");
//		resultList.addElement("still no item yet");
		
		setLayout(new BorderLayout(0, 0));
		
		list = new JList(listModel);
		//list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//ListModel model = new DefaultListModel();
		/*ListModel absModel = new AbstractListModel() {
			ArrayList values = new ArrayList<String>() ;
			public int getSize() {
				return values.size();
			}
			public Object getElementAt(int index) {
				return values.get(index);
			}
		};
		list.setModel(absModel);*/

//		for (Object str : resultList.toArray()) System.out.println(str + " ");
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(-1);
		//list.setEnabled(false);
		add(list, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnBack);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.addElement(listModel.getSize() + ": " + appendex + "   ");
				btnClear.setEnabled(true);
			}
		});
		btnAdd.setEnabled(false);
		panel.add(btnAdd);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setEnabled(false);
		panel.add(btnReset);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				if (!t.isRunning()){
					t.start();
					status = true;
					btnAdd.setEnabled(true);
					btnStart.setText("Pause");
				} else {
					t.stop();
					btnStart.setText("Resume");
					btnReset.setEnabled(true);
				}
			}
		});
		panel.add(btnStart);
		
		btnClear = new JButton("Clear");
		btnClear.setEnabled(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//for (Object str : listModel.toArray()) System.out.println(str + " ");
				//listModel = new DefaultListModel<String>(); // don't use this, will mess up everything
				listModel.clear();
				btnClear.setEnabled(false);
				//list = new JList(resultList); //data has type Object[]
				//list.repaint();
				//repaint();
			}
		});
		panel.add(btnClear);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		txtCountUpTimer = new JTextField();
		txtCountUpTimer.setText(title + appendex);
		add(txtCountUpTimer, BorderLayout.NORTH);
		txtCountUpTimer.setColumns(10);

	}

	private void reset(){
		btnStart.setText("Start");
		listModel.clear();
		cl = new ClockListener();
		t.stop();
		t = new Timer(10, cl);
		btnAdd.setEnabled(false);
		txtCountUpTimer.setText(title + appendex);
		System.out.println(appendex);
		btnReset.setEnabled(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		txtCountUpTimer.setText(title + appendex);
	}

	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	private class ClockListener implements ActionListener {

	    private int hours = 0;
	    private int minutes = 0;
	    private int seconds = 0;
	    private int centiseconds = 0;
	    private String hour;
	    private String minute;
	    private String second;
	    private String centisecond;
	    
	    public ClockListener() {
			super();
			appendex = "null";
		}

		@Override
	    public void actionPerformed(ActionEvent e) {
	        NumberFormat formatter = new DecimalFormat("00");
	        if (centiseconds == 100){
	        	centiseconds = 00;
	        	seconds++;
	        }
	        
	        if (seconds == 60) {
	            seconds = 00;
	            minutes++;
	        }

	        if (minutes == 60) {
	            minutes = 00;
	            hours++;
	        }
	        hour = formatter.format(hours);
	        minute = formatter.format(minutes);
	        second = formatter.format(seconds);
	        centisecond = formatter.format(centiseconds);
	        appendex = (String.valueOf(hour + ":" + minute + ":" + second + ":" + centisecond));
	        centiseconds++;
	        txtCountUpTimer.setText(title + appendex);
//	        repaint();
	    }
	}
}
