package br.com.fiap.dao;

import java.util.List;

public interface Dao<E> {
	
	public E recuperaPorId(long id) throws Exception;
	
	public List<E> recupera() throws Exception;
	
	public void altera(E entidade) throws Exception;
	
	public void deleta(long id) throws Exception;
	
	public void salva(E entidade) throws Exception;	
}