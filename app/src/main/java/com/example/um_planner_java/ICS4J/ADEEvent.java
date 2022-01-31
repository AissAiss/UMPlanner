package com.example.um_planner_java.ICS4J;
public class ADEEvent implements Comparable<ADEEvent>{
	//DTSTART     : 2021 09 16 T 11 15 00Z    Date de début + Heure de début
	//DTEND       : 2021 09 16 T 12 45 00Z    Heure de fin.  
	//SUMMARY     : HAI708I                   Code de l'UE
	//LOCATION    : SC36.09                   Salle 
	//DESCRIPTION : Récupérer ce qu'on peut....
	
	// TODO : Refaire les get avec les noms plus précis
	// TODO : Mieux découper les informations. 
	private ADEDate 	DTSTART;
	private ADEDate 	DTEND;  
	private String 	SUMMARY; 
	private String 	LOCATION; 
	private String  DESCRIPTION;
	
	public ADEEvent(ADEDate DTSTART, 
					ADEDate DTEND, 
					String SUMMARY, 
					String LOCATION, 
					String DESCRIPTION) {
		super();
		this.DTSTART = DTSTART;
		this.DTEND = DTEND;
		this.SUMMARY = SUMMARY;
		this.LOCATION = LOCATION;
		this.DESCRIPTION = DESCRIPTION;
	}

	public ADEDate getDTSTART() {
		return DTSTART;
	}

	public ADEDate getDTEND() {
		return DTEND;
	}

	public String getSUMMARY() {
		return SUMMARY;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	@Override
	public String toString() {
		return "ADEEvent [\n" + 
				"\t" + DTSTART 		+ "\n" + 
				"\t" + DTEND 		+ "\n" + 
				"\t" + SUMMARY 		+ "\n" + 
				"\t" + LOCATION 	+ "\n" + 
				"\t" + DESCRIPTION 	+ "]";
	}

	@Override
	public int compareTo(ADEEvent o) {
		// TODO Auto-generated method stub
		return this.getDTSTART().compareTo(o.getDTSTART());
	} 
	
	
}
