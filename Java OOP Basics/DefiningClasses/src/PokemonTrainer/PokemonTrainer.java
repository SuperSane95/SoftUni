package PokemonTrainer;

import java.util.*;

/**
 * Created by iwano on 6/22/2016.
 */
public class PokemonTrainer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");
            Trainer t = new Trainer(data[0]);
            if (trainers.containsKey(data[0])) {
                trainers.get(data[0]).getPokemons().add(new Pokemon(data[1], data[2], Integer.parseInt(data[3])));
            } else {
                t.getPokemons().add(new Pokemon(data[1], data[2], Integer.parseInt(data[3])));
                trainers.put(data[0], t);
            }
            input = scan.nextLine();
        }

        input = scan.nextLine();
        while(!input.equals("End")) {
            String element = input;
            boolean flag = false;
            for (Trainer t : trainers.values()) {
                if (t.getPokemons().stream().anyMatch(p -> p.getElement().equals(element))) {
                    t.setBadges(t.getBadges() + 1);
                } else {
                    for (int i = 0; i < t.getPokemons().size(); i++) {
                        int newHealth = t.getPokemons().get(i).getHealth() - 10;
                        if (newHealth <= 0) {
                            t.getPokemons().remove(i);
                        } else {
                            t.getPokemons().get(i).setHealth(newHealth);
                        }
                    }
                }
            }

            input = scan.nextLine();
        }

        trainers.values()
                .stream()
                .sorted((p1, p2) -> Integer.compare(p2.getBadges(), p1.getBadges()))
                .forEach(p -> {
                    System.out.println(p.toString());
                });
    }
}

class Trainer {
    private String name;
    private int badges;
    ArrayList<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }

    @Override
    public boolean equals(Object obj) {
        Trainer t = (Trainer) obj;
        return this.name.equals(t.name);
    }
}

class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
