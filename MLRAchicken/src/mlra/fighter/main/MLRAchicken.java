package mlra.fighter.main;

import java.awt.EventQueue;

import mlra.fighter.gui.Gui;
import mlra.fighter.nodes.Node;
import mlra.fighter.nodes.Attacking;
import mlra.fighter.nodes.LootingFeathers;

import org.powerbot.script.Manifest;
import org.powerbot.script.util.Random;
import org.powerbot.script.PollingScript;

@Manifest(description = "An chicken killer", name = "MLRAchicken")
public class MLRAchicken extends PollingScript {

	private Gui gui;
	private Node[] allMyNodes;
	private boolean guiIsOn = false;

	public void Start() {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				gui = new Gui();
			}
		});

		allMyNodes = new Node[] { new Attacking(ctx), new LootingFeathers(ctx) };
	}

	@Override
	public int poll() {

		guiIsOn = gui != null && gui.isVisible();

		if (!guiIsOn) {
			
			for (Node node : allMyNodes) {
				
				if (node.canRun()) {
					node.run();
				}
			}
		}
		return guiIsOn ? 1500 : Random.nextInt(300, 800);
	}
}

