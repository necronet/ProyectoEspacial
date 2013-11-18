package com.atech.proyectoespacial;

public abstract class Enemigo implements Objetivo{

	private String nombre;
	
	public abstract String getNombre();
	
	@Override
	public boolean disparar(Objetivo objetivo) {

		int resultado = ((int) (Math.random() * 15));
		
		return resultado < probabilidadDeGolpe();
	}
	
	public static class Soldado extends Enemigo {

		@Override
		public int probabilidadDeGolpe() {
			return 1;
		}

		@Override
		public String getNombre() {
			return "Soldado";
		}
		
	}
	
	public static class Tanque extends Enemigo {

		@Override
		public int probabilidadDeGolpe() {
			return 2;
		}

		@Override
		public String getNombre() {
			return "Tanqueta";
		}
		
	}
	
	public static class LanzaCohetes extends Enemigo {

		@Override
		public int probabilidadDeGolpe() {
			return 4;
		}

		@Override
		public String getNombre() {
			return "Lanza Cohetes";
		}
		
	}
	

	
}
