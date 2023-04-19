package mvc.view;

import mvc.model.Machine;

/**
 * This is an interface in order to implement the observer pattern.
 */
public interface Observer {

	void update(Machine machine);
}
