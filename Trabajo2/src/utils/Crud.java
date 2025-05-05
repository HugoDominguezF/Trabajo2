package utils;

import java.io.*;
import java.util.TreeSet;

import entidades.Vehiculo;

public class Crud {

	TreeSet<Vehiculo> lista = new TreeSet<Vehiculo>();

	public void añadirCoche(Vehiculo o) {
		lista.add(o);
	}

	public String buscarCoche(Vehiculo o) {

		String datos = null;

		for (Vehiculo vehiculo : lista) {
			if (o.equals(vehiculo)) {
				datos = vehiculo.toString();
			}
		}
		return datos;

	}

	public void listarCoche() {
		System.out.println(lista);
	}
	public boolean alquilarCoche(String matricula) {
		
		boolean sePudo=false;
		
		for (Vehiculo vehiculo : lista) {
			if(vehiculo.getMatricula()==matricula && !vehiculo.isAlquilado()) {
				vehiculo.setAlquilado(true);
				sePudo=true;
			}
		}
		return sePudo;
	}
	public boolean devolverCoche(String matricula) {
		
		boolean sePudo=false;
		
		for (Vehiculo vehiculo : lista) {
			if(vehiculo.getMatricula()==matricula && vehiculo.isAlquilado()) {
				vehiculo.setAlquilado(false);
				sePudo=true;
			}
		}
		return sePudo;
	}
	public void guardar() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ficheros\\Vehiculos.txt"));
			
			for (Vehiculo vehiculo : lista) {
				bw.write(vehiculo.toString());
				bw.flush();
			}
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
