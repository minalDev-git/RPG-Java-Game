import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        //Manages the game loop, handles battles between the hero and enemies, and displays the current game status.
        ArrayList<Enemy> enemies = new ArrayList<>();
        Hero hero = new Hero("Knight", 100, 20);

        hero.addItem(new HealthPotion());
        hero.addItem(new Weapon(20));
        hero.addItem(new Armor());
        
        enemies.add(new Enemy("Dragon", 50, 20));
        enemies.add(new Enemy("Whitch", 30, 10));
        enemies.add(new Enemy("Goblin", 50, 30));
        enemies.add(new Enemy("Vampire", 50, 40));

        System.out.println("Welcome to RPG Game!");
        battles(hero, enemies);
        System.out.println("Points: " + hero.points);
        System.out.println("Health: " + hero.getHealth());
        System.out.println("Number of enemies defeated: " + Hero.NumberOfDefeatedEnemies);
        System.out.println("Game Over");
    }
    static void battles(Hero hero,ArrayList<Enemy> enemies){
        Random random = new Random();
        Enemy enemy = enemies.get(random.nextInt(enemies.size()));
        while (hero.isAlive() && enemy.isAlive()) {
            hero.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(hero);
            }
            else {
                System.out.println(enemy.getName() + " is defeated!");
                enemies.remove(enemy);
            }
            if (enemies.isEmpty()) {
                break;
            }
            enemy = enemies.get(random.nextInt(enemies.size()));
        }
        if (!hero.isAlive()) {
            System.out.println(hero.getName() + " has been defeated!");
        }
        else{
            System.out.println(hero.getName()+" Won");
        }
    }
}