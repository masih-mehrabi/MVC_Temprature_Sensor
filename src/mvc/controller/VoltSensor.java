package mvc.controller;

import mvc.model.Machine;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * The (sensor) controller class, miming a voltage sensor
 * This class forms an alternative controller type for the system.
 * Actually this only updates the machine's voltage, by simulating sensor inputs.
 */
public class VoltSensor {
	private static int timestamp = 0;
	private Machine machine;

	public VoltSensor(Machine machine) {

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
	 * This method updates the current voltage of the machine (by using machine's setter).
	 * It simulates the new value by generating fluctuations around the target voltage.
	 * It uses the timestamp to create alternating values.
	 */
	protected void sendValue() {
		timestamp++;
		
		int value = (int) Math.max(Math.sin(timestamp) * 2 + machine.getTargetVoltage(), 0);

		machine.setCurrentVoltage(value);
	}
}
