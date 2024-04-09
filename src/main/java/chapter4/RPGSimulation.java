package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RPGSimulation {

    record Monster (String name, int attack, int maxDamage, int defense) {
        static Random random = new Random();
        static int hitPoints = 2;
        static boolean alive = true;

        public int rollAttack() {
            return random.nextInt(attack) + 1;
        }

        public int rollDamage() {
            return random.nextInt(maxDamage) + 1;
        }

        public boolean isAlive() {
            return alive;
        }
    }

    public static void main(String[] args) {

        Random randomNumber = new Random();
        Map<String, String> spellbook = new TreeMap<>();
        spellbook.put("Fireball", "A ball of fire that inflicts 8 damage per level of magic.");
        spellbook.put("Healing Touch", "Touching an injured player recovers 5 hit points per character level.");
        spellbook.put("Lightning bolt", "A stream of lightning that inflicts 10 damage per level of magic.");
        spellbook.put("Create Water", "Creates 10 litres of water per level of magic.");
        spellbook.put("Transmutation", "Converts common items into gold.");

        int monsterCount = randomNumber.nextInt(4) + 1;
        List<Monster> monsters = new ArrayList<>();

        for (int monsterIdx = 0; monsterIdx < monsterCount; monsterIdx++) {
            int typeIdx = randomNumber.nextInt(4);

            switch (typeIdx) {
                case 0:
                    monsters.add(new Monster("Kobald", 2, 8, 1));
                    break;
                case 1:
                    monsters.add(new Monster("Skeleton", 2, 8, 2));
                    break;
                case 2:
                    monsters.add(new Monster("Zombie", 1, 6, 2));
                    break;
                default:
                    monsters.add(new Monster("Rats", 1, 4, 1));
            }
        }

    }
}
