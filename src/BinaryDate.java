import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;


public class BinaryDate extends JPanel implements ActionListener{
	public final static int EMPTY_CIRCLE = Position.EMPTY_CIRCLE;
	public final static int FULL_CIRCLE = Position.FULL_CIRCLE;
	public final static Color EMPTY_CIRCLE_COLOR = Position.EMPTY_CIRCLE_COLOR;
	public final static Color FULL_CIRCLE_COLOR = Position.FULL_CIRCLE_COLOR;
	
	private Date date; 
	private Calendar calender = Calendar.getInstance();
	
	private Timer timer = new Timer(1000, this);
	/**
	 * Create the panel.
	 */
	public BinaryDate() {
		date = new Date();
		setLayout(new BorderLayout(0, 0));
		timer.start();
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(getParent(), "startScreen");
			}
		});
		add(btnBack, BorderLayout.SOUTH);
		
	}
	

	private void drawFields(Graphics g){
		g.setColor(EMPTY_CIRCLE_COLOR);
		// Zeiche Sekunden-Felder:
		for (int a = 0; a < 2; a++){
			for (int i = 0; i < Position.time_day[1].length; i++){
				//			x-Coorodinate		y-Coordinate
				g.drawOval(Position.time_day[a][i][0], Position.time_day[a][i][1], EMPTY_CIRCLE, EMPTY_CIRCLE);
			}
		}
		
		for (int a = 0; a < 2; a++){
			for (int i = 0; i < Position.time_month[1].length; i++){
				//			x-Coorodinate		y-Coordinate
				g.drawOval(Position.time_month[a][i][0], Position.time_month[a][i][1], EMPTY_CIRCLE, EMPTY_CIRCLE);
			}
		}
		for (int a = 0; a < 4; a++){
			for (int i = 0; i < Position.time_year[1].length; i++){
				//			x-Coorodinate		y-Coordinate
				g.drawOval(Position.time_year[a][i][0], Position.time_year[a][i][1], EMPTY_CIRCLE, EMPTY_CIRCLE);
			}
		}
	}
	@SuppressWarnings("deprecation")
	private void drawDate(Graphics g){
		g.setColor(FULL_CIRCLE_COLOR);
		int day[] = {
				(date.getDate() / 10 ) ,
				date.getDate() - ((date.getDate() / 10) * 10)				
		};
/*		date.getDate();
		System.out.println( date.getDate()date.getDate() - ((date.getDate() / 10) * 10));
		for (int i : day){ System.out.println(i);}*/
		for (int i = 0; i < 2; i++){
			int rechner = day[i];
			int indexArray = 0;
			while (rechner > 0){
				if (rechner % 2 == 1){
					g.fillOval( (Position.time_day[i][indexArray][0] +1), (Position.time_day[i][indexArray][1] +1), FULL_CIRCLE, FULL_CIRCLE);
				}
				rechner = rechner / 2;
				indexArray++;
			}
		}
		
		int month[] = {
				((date.getMonth()+1) / 10 ) ,
				(date.getMonth()+1) - (((date.getMonth()+1) / 10) * 10)				
		};
//		System.out.print("month: ");
//		for (int i : month){ System.out.print(i + " ");}
//		System.out.println();
/*		date.getDate();
		System.out.println( date.getDate()date.getDate() - ((date.getDate() / 10) * 10));
		for (int i : day){ System.out.println(i);}*/
		for (int i = 0; i < 2; i++){
			int rechner = month[i];
			int indexArray = 0;
			while (rechner > 0){
				if (rechner % 2 == 1){
					g.fillOval( (Position.time_month[i][indexArray][0] +1), (Position.time_month[i][indexArray][1] +1), FULL_CIRCLE, FULL_CIRCLE);
				}
				rechner = rechner / 2;
				indexArray++;
			}
		}
		int yearInt = Calendar.getInstance().get(Calendar.YEAR);
		int year[] = {
				yearInt / 1000,
				(yearInt - (yearInt / 1000) * 1000) / 100,
				(yearInt - (yearInt / 100) * 100) / 10,
				yearInt - (yearInt / 10) * 10
		};
//		System.out.println("year: " + Calendar.getInstance().get(Calendar.YEAR));
/*		date.getDate();
		System.out.println( date.getDate()date.getDate() - ((date.getDate() / 10) * 10));
		for (int i : day){ System.out.println(i);}*/
		for (int i = 0; i < 4; i++){
			int rechner = year[i];
			int indexArray = 0;
			while (rechner > 0){
				if (rechner % 2 == 1){
					g.fillOval( (Position.time_year[i][indexArray][0] +1), (Position.time_year[i][indexArray][1] +1), FULL_CIRCLE, FULL_CIRCLE);
				}
				rechner = rechner / 2;
				indexArray++;
			}
		}
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//System.out.println("repainting");
		this.drawFields(g); 
		this.drawDate(g);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		date = new Date();
		calender = Calendar.getInstance();
		this.repaint();
	}

}
