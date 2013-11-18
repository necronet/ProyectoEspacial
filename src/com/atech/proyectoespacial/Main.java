package com.atech.proyectoespacial;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		String resultado ;
		Scanner scanner = new Scanner(System.in);
		
		do {

			System.out.print("Bienvenido a Atech Proyecto Espacial\n");
			
			System.out.print("[N] Nuevo juego\n");
			System.out.print("[q] Salir\n");
			System.out.print("[2] Acerca de\n");
		
			resultado = scanner.next();
			
			if (resultado.equals("N")) {
				//nuevo juego
				nuevoJuego(scanner, new Nivel(1));
			} else if (resultado.equals("2")) {
				System.out.print("Creado por Yasser Membreno y Jose Ayerdis");
			}
			
		}while (!resultado.equalsIgnoreCase("q"));
		
	}
	
	private static void nuevoJuego(Scanner scanner, Nivel nivel) {
		
	
	   System.out.print(String.format("****BIENVENIDOS AL NIVEL %s*****\n", nivel.getNivel() ));
	   System.out.print("Seleccione el numero para destruir al enemigo\n");
	
       List<Objetivo> enemigos = nivel.getObjetivos();
       
       int objetivo;
       do{
       
	       for(int i=0; i < enemigos.size() ; i++) {
	    	   System.out.println("["+(i+1)+"] " + ((Enemigo)enemigos.get(i)).getNombre());
	       }
	       
	       System.out.print("[q] Salir\n");
	       
	       objetivo = scanner.nextInt();
	       
	       boolean exito = nivel.getNave().disparar(enemigos.get(objetivo-1));
	       
	       if (exito) {
	    	   enemigos.remove(objetivo-1);
	    	   System.out.print("Objetivo destruido con exito\n");   
	    	   continue;
	       } else {
	    	   Enemigo enemigo = (Enemigo)enemigos.get(objetivo-1);
	    	   System.out.print(String.format("Enemigo: \"Has fallado en destruir %s\"\n", enemigo.getNombre()));
	       }
	       
	       for(Objetivo enemigo : enemigos)  {
	    	   exito = enemigo.disparar(nivel.getNave());
	           if (exito) {
	        	   System.out.print(String.format("El enemigo %s te ha eliminado\nFin de la partida \n", ((Enemigo)enemigo).getNombre() ));
	        	   break;
	           }
	       }
	   
	       if (exito) {
	    	   break;
	       } else {
	    	   System.out.print("Has esquivado todos los ataques tu turno!!! \n");
	       }
	       
       }while (enemigos.size() > 0);
	   
		if(enemigos.size() == 0 ) {
			
			if (nivel.getNivel()+1 == 4) {
				System.out.println("Has finalizado todo los niveles con exito felicidades");
				return;
			} else {
				nuevoJuego(scanner, new Nivel(nivel.getNivel()+1));
			}

		}
       
	   
		
	}
	
}
