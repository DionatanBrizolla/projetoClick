package db;

import java.util.ArrayList;

public class PoolDeConexoes {

	private static PoolDeConexoes mySelf;
	private ArrayList<Conexao> lista;

	public PoolDeConexoes() {

		if (lista == null) {
			lista = new ArrayList<Conexao>();
			try {
				lista.add(new Conexao());
				lista.add(new Conexao());
				lista.add(new Conexao());
				lista.add(new Conexao());
				lista.add(new Conexao());
			} catch (FevasDBException e) {
				e.printStackTrace();
			}
		}
	}

	public static PoolDeConexoes getInstance() {

		if (mySelf == null) {
			mySelf = new PoolDeConexoes();
		}

		return mySelf;
	}

	public synchronized Conexao getConexao() {
		
		for( Conexao cnx : lista )  {
			
			if(!cnx.isReservado()){				
				cnx.reserva();
				return cnx;				
			}
		}
		
		try {
			Conexao c = new Conexao();
			lista.add( c );
			c.reserva();
			return c;
		} catch (FevasDBException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void finaliza() {

		mySelf = null;
	}
}
