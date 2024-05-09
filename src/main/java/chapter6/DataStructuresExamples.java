package chapter6;

public class DataStructuresExamples {

    public static void main(String[] args) {

        Stack stack = new Stack();

        Item martian = new Item("The martian");
        Item patriotGames = new Item("Patriot Games");
        Item bladeRunner = new Item("Blade Runner");
        Item bladeRunner2049 = new Item("Blade Runner 2049");
        Item apollo13 = new Item("Apolo 13");
        Item firstMan = new Item("First Man");
        Item empireStrikesBack = new Item("Empire Strikes Back");
        Item rogueOne = new Item("Rogue One");
        Item alexander = new Item("Alexander");
        Item starWars = new Item("Star Wars");
        Item runningMan = new Item("Running Man");

        System.out.println("Stack example:");

        stack.push(firstMan);
        stack.push(apollo13);
        stack.push(rogueOne);
        stack.push(empireStrikesBack);
        stack.push(bladeRunner2049);
        stack.push(bladeRunner);

        System.out.println(stack);

        System.out.println(stack.pop().getName() + " was popped from the stack.");

        stack.push(patriotGames);
        stack.push(martian);
        stack.push(alexander);
        stack.push(runningMan);

        System.out.println(stack.pop().getName() + " was popped from the stack.");

        stack.push(starWars);
    }
}
