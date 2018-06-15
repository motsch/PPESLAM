package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controler.Appartement;
import controler.Membre;
import controler.Reservation;

public class Modele 
{
	public static String verifConnexion (String login, String mdp)
	{
		String IDRep="";
		String requete = " select count(*) as nb, IDRepre from representant where NomRepre='"+login+"' and "
				+ " mdprepre = '"+mdp+"';";
		Bdd uneBdd = new Bdd ("localhost", "dbns", "root", "");
		try
		{
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int nb = unRes.getInt("nb");
				if (nb > 0)
				{
					IDRep = unRes.getString("IDRep");
				}
			}
			unStat.close();
			unRes.close();
			uneBdd.seConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		catch (NullPointerException exp)
		{
			System.out.println("Erreur Connexion BDD non fonctionnelle");
		}
		return IDRep;
	}
	// Modele Membre
		public static ArrayList<Membre> selectAllCients()
		{
			ArrayList<Membre> lesMembres = new ArrayList<Membre>();
			String requete = "Select * from Membre;";
			Bdd uneBdd = new Bdd ("localhost", "dbns", "root", "");
			try{
				uneBdd.seConnecter();
				Statement unStat= uneBdd.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next())
					{ 
						int idMembre = unRes.getInt("idMembre");
						String nom = unRes.getString("nom");
						String adresse = unRes.getString("adresse");
						String typeMembre = unRes.getString("typeMembre");
						Membre unMembre = new Membre ();
						lesMembres.add(unMembre);
								
					}
				unStat.close();
				unRes.close();
				uneBdd.seDeConnecter();

			
				}
			catch (SQLException exp)
				{
				System.out.println("Erreur :"+ requete);
				}
			catch (NullPointerException exp)
				{
					System.out.println("Erreur Connexion BDD non fonctionnelle");
				}
			return lesMembres;
		}
		
		public static Membre selectWhereMembre (Membre unMembre)
		{
			Membre leMembre = null;
			String requete = "select idMembre from Membre where nom='"+unMembre.getNomMembre()+"'and adresse='"+unMembre.getAdresseMembre()+"'and typeMembre='"+unMembre.getTelMembre()+"';" ;
			Bdd uneBdd = new Bdd ("localhost", "dbns", "root", "");
			try{
				uneBdd.seConnecter();
				Statement unStat= uneBdd.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next())
					{ 
						int idMembre = unRes.getInt("idMembre");
						 leMembre = new Membre ();
								
					}
				unStat.close();
				unRes.close();
				uneBdd.seDeConnecter();
				}
				catch (SQLException exp)
				{
				System.out.println("Erreur :"+ requete);
				}
				return leMembre;
		}
		
		public static void insertMembre(Membre unMembre)
		{
			String requete = "insert into Membre values (null, '"+ unMembre.getNomMembre()+"','" + unMembre.getAdresseMembre()+"','"+unMembre.getTelMembre()+"');";
			execRequete(requete);
		}
		public static void updateMembre(Membre unMembre)
		{
			String requete = "update Membre set nom='"+ unMembre.getNomMembre()+"', adresse ='" + unMembre.getAdresseMembre()+"', typeMembre = '"+unMembre.getTelMembre()+"');";
			execRequete(requete);
		}
		public static void deleteMembre(Membre unMembre)
		{
			String requete = "delete from Membre where idMembre=" + "unMembre.getMembre()"+";";
			execRequete(requete);
		}
		private static void execRequete (String requete)
		{
			Bdd uneBdd = new Bdd ("localhost", "dbns", "root", "");
			try{
				uneBdd.seConnecter();
				Statement unStat= uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close();
				uneBdd.seDeConnecter();
			}
			catch (SQLException exp)
			{
			System.out.println("Erreur :"+ requete);
			}
			catch (NullPointerException exp)
			{
				System.out.println("Erreur Connexion BDD non fonctionnelle");
			}
		}
		
		// Modele Appartement
			public static ArrayList<Appartement> selectAllAppartements()
			{
				ArrayList<Appartement> lesAppartements = new ArrayList<Appartement>();
				String requete = "Select * from Appartement;";
				Bdd uneBdd = new Bdd ("localhost", "dbns", "root", "");
				try{
					uneBdd.seConnecter();
					Statement unStat= uneBdd.getMaConnexion().createStatement();
					ResultSet unRes = unStat.executeQuery(requete);
					if (unRes.next())
						{ 
							int idAppartement = unRes.getInt("idAppartement");
							String nom = unRes.getString("nom");
							String adresse = unRes.getString("adresse");
							String compétence = unRes.getString("compétence");
							Appartement unAppartement = new Appartement ();
							lesAppartements.add(unAppartement);
									
						}
					unStat.close();
					unRes.close();
					uneBdd.seDeConnecter();

				
					}
				catch (SQLException exp)
					{
					System.out.println("Erreur :"+ requete);
					}
				catch (NullPointerException exp)
					{
						System.out.println("Erreur Connexion BDD non fonctionnelle");
					}
				return lesAppartements;
			}
			public static void insertAppartement(Appartement unAppartement)
			{
				String requete = "insert into Appartement values (null, '"+ unAppartement.getCPAppartement()+"','" + unAppartement.getAdresseAppartement()+"','"+unAppartement.getPrixAppartement()+"');";
				execRequete(requete);
			}
			public static void updateAppartement(Appartement unAppartement)
			{
				String requete = "update Appartement set nom='"+ unAppartement.getCPAppartement()+"','" + unAppartement.getAdresseAppartement()+"','"+unAppartement.getPrixAppartement()+"');";
				execRequete(requete);
			}
			public static void deleteAppartement(Appartement unAppartement)
			{
				String requete = "delete from Appartement where idAppartement=" + "unAppartement.getAppartement()"+";";
				execRequete(requete);
			}
			
			// Modele Reservation
						public static ArrayList<Reservation> selectAllReservations()
						{
							ArrayList<Reservation> lesReservations = new ArrayList<Reservation>();
							String requete = "Select * from Reservation;";
							Bdd uneBdd = new Bdd ("localhost", "dbns", "root", "");
							try{
								uneBdd.seConnecter();
								Statement unStat= uneBdd.getMaConnexion().createStatement();
								ResultSet unRes = unStat.executeQuery(requete);
								if (unRes.next())
									{ 
										int idReservation = unRes.getInt("idReservation");
										String nom = unRes.getString("nom");
										String adresse = unRes.getString("adresse");
										String compétence = unRes.getString("compétence");
										Reservation unReservation = new Reservation ();
										lesReservations.add(unReservation);
												
									}
								unStat.close();
								unRes.close();
								uneBdd.seDeConnecter();

							
								}
							catch (SQLException exp)
								{
								System.out.println("Erreur :"+ requete);
								}
							catch (NullPointerException exp)
								{
									System.out.println("Erreur Connexion BDD non fonctionnelle");
								}
							return lesReservations;
						}
						public static void insertReservation(Reservation unReservation)
						{
							String requete = "insert into Reservation values (null, '"+ unReservation.getIdResa()+"','" + unReservation.getIdLogement()+"','"+unReservation.getMontant()+"');";
							execRequete(requete);
						}
						public static void updateReservation(Reservation unReservation)
						{
							String requete = "update Reservation set IdResa='"+ unReservation.getIdResa()+"', idLogement ='" + unReservation.getIdLogement()+"', montant = '"+unReservation.getMontant()+"');";
							execRequete(requete);
						}
						public static void deleteReservation(Reservation unReservation)
						{
							String requete = "delete from Reservation where idReservation=" + "unReservation.getReservation()"+";";
							execRequete(requete);
						}
						

}
