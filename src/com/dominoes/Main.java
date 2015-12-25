package com.dominoes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter number of tails which will be randomly generated: ");
        Dominoes dominoes = new Dominoes(scanner.nextInt());

        System.out.printf("Print out of chain tiles? (y/n)");

        scanner.nextLine();
        if (scanner.nextLine().equals("n")) {
            Chain maxChain = dominoes.getLongestChain();
            maxChain.normaize();
            System.out.println(maxChain);
        } else {
            Chain[] chains = dominoes.getLongestChainWithOut();
            chains[0].normaize();

            System.out.println(chains[0]);
            System.out.println(chains[1]);
        }


    }
}
