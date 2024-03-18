package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.ImageLabel;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel imageLabel = ImageLabel.getImageLabel(100, 100, "src/images/image1.png");
        contentPane.add(imageLabel);
        JLabel imageLabel1 = ImageLabel.getImageLabel(200, 500, "src/images/image1.png");
        contentPane.add(imageLabel1);
        JLabel imageLabel2 = ImageLabel.getImageLabel(200, 200, "src/images/image1.png");
        contentPane.add(imageLabel2);
		setContentPane(contentPane);
	}

}
