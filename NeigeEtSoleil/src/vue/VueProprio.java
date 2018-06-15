package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controler.Tech;
import modele.Modele;

@SuppressWarnings("serial")
public class VueProprio extends JPanel implements ActionListener
{
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtIdtechs = new JTextField();
	private JTextField txtNomtechs = new JTextField();
	private JTextField txtAdressetech = new JTextField();
	private JComboBox txtcompétence = new JComboBox();
	private JPanel unPanel = new JPanel();
	//Déclaration d'une JTABLE
	private JTable tabletechs;
	public VueProprio()
	{
		this.setLayout(null);
		this.setBounds(50, 100, 600, 300);
		this.setBackground(Color.GREEN);
		
		//Construction du panel admin
		this.unPanel.setLayout(new GridLayout(3,4));
		this.unPanel.setBounds(20, 180, 550, 100);
		this.unPanel.add(new JLabel("Id tech : "));
		this.unPanel.add(this.txtIdtechs);
		
		this.txtIdtechs.setEditable(false);
		
		this.unPanel.add(new JLabel("Nom tech : "));
		this.unPanel.add(this.txtNomtechs);
		
		this.unPanel.add(new JLabel("Adresse tech : "));
		this.unPanel.add(this.txtAdressetech);
		
		this.txtcompétence.addItem("Reseau");
		this.txtcompétence.addItem("Dev");
		this.unPanel.add(new JLabel("Type tech : "));
		this.unPanel.add(this.txtcompétence);
		
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btAjouter);
		this.unPanel.add(this.btSupprimer);
		this.unPanel.add(this.btEditer);
		
		this.unPanel.setVisible(true);
		this.add(unPanel);
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		
		//Insertion de la table dans la fenêtre.
		String entetes [] ={"Id tech", "Nom tech", "Adresse tech", "compétence tech"};
		Object donnees [][] = this.remplirDonnees();
		this.tabletechs = new JTable(donnees, entetes);
		JScrollPane uneScroll = new JScrollPane(tabletechs);
		uneScroll.setBounds(20, 20, 550, 150);
		this.add(uneScroll);
		//ajout d'un événement souris sur les lignes de la table.
		this.tabletechs.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//Récupération de la ligne
				int ligne = tabletechs.getSelectedRow();
				txtIdtechs.setText(tabletechs.getValueAt(ligne, 0).toString());
				txtNomtechs.setText(tabletechs.getValueAt(ligne, 1).toString());
				txtAdressetech.setText(tabletechs.getValueAt(ligne, 2).toString());
				txtcompétence.setSelectedItem(tabletechs.getValueAt(ligne, 3).toString());
			}
		});
		
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== this.btAjouter)
		{
			
			String nom = this.txtNomtechs.getText();
			String adresse = this.txtAdressetech.getText();
			String compétence = this.txtcompétence.getSelectedItem().toString();
			if (nom.equals("")||adresse.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
			}
			else{
			//instanciation du tech
			Tech untech = new Tech (nom, adresse, compétence);
			//Appel du modèle pour insérer un tech dans la bdd
			Modele.inserttech(untech);
			JOptionPane.showMessageDialog(this, "Insertion réussie!");
			}
			
		}else if (e.getSource()== this.btSupprimer)
		{
			
			if (txtIdtechs.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner l'ID tech");
			}
			else
			{
				int idtech = Integer.parseInt(this.txtIdtechs.getText());
				String nom = this.txtNomtechs.getText();
				String adresse = this.txtAdressetech.getText();
				String compétence = this.txtcompétence.getSelectedItem().toString();
			//instanciation du tech
			Tech untech = new Tech (idtech, nom, adresse, compétence);
			//Appel du modèle pour supprimer un tech dans la bdd
			Modele.deletetech(untech);
			JOptionPane.showMessageDialog(this, "Suppression réussie!");
			}
		}else if (e.getSource()== this.btEditer)
		{
			
			if (txtIdtechs.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner l'ID tech");
			}
			else
			{
				int idtech = Integer.parseInt(this.txtIdtechs.getText());
				String nom = this.txtNomtechs.getText();
				String adresse = this.txtAdressetech.getText();
				String compétence = this.txtcompétence.getSelectedItem().toString();
			
			//instanciation du tech
			Tech untech = new Tech (idtech, nom, adresse, compétence);
			//Appel du modèle pour éditer un tech dans la bdd
			Modele.updatetech(untech);
			JOptionPane.showMessageDialog(this, "Edition réussie!");
			}
		}
		else if (e.getSource() == this.btAnnuler)
		{
			this.txtIdtechs.setText("");
			this.txtNomtechs.setText("");
			this.txtAdressetech.setText("");
		}
	}

	public Object[][] remplirDonnees()
	{
		ArrayList<Tech> Lestechs= Modele.selectAllTechs();
		Object donnees [][] = new Object [Lestechs.size()][4];
		//On prends la taille de l'array pour connaitre les dimensions du tableau.
		
		int i = 0;
		for (Tech untech: Lestechs)
		{
			donnees[i][0] = untech.getIdtech()+"";
			donnees[i][1] = untech.getNom()+"";
			donnees[i][2] = untech.getAdresse()+"";
			donnees[i][3] = untech.getcompétence()+"";
			i++;
			
		}
		return donnees;
	}
}
