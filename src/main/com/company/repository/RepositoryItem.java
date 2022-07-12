package main.com.company.repository;

import main.com.company.model.EquippableItem;
import main.com.company.model.Item;
import main.com.company.model.NPC;
import main.com.company.model.Player;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryItem extends JpaRepository<Item,Integer> {

@Query( "select l from Item l where l.name = ?1")
    public Optional<Item>  findByName( String name);

    @Query("select x from EquippableItem x where x.choice = ?1")
    public Optional<EquippableItem> findByChoice(int choice);
}
