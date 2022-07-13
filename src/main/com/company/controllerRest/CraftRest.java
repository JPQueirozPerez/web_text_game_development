package main.com.company.controllerRest;

import main.com.company.model.Character;
import main.com.company.model.ValuesCraftController;
import main.com.company.repository.RepositoryValuesCraftController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/craft")
public class CraftRest {

    @Autowired
    RepositoryValuesCraftController repoCraft;

    @GetMapping("/listCraft")
    public Iterable<ValuesCraftController> listarChar(){
        return  repoCraft.findAllById();
    }
}
