package com.example.um_planner_java.ICS4J;
public class ADEEvent implements Comparable<ADEEvent>{	
	private ADEDate 	DTSTART;
	private ADEDate 	DTEND;  
	
	private String Summary; 
	private String Location; 
	private String Description; 
	
	public ADEEvent(ADEDate DTSTART, 
					ADEDate DTEND, 
					String SUMMARY, 
					String LOCATION, 
					String DESCRIPTION) {
		super();
		this.DTSTART 		= DTSTART;
		this.DTEND 			= DTEND;
		// TODO : Améliorer le traitement des strings pour éviter les coquilles. 
		this.Summary 		= SUMMARY.replace("SUMMARY:", "").replace("\\n", "").replace("\\", ""); 
		this.Location 		= LOCATION.replace("LOCATION:", ""); 
		this.Description 	= DESCRIPTION.replace("DESCRIPTION:", "").replace("\\n", " ").replace("\\", ""); 
	}

	public ADEDate getDTSTART() {
		return DTSTART;
	}

	public ADEDate getDTEND() {
		return DTEND;
	}

	
	public String getSummary() {
		return this.Summary;
	}

	
	public String getLocation() {
		return this.Location;
	}

	
	public String getDescription() {
		// TODO : Mettre en forme la description
		return this.Description;
	}

	@Override
	public String toString() {
		return "ADEEvent [\n" + 
				"\t" + DTSTART 		+ "\n" + 
				"\t" + DTEND 		+ "\n" + 
				"\t" + Summary 		+ "\n" + 
				"\t" + Location 	+ "\n" + 
				"\t" + Description 	+ "]";
	}

	@Override
	public int compareTo(ADEEvent o) {
		// TODO Auto-generated method stub
		return this.getDTSTART().compareTo(o.getDTSTART());
	} 
	
	
}
