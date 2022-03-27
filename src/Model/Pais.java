package Model;

public class Pais implements Comparable<Pais> {
	
	private String name;
	private int oroHombre;
	private int oroMujer;
	private int plataHombre;
	private int plataMujer;
	private int bronceHombre;
	private int bronceMujer;
	
	
	
	public Pais(String name, int oroHombre,  int plataHombre,  int bronceHombre,int oroMujer,int plataMujer,
			int bronceMujer) {
		
		this.name = name;
		this.oroHombre = oroHombre;
		this.oroMujer = oroMujer;
		this.plataHombre = plataHombre;
		this.plataMujer = plataMujer;
		this.bronceHombre = bronceHombre;
		this.bronceMujer = bronceMujer;
		
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getOroHombre() {
		return oroHombre;
	}
	
	public void setOroHombre(int oroHombre) {
		this.oroHombre = oroHombre;
	}
	
	public int getOroMujer() {
		return oroMujer;
	}
	
	public void setOroMujer(int oroMujer) {
		this.oroMujer = oroMujer;
	}
	
	public int getPlataHombre() {
		return plataHombre;
	}
	
	public void setPlataHombre(int plataHombre) {
		this.plataHombre = plataHombre;
	}
	
	public int getPlataMujer() {
		return plataMujer;
	}
	
	public void setPlataMujer(int plataMujer) {
		this.plataMujer = plataMujer;
	}
	
	public int getBronceHombre() {
		return bronceHombre;
	}
	
	public void setBronceHombre(int bronceHombre) {
		this.bronceHombre = bronceHombre;
	}
	
	public int getBronceMujer() {
		return bronceMujer;
	}
	
	public void setBronceMujer(int bronceMujer) {
		this.bronceMujer = bronceMujer;
	}
	
	public int compareTo(Pais o) {
		
		Pais A = this;
		Pais B = o;
		
		int output = A.oroMujer - B.oroMujer;
		if(output == 0) {
			int plataOutput = B.plataMujer - A.plataMujer;
			if(plataOutput == 0) {
				int bronceOutput = B.bronceMujer - A.bronceMujer;
				if(bronceOutput == 0) {
					return (A.getName().compareTo(B.getName()));
				}else {
					return bronceOutput;
				}
			}else {
				return plataOutput;
			}
			
		}else {
			return output;
		}
		
	}
	

}
