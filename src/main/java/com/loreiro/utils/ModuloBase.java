package com.loreiro.utils;

public class ModuloBase {
	
	static ConnectionPool cone ;
	
	public ModuloBase() {
		cone = new ConnectionPool();
	}
	
	public static ConnectionPool getConeBase(){
		return cone;
	}
	
	
}
