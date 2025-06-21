package com.garage.gestionGarage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produit")
public class ProduitUtiliserController {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired 
    InterventionRepository interventionRepository;
    @PostMapping
    public String utiliserProduit(@RequestBody ProduitUtiliser produit) {
    	Long stockId=produit.getStock().getId();
    	Long interventionId=produit.getIntervention().getId();
    	double quantiteDemandee=produit.getQuantiteUtiliser();
    	Stock stock=stockRepository.findById(stockId).orElse(null);
    	Intervention intervention=interventionRepository.findById(interventionId).orElse(null);
    	if(stock==null)return "Produit non Trouver dans le stock";
    	if(intervention==null)return "Intervention Non trouvée";
    	if(stock.getQuantite() < quantiteDemandee)return "Quantité insuffisante dans le stock";
    	stock.setQuantite(stock.getQuantite()-quantiteDemandee);
    	stockRepository.save(stock);
    	produit.setStock(stock);
    	produit.setIntervention(intervention);
    	produit.setQuantiteUtiliser(quantiteDemandee);
    	produitRepository.save(produit);
    	return "Produit utiliser Enregistrer avec succès";
    }
    @GetMapping
    public List<ProduitDTO>afficherProduit(){
    	return produitRepository.findAll().stream().map(p->new ProduitDTO(
    			p.getId(),p.getIntervention().getTechnicien().getNom()+" "+p.getIntervention().getTechnicien().getPrenom(),
    			p.getIntervention().getTypeIntervention(),p.getStock().getNomProduit(),p.getQuantiteUtiliser())).toList();
    }
    @PutMapping("/{id}")
    public String modifierProduit(@PathVariable Long id,@RequestBody ProduitUtiliser produit) {
    	return produitRepository.findById(id).map(p->{
    		Stock stock=stockRepository.findById(produit.getStock().getId()).orElse(null);
    		Intervention intervention=interventionRepository.findById(produit.getIntervention().getId()).orElse(null);
    		if(stock==null)return "Produit non Trouver dans le stock";
        	if(intervention==null)return "Intervention Non trouvée";
        	double ancienneQuantite=p.getQuantiteUtiliser();
        	double nouvelleQuantite=produit.getQuantiteUtiliser();
        	double ajustement=nouvelleQuantite-ancienneQuantite;
        	if(ajustement >0 && stock.getQuantite()<ajustement)return "Quantité insufissante pour la mise a jour";
        	stock.setQuantite(stock.getQuantite()-ajustement);
        	stockRepository.save(stock);
        	p.setStock(stock);
        	p.setIntervention(intervention);
        	p.setQuantiteUtiliser(nouvelleQuantite);
        	produitRepository.save(p);
        	return "Produit utiliser Modifier avec succès";
    	}).orElse("Produit utiliser non trouver");
    } 
    
}
