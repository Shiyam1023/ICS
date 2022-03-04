import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * description calculates the power with base and exponent
 * 
 * modified 20220302 date 20220302
 * 
 * @filename Powers.java
 * @author Shiyam Sritharan
 * @version 1.0
 * @see ICS4U Content
 */

public class Powers extends JFrame {

	private JPanel contentPane;
	private JTextField txtBase;
	private JTextField txtExponent;
	private Double exponentNum, baseNum, power;
	private boolean validInput;
	private String text;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Powers frame = new Powers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Powers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("Powers!");
		title.setBounds(188, 11, 80, 20);
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setForeground(new Color(255, 99, 71));
		contentPane.add(title);

		JLabel lblBase = new JLabel("Base:");
		lblBase.setBounds(54, 65, 86, 14);
		contentPane.add(lblBase);

		JLabel lblExponent = new JLabel("Exponent (1-10):");
		lblExponent.setBounds(54, 96, 124, 14);
		contentPane.add(lblExponent);

		txtBase = new JTextField();
		txtBase.setBounds(188, 62, 105, 20);
		contentPane.add(txtBase);
		txtBase.setColumns(10);

		txtExponent = new JTextField();
		txtExponent.setBounds(188, 93, 105, 20);
		contentPane.add(txtExponent);
		txtExponent.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 142, 202, 96);
		contentPane.add(scrollPane);

		JTextArea txtOutput = new JTextArea();
		txtOutput.setEditable(false);
		scrollPane.setViewportView(txtOutput);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(255, 67, 67));
		btnExit.setBounds(366, 227, 58, 23);
		contentPane.add(btnExit);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validInput = true;
				text = "";

				try {
					baseNum = Double.parseDouble(txtBase.getText());
					exponentNum = Double.parseDouble(txtExponent.getText());
				} catch (Exception e) {
					txtOutput.setText("Error");
					validInput = false;
				}
				if (validInput) {
					if(exponentNum >=1 && exponentNum <= 10) {
					for (int i = 1; i <= exponentNum; i++) {
						power = Math.pow(baseNum, i);
						text += baseNum + "^" + i + " = " + power + "\n";
						txtOutput.setText(text);
					}
					}
					else { 
						txtOutput.setText("Enter a exponent between 1 and 10");
					}
				} else {
					txtOutput.setText("Bad Input!");
				}
			}
		});
		btnCalculate.setBackground(new Color(124, 252, 0));
		btnCalculate.setBounds(283, 144, 89, 23);
		contentPane.add(btnCalculate);

	}
}
