package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PaisData {
	
	private ArrayList<Pais>paises;
	
	public PaisData() throws NumberFormatException, IOException{
		paises = new ArrayList<>();
		readInfo();
	}
	
	public void ordenar() {
		Collections.sort(paises);
	}
	
	public void addPais(Pais pais) {
		paises.add(pais);
		
	}
	
	public void readInfo() throws NumberFormatException, IOException {
		String path = "..\\Seguimiento8Apo\\src\\Entradas.txt";
		
		File file = new File(path);
		
		FileInputStream fis = new FileInputStream(file);
		
		//BufferedReader 
		
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(isr);
		
		
		
		String line = null;
		int [] medalla;
		medalla = new int [6];
		
		while((line = reader.readLine()) != null){
			String []data = line.split(";");
			for(int i = 1; i<7; i++) {
				medalla[i-1] = Integer.parseInt(data[i]); 
				addPais(new Pais(data[0],medalla[0],medalla[1],medalla[2],medalla[3],medalla[4],medalla[5]));
			}
		}
	}
	public void bubbleSort() {
		for(int i = 0; i<paises.size()-1;i++) {
			for (int j=0; j<paises.size()-1; j++) {
				int OroA = paises.get(j).getOroMujer()+paises.get(j).getOroHombre();
				int OroB = paises.get(j+1).getOroMujer()+paises.get(j+1).getOroHombre();
				
				if(OroA == OroB ) {
					int PlataA = paises.get(j).getPlataMujer()+paises.get(j).getPlataHombre();
					int PlataB = paises.get(j+1).getPlataMujer()+paises.get(j+1).getPlataHombre();
					
					if(PlataA == PlataB) {
						int BronceA = paises.get(j).getBronceMujer()+paises.get(j).getBronceHombre();
						int BronceB = paises.get(j+1).getBronceMujer()+paises.get(j+1).getBronceHombre();
						
						if(BronceA == BronceB) {
							int x = paises.get(j).getName().compareTo(paises.get(j).getName());
							if(x==-1) {
								Collections.swap(paises, j, j+1);
							}
						}else {
							if (BronceA<BronceB) {
								Collections.swap(paises, j, j+1);
							}
						}
						
						}else {
							if(PlataA<PlataB) {
								Collections.swap(paises, j, j+1);
							}
						}
					}else {
						if(OroA<OroB) {
							Collections.swap(paises, j, j+1);
						}
					}
					
				}
				}
	}
	
	public void manCompare() {
		Collections.sort(paises, new Comparator<Pais>(){

			@Override
			public int compare(Pais o1, Pais o2) {
				if(o1.getOroHombre()-o2.getOroHombre() == 0) {
					if (o1.getPlataHombre()-o2.getPlataHombre() == 0) {
						if (o1.getBronceHombre()-o2.getBronceHombre() == 0) {
							return o1.getName().compareTo(o2.getName());
						} else {
							return (o1.getBronceHombre()-o2.getBronceHombre());
						}
					} else {
						return (o1.getPlataHombre()-o2.getPlataHombre());
					}
				} else { 
					return (o1.getOroHombre()-o2.getOroHombre());
				}
				
			};
			
		});
	}
	
	public void tostring() {
		
		manCompare();
		System.out.println("Masculino");
		for(Pais p: paises) {
			System.out.println(p.getName()+" "+p.getOroHombre()+" "+p.getPlataHombre()+" "+p.getBronceHombre());
		}
		
		System.out.println("");
		System.out.println("----------");
		System.out.println("Femenino");
		Collections.sort(paises);
		
		for (Pais p: paises) {
			
			System.out.println(p.getName()+" "+p.getOroMujer()+" "+p.getPlataMujer()+" "+p.getBronceMujer());
		}
		
		System.out.println("");
		System.out.println("----------");
		System.out.println("Combinado");
		bubbleSort();
		for (Pais p: paises) {
			int oro = p.getOroHombre()+p.getOroMujer();
			int plata = p.getPlataMujer()+p.getPlataHombre();
			int bronce = p.getBronceMujer()+p.getBronceHombre();
			System.out.println(p.getName()+" "+oro+" "+plata+" "+bronce);
		}
	} 
	
	
	
	
	
	
}
