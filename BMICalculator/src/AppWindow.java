import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

public class AppWindow extends JDialog {

	private JFrame frmBmiCalculator;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frmBmiCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AppWindow() {
		initialize();
	}

	private void initialize() {
		frmBmiCalculator = new JFrame();

		JLabel label = new JLabel(new ImageIcon("health.jpg"));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		frmBmiCalculator.setContentPane(label);
		;
		frmBmiCalculator.setTitle("BMI Calculator");
		frmBmiCalculator.setBounds(100, 100, 797, 573);
		frmBmiCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBmiCalculator.getContentPane().setLayout(null);

		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblWeight.setBounds(414, 64, 102, 44);
		frmBmiCalculator.getContentPane().add(lblWeight);

		JLabel lblImage = new JLabel("");
		ImageIcon img = new ImageIcon("img.jpg");
		lblImage.setIcon(img);
		lblImage.setBounds(63, 76, 561, 349);
		frmBmiCalculator.getContentPane().add(lblImage);

		JFormattedTextField formattedWeightTextField = new JFormattedTextField();
		formattedWeightTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		formattedWeightTextField.setBackground(new Color(230, 230, 250));
		formattedWeightTextField.setBounds(514, 64, 102, 44);
		frmBmiCalculator.getContentPane().add(formattedWeightTextField);

		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblHeight.setBounds(414, 116, 102, 44);
		frmBmiCalculator.getContentPane().add(lblHeight);

		JFormattedTextField formattedHeightTextField = new JFormattedTextField();
		formattedHeightTextField.setBackground(new Color(230, 230, 250));
		formattedHeightTextField.setBounds(514, 119, 102, 44);
		frmBmiCalculator.getContentPane().add(formattedHeightTextField);

		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
				double weight;
				double height;
				try {
					weight = numberFormat.parse(formattedWeightTextField.getText()).doubleValue();
					height = numberFormat.parse(formattedHeightTextField.getText()).doubleValue();

					double bmi = weight / Math.pow(height, 2) * 703;
					String status;
					if (bmi <= 18.5) {
						status = "underweight";
					} else if (bmi <= 25) {
						status = "normal";
					} else if (bmi <= 30) {
						status = "overweight";
					} else {
						status = "obese";
					}

					DecimalFormat num = new DecimalFormat("#.##");
					ImageIcon icon = new ImageIcon("bmi.jpg");
					JOptionPane.showMessageDialog(null, "Your BMI is " + num.format(bmi) + ". You are " + status + "!",
							"BMI", JOptionPane.INFORMATION_MESSAGE, icon);
					formattedWeightTextField.setText(null);
					formattedHeightTextField.setText(null);

				} catch (ParseException ex) {

					JOptionPane.showMessageDialog(null, "You can enter only numbers!", "", JOptionPane.WARNING_MESSAGE);
					formattedWeightTextField.setText(null);
					formattedHeightTextField.setText(null);
					ex.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnNewButton.setBounds(465, 258, 207, 85);
		frmBmiCalculator.getContentPane().add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBmiCalculator.setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnCancel.setBounds(465, 354, 207, 85);
		frmBmiCalculator.getContentPane().add(btnCancel);

		JLabel lblLbs = new JLabel("lbs");
		lblLbs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblLbs.setBounds(626, 68, 46, 29);
		frmBmiCalculator.getContentPane().add(lblLbs);

		JLabel lblIn = new JLabel("inches");
		lblIn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblIn.setBounds(626, 125, 74, 26);
		frmBmiCalculator.getContentPane().add(lblIn);
	}
}
