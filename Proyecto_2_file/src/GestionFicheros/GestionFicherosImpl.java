package GestionFicheros;

import gestionficheros.FormatoVistas;
import gestionficheros.GestionFicheros;
import gestionficheros.GestionFicherosException;
import gestionficheros.TipoOrden;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class GestionFicherosImpl implements GestionFicheros {
	private File carpetaDeTrabajo = null;
	private Object[][] contenido;
	private int filas = 0;
	private int columnas = 3;
	private FormatoVistas formatoVistas = FormatoVistas.NOMBRES;
	private TipoOrden ordenado = TipoOrden.DESORDENADO;

	public GestionFicherosImpl() {
		carpetaDeTrabajo = File.listRoots()[0];
		actualiza();
	}

	private void actualiza() {

		String[] ficheros = carpetaDeTrabajo.list(); // obtener los nombres
		// calcular el número de filas necesario
		filas = ficheros.length / columnas;
		if (filas * columnas < ficheros.length) {
			filas++; // si hay resto necesitamos una fila más
		}

		// dimensionar la matriz contenido según los resultados

		contenido = new String[filas][columnas];
		// Rellenar contenido con los nombres obtenidos
		for (int i = 0; i < columnas; i++) {
			for (int j = 0; j < filas; j++) {
				int ind = j * columnas + i;
				if (ind < ficheros.length) {
					contenido[j][i] = ficheros[ind];
				} else {
					contenido[j][i] = "";
				}
			}
		}
	}

	@Override
	public void arriba() {

		//System.out.println("holaaa");
		if (carpetaDeTrabajo.getParentFile() != null) {
			carpetaDeTrabajo = carpetaDeTrabajo.getParentFile();
			actualiza();
		}

	}
//Toni Mateo
//ejercicio 1b
	@Override
	public void creaCarpeta(String arg0) throws GestionFicherosException {
		File file = new File(carpetaDeTrabajo,arg0);
		//que se pueda escribir -> lanzará una excepción
		if (carpetaDeTrabajo.canWrite()==false){
			throw new GestionFicherosException("Error, no se puede escribir en el fichero");
		}
		//que no exista -> lanzará una excepción
		if (file.exists()==true){
			throw new GestionFicherosException("El fichero ya existe!!");
		}
		//crear carpeta, si no, lanzará excepción
		try{
			file.mkdir();
			}catch (SecurityException e){
				throw new GestionFicherosException("Error al crear el directorio");
			}
		actualiza();
		}
		
//ejercicio 1b
	@Override
	public void creaFichero(String arg0) throws GestionFicherosException {
		File file = new File(carpetaDeTrabajo,arg0);
		
		if (carpetaDeTrabajo.canWrite()==false){
			throw new GestionFicherosException("Error, no se puede escribir en el fichero");
		}
		
		if (carpetaDeTrabajo.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					throw new GestionFicherosException("error al crear el fichero");
				}				
			}
		actualiza();
	}
//ejercicio 1b
	@Override
	public void elimina(String arg0) throws GestionFicherosException {
		File file = new File(carpetaDeTrabajo,arg0);
		if (carpetaDeTrabajo.canWrite() && carpetaDeTrabajo.exists()){
			file.delete();	
		}
		actualiza();
	}
	
	@Override
	public void entraA(String arg0) throws GestionFicherosException {
		File file = new File(carpetaDeTrabajo, arg0);
		// se controla que el nombre corresponda a una carpeta existente
		if (!file.isDirectory()) {
			throw new GestionFicherosException("Error. Se ha encontrado "
					+ file.getAbsolutePath()
					+ " pero se esperaba un directorio");
		}
		// se controla que se tengan permisos para leer carpeta
		if (!file.canRead()) {
			throw new GestionFicherosException("Alerta. No se puede acceder a "
					+ file.getAbsolutePath() + ". No hay permiso");
		}
		// nueva asignación de la carpeta de trabajo
		carpetaDeTrabajo = file;
		// se requiere actualizar contenido
		actualiza();

	}

	@Override
	public int getColumnas() {
		return columnas;
	}

	@Override
	public Object[][] getContenido() {
		return contenido;
	}

	@Override
	public String getDireccionCarpeta() {
		return carpetaDeTrabajo.getAbsolutePath();
	}

	@Override
	public String getEspacioDisponibleCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEspacioTotalCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFilas() {
		return filas;
	}

	@Override
	public FormatoVistas getFormatoContenido() {
		return formatoVistas;
	}
