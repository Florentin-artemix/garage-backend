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
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    StockRepository stockRepository;
    @PostMapping
    public String ajouterStock(@RequestBody Stock stock) {
    	stockRepository.save(stock);
    	return "Stock ajouter avec succès";
    }
    @GetMapping
    public List<Stock>afficherStock(){
    	return stockRepository.findAll();
    }
    @PutMapping("/{id}")
    public String modifierStock(@PathVariable Long id,@RequestBody Stock stock) {
    	return stockRepository.findById(id).map(s->{
    		s.setNomProduit(stock.getNomProduit());
    		s.setQuantite(stock.getQuantite());
    		s.setFournisseur(stock.getFournisseur());
    		s.setPrixUnitaire(stock.getPrixUnitaire());
    		s.setSeuilAlerte(stock.getSeuilAlerte());
    		stockRepository.save(s);
    		return"Stock Modifier avec succès";
    	}).orElse("Stock Non Trouver");
    }
}
