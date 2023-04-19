package ar.edu.unju.edm.model;

import java.time.LocalDate;
import java.time.Period;

public class ProcesoFecha {

    private LocalDate fecha1;
    private LocalDate fecha2;
    private String mensaje1;
    private String mensaje2;

    public ProcesoFecha(LocalDate fecha1, LocalDate fecha2) {
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
    }
    
    public ProcesoFecha() {
    	
    }

    public LocalDate getFecha1() {
        return fecha1;
    }

    public void setFecha1(LocalDate fecha1) {
        this.fecha1 = fecha1;
    }

    public LocalDate getFecha2() {
        return fecha2;
    }

    public void setFecha2(LocalDate fecha2) {
        this.fecha2 = fecha2;
    }

    public String getMensaje1() {
        return mensaje1;
    }

    public void setMensaje1(String mensaje1) {
        this.mensaje1 = mensaje1;
    }

    public String getMensaje2() {
        return mensaje2;
    }

    public void setMensaje2(String mensaje2) {
        this.mensaje2 = mensaje2;
    }

    public String compararFechas() {
        if (fecha1.isAfter(fecha2)) {
            return "La fecha " + fecha1 + " es posterior a la fecha " + fecha2;
        } else if (fecha1.isBefore(fecha2)) {
            return "La fecha " + fecha1 + " es anterior a la fecha " + fecha2;
        } else {
            return "Las fechas son iguales";
        }
    }

    public String calcularPeriodo() {
        Period periodo = Period.between(fecha2, fecha1);
        int anos = periodo.getYears();
        int meses = periodo.getMonths();
        int dias = periodo.getDays();
        return "Han transcurrido " + anos + " años, " + meses + " meses y " + dias + " días desde la fecha menor hasta la fecha mayor.";
    }
}

