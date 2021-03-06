import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.*;
import java.util.List;
import org.jdom.output.XMLOutputter;
import java.io.PrintWriter;
import java.io.FileWriter;
import org.jdom.input.SAXBuilder;
import org.jdom.input.DOMBuilder;
import java.io.FileInputStream;  
import java.io.FileOutputStream; 
import java.io.File;


public class XMLimagen extends Thread{
	String nombre;
	String imagen;
	String type;
	String ruta;
	
	public XMLimagen(String ruta, String nombre,String imagen,String type){
		this.nombre=nombre;
		this.imagen = imagen;
		this.type = type;
		this.ruta = ruta;
	}
    public void run() {
		try{
			SAXBuilder builder = new SAXBuilder();

			File documentJDOM = new File(ruta);
			Document doc = builder.build(documentJDOM);
			Element raiz = doc.getRootElement();  
			Element element = new Element("StoryBoard");
			Element name = new Element("Nombre");
			name.setText(nombre);
			element.addContent(name);
			Element pass = new Element("Imagen");
			pass.setText(imagen);
			element.addContent(pass);
			Element tipo = new Element("Tipo");
			tipo.setText(type);
			element.addContent(tipo);
			raiz.addContent(element);
			XMLOutputter xmlout = new XMLOutputter();
			FileOutputStream fileout = new FileOutputStream(ruta);
			xmlout.output(doc, fileout);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
