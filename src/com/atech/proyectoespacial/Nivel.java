package com.atech.proyectoespacial;

import java.util.ArrayList;
import java.util.List;

import com.atech.proyectoespacial.Enemigo.LanzaCohetes;
import com.atech.proyectoespacial.Enemigo.Soldado;
import com.atech.proyectoespacial.Enemigo.Tanque;
import com.atech.proyectoespacial.Nave.Basica;
import com.atech.proyectoespacial.Nave.Bombardero;
import com.atech.proyectoespacial.Nave.Platillo;

public class Nivel {

	private int nivel;
	private Nave nave;
	
	public int getNivel() {
		return nivel;
	}
	
	public Nivel(int nivel) {
		this.nivel = nivel;
	}
	
	public Nave getNave() {
		switch(nivel) {
		case 1:
			
			return new Basica();
		case 2:
			return new Platillo();
		case 3:
			return new Bombardero();
		
		}
		
		return null;
		
	}
	
	public List<Objetivo> getObjetivos() {
		List<Objetivo> objetivos = new ArrayList<Objetivo>();
		
		switch(nivel) {
		
		case 1:
			for (int i = 0 ; i < 3; i ++) {
				objetivos.add(new Soldado());
			}
			break;
		case 2:
			for (int i = 0 ; i < 3; i ++) {
				objetivos.add(new Soldado());
			}
			objetivos.add(new Tanque());
			break;
		case 3:
			for (int i = 0 ; i < 3; i ++) {
				objetivos.add(new Soldado());
			}
			for (int i = 0 ; i < 2; i ++)
				objetivos.add(new Tanque());
			
			objetivos.add(new LanzaCohetes());
			
			break;
			
		
		}
		
		return objetivos;
	}
	
}
