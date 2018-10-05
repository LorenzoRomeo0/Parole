package parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	ArrayList<String> parole;
	
	
		
	public Parole() {
		parole=new ArrayList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole=new ArrayList<String>();
	}
	
	public void delete(String p) {
		int index=parole.indexOf(p);
		if(index!=-1) 
			parole.remove(index);
	}
	

}
