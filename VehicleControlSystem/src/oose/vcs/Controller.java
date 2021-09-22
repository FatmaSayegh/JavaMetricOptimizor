package oose.vcs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class Controller extends ControllerUI implements Runnable {

	private Vehicle vehicle;

	private volatile Simulator simulationPane;

	int acceleration = 0;
	int currentvelocity = 1;
	int maximumvelocity = 300;

	public static void main(String args[]) {
		Thread t = new Thread(new Controller());
		t.start();
	}

	public Controller() {
		super();
	}

	public void start() {

		if (vehicle == null) {
			String vehicleName = vehicles[combobox.getSelectedIndex()];
			initialiseVehicle(vehicleName);
		}

		if (simulationPane != null) {
			this.remove(simulationPane);
		}

		simulationPane = new Simulator(vehicle, maximumvelocity / currentvelocity);
		this.add(simulationPane, BorderLayout.CENTER);

		this.revalidate();
		this.repaint();
	}
	


	public void cruise() {
		acceleration = 0;
	}

	public void decelerate() {
		acceleration = -1;
	}

	public void accelerate() {
		acceleration = 1;
	}

	public void stop() {

		acceleration = 0;
		currentvelocity = 1;
	}

	private void updateSimulationTimer() {
		simulationPane.updateTimer(maximumvelocity / currentvelocity);
	}

	public void initialiseVehicle(String vehicleName) {
		if (vehicleName.equals("Boat")) {
			vehicle = new Boat("Apollo ");
		} else if (vehicleName.equals("Ship")) {
			vehicle = new Ship("Cruizz");
		} else if (vehicleName.equals("Truck")) {
			vehicle = new Truck("Ford F-650");
		} else if (vehicleName.equals("Motorcycle")) {
			vehicle = new Motorcycle("Suzuki");
		} else if (vehicleName.equals("Bus")) {
			vehicle = new Bus("Aero");
		} else if (vehicleName.equals("Car")) {
			vehicle = new Car("BMW");
		} else if (vehicleName.equals("Bicycle")) {
			vehicle = new Bicycle("A-bike");
		} else if (vehicleName.equals("Helicopter")) {
			vehicle = new Helicopter("Eurocopter");
		} else if (vehicleName.equals("Airplane")) {
			vehicle = new Airplane("BA");
		} else if (vehicleName.equals("Tram")) {
			vehicle = new Tram("EdinburghTram");
		} else if (vehicleName.equals("Train")) {
			vehicle = new Train("Virgin", 4);
		}
	}

	@Override
	public void run() {
		System.out.println("Starting threead!");
		while (true) {
			if (simulationPane == null)
				continue;
			if (acceleration != 0) {
				try {
					Thread.sleep(2 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (currentvelocity > 1 || currentvelocity <= maximumvelocity) {
					currentvelocity += acceleration;
				}

				if (currentvelocity < 1)
					currentvelocity = 1;
				else if (currentvelocity > maximumvelocity) {
					currentvelocity = maximumvelocity;
				}

			}
			vehicle.setCurrentSpeed(this.currentvelocity);
			speedlabel.setText(vehicle.printSpeed());

			updateSimulationTimer();
		}

	}

}
