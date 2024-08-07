package com.dobackaofront.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ControllerFormulario {

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        String titulo1 ="Do Back ao Front";
        String paragrafo1= "Programação FullStack";
        String nome1= "Olival";
        ArrayList<String> nomes = new ArrayList<String>();
        nomes.add("Olival");
        nomes.add("Lucas");
        nomes.add("Antônio");
        nomes.add("Marcelo");
        nomes.add("Junior");
        nomes.add("Paula");


        mv.addObject("titulo", titulo1);
        mv.addObject("paragrafo", paragrafo1);
        mv.addObject("nome", nome1);
        mv.addObject("listaDeNomes", nomes);

        return mv;
    }
    @PostMapping("/formulario")
    public ModelAndView form(String email){
            ModelAndView mv = new ModelAndView("formulario");
            mv.addObject("email", email);
            System.out.println(email);
            return mv;
    }


}
