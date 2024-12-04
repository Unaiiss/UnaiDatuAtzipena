package DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {
	
	public static void deparBerriaSortuCS() {
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			String sql = "{CALL añadir_dept_marketing()}";
			CallableStatement cs = db.prepareCall(sql);
			
			ResultSet lerroak = cs.executeQuery();

		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}
	
	public static void eguneratuSoldatakValencia() {
		
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			String sql = "{CALL actualizar_salarios_marketing(?)}";
			CallableStatement cs = db.prepareCall(sql);
			cs.setInt(1, 1700);
			ResultSet lerroak = cs.executeQuery();
			
		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}
	
	public static void ezabatuDepMarketing() {
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			String sql = "{CALL eliminar_dept_marketing()}";
			CallableStatement cs = db.prepareCall(sql);
			
			ResultSet lerroak = cs.executeQuery();

		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}
	
}
