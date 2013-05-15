import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class WorldTimeConverter extends JPanel implements ActionListener{
	private JTextField textFieldFromTime;
	private JTextField textFieldToTime;
	private String[] timeZones;
	private Calendar calendar;
	private SimpleDateFormat formatterWithDate = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
	private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	private JButton btnConfirm, btnSwap, btnBack;
	private JComboBox comboBoxFromTimeZone, comboBoxToTimeZone;
	private TimeZone tz;
	private JLabel lbStatus = new JLabel("time converter");;

	/**
	 * Create the panel.
	 */
	private int findIndexOfATimeZone(String tz){
		for (int i = 0; i < timeZones.length; i++){
			if (tz.contains(timeZones[i])){
				return i;
			}
		}
		return -1;
	}
	public WorldTimeConverter() {
//		lbStatus = new JLabel("time converter");
		calendar = Calendar.getInstance();
		timeZones = TimeZone.getAvailableIDs();
		Arrays.sort(timeZones);
		tz = calendar.getTimeZone();
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(new GridLayout(4, 3, 0, 0));
		add(lbStatus);
		
		JLabel lblTimeZone = new JLabel("TimeZone");
		lblTimeZone.setFont(new Font("Dialog", Font.PLAIN, 17));
		add(lblTimeZone);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Dialog", Font.PLAIN, 17));
		add(lblTime);
		
		JLabel lblFrom = new JLabel("From: ");
		lblFrom.setFont(new Font("Dialog", Font.ITALIC, 17));
		add(lblFrom);
		
		comboBoxFromTimeZone = new JComboBox();
		comboBoxFromTimeZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxFromTimeZone != null && comboBoxFromTimeZone.getSelectedIndex() != -1 && comboBoxToTimeZone != null && comboBoxToTimeZone.getSelectedIndex() != -1){
				btnSwap.setEnabled(true);
				btnConfirm.setEnabled(true);
				}
			}
		});
		comboBoxFromTimeZone.setEditable(true);
		comboBoxFromTimeZone.setMaximumRowCount(15);
		comboBoxFromTimeZone.setFont(new Font("Dialog", Font.ITALIC, 12));
		comboBoxFromTimeZone.setModel(new DefaultComboBoxModel(timeZones));
		comboBoxFromTimeZone.setSelectedIndex(findIndexOfATimeZone(TimeZone.getDefault().getDisplayName(true, 0)));
		//System.out.println(TimeZone.getDefault().getDisplayName(true, 0));
		add(comboBoxFromTimeZone);
		
		textFieldFromTime = new JTextField();
//		textFieldFromTime.setText((new SimpleDateFormat("HH:mm:ss")).format(calender.getTime()));
		textFieldFromTime.setText((formatter.format(calendar.getTime())));
		add(textFieldFromTime);
		textFieldFromTime.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 17));
		add(lblNewLabel);
		
		comboBoxToTimeZone = new JComboBox();
		comboBoxToTimeZone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxFromTimeZone != null && comboBoxFromTimeZone.getSelectedIndex() != -1 && comboBoxToTimeZone != null && comboBoxToTimeZone.getSelectedIndex() != -1){
				btnSwap.setEnabled(true);
				btnConfirm.setEnabled(true);
				}
			}
		});
//		comboBoxToTimeZone.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (comboBoxToTimeZone.getSelectedIndex() != -1){
//					btnConfirm.setEnabled(false);
//				}
//			}
//		});
		comboBoxToTimeZone.setEditable(true);
		comboBoxToTimeZone.setMaximumRowCount(15);
		comboBoxToTimeZone.setFont(new Font("Dialog", Font.ITALIC, 12));
		comboBoxToTimeZone.setModel(new DefaultComboBoxModel(timeZones));
		comboBoxToTimeZone.setSelectedIndex(-1);
		add(comboBoxToTimeZone);
		
		textFieldToTime = new JTextField();
		textFieldToTime.setEditable(false);
		add(textFieldToTime);
		textFieldToTime.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "startScreen");
			}
		});
		add(btnBack);
		
		btnSwap = new JButton("Swap");
