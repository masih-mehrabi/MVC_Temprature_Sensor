package mvc.controller;

import mvc.model.AssemblyMachine;
import mvc.model.ChipType;
import mvc.utils.FactoryException;

/**
 * The controller class for the model AssemblyMachine
 * This class and the corresponding buttons form the controller part of the system.
 * Actually this only delegates the calls. It was however implemented to mock a dedicated controller.
 */
public class AssemblyTerminal {

	private final AssemblyMachine machine;
	
	private static final int SPACEMAX = 60;
	private static final int SPACEMIN = 27;
	
	
	public AssemblyTerminal(AssemblyMachine assemblyMachine) {
		this.machine = assemblyMachine;
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
			 throw new FactoryException("Out of range!");
		}
		
	}

	/**
	 * This method updates the target voltage of the machine (by using machine's setter).
	 * It checks if the input value is between the min. and the max. voltage of the machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetVoltage(int targetVoltage) {
	
		if (targetVoltage <= getMachine().getMaxVoltage() && targetVoltage >= getMachine().getMinVoltage()) {
			getMachine().setTargetVoltage(targetVoltage);
		} else {
			throw new FactoryException("Out of range!");
		}
		
	}

	/**
	 * This method sets the space between transistors ("fin pitch") of the assembly machine (by using machine's setter).
	 * It checks if the input value is reasonable (between 27nm and 60nm),
	 * and throws a FactoryException otherwise.
	 */
	public void setSpaceBetweenTrans(int space) {
	
		if (space >= SPACEMIN && space <= SPACEMAX) {
			getMachine().setSpaceBetweenTrans(space);
		} else {
			throw new FactoryException("Out of range!");
		}
	}

	/**
	 * This method sets the chip type of the assembly machine (by using machine's setter).
	 */
	public void setChipType(ChipType chipType) {
		machine.setChipType(chipType);
	}
	
	public AssemblyMachine getMachine() {
		return machine;
	}
}
