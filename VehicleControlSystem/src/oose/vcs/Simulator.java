package oose.vcs;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import vehicle.types.Airplane;
import vehicle.types.Bicycle;
import vehicle.types.Boat;
import vehicle.types.Bus;
import vehicle.types.Car;
import vehicle.types.Helicopter;
import vehicle.types.Motorcycle;
import vehicle.types.Ship;
import vehicle.types.Train;
import vehicle.types.Tram;
import vehicle.types.Truck;
import vehicle.types.Vehicle;

public class Simulator extends JPanel {


	private int xPos = 0;
	private int direction = 1;

	private Timer timer;

	private File file;
	private BufferedImage boat;

	public Simulator(Vehicle vehicle, int timerDelay) {
		this.setDisplayObject(vehicle);

		try {
			boat = ImageIO.read(file);
			timer = new Timer(timerDelay, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					xPos += direction;
					if (xPos + boat.getWidth() > getWidth()) {
						xPos = 0;
						direction *= -1;

					} else if (xPos < 0) {
						xPos = 0;
						direction *= -1;
					}
					repaint();
				}

			});
			timer.setRepeats(true);
			timer.setCoalesce(true);
			timer.start();
		} catch (Exception ex) {

		}
	}

	private void setDisplayObject(Vehicle vehicle) {
		Class<?>[] vehicles = { Boat.class, Ship.class, Truck.class, Motorcycle.class, Bus.class, Car.class,
				Bicycle.class, Helicopter.class, Airplane.class, Tram.class, Train.class };

		for (Class<?> c : vehicles) {
			try {
				c.cast(vehicle);
				file = new File(System.getProperty("user.dir") + "/img/" + c.getSimpleName().toLowerCase() + ".png");
				break;
			} catch (Exception ex) {
				//ex.printStackTrace();
			}
		}
	}

	public void updateTimer(int delay) {
		timer.setDelay(delay);
	}



	@Override
	public Dimension getPreferredSize() {
		return boat == null ? super.getPreferredSize() : new Dimension(boat.getWidth() * 4, boat.getHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int y = getHeight() - boat.getHeight();
		g.drawImage(boat, xPos, y, this);

	}

}
