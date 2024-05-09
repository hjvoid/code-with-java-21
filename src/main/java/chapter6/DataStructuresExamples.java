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

        System.out.println("Queue example:");

        Queue queue = new Queue();

        queue.enqueue(starWars);
        queue.enqueue(bladeRunner);
        queue.enqueue(empireStrikesBack);
        queue.enqueue(patriotGames);
        queue.enqueue(bladeRunner2049);

        System.out.println(queue);

        System.out.println(queue.dequeue().getName() + " was dequeued from the queue.");
        System.out.println(queue.dequeue().getName() + " was dequeued from the queue.");

        System.out.println(queue);

        System.out.println("Linked list example:");

        LinkedList linkedList = new LinkedList();

        Item  elddim = new Item("Elddim");
        Item  crystwind = new Item("Crystwind");
        Item  fallraen = new Item("Fallraen");
        Item  meren = new Item("Meren");
        Item  lang = new Item("Lang");
        Item  hiroth = new Item("Hiroth");

        linkedList.addItem(lang);
        linkedList.addItem(meren);
        linkedList.addItem(fallraen);
        linkedList.addItem(crystwind);
        linkedList.addItem(elddim);

        System.out.println(linkedList);

        System.out.println("Does the list contain " + crystwind.getName() + "?");
        if(linkedList.findItemByName(crystwind.getName()) != null) {
            System.out.println("Yes!");
        }else{
            System.out.println("No! Not found...\uD83D\uDE14");
        }

        System.out.println("Does the list contain " + hiroth.getName() + "?");
        if(linkedList.findItemByName(hiroth.getName()) != null) {
            System.out.println("Yes!");
        }else{
            System.out.println("No! Not found...\uD83D\uDE14");
        }

        System.out.println("Now remove " + meren.getName());
        linkedList.removeItemByName(meren.getName());

        System.out.println(linkedList);

    }
}
