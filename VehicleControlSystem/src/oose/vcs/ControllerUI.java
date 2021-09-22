package oose.vcs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

public abstract class ControllerUI extends JFrame implements VehicleController{
	protected String[] vehicles = { "Boat", "Ship", "Truck", "Motorcycle", "Bus", "Car", "Bicycle", "Helicopter",
			"Airplane", "Tram", "Train" };

	protected JLabel speedlabel;
	private List<JButton> buttons;
	protected JComboBox<String> combobox;

	public ControllerUI() {
		super("Vehicle Control System");
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		combobox = new JComboBox<String>(vehicles);
		combobox.setSelectedIndex(6);
		combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = combobox.getSelectedIndex();
				String vehicleName = vehicles[selectedIndex];
				initialiseVehicle(vehicleName);
			}
		});

		speedlabel = new JLabel("          ");

		buttons = new ArrayList<>();
		addButton("start", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});

		addButton("accelerate", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accelerate();
			}
		});

		addButton("decelerate", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				decelerate();
			}
		});

		addButton("cruise", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cruise();
			}
		});

		addButton("stop", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});

		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);

		toolBar.add(combobox);
		toolBar.add(speedlabel);
		for (JButton btn : buttons) {
			toolBar.add(btn);
		}

		add(toolBar, BorderLayout.NORTH);
		setPreferredSize(new Dimension(800, 200));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}
	

	
	
	private void setButtonColors(Color c) {
		buttons.forEach(btn -> btn.setBackground(c));
	}

	private void addButton(String name, ActionListener click) {
		JButton btn = new JButton(name);
		btn.setBackground(Color.lightGray);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setButtonColors(Color.lightGray);
				btn.setBackground(Color.GREEN);

				click.actionPerformed(e);
			}

		});
		buttons.add(btn);
	}

}
