package controler;

import vue.VueConnexion;

public class Main {
	//R�cup�re le visuel du package vue
	public static VueConnexion uneVueConnexion;
	
	public static void rendreVisible (boolean action)
	{
		Main.uneVueConnexion.setVisible(action);
	}
	
	public static void main(String[] args) 
	{
		Main.uneVueConnexion = new VueConnexion();

	}

}
