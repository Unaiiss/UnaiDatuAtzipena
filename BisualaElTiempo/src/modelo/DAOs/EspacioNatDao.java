package modelo.DAOs;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import control.HibernateUtil;
import modelo.EspaciosNaturales;
import modelo.Municipios;

public class EspacioNatDao {

    public EspacioNatDao() {
    }

    public void añadirEspacioNatural() {
        // Crear el objeto EspaciosNaturales usando un constructor con todos los atributos
        EspaciosNaturales espacioNatural = new EspaciosNaturales(26, "Playa de la Arena", "La playa ubicada en muskiz","Playas, pantanos y rios", "Playas", 43.347769845163434, -3.1185808315783614);

        // Iniciar la sesión y la transacción
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(espacioNatural);
        tx.commit();
    }
    
	//funcion que me devuelve un array de espacios naturales en base al municipio
    public ArrayList<EspaciosNaturales> obtenerEspaciosNaturales(Municipios municipio) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Aquí, estamos usando la relación entre la tabla 'MunicipiosEspaciosNat' y 'EspaciosNaturales'
        String hql = "select men.espaciosNaturales from MunicipiosEspaciosNat men where men.municipios.idMunicipio = :idMunicipio";
        Query query = session.createQuery(hql);
        query.setParameter("idMunicipio", municipio.getIdMunicipio());
        
        // Ejecutamos la consulta y la retornamos como una lista
        ArrayList<EspaciosNaturales> espaciosNaturales = (ArrayList<EspaciosNaturales>) query.list();
        return espaciosNaturales;
    }

 
}
