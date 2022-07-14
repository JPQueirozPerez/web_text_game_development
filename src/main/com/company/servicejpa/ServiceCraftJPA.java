package main.com.company.servicejpa;

import main.com.company.model.ValuesCraftController;
import main.com.company.repository.RepositoryValuesCraftController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;
@Service
public class ServiceCraftJPA {


    @Autowired
    private RepositoryValuesCraftController repoCraft;

    private static RepositoryValuesCraftController repoC;

    @PostConstruct
    public void init(){
        this.repoC = repoCraft;

    }

    public ValuesCraftController findbyID(int id){
        Optional<ValuesCraftController> o = repoC.findById(id);
        ValuesCraftController n = o.get();
        return n;
    }

    public Iterable<ValuesCraftController> findAll(){
        Iterable<ValuesCraftController> craftRecipes = repoC.findAllById();
        return craftRecipes;
    }


}