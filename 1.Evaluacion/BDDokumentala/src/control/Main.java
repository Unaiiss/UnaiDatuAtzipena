package control;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firestore.v1.WriteResult;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String ficheroJson = "empresa-Unai.json";

		FileInputStream serviceAccount = new FileInputStream(ficheroJson);
		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
				.setProjectId("empresa-unai").setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

		Firestore db = firestoreOptions.getService();

		// *************LECTURA*************

//		ApiFuture<QuerySnapshot> query = db.collection("empresa").get();
//		QuerySnapshot querySnapshot = query.get();
//		
//		List<QueryDocumentSnapshot> departamentos = querySnapshot.getDocuments();
//		
//		for (QueryDocumentSnapshot departamento : departamentos) {
//			System.out.println("*************************");
//			System.out.println("ID: " + departamento.getString("dpto_loc"));
//			System.out.println("Nombre: " + departamento.getString("dpto_nom"));
//			System.out.println("Localización: " + departamento.getLong("dpto_num"));
//
//			
//			DocumentReference turnoDepartamento = departamento.getReference();
//			CollectionReference empleadosCol = turnoDepartamento.collection("Langileak");
//			List<QueryDocumentSnapshot> empleados = empleadosCol.get().get().getDocuments();
//			for (QueryDocumentSnapshot empleado : empleados) {
//				System.out.println("==========================");
//				System.out.println("Comision: " + empleado.getLong("comision"));
//				System.out.println("Dirección: " + empleado.getString("dir"));
//				System.out.println("Apellido1: " + empleado.getString("emple_ap1"));
//				System.out.println("Nombre: " + empleado.getString("emple_nom"));
//				System.out.println("Fecha de alta: " + empleado.getDate("fecha_alt"));
//				System.out.println("Oficio: " + empleado.getString("oficio"));
//				System.out.println("Salario: " + empleado.getLong("salario"));
//				System.out.println("==========================");
//			}
//		}

		// ***********ESCRITURA*************

//		CollectionReference empresa = db.collection("empresa");
//		
//		Map<String, Object> dep = new HashMap<>();
//		dep.put("dpto_loc", "Gorliz");
//		dep.put("dpto_nom", "prueba");
//		dep.put("dpto_num", 5);
//		DocumentReference depNew = empresa.document();
//		
//		Map<String, Object> empleado = new HashMap<>();
//		empleado.put("comision", 500);
//		empleado.put("dir", "yeeeepa");
//		empleado.put("emple_ap1", "pruebaapellido");
//		empleado.put("emple_nom", "pruebanombre");
//		Date fecha = new Date();
//		empleado.put("fecha_alt", fecha);
//		empleado.put("oficio", "probador");
//		empleado.put("salario", 10000);
//		
//		depNew.set(dep);
//		CollectionReference empleadosCol = depNew.collection("Langileak");
//		empleadosCol.add(empleado);
//		
//		db.close();

		// *************MODIFICAR*************

//		ApiFuture<QuerySnapshot> query = db.collection("empresa").whereEqualTo("dpto_num", 2).get();

		// Obtener la fecha de "ayer"
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_YEAR, -1);  // Restar un día
//        Date fechaAyer = calendar.getTime();  // Obtener la fecha de ayer
//		
//		QuerySnapshot querySnapshot = query.get();
//		List<QueryDocumentSnapshot> departamentos = querySnapshot.getDocuments();
//		for (QueryDocumentSnapshot departamento : departamentos) {
//            // Mapa de los campos del documento del departamento (si lo necesitas)
//            Map<String, Object> dep = departamento.getData();
//
//            // Obtener la referencia de la subcolección "Langileak" (empleados)
//            CollectionReference empleadosCol = departamento.getReference().collection("Langileak");
//
//            // Supongamos que queremos actualizar el salario de un empleado con ID "L1"
//            DocumentReference empleadoRef = empleadosCol.document("L1");
//
//            // Actualizar el salario del empleado a un nuevo valor (por ejemplo, 25000) y asigno la fecha de ayer
//            ApiFuture<com.google.cloud.firestore.WriteResult> future = empleadoRef.update("salario", 10000, "fecha_alt", fechaAyer);
//		}

		// *************ELIMINAR*************
		// Realizar una consulta a Firestore para obtener los documentos de la colección
		// "empresa"
		// donde el campo "dpto_loc" sea igual a "Gorliz".
		ApiFuture<QuerySnapshot> query = db.collection("empresa").whereEqualTo("dpto_loc", "Gorliz").get();

		// Obtener los resultados de la consulta
		QuerySnapshot querySnapshot = query.get();

		// Obtener los documentos de la consulta en forma de una lista de
		// QueryDocumentSnapshot
		List<QueryDocumentSnapshot> departamentos = querySnapshot.getDocuments();

		// Iterar sobre cada documento (departamento) obtenido de la consulta
		for (QueryDocumentSnapshot departamento : departamentos) {
			// Obtener los datos del documento actual como un mapa clave-valor
			Map<String, Object> dep = departamento.getData();

			// Borrar el campo "dpto_loc" del documento actual.
			// Se usa FieldValue.delete() para indicar que queremos eliminar ese campo
			// específico.
			dep.put("dpto_loc", FieldValue.delete());

			// Obtener la referencia al documento (departamento) en Firestore
			DocumentReference depRef = departamento.getReference();

			// Actualizar el documento con los cambios (en este caso, eliminar el campo
			// "dpto_loc")
			depRef.update(dep);
		}

		// Cerrar la conexión con Firestore (importante para liberar recursos)
		db.close();

	}

}
