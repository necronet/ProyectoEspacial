package com.atech.proyectoespacial;

public abstract class Nave implements Objetivo {

	@Override
	public boolean disparar(Objetivo objetivo) {

		int resultado = ((int) (Math.random() * 10));
		
		return resultado < probabilidadDeGolpe();
	}


	public static class Basica extends Nave {

	
		@Override
		public int probabilidadDeGolpe() {
			return 9;
		}
	}
	
	public static class Platillo extends Nave {

		@Override
		public int probabilidadDeGolpe() {
			return 7;
		}


	}
	
	public static class Bombardero extends Nave {
		
		@Override
		public int probabilidadDeGolpe() {
			return 5;
		}


	}



}
