package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controler.Main;

@SuppressWarnings("serial")
public class VueGenerale extends JFrame implements ActionListener {
	
	private JPanel panelMenu = new JPanel();
	private JButton tabButtons [] = new JButton[4];
	private String tab[] = {"Clients", "Interventions", "Techniciens", "Quitter"};
	
	//instanciation des panels
	
	private VueMembre uneVueClients = new VueMembre();
	private VueAppart uneVueAppart = new VueAppart();
	private VueProprio uneVueProprio = new VueProprio();
	private VueContrats uneVueContrats = new VueContrats();


	// Le constructeur
	public VueGenerale()
	{
		this.setTitle("Logiciel de gestion des interventions");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(200, 200, 700, 500);
		this.getContentPane().setBackground(Color.gray);
		
		//Construction du panel menu
		this.panelMenu.setBounds(0, 20, 700, 30);
		this.panelMenu.setLayout(new GridLayout(1, 4));
		//Construction des boutons. Crée un tableau puis pour chaque entrée leur assigne leur package bouton complet.
		for (int i =0; i<this.tabButtons.length; i++)
		{
			this.tabButtons[i] = new JButton(this.tab[i]);
			this.panelMenu.add(this.tabButtons[i]);
			this.tabButtons[i].addActionListener(this);
		}
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		//Ajout des panels
		this.add(this.uneVueClients);
		this.add(this.uneVueAppart);
		this.add(this.uneVueProprio);
		this.add(this.uneVueContrats);
		
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Clients":
			this.uneVueClients.setVisible(true);
			this.uneVueAppart.setVisible(false);
			this.uneVueProprio.setVisible(false);
			this.uneVueContrats.setVisible(false);
		break;
		case "Appartement":
			this.uneVueClients.setVisible(false);
			this.uneVueAppart.setVisible(true);
			this.uneVueProprio.setVisible(false);
			this.uneVueContrats.setVisible(false);
			break;
		case "Proprietaires":
			this.uneVueClients.setVisible(false);
			this.uneVueAppart.setVisible(false);
			this.uneVueProprio.setVisible(true);
			this.uneVueContrats.setVisible(false);
			break;
		case "Contrats":
			this.uneVueClients.setVisible(false);
			this.uneVueAppart.setVisible(false);
			this.uneVueProprio.setVisible(true);
			this.uneVueContrats.setVisible(true);
			break;
		case "Quitter":
			this.dispose();
			Main.rendreVisible(true);
			break;
		}
		
	}

}
