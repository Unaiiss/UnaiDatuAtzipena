package modelo.DAOs;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import control.HibernateUtil;
import modelo.Municipios;
import modelo.Provincias;

public class MunicipiosDAO {

	
	public MunicipiosDAO() { }
	
	public Municipios añadirMunicipio(Provincias provincia) {
		Municipios municipio = new Municipios(provincia, "inventadisimo", "Pueblo prueba", 11111, null, null);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Integer id = (Integer) session.save(municipio);
		Transaction tx = session.beginTransaction();
		session.save(municipio);
		tx.commit();
		
		// COMPRUEBO SI SE HA INSERTADO
		String consulta = "select idMunicipio from Municipios m where m.idMunicipio = :idMuni";
		Query q = session.createQuery(consulta);
		q.setParameter("idMuni", id);
		Integer result = (Integer) q.uniqueResult();
		
		if(result != 0) {
			return municipio;
		}
		
		return null;
	}
	
	//funcion para obrtener todos los municipios de una provincia
	public ArrayList<Municipios> obtenerMunicipios(Provincias provincia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Municipios m where m.provincias.idProvincia = :idProvincia";
		Query q = session.createQuery(hql);
		q.setParameter("idProvincia", provincia.getIdProvincia());
		ArrayList<Municipios> municipios = (ArrayList<Municipios>) q.list();
		return municipios;
	}
	
	public Municipios obtenerMunicipio(String municipioElegido) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String consulta = "from Municipios m where m.nombre = :nombre";
		Query q = session.createQuery(consulta);
		q.setParameter("nombre", municipioElegido);
		Municipios municipio = (Municipios) q.uniqueResult();

		if (municipio != null) {
			return municipio;
		}

		return null;
	}

	
	
	

}
