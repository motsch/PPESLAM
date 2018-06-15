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

import controler.Appartement;
import modele.Modele;

@SuppressWarnings("serial")
public class VueAppart extends JPanel implements ActionListener
{
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtIdAppartements = new JTextField();
	private JTextField txtNomAppartements = new JTextField();
	private JTextField txtAdresseAppartement = new JTextField();
	private JComboBox txtcompétence = new JComboBox();
	private JPanel unPanel = new JPanel();
	//Déclaration d'une JTABLE
	private JTable tableAppartements;
	public VueAppart()
	{
		this.setLayout(null);
		this.setBounds(50, 100, 600, 300);
		this.setBackground(Color.GREEN);
		
		//Construction du panel admin
		this.unPanel.setLayout(new GridLayout(3,4));
		this.unPanel.setBounds(20, 180, 550, 100);
		this.unPanel.add(new JLabel("Id Appartement : "));
		this.unPanel.add(this.txtIdAppartements);
		
		this.txtIdAppartements.setEditable(false);
		
		this.unPanel.add(new JLabel("Nom Appartementement : "));
		this.unPanel.add(this.txtNomAppartements);
		
		this.unPanel.add(new JLabel("Adresse : "));
		this.unPanel.add(this.txtAdresseAppartement);
		
		this.txtcompétence.addItem("Reseau");
		this.txtcompétence.addItem("Dev");
		this.unPanel.add(new JLabel("Type Appartement : "));
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
		String entetes [] ={"Id Appartement", "CP Appartement", "Adresse Appartement", "Prix Appartement"};
		Object donnees [][] = this.remplirDonnees();
		this.tableAppartements = new JTable(donnees, entetes);
		JScrollPane uneScroll = new JScrollPane(tableAppartements);
		uneScroll.setBounds(20, 20, 550, 150);
		this.add(uneScroll);
		//ajout d'un événement souris sur les lignes de la table.
		this.tableAppartements.addMouseListener(new MouseListener() {
			
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
				int ligne = tableAppartements.getSelectedRow();
				txtIdAppartements.setText(tableAppartements.getValueAt(ligne, 0).toString());
				txtNomAppartements.setText(tableAppartements.getValueAt(ligne, 1).toString());
				txtAdresseAppartement.setText(tableAppartements.getValueAt(ligne, 2).toString());
				txtcompétence.setSelectedItem(tableAppartements.getValueAt(ligne, 3).toString());
			}
		});
		
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== this.btAjouter)
		{
			
			String nom = this.txtNomAppartements.getText();
			String adresse = this.txtAdresseAppartement.getText();
			String compétence = this.txtcompétence.getSelectedItem().toString();
			if (nom.equals("")||adresse.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
			}
			else{
			//instanciation du Appartement
			Appartement unAppartement = new Appartement ();
			//Appel du modèle pour insérer un Appartement dans la bdd
			Modele.insertAppartement(unAppartement);
			JOptionPane.showMessageDialog(this, "Insertion réussie!");
			}
			
		}else if (e.getSource()== this.btSupprimer)
		{
			
			if (txtIdAppartements.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner l'ID Appartement");
			}
			else
			{
				int idAppartement = Integer.parseInt(this.txtIdAppartements.getText());
				String nom = this.txtNomAppartements.getText();
				String adresse = this.txtAdresseAppartement.getText();
				String compétence = this.txtcompétence.getSelectedItem().toString();
			//instanciation du Appartement
			Appartement unAppartement = new Appartement ();
			//Appel du modèle pour supprimer un Appartement dans la bdd
			Modele.deleteAppartement(unAppartement);
			JOptionPane.showMessageDialog(this, "Suppression réussie!");
			}
		}else if (e.getSource()== this.btEditer)
		{
			
			if (txtIdAppartements.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner l'ID Appartement");
			}
			else
			{
				int idAppartement = Integer.parseInt(this.txtIdAppartements.getText());
				String nom = this.txtNomAppartements.getText();
				String adresse = this.txtAdresseAppartement.getText();
				String compétence = this.txtcompétence.getSelectedItem().toString();
			
			//instanciation du Appartement
			Appartement unAppartement = new Appartement ();
			//Appel du modèle pour éditer un Appartement dans la bdd
			Modele.updateAppartement(unAppartement);
			JOptionPane.showMessageDialog(this, "Edition réussie!");
			}
		}
		else if (e.getSource() == this.btAnnuler)
		{
			this.txtIdAppartements.setText("");
			this.txtNomAppartements.setText("");
			this.txtAdresseAppartement.setText("");
		}
	}

	public Object[][] remplirDonnees()
	{
		ArrayList<Appartement> LesAppartements= Modele.selectAllAppartements();
		Object donnees [][] = new Object [LesAppartements.size()][4];
		//On prends la taille de l'array pour connaitre les dimensions du tableau.
		
		int i = 0;
		for (Appartement unAppartement: LesAppartements)
		{
			donnees[i][0] = unAppartement.getIdAppartement()+"";
			donnees[i][1] = unAppartement.getCPAppartement()+"";
			donnees[i][2] = unAppartement.getAdresseAppartement()+"";
			donnees[i][3] = unAppartement.getPrixAppartement()+"";
			i++;
			
		}
		return donnees;
	}
}
