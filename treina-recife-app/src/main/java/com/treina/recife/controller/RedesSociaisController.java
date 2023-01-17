package com.treina.recife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.treina.recife.model.RedesSociais;
import com.treina.recife.service.ContatoService;
import com.treina.recife.service.RedesSociaisService;

@RestController
public class RedesSociaisController {


    @PostMapping("/Redes_sociais")
    public RedesSociais criarNovasRedesSociais(@RequestBody RedesSociais redesSociais){
        return redesSociaisService.save(redesSociais);
    }


    @GetMapping("/Redes_sociais")
    public Iterable<RedesSociais> obterTodasAsRedes(){
        return redesSociaisService.findAll();
    }


    @GetMapping("/Redes_sociais/{id}")
    public RedesSociais obterTodasAsRedes(@PathVariable("id") long id){
        return redesSociaisService.findById(id).get();
    }

    @DeleteMapping("/Redes_sociais/{id}")
    public String deletarRedesSociais(@PathVariable("id") long id){
        redesSociaisService.deleteById(id);

        return "Rede social deletada com sucesso";
    }

    

    @PutMapping("/Redes_sociais/")
    public RedesSociais atualizarRedeSocial(@RequestBody RedesSociais redesSociais){
        RedesSociais redesSociaisBD = redesSociaisService.findById(redesSociais.getId()).get();

        redesSociaisBD.setNome(redesSociais.getNome());
        redesSociaisBD.setLink(redesSociais.getLink());

        redesSociaisBD = redesSociaisService.save(redesSociaisBD);
        
        return redesSociaisBD;
    }


    @Autowired
    private RedesSociaisService redesSociaisService;
    
}
