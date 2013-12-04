package mlra.fighter.nodes;

import org.powerbot.script.wrappers.GroundItem;
import org.powerbot.script.methods.MethodContext;

public class LootingFeathers extends Node {

	private GroundItem feather = null;

	private static final int FEATHER_ID = 314;
	public static boolean lootFeather = false;

	public LootingFeathers(MethodContext arg) {

		super(arg);
	}

	@Override
	public void run() {

		if (feather.isOnScreen()) {

			feather.interact("Take", feather.getName());
			sleep(1000);

		} else {

			System.out.println("Walking to feathers");
			ctx.movement.stepTowards(feather);
		}

	}

	@Override
	public boolean canRun() {

		feather = ctx.groundItems.select().id(FEATHER_ID).getNil();
		return lootFeather && feather != null;
	}

}
