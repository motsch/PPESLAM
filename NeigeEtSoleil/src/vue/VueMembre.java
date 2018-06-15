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

import controler.Membre;
import modele.Modele;

@SuppressWarnings("serial")
public class VueMembre extends JPanel implements ActionListener
{
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtIdMembres = new JTextField();
	private JTextField txtNomMembres = new JTextField();
	private JTextField txtAdresseMembre = new JTextField();
	private JComboBox txtTelMembre = new JComboBox();
	private JPanel unPanel = new JPanel();
	//Déclaration d'une JTABLE
	private JTable tableMembres;
	public VueMembre()
	{
		this.setLayout(null);
		this.setBounds(50, 100, 600, 300);
		this.setBackground(Color.GREEN);
		
		//Construction du panel admin
		this.unPanel.setLayout(new GridLayout(3,4));
		this.unPanel.setBounds(20, 180, 550, 100);
		this.unPanel.add(new JLabel("Id Membre : "));
		this.unPanel.add(this.txtIdMembres);
		
		this.txtIdMembres.setEditable(false);
		
		this.unPanel.add(new JLabel("Nom Membre : "));
		this.unPanel.add(this.txtNomMembres);
		
		this.unPanel.add(new JLabel("Adresse Membre : "));
		this.unPanel.add(this.txtAdresseMembre);
		
		this.txtTelMembre.addItem("Reseau");
		this.txtTelMembre.addItem("Dev");
		this.unPanel.add(new JLabel("Type Membre : "));
		this.unPanel.add(this.txtTelMembre);
		
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
		String entetes [] ={"Id Membre", "Nom Membre", "Adresse Membre", "TelMembre Membre"};
		Object donnees [][] = this.remplirDonnees();
		this.tableMembres = new JTable(donnees, entetes);
		JScrollPane uneScroll = new JScrollPane(tableMembres);
		uneScroll.setBounds(20, 20, 550, 150);
		this.add(uneScroll);
		//ajout d'un événement souris sur les lignes de la table.
		this.tableMembres.addMouseListener(new MouseListener() {
			
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
				int ligne = tableMembres.getSelectedRow();
				txtIdMembres.setText(tableMembres.getValueAt(ligne, 0).toString());
				txtNomMembres.setText(tableMembres.getValueAt(ligne, 1).toString());
				txtAdresseMembre.setText(tableMembres.getValueAt(ligne, 2).toString());
				txtTelMembre.setSelectedItem(tableMembres.getValueAt(ligne, 3).toString());
			}
		});
		
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== this.btAjouter)
		{
			
			String nom = this.txtNomMembres.getText();
			String adresse = this.txtAdresseMembre.getText();
			String TelMembre = this.txtTelMembre.getSelectedItem().toString();
			if (nom.equals("")||adresse.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
			}
			else{
			//instanciation du Membre
			Membre unMembre = new Membre ();
			//Appel du modèle pour insérer un Membre dans la bdd
			Modele.insertMembre(unMembre);
			JOptionPane.showMessageDialog(this, "Insertion réussie!");
			}
			
		}else if (e.getSource()== this.btSupprimer)
		{
			
			if (txtIdMembres.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner l'ID Membre");
			}
			else
			{
				int idMembre = Integer.parseInt(this.txtIdMembres.getText());
				String nom = this.txtNomMembres.getText();
				String adresse = this.txtAdresseMembre.getText();
				String TelMembre = this.txtTelMembre.getSelectedItem().toString();
			//instanciation du Membre
			Membre unMembre = new Membre ();
			//Appel du modèle pour supprimer un Membre dans la bdd
			Modele.deleteMembre(unMembre);
			JOptionPane.showMessageDialog(this, "Suppression réussie!");
			}
		}else if (e.getSource()== this.btEditer)
		{
			
			if (txtIdMembres.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez renseigner l'ID Membre");
			}
			else
			{
				int idMembre = Integer.parseInt(this.txtIdMembres.getText());
				String nom = this.txtNomMembres.getText();
				String adresse = this.txtAdresseMembre.getText();
				String TelMembre = this.txtTelMembre.getSelectedItem().toString();
			
			//instanciation du Membre
			Membre unMembre = new Membre ();
			//Appel du modèle pour éditer un Membre dans la bdd
			Modele.updateMembre(unMembre);
			JOptionPane.showMessageDialog(this, "Edition réussie!");
			}
		}
		else if (e.getSource() == this.btAnnuler)
		{
			this.txtIdMembres.setText("");
			this.txtNomMembres.setText("");
			this.txtAdresseMembre.setText("");
		}
	}

	public Object[][] remplirDonnees()
	{
		ArrayList<Membre> LesMembres= Modele.selectAllCients();
		Object donnees [][] = new Object [LesMembres.size()][4];
		//On prends la taille de l'array pour connaitre les dimensions du tableau.
		
		int i = 0;
		for (Membre unMembre: LesMembres)
		{
			donnees[i][0] = unMembre.getIdMembre()+"";
			donnees[i][1] = unMembre.getNomMembre()+"";
			donnees[i][2] = unMembre.getAdresseMembre()+"";
			donnees[i][3] = unMembre.getTelMembre()+"";
			i++;
			
		}
		return donnees;
	}
}
