public class Enemy extends Character {

    Enemy(String name, int health, int attackPower ){
        super(name, health, attackPower);
    }

    void attack(Hero hero) {
        System.out.println(getName() + " attacks " + hero.getName() + " with power " + getAttackPower());
        hero.takeDamage(getAttackPower());
    }
}
