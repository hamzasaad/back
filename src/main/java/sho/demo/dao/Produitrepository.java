package sho.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sho.demo.models.Produit;

@Repository
public interface Produitrepository extends JpaRepository<Produit,Long>{
}
