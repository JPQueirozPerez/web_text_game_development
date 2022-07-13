package main.com.company.repository;

import main.com.company.model.*;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RepositoryItem extends JpaRepository<Item,Integer> {

    @Query( "select l from Item l where l.name = ?1")
    public Optional<Item>  findByName( String name);

    @Query( "select l from Item l where l.choise = ?1")
    public Optional<Item>  findByChoise( int choise);

    @Query("select x from EquippableItem x where x.choise = ?1")
    public Optional<EquippableItem> findByChoiseEquippable(int choise);

    @Query("select x from UsableItem x where x.choise = ?1")
    public Optional<UsableItem> findByChoiseUsable(int choise);

    @Query("select x,p,m from Item x, UsableItem p, EquippableItem m where x.name = ?1 or p.name =?1 or m.name = ?1")
    public Optional<Object> findByNameMultiply(String name);

    @Query("select x,p,m from Item x, UsableItem p, EquippableItem m where x.choise = ?1 or p.choise =?1 or m.choise = ?1")
    public Optional<Object> findByChoiseMultiply(int choise);


    @Query("delete from Item i where i.name = ?1")
    public Optional<Item> deleteByName(String name);


}
