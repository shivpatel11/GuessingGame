import TreePackage.DecisionTreeInterface;
import TreePackage.DecisionTree;

import java.util.Iterator;
import java.util.Scanner;

public class GuessingGame
{
    private DecisionTreeInterface<String> tree;

    public GuessingGame(String question, String noAnswer, String yesAnswer)
    {
        DecisionTree<String> no = new DecisionTree<>(noAnswer);
        DecisionTree<String> yes = new DecisionTree<>(yesAnswer);
        tree = new DecisionTree<>(question, no, yes);
    }

    public void play()
    {
        Scanner kb = new Scanner(System.in);
        while (!tree.isAnswer())
        {
            System.out.print(tree.getCurrentData());
            String answer = kb.nextLine();
            if (answer.equalsIgnoreCase("no")){
                tree.advanceToNo();
            }
            if (answer.equalsIgnoreCase("yes")){
                tree.advanceToYes();
            }
        }
        if (tree.isAnswer())
        {
            System.out.print("Is your animal a " + tree.getCurrentData() + ":");
            String guess = kb.nextLine();
            if(guess.equalsIgnoreCase("yes"))
            {
                System.out.print("I win!");
            } else {
                learn();
            }
        }
        System.out.print(" Do you want a level order traversal?");
        String user = kb.nextLine();
        if (user.equalsIgnoreCase("yes"))
        {
            Iterator<String> iterator = tree.getLevelOrderIterator();
            while (iterator.hasNext())
            {
                System.out.print(iterator.next() + " ");
            }
        }
        System.out.print("\nDo you want a pre order traversal?");
        user = kb.nextLine();
        if (user.equalsIgnoreCase("yes"))
        {
            Iterator<String> iterator = tree.getPreorderIterator();
            while (iterator.hasNext())
            {
                System.out.print(iterator.next() + " ");
            }
        }
        System.out.print("\nDo you want to play again?");
        String play = kb.nextLine();
        if (play.equalsIgnoreCase("yes"))
        {
            tree.resetCurrentNode();
            play();
        }
    }

    public void learn()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("What animal were you thinking of?");
        String animal = kb.nextLine();
        String noAnswer = tree.getCurrentData();
        System.out.print("Give a question for your animal.");
        String question = kb.nextLine();
        tree.setCurrentData(question);
        tree.setResponses(animal,noAnswer);
    }
}
