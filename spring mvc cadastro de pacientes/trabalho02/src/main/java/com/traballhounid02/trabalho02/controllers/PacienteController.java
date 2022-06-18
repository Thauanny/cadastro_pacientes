package com.traballhounid02.trabalho02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traballhounid02.trabalho02.dto.RequestNewPacientDTO;
import com.traballhounid02.trabalho02.models.Paciente;
import com.traballhounid02.trabalho02.services.PacienteService;

@Controller

public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value = "/cadastro_pacientes")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("pacientes/index");
        List<Paciente> pacientes = this.pacienteService.findAll();
        mv.addObject("pacientes", pacientes);
        return mv;

    }

    @GetMapping(value = "/cadastro_pacientes/new")
    public String newPacient() {

        return "pacientes/new";

    }

    @PostMapping(value = "/cadastro_pacientes")
    public String create(RequestNewPacientDTO req) {
        Paciente paciente = req.toPaciente();
        this.pacienteService.save(paciente);
        return "redirect:http://localhost:9000/CADASTROPACIENTES/cadastro_pacientes";
    }

}
