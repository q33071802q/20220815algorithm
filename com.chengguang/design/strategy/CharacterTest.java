package design.strategy;

public class CharacterTest{
    public static void main(String[] args) {
        Character character = new King();
        character.fight();
        character.setWeapon(new KnifeBehavior());
        character.fight();
    }
}

abstract class Character {
    WeaponBehavior weapon;
    abstract void fight();
    void setWeapon(WeaponBehavior weaponBehavior){
        weapon = weaponBehavior;
    }
}

class Queen extends Character{

    @Override
    void fight() {
        weapon.useWeapon();
    }
}

class King extends Character{
    public King() {
        this.setWeapon(new AxeBehavior());
    }

    @Override
    void fight() {
        weapon.useWeapon();
    }
}

class Troll extends Character{

    @Override
    void fight() {
        weapon.useWeapon();
    }
}

class Knight extends Character{

    @Override
    void fight() {
        weapon.useWeapon();
    }
}

interface WeaponBehavior{
    void useWeapon();
}

class KnifeBehavior implements WeaponBehavior{

    @Override
    public void useWeapon() {
        System.out.println("knife");
    }
}

class BowAndArrowBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("BowAndArrowBehavior");
    }
}

class AxeBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("AxeBehavior");
    }
}

class SwordBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("SwordBehavior");
    }
}
