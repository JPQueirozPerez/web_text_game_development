//package main.com.company.controllerRest;
//
//
//import main.com.company.model.Equipment;
//import main.com.company.model.EquippableItem;
//import main.com.company.model.Item;
//import main.com.company.servicejpa.ServiceEquipment;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//@RestController
//@RequestMapping("/equipment")
//public class EquipmentRest {
//    @Autowired
//    ServiceEquipment serveequipment;
//
//    @PostMapping("/addE")
//    public Equipment saveE(@RequestBody Equipment e){
//        return serveequipment.createEquipment2(e);
//    }
////
////    @PostMapping("/add")
////    public String saveItemT(@ModelAttribute ("equipment") Equipment equipment) {
////        serveequipment.saveItem(equipment);
////        return "redirect:/equipment";
////    }
//}
