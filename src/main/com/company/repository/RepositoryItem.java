package main.com.company.repository;

import main.com.company.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositoryItem extends JpaRepository<Item,Integer> {

    @Query( "select l from Item l where l.name = ?1")
    public Optional<Item> findByNameItem(String name);

    @Query( "select l from Item l where l.choise = ?1")
    public Optional<Item> findByChoiseItem(int choise);

    @Query("delete from Item i where i.name = ?1")
    public Optional<Item> deleteByNameItem(String name);

    @Query( "select l from EquippableItem l where l.choise = ?1")
    public Optional<EquippableItem> findByChoiseEquippable(int choise);

    @Query( "select l from EquippableItem l where l.name = ?1")
    public Optional<EquippableItem> findByNameEquippable(String name);

    @Query( "select l from UsableItem l where l.choise = ?1")
    public Optional<UsableItem> findByChoiseUsable(int choise);

    @Query( "select l from UsableItem l where l.name = ?1")
    public Optional<UsableItem> findByNameUsable(String name);









}
