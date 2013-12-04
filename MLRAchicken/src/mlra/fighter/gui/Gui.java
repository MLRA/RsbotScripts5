package mlra.fighter.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import mlra.fighter.nodes.LootingFeathers;

public class Gui extends JFrame {

	private JButton btnStartScript;
	private JCheckBox lootFeathersBox;
	private static final long serialVersionUID = 1L;
	private static final String SCRIPT_NAME = "MLRAchicken";

	public Gui() {

		super(SCRIPT_NAME);

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(250, 250);

		lootFeathersBox = new JCheckBox("Loot Feathers");
		add(lootFeathersBox);

		btnStartScript = new JButton("Start script !");
		add(btnStartScript);

		btnStartScript.addActionListener(new Handler());
		setResizable(false);
		setVisible(true);

	}

	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(btnStartScript)) {

				LootingFeathers.lootFeather = lootFeathersBox.isSelected();

			}
			setVisible(false);
			System.out.println("Script started!");
		}

	}

}
