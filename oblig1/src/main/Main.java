package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static BinaryTree binaryTree = new BinaryTree();

    public static void main(String[] args) {
        try {
            loadDictionary("dictionary.txt");
        } catch (Exception e) {
            System.out.println("Dictionary hasn't been loaded :( \n" + e.getMessage());
            return;
        }

        menu();
        printOutStatistics();
    }


    public static void printOutStatistics(){
        System.out.println("\n****** Statistics ******");
        System.out.println("Tree depth: " + binaryTree.getHeight());

        System.out.println("Nodes per depth: ---------");
        int[] nodesPerDepth = binaryTree.getNodesPerDepth();
        int n=0;
        for (int nodes: nodesPerDepth
             ) {
            System.out.println("Depth " + n + ": " + nodes);
            n++;
        }
        System.out.println("---------------------------");


    }

    public static void menu(){

        Scanner scanner = new Scanner(System.in);
        String input = "";

        while(!input.equals("q")){
            System.out.println("Type a word:");
            input = scanner.nextLine();
            System.out.println("You are a " + input + "!");
        }
    }


    public static void loadDictionary(String filename) throws Exception {

        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            binaryTree.insert(new BinaryNode(scanner.nextLine()));
        }
    }



}
