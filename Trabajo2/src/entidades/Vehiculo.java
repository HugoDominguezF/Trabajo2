package entidades;

import excepciones.ExcepcionMatricula;

public class Vehiculo implements Comparable<Vehiculo> {

	String matricula;
	String marca;
	String modelo;
	boolean alquilado;

	public Vehiculo(String matricula, String marca, String modelo, boolean alquilado) throws ExcepcionMatricula {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new ExcepcionMatricula("La matrícula no puede ser nula ni estar vacía.");
        }else {
        	this.matricula = matricula;
        }


        this.marca = marca;
        this.modelo = modelo;
        this.alquilado = alquilado;
    }
	
	public String getMatricula() {
		return matricula;
	}
	
	public boolean isAlquilado() {
		return alquilado;
	}
	
	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	

	@Override
	public String toString() {

		if (alquilado) {
			return matricula + " " + marca + " " + modelo + " No Disponible";
		} else {
			return matricula + " " + marca + " " + modelo + " Disponible";

		}

	}

	@Override
	public boolean equals(Object obj) {

		Vehiculo nuevo = (Vehiculo) obj;

		return matricula == nuevo.matricula;
	}

	@Override
	public int compareTo(Vehiculo o) {
		if (marca != o.marca) {
			return marca.compareTo(o.marca);
		} else {
			return modelo.compareTo(o.modelo);
		}
	}

}
