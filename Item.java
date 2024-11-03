public abstract class Item {

    public String name;
    public String type;
    
    Item(String name, String type){
        this.name = name;
        this.type = type;
    }

}
class Weapon extends Item {

    int attackPower;

    Weapon(int attackPower) {
        super("sword", "weapon");
        this.attackPower = attackPower;
    }
}
class Armor extends Item {

    int defense;

    Armor() {
        super("Armor", "armor");
        this.defense = 10;
    }
}
class HealthPotion extends Item {

    int restoreHealth;

    HealthPotion() {
        super("HealthPotion", "potion");
        this.restoreHealth = 10;
    }
}
