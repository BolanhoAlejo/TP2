package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.ProcesoString;

@Controller
public class ProcesoStringController {

    @GetMapping("/procesoString")
    public String procesoStringForm(Model model) {
        model.addAttribute("procesoString", new ProcesoString());
        return "procesoString";
    }

    @PostMapping("/procesoString")
    public String procesoStringSubmit(@ModelAttribute ProcesoString procesoString) {
        procesoString.setMensaje1("La cadena tiene " + procesoString.getCadena().length() + " caracteres y " + contarVocales(procesoString.getCadena()) + " vocales");
        procesoString.setCadenaInvertida(invertirCadena(procesoString.getCadena()));
        procesoString.setMensaje2("La cadena tiene " + contarPalabras(procesoString.getCadena()) + " palabras");
        return "procesoStringResultado";
    }
    
    public int contarVocales(String cadena) {
    	int n=0;
    	char[] caracteres=cadena.toCharArray();
    	for(int i=0; i<caracteres.length; i++) {
    		char c=caracteres[i];
    		if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
    			n++;
    		}
    	}
    	return n;
    }
    
    public static String invertirCadena(String cadena) {
        // Eliminar espacios de la cadena
        String cadenaSinEspacios = cadena.replaceAll("\\s", "");
        
        // Convertir la cadena sin espacios a un arreglo de caracteres
        char[] caracteres = cadenaSinEspacios.toCharArray();
        
        // Invertir el orden de los caracteres
        for (int i = 0; i < caracteres.length / 2; i++) {
            char temp = caracteres[i];
            caracteres[i] = caracteres[caracteres.length - 1 - i];
            caracteres[caracteres.length - 1 - i] = temp;
        }
        
        // Convertir el arreglo de caracteres de vuelta a una cadena y retornarla
        return new String(caracteres);
    }
    
    public static int contarPalabras(String cadena) {
        // Dividir la cadena en palabras usando expresiones regulares
        String[] palabras = cadena.trim().split("\\s+");
        
        // Retornar la cantidad de palabras
        return palabras.length;
    }
    
}
