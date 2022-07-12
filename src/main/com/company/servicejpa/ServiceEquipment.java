package main.com.company.servicejpa;


import main.com.company.model.Equipment;

import main.com.company.repository.RepositoryEquipment;

import org.springframework.stereotype.Service;

@Service
public class ServiceEquipment {

   private final  RepositoryEquipment repoequipment;


    public ServiceEquipment(RepositoryEquipment repoequipment) {
        this.repoequipment = repoequipment;

    }





    public Equipment createEquipment2(Equipment e){
        return repoequipment.save(e);
    }

}
