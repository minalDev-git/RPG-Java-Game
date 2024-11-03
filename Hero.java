import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hero extends Character {

    public static int NumberOfDefeatedEnemies = 0;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private Item[] prizes = {new HealthPotion(), new Weapon(20), new Armor()};
    public int points;
    private final int MaxHealth = 100;
    
    Hero(String name, int health, int attackPower ){
        super(name, health, attackPower);
    }
    void attack(Enemy enemy) {
        Item inventoryItem = null;
        boolean flag = false;
        Random random = new Random();

        System.out.println("Do you want to use an item? Y/N");
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        String choice = scan.next().toLowerCase();
        if (choice.equals("y")) {
            int enemyAttackPower = getAttackPower();
            try {
                System.out.println("Enter the type of item you want to choose: 'weapon', 'armor' or, potion");
                String itemChoice = scan.next();
                for (Item item : inventory) {
                    if (item.type.equals(itemChoice)) {
                        inventoryItem = item;
                        removeItem(item);
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    // System.out.println(itemChoice +" is not available");
                    throw new ItemNotFoundException();
                }
                else{
                    if (itemChoice.equals("potion")) {
                        if (getHealth() == MaxHealth) {
                            System.out.println("Health already maximum");
                            inventory.add(inventoryItem);
                        }
                        else{
                            useItem(inventoryItem);
                        }
                    }
                    else{
                        if (itemChoice.equals("armor")) {
                            enemy.setAttackPower(enemyAttackPower - 10);
                        }
                        else{
                            enemy.setAttackPower(enemyAttackPower);
                        }
                        useItem(inventoryItem);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println("Attacking without using any Item");
            }
            finally{
                System.out.println("Action Complete");
            }
        }
        System.out.println("Attack with attackPower:" + getAttackPower());
        enemy.takeDamage(getAttackPower());
        if (!enemy.isAlive()) {
            NumberOfDefeatedEnemies++;
            Item prize = prizes[random.nextInt(prizes.length)];
            if (prize instanceof HealthPotion) {
                System.out.println("Hero collects Health Potion");
                inventory.add(prize);
            }
            else if (prize instanceof Weapon) {
                System.out.println("Hero collects a Weapon");
                inventory.add(prize);
            }
            else{
                System.out.println("Hero collects an Armor");
                inventory.add(prize);
            }
            points += 5;
        }
        
    }
    void useItem(Item item){
        if (item instanceof Armor) {
            Armor armor = (Armor) item;
            System.out.println("Equipping armor: " + armor.name + " with defense " + armor.defense);
        }
        else if (item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            System.out.println("Equipping weapon: " + weapon.name + " with attack power " + weapon.attackPower);
            setAttackPower(getAttackPower() + weapon.attackPower);
        }
        else{
            HealthPotion potion = (HealthPotion) item;
            System.out.println("Using health potion: " + potion.name + " which restores " + potion.restoreHealth + " health points.");
            setHealth(getHealth() + potion.restoreHealth);
        }
    }
    void removeItem(Item item){
        inventory.remove(item);
    }
    void addItem(Item item){
        inventory.add(item);
        System.out.println("Item added sucessfully");
    }

}
