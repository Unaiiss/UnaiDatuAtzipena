package modelo.DAOs;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import control.HibernateUtil;
import modelo.CentrosMeteorologicos;
import modelo.Municipios;

public class CentroMetDao {

	public CentroMetDao() {}
	
	public CentrosMeteorologicos añadirCentroMet(Municipios municipio) {
        // Crear el objeto EspaciosNaturales usando un constructor con todos los atributos
        CentrosMeteorologicos centrosMet = new CentrosMeteorologicos(municipio, "PORBASS", "Itsasalde 6", 43.351682, -3.136677, null, null, null);

        // Iniciar la sesión y la transacción
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer id = (Integer) session.save(centrosMet);
        Transaction tx = session.beginTransaction();
        session.save(centrosMet);
        tx.commit();
        
		// COMPRUEBO SI SE HA INSERTADO
		String consulta = "select idCentroMet from CentrosMeteorologicos cm where cm.idCentroMet = :idCentroMet";
		Query q = session.createQuery(consulta);
		q.setParameter("idCentroMet", id);
		Integer result = (Integer) q.uniqueResult();
		
		if(result != 0) {
			return centrosMet;
		}
		
		return null;
	}
}