//		btnSwap.setEnabled(false);
//		if (comboBoxFromTimeZone.getSelectedIndex() != -1 && comboBoxToTimeZone.getSelectedIndex() != -1){
//			btnSwap.setEnabled(true);
//		}
		btnSwap.setEnabled(true);
		//System.out.println(comboBoxFromTimeZone.getSelectedIndex());
		btnSwap.addActionListener(/*new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		}*/ this);
		add(btnSwap);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(/*new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboBoxToTimeZone1, comboBoxFromTimeZone;
				//comboBoxToTimeZone1 = comboBoxToTimeZone.getSelectedIndex();
			}
		}*/this);
		btnConfirm.setEnabled(false);
		add(btnConfirm);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxFromTimeZone, textFieldFromTime, comboBoxToTimeZone, textFieldToTime, btnBack, btnSwap}));

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//e.getSource();
		// there are a lot TODO in this method, i'm just too tired, it's 6 in the morning!!!!!!!! ffs, i haven't sleep the whole night
		if (e.getSource() == btnConfirm){
			System.out.println("confirmed");
			//lbStatus = new JLabel(new String(timeZones[comboBoxFromTimeZone.getSelectedIndex()] + " - " + timeZones[comboBoxToTimeZone.getSelectedIndex()]));
			lbStatus.setText(timeZones[comboBoxFromTimeZone.getSelectedIndex()] + " - " + timeZones[comboBoxToTimeZone.getSelectedIndex()]);
			//System.out.println(timeZones[comboBoxFromTimeZone.getSelectedIndex()] + " - " + timeZones[comboBoxToTimeZone.getSelectedIndex()]);
			//textFieldFromTime.getText();
			Calendar fromTime = new GregorianCalendar(TimeZone.getTimeZone(timeZones[comboBoxFromTimeZone.getSelectedIndex()]));
//			fromTime.set(Calendar.HOUR,Integer.parseInt(new SimpleDateFormat("HH").format(textFieldFromTime.getText())));
//			fromTime.set(Calendar.MINUTE,Integer.parseInt(new SimpleDateFormat("mm").format(textFieldFromTime.getText())));
//			fromTime.set(Calendar.SECOND,Integer.parseInt(new SimpleDateFormat("ss").format(textFieldFromTime.getText())));
			fromTime.set(Calendar.HOUR,Integer.parseInt(textFieldFromTime.getText().substring(0,2)));
			fromTime.set(Calendar.MINUTE,Integer.parseInt(textFieldFromTime.getText().substring(3,5)));
			fromTime.set(Calendar.SECOND,Integer.parseInt(textFieldFromTime.getText().substring(6,8)));
			
			//TimeZone tzFrom = Time
			Calendar toTime = new GregorianCalendar(TimeZone.getTimeZone(timeZones[comboBoxToTimeZone.getSelectedIndex()]));
			toTime.setTimeInMillis(fromTime.getTimeInMillis());
			String strTime = "" + toTime.get(Calendar.HOUR) + ":" + toTime.get(Calendar.MINUTE) + ":" + toTime.get(Calendar.SECOND);
			textFieldToTime.setText(strTime);
			System.out.println(strTime);
			
			//tz = TimeZone.getTimeZone(timeZones[comboBoxFromTimeZone.getSelectedIndex()]);
			//calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZones[comboBoxToTimeZone.getSelectedIndex()]));//new GregorianCalendar();
			repaint();
		}
		if (e.getSource() == btnSwap){
			System.out.println("swaped");
			int comboBoxToTimeZone1 = comboBoxToTimeZone.getSelectedIndex(), comboBoxFromTimeZone1 = comboBoxFromTimeZone.getSelectedIndex();
			comboBoxToTimeZone.setSelectedIndex(comboBoxFromTimeZone1);
			comboBoxFromTimeZone.setSelectedIndex(comboBoxToTimeZone1);
			repaint();
		}
	}

}
