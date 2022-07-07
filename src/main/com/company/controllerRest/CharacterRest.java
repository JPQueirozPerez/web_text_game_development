package main.com.company.controllerRest;

import main.com.company.model.*;
import main.com.company.repository.RepositoryChar;
import main.com.company.servicejpa.ServiceCharacterJPA;
import main.com.company.servicejpa.ServiceEquipment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/char")
public class CharacterRest {
    @Autowired
    RepositoryChar repositoryChar;

    @Autowired
    ServiceCharacterJPA serviceChar;

    //---------------------------Rest Player------------------------------------------//

    @GetMapping("/player/{charClass}")
    public Player getByNameP(@PathVariable String charClass){
        Optional<Player> player = repositoryChar.findBycharClass(charClass);
        return player.get();
    }

    @PostMapping("/player/add")
    public Player save(@RequestBody Player player){
        return repositoryChar.save(player);
    }

    @PutMapping("/player/update/{charClass}")
    public  Player updateP(@PathVariable String charClass, @RequestBody Player player){
        return serviceChar.update(charClass,player);
    }

    @DeleteMapping("/player/delete/{name}")
    public ResponseEntity<Void> deleteP(@PathVariable("charClass") String charClass) {
        serviceChar.deleteBycharClass(charClass);
        return ResponseEntity.noContent().build();
    }
    //---------------------------Rest Player------------------------------------------//

    //---------------------------Rest NPC------------------------------------------//

    @GetMapping("/npc/{name}")
    public NPC getByNameN(@PathVariable String name){
        Optional<NPC> npc = repositoryChar.findByName(name);
        return npc.get();
    }

    @PostMapping("/npc/add")
    public NPC save(@RequestBody NPC npc){
        return repositoryChar.save(npc);
    }

    @PutMapping("/npc/update/{name}")
    public  NPC update(@PathVariable String name, @RequestBody NPC npc){
        return serviceChar.update(name,npc);
    }

    @DeleteMapping("/npc/delete/{name}")
    public ResponseEntity<Void> deleteN(@PathVariable("name") String name) {
        serviceChar.deleteByname(name);
        return ResponseEntity.noContent().build();
    }
    //---------------------------Rest NPC------------------------------------------//
}
