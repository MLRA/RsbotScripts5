package mlra.fighter.nodes;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;

public abstract class Node extends MethodProvider {

	public Node(MethodContext arg) {
		
		super(arg);
		
	}
	
	public abstract void run();
	public abstract boolean canRun();

}
