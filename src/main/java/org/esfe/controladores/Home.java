package org.esfe.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class Home {

    @GetMapping
    public String index(Model model){
        String saludo = "Hola, bienvenido";
        model.addAttribute("mensaje", saludo);
        return "home/index";
    }

    @GetMapping("/saludame")
    public String saludame(@RequestParam("nombre") String nombre, Model model){
    String saludo = "Hola, " + nombre + ", bienvenido/a";
    model.addAttribute("mensaje", saludo);
    return "home/saludame";
    }

    @GetMapping("/suma")
    public String suma(){
     return "home/suma";
    }

    @PostMapping("/resultado")
    public String  resultado(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model){

        int suma = num1 + num2;
        model.addAttribute("resultado", suma);
        return "home/resultado";

    }


    @GetMapping("/conversor")
    public String conversor() {
        return "home/conversor";}

    // Nuevo método para manejar la conversión
    @PostMapping("/convertir")
    public String convertir(@RequestParam("valor") double valor,
                            @RequestParam("unidad") String unidad,
                            Model model) {
        String resultado;
        if (unidad.equalsIgnoreCase("km")) {
            double millas = valor * 0.621371;
            resultado = valor + " kilómetros son " + millas + " millas.";
        } else if (unidad.equalsIgnoreCase("millas")) {
            double kilometros = valor / 0.621371;
            resultado = valor + " millas son " + kilometros + " kilómetros.";
        } else {
            resultado = "Unidad desconocida: " + unidad;
        }
        model.addAttribute("resultado", resultado);
        return "home/convertir";
    }
}

