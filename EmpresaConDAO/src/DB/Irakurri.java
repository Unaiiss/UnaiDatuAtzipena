package DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Irakurri {

	public static void departamentuakIkusiS() {
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			Statement s1 = db.createStatement();
			String sql = "SELECT * FROM departamentos";
			ResultSet lerroak = s1.executeQuery(sql);

			while (lerroak.next()) {
				System.out.println(lerroak.getInt("dept_no"));
				System.out.println(lerroak.getString("dnombre"));
				System.out.println(lerroak.getString("loc"));
				System.out.println("=============");
			}

		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}

	public static void depar10LangS() {
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			Statement s1 = db.createStatement();
			String sql = "SELECT e.apellido, e.oficio, e.salario FROM empleados e "
					+ "JOIN departamentos d USING(dept_no) WHERE d.dept_no = 10";
			ResultSet lerroak = s1.executeQuery(sql);

			while (lerroak.next()) {
				System.out.println(lerroak.getString("apellido"));
				System.out.println(lerroak.getString("oficio"));
				System.out.println(lerroak.getDouble("salario"));
				System.out.println("=============");
			}

		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}

	public static void soldataAltuenaS() {
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			Statement s1 = db.createStatement();
			String sql = "SELECT e.apellido, e.oficio, e.salario FROM empleados e "
					+ "ORDER BY e.salario DESC LIMIT 1";
			ResultSet lerroak = s1.executeQuery(sql);

			while (lerroak.next()) {
				System.out.println(lerroak.getString("apellido"));
				System.out.println(lerroak.getString("oficio"));
				System.out.println(lerroak.getDouble("salario"));
				System.out.println("=============");
			}

		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}

	public static void depar10LangPS() {
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			
			String consulta = "SELECT e.apellido, e.oficio, e.salario FROM empleados e "
					+ "JOIN departamentos d USING(dept_no) WHERE d.dept_no = ?";
			PreparedStatement ps = db.prepareStatement(consulta);
			// añado el numero de departamento 10 al primer ?
			ps.setInt(1, 10);
			ResultSet lerroak = ps.executeQuery();

			while (lerroak.next()) {
				System.out.println(lerroak.getString("apellido"));
				System.out.println(lerroak.getString("oficio"));
				System.out.println(lerroak.getDouble("salario"));
				System.out.println("=============");
			}

		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}

	public static void departamentuakIkusiCS() {
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			String sql = "{CALL DepartamentuakAtera()}";
			CallableStatement cs = db.prepareCall(sql);
			
			ResultSet lerroak = cs.executeQuery();

			while (lerroak.next()) {
				System.out.println(lerroak.getInt("dept_no"));
				System.out.println(lerroak.getString("dnombre"));
				System.out.println(lerroak.getString("loc"));
				System.out.println("=============");
			}

		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}
	
	public static void depar10LangCS() {
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			String sql = "{CALL Depar10Langileak(?)}";
			CallableStatement cs = db.prepareCall(sql);
			cs.setInt(1, 10);
			ResultSet lerroak = cs.executeQuery();

			while (lerroak.next()) {
				System.out.println(lerroak.getString("apellido"));
				System.out.println(lerroak.getString("oficio"));
				System.out.println(lerroak.getDouble("salario"));
				System.out.println("=============");
			}

		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}
	
	public static void soldataAltuenaCS() {
		Konexioa conec = new Konexioa();
		Connection db = conec.konektatu();

		try {
			String sql = "{CALL SoldataAltuenaLang()}";
			CallableStatement cs = db.prepareCall(sql);
			
			ResultSet lerroak = cs.executeQuery();

			while (lerroak.next()) {
				System.out.println(lerroak.getString("apellido"));
				System.out.println(lerroak.getString("oficio"));
				System.out.println(lerroak.getDouble("salario"));
				System.out.println("=============");
			}

		} catch (SQLException e) {
			System.err.println("Errorea: Ezin izan da kontsulta egin.");
			e.printStackTrace();
		} finally {
			conec.deskonektatu();
		}
	}
}
