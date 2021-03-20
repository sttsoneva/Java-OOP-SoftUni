package barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Runnable {
	void run() throws ExecutionControl.NotImplementedException;
}
