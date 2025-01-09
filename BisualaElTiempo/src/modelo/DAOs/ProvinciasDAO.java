package modelo.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import control.HibernateUtil;
import modelo.Provincias;

public class ProvinciasDAO {

	public ProvinciasDAO() {
	}

	public Provincias añadirProvincia() {
		Provincias provincia = new Provincias(8, "Inventada");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(provincia);
		tx.commit();

		// COMPRUEBO SI SE HA INSERTADO
		String consulta = "select idProvincia from Provincias p where p.idProvincia = :idProvincia";
		Query q = session.createQuery(consulta);
		q.setParameter("idProvincia", provincia.getIdProvincia());
		int result = (int) q.uniqueResult();

		if (result != 0) {
			return provincia;
		}

		return null;

	}

	public ArrayList<Provincias> obtenerNombres() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String consulta = "from Provincias";
		Query q = session.createQuery(consulta);
		tx.commit();

		ArrayList<Provincias> listaProvincias = (ArrayList<Provincias>) q.list();
		for (int i = 0; i < listaProvincias.size(); i++) {
			// se usa .get para obtener el objeto de la lista
			Provincias provincia = listaProvincias.get(i);
		}
		return listaProvincias;
	}

	public Provincias obtenerProvincia(String provinElegida) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String consulta = "from Provincias p where p.nombre = :nombre";
		Query q = session.createQuery(consulta);
		q.setParameter("nombre", provinElegida);
		Provincias provincia = (Provincias) q.uniqueResult();

		if (provincia != null) {
			return provincia;
		}

		return null;
	}

}
