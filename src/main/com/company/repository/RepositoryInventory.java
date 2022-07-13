package main.com.company.repository;

import main.com.company.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInventory extends JpaRepository<Inventory,Integer> {
}
