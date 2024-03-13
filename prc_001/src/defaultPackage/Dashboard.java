package defaultPackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard {

	private JFrame frame;
	private JPanel content;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dashboard() {
		
		initialize();
		
		Page1 p1 = new Page1();
		showPannel(p1);
		
	}
	
	private void showPannel(JPanel panel) {

		panel.setBounds(10, 92, 1084, 665);
		
        if (content != null) {
            content.removeAll();
            content.add(panel, BorderLayout.CENTER);
            content.revalidate();
            content.repaint();
        }
	}


	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1140, 829);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel bg = new JPanel();
		bg.setBounds(10, 11, 1104, 768);
		frame.getContentPane().add(bg);
		bg.setLayout(null);
		
		JButton pageBtn1 = new JButton("Button 1");
		pageBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page1 p1 = new Page1();
				showPannel(p1);
			}
		});
		pageBtn1.setBounds(10, 11, 240, 70);
		bg.add(pageBtn1);
		
		JButton pageBtn2 = new JButton("Button 2");
		pageBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page2 p2 = new Page2();
				p2.setBounds(10, 92, 1084, 665);
				showPannel(p2);
			}
		});
		pageBtn2.setBounds(854, 11, 240, 70);
		bg.add(pageBtn2);
		
		content = new JPanel();
		content.setBackground(new Color(255, 255, 255));
		content.setBounds(10, 92, 1084, 665);
		bg.add(content);
		
	}
}
