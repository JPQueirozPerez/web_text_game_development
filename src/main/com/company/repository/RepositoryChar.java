package main.com.company.repository;

import main.com.company.model.Character;
import main.com.company.model.Item;
import main.com.company.model.NPC;
import main.com.company.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RepositoryChar extends JpaRepository<Character,Integer> {

    @Query("select p from Player p where p.charClass =?1")
    public Optional<Player> findBycharClass(String charClass);

    @Query("select x from NPC x where x.choise = ?1")
    public Optional<NPC> findByChoise(int choise);

    @Query("select c from Character c where c.name = ?1")
    public Optional<NPC> findByName(String name);

    @Transactional
    @Modifying
    @Query("delete from Player p where p.charClass = ?1")
    public Optional<Player>  deleteBycharClass(String charClass);

    @Transactional
    @Modifying
    @Query("delete from Character c where c.name = ?1")
    public int deleteByname(String name);

}
