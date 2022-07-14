package main.com.company.repository;

import main.com.company.model.Character;
import main.com.company.model.NPC;
import main.com.company.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface RepositoryChar extends JpaRepository<Character,Integer> {

    @Query("select p from Player p where p.charClass =?1")
    public Optional<Player> findBycharClass(String charClass);

    @Query("select x from NPC x where x.choice = ?1")
    public Optional<NPC> findByChoice(int choice);


    @Query("select c from Character c where c.name = ?1")
    public Optional<NPC> findByNameNPC(String name);

    @Query("select c from Character c where c.charClass is not null ")
    public Iterable<Character> findAllChar();

    @Query("select p from Player p where p.charClass is not null ")
    public Iterable<Player> findAllPlayer();

    @Query("select n from NPC n where n.charClass is not null ")
    public Iterable<NPC> findAllNPC();
}
