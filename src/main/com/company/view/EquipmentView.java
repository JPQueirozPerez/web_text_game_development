
package main.com.company.view;

import main.com.company.model.Player;

import static main.com.company.service.EquipmentService.searchItemByPlace;
import static main.com.company.service.EquipmentService.searchWeaponByPlace;


public class EquipmentView {

    public static void showEquipmentView(Player player) {

        System.out.println();
        System.out.println("EQUIPMENT");
        System.out.println();
        if (player.getEquipment().getQuantityEquippedItems() == 0)
            System.out.println("You don't have any equipment");
        else {
            System.out.println("Body: "+(player.getEquipment().isBody() ? searchItemByPlace(player.getEquipment().getEquipments(),"body").getName():""));
            System.out.println("Head: "+(player.getEquipment().isHead() ? searchItemByPlace(player.getEquipment().getEquipments(),"head").getName():""));
            System.out.println("Legs armour: "+(player.getEquipment().isLegs() ? searchItemByPlace(player.getEquipment().getEquipments(),"legs").getName():""));
            System.out.println("Arms armour: "+(player.getEquipment().isArms() ? searchItemByPlace(player.getEquipment().getEquipments(),"arms").getName():""));
            System.out.println("Right weapon: "+(player.getEquipment().isWeapon1() ? searchItemByPlace(player.getEquipment().getEquipments(),"weapon").getName():""));
            System.out.println("Left weapon: "+(player.getEquipment().isWeapon1() ?
                    (player.getEquipment().isWeapon2() ? searchWeaponByPlace(player.getEquipment().getEquipments(),"weapon").getName():"")
                    :(player.getEquipment().isWeapon2() ? searchItemByPlace(player.getEquipment().getEquipments(),"weapon").getName():"")));

//            for (int i = 0; i < player.getEquipment().getEquipments().size(); i++) {
//                System.out.println("You have a "+ player.getEquipment().getEquipments().get(i).getName());
//            }
        }
        System.out.println();
    }
}

