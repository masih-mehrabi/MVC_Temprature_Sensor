package mvc.controller;

import mvc.model.Machine;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * The (sensor) controller class, miming a temperature sensor
 * This class forms an alternative controller type for the system.
 * Actually this only updates the machine's temperature, by simulating sensor inputs.
 */
public class TemperatureSensor {

	private static final int MULTIPLIER = 3;
	private static int timestamp = 0;

	private Machine machine;
	public TemperatureSensor(Machine machine) {

		//for simulating regular sensor input/update
		Timeline beat = new Timeline(
				new KeyFrame(Duration.ZERO, event -> sendValue()),
				new KeyFrame(Duration.seconds(1), event -> {
				})
		);
		beat.setAutoReverse(true);
		beat.setCycleCount(Animation.INDEFINITE);
		beat.play();
		this.machine = machine;
	}

	/**
	 * This method updates the current temperature of the machine (by using machine's setter).
	 * It simulates the new value by generating fluctuations around the target temperature.
	 * It uses the timestamp to create alternating values.
	 */
	protected void sendValue() {
		timestamp++;
		
		int value = (int) Math.max(Math.sin(timestamp) * MULTIPLIER + machine.getTargetTemperature(), 0);
		
		machine.setCurrentTemperature(value);
	}
}
