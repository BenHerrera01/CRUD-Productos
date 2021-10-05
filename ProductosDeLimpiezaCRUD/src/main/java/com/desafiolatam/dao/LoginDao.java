package com.desafiolatam.dao;

import com.desafiolatam.modelo.Credencial;

public interface LoginDao {
	public Credencial obtenerCredenciales(String usuario, String clave);
}
