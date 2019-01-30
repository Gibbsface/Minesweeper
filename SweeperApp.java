package minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SweeperApp extends JFrame implements ActionListener {
	
	private static final String TITLE = "Minesweeper by Gibbsface";
	private static final String UNPRESSED_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper00.png";
	private static final String PRESSED_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper01.png";
	private static final String ONE_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper02.png";
	private static final String TWO_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper03.png";
	private static final String THREE_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper04.png";
	private static final String FOUR_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper05.png";
	private static final String FIVE_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper06.png";
	private static final String SIX_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper07.png";
	private static final String SEVEN_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper08.png";
	private static final String EIGHT_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper09.png";
	private static final String FLAG_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper10.png";
	private static final String BOMB_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper11.png";
	private static final String DETONATE_LINK = "C:\\Users\\coleg\\Everything\\Coding\\Java\\Java Projects\\Minesweeper\\New Piskel\\sprite_minesweeper12.png";
	
	private static final int ROWS = 15;
	private static final int COLS = 10;
	
	private static ImageIcon[] icons = new ImageIcon[13];
	
	private int[][] puzzle;
	
	private JPanel gameboard = new JPanel();
	private JPanel menu = new JPanel();
	private JButton[][] gamebuttons = new JButton[ROWS][COLS];
	private JButton start = new JButton("Start");
	private Dimension panelD = new Dimension(320,480);
	
	public SweeperApp() {
		super(TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10,10));
		
		int difficulty = 0;
		
		Puzzle p = new Puzzle(ROWS, COLS, difficulty);
		puzzle = p.getPuzzle();
		
		icons[0] = new ImageIcon(UNPRESSED_LINK, "");
		icons[1] = new ImageIcon(PRESSED_LINK, "");
		icons[2] = new ImageIcon(ONE_LINK, "");
		icons[3] = new ImageIcon(TWO_LINK, "");
		icons[4] = new ImageIcon(THREE_LINK, "");
		icons[5] = new ImageIcon(FOUR_LINK, "");
		icons[6] = new ImageIcon(FIVE_LINK, "");
		icons[7] = new ImageIcon(SIX_LINK, "");
		icons[8] = new ImageIcon(SEVEN_LINK, "");
		icons[9] = new ImageIcon(EIGHT_LINK, "");
		icons[10] = new ImageIcon(FLAG_LINK, "");
		icons[11] = new ImageIcon(BOMB_LINK, "");
		icons[12] = new ImageIcon(DETONATE_LINK, "");
		
		gameboard.setLayout(new GridLayout(ROWS,COLS));
		gameboard.setBackground(Color.GRAY);
		gameboard.setPreferredSize(panelD);
		
		for(int row = 14; row >= 0; --row) {
			for(int col = 0; col < COLS; ++col) {
				
				gamebuttons[row][col] = new JButton();
				gamebuttons[row][col].addActionListener(this);
				gamebuttons[row][col].setActionCommand(row + " " + col);
				gamebuttons[row][col].setIcon(icons[0]);
				gamebuttons[row][col].setFocusable(false);
				gamebuttons[row][col].setContentAreaFilled(false);
				gamebuttons[row][col].setBorderPainted(false);
				gamebuttons[row][col].setOpaque(false);
				
				gameboard.add(gamebuttons[row][col], row, col);
			
			}
		}
		
		menu.setLayout(new FlowLayout(FlowLayout.CENTER));
		menu.add(start);
		
		add(gameboard,BorderLayout.CENTER);
		add(menu,BorderLayout.SOUTH);
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		//System.out.print(msg);
		
		for(int row = 0; row < ROWS; ++row) {
			for(int col = 0; col < COLS; ++col) {
				String test = row + " " + col;
				if(test.equals(msg)) {
					
					int a;
					
					switch(puzzle[row][col]) {
					case -1: a = 12;
					break;
					default: a = puzzle[row][col] + 1;
					break;
					};
						
					
					gamebuttons[row][col].setIcon(icons[a]);
					
				}
			}
		}
	}
		
}
