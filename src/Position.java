import java.awt.Color;
import java.awt.Graphics;


public class Position {

	public static int  WINDOW_WIDTH = 450;
	public static int WINDOW_HEIGHT = 300; //height
	public static int EMPTY_CIRCLE;
	public static int EMPTY_CIRCLE_THK;
	public static int FULL_CIRCLE;
	public static Color EMPTY_CIRCLE_COLOR = Color.blue;
	public static Color FULL_CIRCLE_COLOR = Color.green;
	public static int  INDEPENDENT = 40; //
	public static int  RESERVED_HEIGHT; //
	public static int  RESERVED_WIDTH; //
	public static int  AREA_HEIGHT = WINDOW_HEIGHT - 2 * RESERVED_HEIGHT; //
	public static int  AREA_WIDTF = WINDOW_WIDTH - 2 * RESERVED_WIDTH; //
	

	public static int time_day[][][] = {
		{
			{0, 180},
			{0, 120},
			{0, 60},
			{0, 0},
		}, {
			{45, 180},
			{45, 120},
			{45, 60},
			{45, 0},
		}
	};
	public final static int time_month[][][] = {
		{
			{135, 180},
			{135, 120},
			{135, 60},
			{135, 0},
		}, {
			{180, 180},
			{180, 120},
			{180, 60},
			{180, 0},
		}
	};
	public final static int time_year[][][] = {
		{
			{270, 180},
			{270, 120},
			{270, 60},
			{270, 0},
		}, {
			{315, 180},
			{315, 120},
			{315, 60},
			{315, 0},
		},{
			{360, 180},
			{360, 120},
			{360, 60},
			{360, 0},
		},{
			{405, 180},
			{405, 120},
			{405, 60},
			{405, 0},	
		}
	};

	public static int time[][][] = new int[6][4][2];
	
	public static void setSize(int w, int h){
		WINDOW_HEIGHT = h;
		WINDOW_WIDTH = w;
		init();
	}
	
	public Position() {
		init();
		
	}
	public static void init(){
		//System.out.println(" size: " + WINDOW_HEIGHT + " " + WINDOW_WIDTH + " " + EMPTY_CIRCLE);
		AREA_HEIGHT = WINDOW_HEIGHT - 2 * RESERVED_HEIGHT; //
		AREA_WIDTF = WINDOW_WIDTH - 2 * RESERVED_WIDTH; //
		EMPTY_CIRCLE = (WINDOW_WIDTH + WINDOW_HEIGHT) / 20;
		FULL_CIRCLE = (WINDOW_WIDTH + WINDOW_HEIGHT) / 22;
		EMPTY_CIRCLE_THK = (WINDOW_WIDTH + WINDOW_HEIGHT) / 100;
		RESERVED_HEIGHT = (WINDOW_WIDTH + WINDOW_HEIGHT) / 35; //
		RESERVED_WIDTH = (WINDOW_WIDTH + WINDOW_HEIGHT) / 35; //
		AREA_HEIGHT = WINDOW_HEIGHT - 2 * RESERVED_HEIGHT; //
		AREA_WIDTF = WINDOW_WIDTH - 2 * RESERVED_WIDTH; //
		
		// dx: 102 dy: 36
		int x = RESERVED_WIDTH, y = RESERVED_HEIGHT, dx = (AREA_WIDTF  - 3 * INDEPENDENT) / 6, dy = (AREA_HEIGHT - 2 * INDEPENDENT) / 4;
//		this.time_hour =
		for (int a = 0; a < 6; a ++){
			// hour, min, sec
			y = RESERVED_HEIGHT;
			for (int b = 3; b >= 0; b--){
				//for (int c = 0; c < 2; c++){
				time[a][b][0] = x + RESERVED_WIDTH;
				time[a][b][1] = y + RESERVED_HEIGHT;
				//System.out.println("intial time: x: " + x + " y: " + y /*+ " dx: " + dx + " dy: " + dy*/);
				y += dy;
			}
			if ((a+1) % 2 == 0){
				x += INDEPENDENT;
			}
			x += dx;
		}
		
	}
	public void init(int w, int h){
		setSize(w, h);
	}
	public static void drawEmptyCircle(Graphics g, int x, int y){
		// d = EMPTY_CIRCLE
		// center (x + EMPTY_CIRCLE) / 2 , (y + EMPTY_CIRCLE) / 2  
//		for (int i = 255; i >= 0; i-= (255/10)){
//			g.setColor(new Color(i,0,255));
//			
//		}
		for (int i = 10; i >= -10; i--){
			g.setColor(new Color(Math.abs(i * (127 / 10))+127,0,255));
//			g.fillOval((x + EMPTY_CIRCLE) / 2 + (EMPTY_CIRCLE / 2) - EMPTY_CIRCLE_THK / 2 + i * EMPTY_CIRCLE_THK / 20,
//					(y + EMPTY_CIRCLE) / 2 + (EMPTY_CIRCLE / 2) - EMPTY_CIRCLE_THK / 2 + i * EMPTY_CIRCLE_THK / 20,
//					EMPTY_CIRCLE - EMPTY_CIRCLE_THK / 2 + i * EMPTY_CIRCLE_THK / 20, 
//					EMPTY_CIRCLE - EMPTY_CIRCLE_THK / 2 + i * EMPTY_CIRCLE_THK / 20);
			g.drawOval(x - i * EMPTY_CIRCLE_THK / 20,
					y - i * EMPTY_CIRCLE_THK / 20,
					EMPTY_CIRCLE + i * EMPTY_CIRCLE_THK / 10, 
					EMPTY_CIRCLE + i * EMPTY_CIRCLE_THK / 10);
		}
		//g.setColor(MainFrame.getContentPane().getBackground());
		
		//g.fillOval(x + EMPTY_CIRCLE_THK / 2, y + EMPTY_CIRCLE_THK / 2, EMPTY_CIRCLE - EMPTY_CIRCLE_THK, EMPTY_CIRCLE - EMPTY_CIRCLE_THK);
	}
	public static void drawFullCircle(Graphics g, int x, int y){
		//TODO:
		for (int i = 0; i <= 20; i++){
			g.setColor(new Color(Math.abs(i * (127 / 20)) + 127,255,0));
			//System.out.println(Math.abs(i * (127 / 20)));
//			g.fillOval((x + EMPTY_CIRCLE) / 2 + (EMPTY_CIRCLE / 2) - EMPTY_CIRCLE_THK / 2 + i * EMPTY_CIRCLE_THK / 20,
//					(y + EMPTY_CIRCLE) / 2 + (EMPTY_CIRCLE / 2) - EMPTY_CIRCLE_THK / 2 + i * EMPTY_CIRCLE_THK / 20,
//					EMPTY_CIRCLE - EMPTY_CIRCLE_THK / 2 + i * EMPTY_CIRCLE_THK / 20, 
//					EMPTY_CIRCLE - EMPTY_CIRCLE_THK / 2 + i * EMPTY_CIRCLE_THK / 20);
			g.fillOval(x + EMPTY_CIRCLE / 2 - (20 - i) * FULL_CIRCLE / 40,
					y + EMPTY_CIRCLE / 2 - (20 - i) * FULL_CIRCLE / 40,
					(20 - i) * FULL_CIRCLE / 20 ,(20 - i) * FULL_CIRCLE / 20 );
		}
	}
}
