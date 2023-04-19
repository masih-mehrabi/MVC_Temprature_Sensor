package mvc.model;

/**
 * This class is representing a factory machine producing transistors, which is a model inside the system.
 */
public class TransistorMachine extends Machine {

	private int transistorSize;
	private TransistorType transistorType;
	private GateType gateType;
	

	
	
	public TransistorMachine(String name, int minVoltage, int maxVoltage, int targetVoltage, int minTemperature,
	                         int maxTemperature, int targetTemperature,
	                         int transistorSize, TransistorType transistorType, GateType gateType) {
		super(name, minVoltage, maxVoltage, targetVoltage, minTemperature, maxTemperature, targetTemperature);
		this.transistorSize = transistorSize;
		this.transistorType = transistorType;
		this.gateType = gateType;
		
		
	}

	public void setTransistorSize(int transistorSize) {
		this.transistorSize = transistorSize;
		notifyObservers();
	}
	

	
	public void setTransistorType(TransistorType transistorType) {
		this.transistorType = transistorType;
		notifyObservers();
	}

	public void setGateType(GateType gateType) {
		this.gateType = gateType;
		notifyObservers();
	}
	


	/**
	 * Standard getters for the transistor machine values.
	 */

	public int getTransistorSize() {
		
		return transistorSize;
	}

	public TransistorType getTransistorType() {
		return transistorType;
	}

	public GateType getGateType() {
		return gateType;
	}
}
