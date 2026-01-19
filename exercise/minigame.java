import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        // weapon setup
        Weapon knife = new Weapon("Knife", 25);
        Weapon sword = new Weapon("Sword", 50);

        // shield setup
        Shield iron = new Shield("Iron", 30);
        Shield rock = new Shield("Rock", 15);

        // Human Player Setup
        System.out.print("Masukkan nama Player: ");
        String plName = scanner.nextLine();
        
        Player player1 = new Player(plName, 100);

        // Weapon Selection
        System.out.println("\nPilih Senjata:");
        System.out.println("1. Knife (Damage: 25)");
        System.out.println("2. Sword (Damage: 50)");
        System.out.print("Pilihan (1/2): ");
        int weaponChoice = scanner.nextInt();

        if (weaponChoice == 1) {
            player1.equipWeapon(knife);
        } else {
            player1.equipWeapon(sword);
        }

        // Shield Selection
        System.out.println("\nPilih Shield:");
        System.out.println("1. Iron (Defense: 30)");
        System.out.println("2. Rock (Defense: 15)");
        System.out.print("Pilihan (1/2): ");
        int shieldChoice = scanner.nextInt();

        if (shieldChoice == 1) {
            player1.equipShield(iron);
        } else {
            player1.equipShield(rock);
        }

        // Opponent Setup (Auto)
        Player player2 = new Player("Ginko", 100);
        player2.equipWeapon(knife);
        player2.equipShield(rock);

        // player info
        player1.info();
        player2.info();

        // attacking example
        player1.attack(player2);
        
        scanner.close();
    }
}
