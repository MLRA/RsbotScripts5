package mlra.fighter.nodes;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Npc;

public class Attacking extends Node {

	private Npc chicken = null;
	private boolean chickenExist;
	private boolean playerInCombat;
	private static final String CHICKEN_NAME = "Chicken";

	public Attacking(MethodContext arg) {

		super(arg);
	}

	@Override
	public void run() {

		if (chicken.isOnScreen() && chicken != null) {

			if (chicken.interact("Attack", chicken.getName())) {

				for (int x = 0; x < 10 && !ctx.players.local().isInCombat(); x++) {

					sleep(Random.nextInt(100, 160));

				}
			}

		} else {

			ctx.movement.stepTowards(chicken.getLocation());
			System.out.println("Walking to the chicken !!");

		}

	}

	@Override
	public boolean canRun() {

		playerInCombat = ctx.players.local().isInCombat();
		chickenExist = (chicken = getNpcWithName(10, CHICKEN_NAME)) != null;

		return chickenExist && ctx.game.isLoggedIn() && !playerInCombat;

	}

	/**
	 * @param names
	 * @return an random Npc within 10 tiles
	 */
	private Npc getNpcWithName(final int distance, final String... names) {

		Npc perfectNpc = null;

		for (Npc npc : ctx.npcs.within(distance)) {

			for (String name : names) {

				if (npc.getName().equalsIgnoreCase(name)) {

					perfectNpc = npc;
					break;
				}
			}
		}
		return perfectNpc;
	}

}
