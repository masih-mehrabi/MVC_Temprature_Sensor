package mvc.controller;

import mvc.model.Machine;
import mvc.utils.FactoryException;

/**
 * The (terminal) controller superclass
 * This class and the corresponding buttons form the controller part of the system.
 * Actually this only delegates the calls. It was however implemented to mock a dedicated controller.
 */
public class MachineTerminal {

	private final Machine machine;

	public MachineTerminal(Machine machine) {
		this.machine = machine;
	}

	/**
	 * This method updates the target temperature of the machine (by using machine's setter).
	 * It checks if the input value is between the min. and the max. temperature of the machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetTemperature(int targetTemperature) {
	
		if (targetTemperature <= getMachine().getMaxTemperature() && targetTemperature >= getMachine().getMinTemperature()) {
			getMachine().setTargetTemperature(targetTemperature);
		} else {
			throw new FactoryException("Out of range");
		}
	}

	/**
	 * This method updates the target voltage of the machine (by using machine's setter).
	 * It checks if the input value is between the min. and the max. voltage of the machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetVoltage(int targetVoltage) {
	
		if (targetVoltage >= getMachine().getMinVoltage() && targetVoltage <= getMachine().getMaxVoltage()) {
			getMachine().setTargetVoltage(targetVoltage);
			
		} else {
			throw new FactoryException("Out of range!");
		}
	}
	
	public Machine getMachine() {
		return machine;
	}
}
