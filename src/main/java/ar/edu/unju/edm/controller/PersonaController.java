package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Persona;


@Controller
public class PersonaController {
    
    @GetMapping("/persona")
    public String mostrarFormulario(Model model) {
        model.addAttribute("persona", new Persona());
        return "persona";
    }
    
    @PostMapping("/persona")
    public String procesarFormulario(@ModelAttribute Persona persona, Model model) {
        model.addAttribute("edad", calcularEdad(persona.getFechaNacimiento()));
        model.addAttribute("signoZodiaco", obtenerSignoZodiaco(persona.getFechaNacimiento()));
        model.addAttribute("estacionAnio", obtenerEstacionAnio(persona.getFechaNacimiento()));
        return "resultadopersona";
    }
    
    private int calcularEdad(LocalDate fechaNacimiento) {
        LocalDate ahora = LocalDate.now();
        return Period.between(fechaNacimiento, ahora).getYears();
    }
    
    private String obtenerSignoZodiaco(LocalDate fechaNacimiento) {
    	    int dia = fechaNacimiento.getDayOfMonth();
    	    int mes = fechaNacimiento.getMonthValue();
    	    
    	    switch (mes) {
    	        case 1: // Enero
    	            if (dia < 20) {
    	                return "Capricornio";
    	            } else {
    	                return "Acuario";
    	            }
    	        case 2: // Febrero
    	            if (dia < 19) {
    	                return "Acuario";
    	            } else {
    	                return "Piscis";
    	            }
    	        case 3: // Marzo
    	            if (dia < 21) {
    	                return "Piscis";
    	            } else {
    	                return "Aries";
    	            }
    	        case 4: // Abril
    	            if (dia < 20) {
    	                return "Aries";
    	            } else {
    	                return "Tauro";
    	            }
    	        case 5: // Mayo
    	            if (dia < 21) {
    	                return "Tauro";
    	            } else {
    	                return "Géminis";
    	            }
    	        case 6: // Junio
    	            if (dia < 21) {
    	                return "Géminis";
    	            } else {
    	                return "Cáncer";
    	            }
    	        case 7: // Julio
    	            if (dia < 23) {
    	                return "Cáncer";
    	            } else {
    	                return "Leo";
    	            }
    	        case 8: // Agosto
    	            if (dia < 23) {
    	                return "Leo";
    	            } else {
    	                return "Virgo";
    	            }
    	        case 9: // Septiembre
    	            if (dia < 23) {
    	                return "Virgo";
    	            } else {
    	                return "Libra";
    	            }
    	        case 10: // Octubre
    	            if (dia < 23) {
    	                return "Libra";
    	            } else {
    	                return "Escorpio";
    	            }
    	        case 11: // Noviembre
    	            if (dia < 22) {
    	                return "Escorpio";
    	            } else {
    	                return "Sagitario";
    	            }
    	        case 12: // Diciembre
    	            if (dia < 22) {
    	                return "Sagitario";
    	            } else {
    	                return "Capricornio";
    	            }
    	        default:
    	            return "Error: mes inválido";
    	    }
    	}
    
    private String obtenerEstacionAnio(LocalDate fechaNacimiento) {

    	    int dia = fechaNacimiento.getDayOfMonth();
    	    int mes = fechaNacimiento.getMonthValue();
    	    
    	    switch (mes) {
    	        case 12:
    	        case 1:
    	        case 2:
    	            return "Verano";
    	        case 3:
    	            if (dia < 21) {
    	                return "Verano";
    	            } else {
    	                return "Otoño";
    	            }
    	        case 4:
    	        case 5:
    	            return "Otoño";
    	        case 6:
    	            if (dia < 21) {
    	                return "Otoño";
    	            } else {
    	                return "Invierno";
    	            }
    	        case 7:
    	        case 8:
    	            return "Invierno";
    	        case 9:
    	            if (dia < 23) {
    	                return "Invierno";
    	            } else {
    	                return "Primavera";
    	            }
    	        case 10:
    	        case 11:
    	            return "Primavera";
    	        default:
    	            return "Error: mes inválido";
    	    }
    	}

}

