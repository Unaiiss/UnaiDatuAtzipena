package modelo.DAOs;

import java.sql.Time;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import control.HibernateUtil;
import modelo.CentrosMeteorologicos;
import modelo.MedicionesCentroMet;
import modelo.MedicionesCentroMetId;
import modelo.Municipios;

public class MedicionCMDao {
	
	public MedicionCMDao() {}
	
	public void añadirMediCentroMet(CentrosMeteorologicos centroMet) {
        // Crear el objeto EspaciosNaturales usando un constructor con todos los atributos
		Date fecha = new Date(9, 01, 2025);
		Time hora = new Time(12, 00, 00);
		MedicionesCentroMetId mCentroMetId = new MedicionesCentroMetId(fecha, hora, centroMet.getIdCentroMet());
		MedicionesCentroMet mCentroMet = new MedicionesCentroMet(mCentroMetId, centroMet, null, null, null, null, null, null, null, "Muy bueno / Oso ona");

        // Iniciar la sesión y la transacción
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(mCentroMet);
        tx.commit();
	}

}
