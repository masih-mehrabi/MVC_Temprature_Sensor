package mvc.controller;

import mvc.model.GateType;
import mvc.model.TransistorMachine;
import mvc.model.TransistorType;
import mvc.utils.FactoryException;

/**
 * The controller class for the model TransistorMachine
 * This class and the corresponding buttons form the controller part of the system.
 * Actually this only delegates the calls. It was however implemented to mock a dedicated controller.
 */
public class TransistorTerminal {

	private final TransistorMachine machine;
	
	private static final int TRANS_SIZE_MAX = 22;
	
	private static final int TRANS_SIZE_MIN = 7;
	
	
	public TransistorTerminal(TransistorMachine transistorMachine) {
		this.machine = transistorMachine;
	}

	/**
	 * This method updates the target temperature of the machine (by using machine's setter).
	 * It checks if the input value is between the min. and the max. temperature of the machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetTemperature(int targetTemperature) {

		if (targetTemperature <= getMachine().getMaxTemperature()
				    && targetTemperature >= getMachine().getMinTemperature()) {
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

		if (targetVoltage >= getMachine().getMinVoltage()
				    && targetVoltage <= getMachine().getMaxVoltage()) {
			getMachine().setTargetVoltage(targetVoltage);
			
		} else {
			throw new FactoryException("Out of range!");
		}
	}

	/**
	 * This method sets the transistor size of the transistor machine (by using machine's setter).
	 * It checks if the input value is reasonable (between 7nm and 22nm),
	 * and throws a FactoryException otherwise.
	 */
	public void setTransistorSize(int transistorSize) {
	
		if (transistorSize >= TRANS_SIZE_MIN
				    && transistorSize <= TRANS_SIZE_MAX) {
			getMachine().setTransistorSize(transistorSize);
		} else {
			throw new FactoryException("out of range");
		}
	}

	/**
	 * This method sets the transistor type of the transistor machine (by using machine's setter).
	 */
	public void setTransistorType(TransistorType transistorType) {
		getMachine().setTransistorType(transistorType);
	}

	/**
	 * This method sets the gate type of the transistor machine (by using machine's setter).
	 */
	public void setGateType(GateType gateType) {
		getMachine().setGateType(gateType);
	}
	
	public TransistorMachine getMachine() {
		return machine;
	}
}
