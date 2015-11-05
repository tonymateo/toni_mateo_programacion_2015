import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Parser {
		/*Toni Mateo*/
		
		private Document dom = null;
		private ArrayList<Libro> libros = null;
		
		public Parser(){
			libros = new ArrayList<Libro>();
		}
		
		public void parseFicheroXml(String fichero){
			//Creamos un factory
			DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();	
			try {
				//Creamos un document builder
				DocumentBuilder db=dbf.newDocumentBuilder();
				//parseo el xml y obtengo una representacion DOM
				dom = db.parse("biblioteca.xml");
			} catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			} catch (SAXException se) {
				se.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
		public void parseDocument(){//metodo que me permite recorrer el fichero y crearme un objeto libro por cada nodo libro
			// elemento raiz
			Element docEle =dom.getDocumentElement();
			
			//lista de elementos dentro del elemento raiz(todos los libros que tiene)
			NodeList nodeL=docEle .getElementsByTagName("libro");
			//recorrer cada libro
			if (nodeL != null && nodeL.getLength() > 0){
				for(int i=0;i<nodeL.getLength();i++){
					
					//obtener elemento i libro
					Element el=(Element) nodeL.item(i);
					
					//transformo elemento libro en objeto libro
					Libro l1=getLibro(el);
					
					//añado a array de libros
					libros.add(l1);
				}
			}
			System.out.println("bliblioteca.xml parseada con exito");
		}
		
		public Libro getLibro(Element libroEle){
			//extraer todos los valores del libro
			String datoTitulo=getValor(libroEle,"titulo");
			
			String datoAutor=getValor(libroEle,"autor");
			
			int datoAny=Integer.parseInt(getValor(libroEle,"any"));
			
			String datoEditor=getValor(libroEle,"editor");
			
			int datoPaginas= Integer.parseInt(getValor(libroEle,"paginas"));
					
			
			//crear onjeto libro y devolver el objeto
			Libro l=new Libro(datoTitulo,datoAutor,datoAny,datoEditor,datoPaginas);
			return l;
		}
		
		public String getValor(Element ele, String tagName){
			String textVal = null;
			NodeList nodeL = ele.getElementsByTagName(tagName);
			if(nodeL != null && nodeL.getLength() > 0) {
				Element e1 = (Element)nodeL.item(0);
				textVal = e1.getFirstChild().getNodeValue();
			}
			return textVal;
		}
		
		public void print(){
			//imprimo obtejos del archivo xml parseado
			Iterator iterator = libros.iterator();
			while(iterator.hasNext()) {
				Libro l = (Libro) iterator.next();
				l.print();
			}
		}
	}