package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ar.edu.unju.edm.model.ProcesoFecha;

@Controller
public class ProcesoFechaController {

    @GetMapping("/procesoFecha")
    public String procesoFecha(Model model) {
    	model.addAttribute("procesoFecha", new ProcesoFecha());
        return "procesoFecha";
    }

    @PostMapping("/procesoFecha")
    public String procesarFecha(@RequestParam String fecha1, @RequestParam String fecha2, Model model) {

        LocalDate fecha1LocalDate = LocalDate.parse(fecha1);
        LocalDate fecha2LocalDate = LocalDate.parse(fecha2);

        ProcesoFecha procesoFecha = new ProcesoFecha(fecha1LocalDate, fecha2LocalDate);

        String mensaje1 = procesoFecha.compararFechas();
        String mensaje2 = procesoFecha.calcularPeriodo();

        procesoFecha.setMensaje1(mensaje1);
        procesoFecha.setMensaje2(mensaje2);

        model.addAttribute("procesoFecha", procesoFecha);

        return "resultadoProcesoFecha";
    }
}

