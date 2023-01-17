package com.treina.recife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.treina.recife.model.DadosPessoais;
import com.treina.recife.service.DadosPessoaisService;

@RestController
public class DadosPessoaisController {

    @PostMapping("/Dados_pessoais")
    public DadosPessoais criarDadoPessoal(@RequestBody DadosPessoais dadosPessoais){
        return dadoPessoalService.save(dadosPessoais);
    }

    

    @GetMapping("/Dados_pessoais")
    public Iterable<DadosPessoais> obterTodosDadosPessoais(){
        return dadoPessoalService.findAll();
    }

    /*@GetMapping("/contatos/{id}")
    public Contado obterTodosContatos(@PathVariable("id") long id){
        return contatoService.findById(id).get();
    }*/

    @GetMapping("/Dados_pessoais/{id}")
    public DadosPessoais obterTodosDadosPessoais(@PathVariable("id") long id){
    return dadoPessoalService.findById(id).get();
    }

    
    @DeleteMapping("/Dados_pessoais/{id}")
    public String deletarDadosPessoaisPeloId(@PathVariable("id") long id){
        dadoPessoalService.deleteById(id);

        return "Dados pessoais deletados com sucesso!";
    }

    

    @PutMapping("/Dados_pessoais/")
    public DadosPessoais atualizarDadosPessoais(@RequestBody DadosPessoais dadosPessoais){
        DadosPessoais dadosPessoaisBD = dadoPessoalService.findById(dadosPessoais.getId()).get();

        dadosPessoaisBD.setCpf(dadosPessoais.getCpf());
        dadosPessoaisBD.setRg(dadosPessoais.getRg());
        dadosPessoaisBD.setTituloEleitor(dadosPessoais.getTituloEleitor());
        dadosPessoaisBD.setPis(dadosPessoais.getPis());

        dadosPessoaisBD = dadoPessoalService.save(dadosPessoaisBD);

        return dadosPessoaisBD;

    }


    @Autowired
    private DadosPessoaisService dadoPessoalService;
    
}
