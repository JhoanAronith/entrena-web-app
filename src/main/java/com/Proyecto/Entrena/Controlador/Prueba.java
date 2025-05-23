package com.Proyecto.Entrena.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Prueba {

    @GetMapping("/paginaPrueba")
    public String prueba() {
        return "paginaPrueba";
    }

}
