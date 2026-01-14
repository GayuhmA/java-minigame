class Player{
    String name;
    double health;
    Weapon weapon;
    Shield shield;

    Player(String name, double health){
        this.name = name;
        this.health = health;
    }

    void info(){
        System.out.println("\n----- Player Info -----");
        System.out.println("Player name: " + this.name);
        System.out.println("Player Weapon: " + this.weapon.name);
        System.out.println("Player shield: " + this.shield.name);
        System.out.println("Player total health: " + (this.shield.defense + this.health));
    }

    void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    void equipShield(Shield shield){
        this.shield = shield;
    }

    void attack(Player opponent){
        double damage = this.weapon.damage;

        if (damage < 0) {
            damage = 0;
        }

        opponent.health = opponent.health - damage;

        double currentTotalHealth = opponent.health;
        
        if (opponent.shield != null) {
            currentTotalHealth += opponent.shield.defense;
        }

        System.out.println("\n----- ATTACKING!! -----");
        System.out.println(this.name + " attacking " + opponent.name);
        System.out.println("Damage dealt: " + damage);
        System.out.println(opponent.name + " remaining health: " + currentTotalHealth);
    }
}

class Weapon{
    String name;
    double damage;

    Weapon(String name, double damage){
        this.name = name;
        this.damage = damage;
    }
}

class Shield{
    String name;
    double defense;

    Shield(String name, double defense){
        this.name = name;
        this.defense = defense;
    }
}

public class minigame {
    public static void main(String[] args) {
        // player setup
        Player player1 = new Player("Robert", 100);
        Player player2 = new Player("Ginko", 100);

        // weapon setup
        Weapon knife = new Weapon("Knife", 5);
        Weapon sword = new Weapon("Sword", 10);

        // shield setup
        Shield iron = new Shield("Iron", 20);
        Shield rock = new Shield("Rock", 10);

        // player action
        player1.equipWeapon(knife);
        player1.equipShield(iron);
        player2.equipWeapon(sword);
        player2.equipShield(rock);

        // player info
        player1.info();
        player2.info();

        // attacking
        player1.attack(player2);

    }
}
