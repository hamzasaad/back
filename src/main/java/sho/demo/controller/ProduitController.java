package sho.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import sho.demo.dao.Produitrepository;
import sho.demo.models.Produit;
import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/users/produit")
public class ProduitController {
    @Autowired
    Produitrepository produitrepository;
    @Autowired


    @GetMapping("/get")
    public List<Produit> getAllProduit(){return produitrepository.findAll();}

    @PostMapping("/save")
    public Produit saveProduit(@RequestBody Produit produit){return produitrepository.save(produit);}


    @PutMapping("/update/{id}")
    public Produit updateProduit(@RequestBody Produit produit, @PathVariable Long id){
        Produit produitExistant = produitrepository.findOne(id);
        produitExistant.setNom(produit.getNom());
        produitExistant.setPrix(produit.getPrix());
        produitExistant.setQuantite(produit.getQuantite());
        return produitrepository.saveAndFlush(produitExistant);
    }

    @GetMapping ("/getone/{id}")
    public Produit getOneProduit(@PathVariable Long id){
        return produitrepository.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteProduit(@PathVariable Long id){
        HashMap message = new HashMap();
        try{
            produitrepository.delete(id);
            message.put("status","produit deleted !");
            return message;
        }catch(Exception e){
            message.put("status","produit not found !");
            return message;
        }
    }

}
