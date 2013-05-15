import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.Timer;


public class BinaryTime extends JPanel implements ActionListener, EventListener{
	public static Position position = new Position();
	private Date date; 
	private Calendar calender = Calendar.getInstance();
	
	private Timer timer = new Timer(500, this);
	/**
	 * Create the panel.
	 */
	public BinaryTime() {
		setLayout(new BorderLayout(0, 0));
		timer.start();
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "startScreen");
			}
		});
		add(btnBack, BorderLayout.SOUTH);
	}
	private void drawFields(Graphics g){
		for (int[][] a : Position.time){
			for (int []b : a){
				//System.out.println(" x: " + b[0] + " y: " + b[1]);
				Position.drawEmptyCircle(g, b[0], b[1]);
			}
		}
		
	}
	public void drawTime(Graphics g){
		int time_sec, time_min, time_hour;
		//System.out.println("current time: " + (new SimpleDateFormat("HH:mm:ss")).format(calender.getTime()));
		time_sec = Integer.parseInt((new SimpleDateFormat("ss")).format(calender.getTime()));
		time_min = Integer.parseInt((new SimpleDateFormat("mm")).format(calender.getTime()));
		time_hour = Integer.parseInt((new SimpleDateFormat("HH")).format(calender.getTime()));
		//System.out.println(time_hour + " : " + time_min + " : " + time_sec);
		int[] time = {
				time_hour / 10, time_hour - (time_hour / 10) * 10,
				time_min / 10, time_min - (time_min / 10) * 10,
				time_sec / 10, time_sec - (time_sec / 10) * 10,
		};
		//for (int i : time){ System.out.print( " " + i); } System.out.println();

		int remainder;
		for (int i = 0; i < 6; i++){
			remainder = time[i];
			//remainder = 15;
			int row = 0;
			while (remainder > 0){
				if (remainder % 2 == 1){
					//System.out.print(" collon: " + i + " row: " + row);
					//System.out.println( Position.time[i][row][0] + " " + Position.time[i][row][1]);
//					g.fillOval(Position.time[i][row][0],Position.time[i][row][1], FULL_CIRCLE, FULL_CIRCLE);
					Position.drawFullCircle(g, Position.time[i][row][0], Position.time[i][row][1]);
					//try {Thread.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
					//System.out.println(remainder);
					}
				row ++;
				remainder = remainder / 2;
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		this.drawFields(g); 
		//System.out.println("paint activited");
		calender = Calendar.getInstance();
		this.drawTime(g);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		repaint();
	}
	@Override
	public void handleEvent(Event evt) {
		// TODO Auto-generated method stub
		repaint();
	}
}
