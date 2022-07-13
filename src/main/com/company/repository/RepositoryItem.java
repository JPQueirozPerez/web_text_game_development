package main.com.company.repository;

import main.com.company.model.*;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryItem extends JpaRepository<Item,Integer> {

    @Query( "select l from Item l where l.name = ?1")
    public Optional<Item>  findByName( String name);

    @Query( "select l from Item l where l.choise = ?1")
    public Optional<Item>  findByChoiseI( int choise);

    @Query("delete from Item i where i.name = ?1")
    public Optional<Item> deleteByName(String name);


    @Query( "select l from EquippableItem l where l.choise = ?1")
    public Optional<EquippableItem>  findByChoiseE( int choise);

    @Query( "select l from EquippableItem l where l.name = ?1")
    public Optional<EquippableItem>  findByNameE( String name);

    @Query( "select l from UsableItem l where l.choise = ?1")
    public Optional<UsableItem>  findByChoiseU( int choise);

    @Query( "select l from UsableItem l where l.name = ?1")
    public Optional<UsableItem>  findByNameU( String name);


    @Query("select x,p,m from Item x, UsableItem p, EquippableItem m where x.name = ?1 or p.name =?1 or m.name = ?1")
    public Optional<Object> findByNameMultiply(String name);








}
