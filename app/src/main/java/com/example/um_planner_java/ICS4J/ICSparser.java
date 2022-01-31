package com.example.um_planner_java.ICS4J;
import java.io.File;

public class ICSparser {
	// Faire une classe static avec une seule méthode
	// qui renvois directement le calendrier correspondant
	// au fichier passer en paramètre
	
	static public ADECalendar getADECalendar(File file){
		return new ADECalendar(file);
	}
}