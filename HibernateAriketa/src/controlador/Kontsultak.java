package controlador;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;
import modelo.Departamentos;
import modelo.Empleados;

public class Kontsultak {

	public void DepartamentuEremuak10() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("_____________________");
		String hql = "from Empleados e where e.departamentos.deptNo = :deptZenb )";
		Query q = session.createQuery(hql);
		q.setParameter("deptZenb", (byte) 10);
		
		List<Empleados> emps = (List<Empleados>) q.list();
		for (int i = 0; i < emps.size(); i++) {
			Empleados emp = emps.get(i);
			System.out.println(emp.getApellido());
			System.out.println(emp.getOficio());
			System.out.println(emp.getSalario());
			System.out.println("..............");
		}
		System.out.println("_____________________");
	}
	
	public void GehienekoSoldataErakutsi() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("_____________________");
		
		String hql = "from Empleados e where e.salario = (select max(emp.salario) from Empleados emp)";
		Query q = session.createQuery(hql);

		// como solo espero un único resultado no necesito hacer un for y especifico a la query
		// que solo habrá uno (q.uniqueResult())
		Empleados empleado = (Empleados) q.uniqueResult();
		System.out.println(empleado.getApellido());
		System.out.println(empleado.getSalario());
		System.out.println(empleado.getDepartamentos().getDnombre());
		System.out.println("_____________________");
	}
	
	

}
