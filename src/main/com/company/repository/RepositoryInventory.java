package main.com.company.repository;

import main.com.company.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryInventory extends JpaRepository<Inventory,Integer> {
}
