	import java.io.Serializable;
	
	public class Libro implements Serializable {
		
		private String nombre=null;
		private String editor=null;
		private String autor=null;
		private int paginas=0;
		private int any=0;
	
		public Libro(String nom, String aut, int an, String edit, int pags) {
			nombre = nom;
			autor = aut;
			any=an;
			editor=edit;
			paginas=pags;
		}
		
		//getters
		public String getNombre() {
			return nombre;
		}
		public String getAutor() {
			return autor;
		}
		public int getAny(){
			return any;
		}
		public String getEditor(){
			return editor;
		}
		public int getPaginas(){
			return paginas;
		}
		
		
		//setters
		public void setNombre(String nom) {
			nombre = nom;
		}
		public void setAutor(String aut) {
			autor = aut;
		}
		public void setAny(int an){
			any = an;
		}
		public void setEditor(String edit){
			editor = edit;
		}
		public void setPaginas(int pags){
			paginas = pags;
		}
		
		public void print(){
			System.out.println("Titulo: "+nombre+" /Autor: "+autor+" /Any: "+any+" /Editor: "+editor+" /Paginas: "+paginas);
		}
	
	}