//Toni Mateo
//Ejercicio 1a
	@Override
	public String getInformacion(String arg0) throws GestionFicherosException {
		
		StringBuilder strBuilder=new StringBuilder();
		File file = new File(carpetaDeTrabajo,arg0);
		
		//Controlar que existe. Si no, se lanzará una excepción
		if (file.exists()==false){
			throw new GestionFicherosException("El archivo no existe");
		}
		//Controlar que haya permisos de lectura. Si no, se lanzará una excepción
		if (file.canRead()==false){
			throw new GestionFicherosException("No se puede leer el archivo");		
		}
		
		//Título
		strBuilder.append("INFORMACIÓN DEL SISTEMA");
		strBuilder.append("\n\n");
		
		//Nombre
		strBuilder.append("Nombre: ");
		strBuilder.append(arg0);
		strBuilder.append("\n");
		
		//Tipo: fichero o directorio
		strBuilder.append("Tipo de fichero: ");
			if(file.isDirectory() == true){
				strBuilder.append("Es un directorio");
			}
			if(file.isFile() == true){
				strBuilder.append("Es un fichero");
			}
		strBuilder.append("\n");
		
		//Ubicación
		strBuilder.append("La ubicación del archivo es: ");
		try {
			strBuilder.append(file.getCanonicalPath());
		} catch (IOException e) {
			throw new GestionFicherosException("No se puede obtener el nombre del fichero");
		}
		strBuilder.append("\n");
		
		//Fecha de última modificación
		strBuilder.append("La ultima modificación fue: ");
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");//Se establece el tipo de fecha
		strBuilder.append(fecha.format(file.lastModified()));
		strBuilder.append("\n");
		
		//Si es un fichero oculto o no
		strBuilder.append("Oculto: ");
		if (file.isHidden() == true){
			strBuilder.append("Si");
		}else{
			strBuilder.append("No");
		}
		strBuilder.append("\n");
		
		//Si es directorio: Espacio libre, espacio disponible, espacio total
		//bytes
		if(file.isDirectory() == true){
			
			//Espacio libre
			strBuilder.append("Espacio libre: ");
			long libre = file.getFreeSpace();
			strBuilder.append(libre);
			strBuilder.append(" bytes");
			strBuilder.append("\n");
			
			//espacio disponible
			strBuilder.append("Espacio disponible: ");
			long disponible = file.getUsableSpace();
			strBuilder.append(disponible);
			strBuilder.append(" bytes");
			strBuilder.append("\n");
			
			//espacio total
			strBuilder.append("Espacio total: ");
			long total = file.getTotalSpace();
			strBuilder.append(total);
			strBuilder.append(" bytes");
			strBuilder.append("\n");
				}
			return strBuilder.toString();
		}

	@Override
	public boolean getMostrarOcultos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNombreCarpeta() {
		return carpetaDeTrabajo.getName();
	}

	@Override
	public TipoOrden getOrdenado() {
		return ordenado;
	}

	@Override
	public String[] getTituloColumnas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUltimaModificacion(String arg0)
			throws GestionFicherosException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String nomRaiz(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numRaices() {
		// TODO Auto-generated method stub
		return 0;
	}
	
//ejercicio 1b
	@Override
	public void renombra(String arg0, String arg1) throws GestionFicherosException {
		File file = new File(carpetaDeTrabajo,arg0);
		//me creo un nuevo File que sustituirá el nombre del anterior
		File nuevoNombre = new File(carpetaDeTrabajo,arg1);
		//compruebo que se puede escribir y que existe
		if (carpetaDeTrabajo.canWrite()){
			if (file.exists()==false){
					throw new GestionFicherosException("Error, no se encuentra el archivo especificado");
				}
			if (nuevoNombre.exists()){
					throw new GestionFicherosException("El nombre que has puesto ya existe");
				}
			try{
				file.renameTo(nuevoNombre);	
			}catch(Exception e){
				throw new GestionFicherosException("No se puede renombrar");
			}
		}
		actualiza();
	}

	@Override
	public boolean sePuedeEjecutar(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeEscribir(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeLeer(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColumnas(int arg0) {
		columnas = arg0;

	}

	@Override
	public void setDirCarpeta(String arg0) throws GestionFicherosException {
		File file = new File(arg0);

		// se controla que la dirección exista y sea directorio
		if (!file.isDirectory()) {
			throw new GestionFicherosException("Error. Se esperaba "
					+ "un directorio, pero " + file.getAbsolutePath()
					+ " no es un directorio.");
		}

		// se controla que haya permisos para leer carpeta
		if (!file.canRead()) {
			throw new GestionFicherosException(
					"Alerta. No se puede acceder a  " + file.getAbsolutePath()
							+ ". No hay permisos");
		}

		// actualizar la carpeta de trabajo
		carpetaDeTrabajo = file;

		// actualizar el contenido
		actualiza();

	}

	@Override
	public void setFormatoContenido(FormatoVistas arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMostrarOcultos(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOrdenado(TipoOrden arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSePuedeEjecutar(String arg0, boolean arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSePuedeEscribir(String arg0, boolean arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSePuedeLeer(String arg0, boolean arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUltimaModificacion(String arg0, long arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

}
