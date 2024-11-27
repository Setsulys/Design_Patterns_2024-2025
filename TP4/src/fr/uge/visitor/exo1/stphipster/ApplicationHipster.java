package fr.uge.visitor.exo1.stphipster;

import java.util.Scanner;

public class ApplicationHipster {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            var complexTreatment = new ComplexTreatmentProcessor();
            while(sc.hasNextLine()){
                var line = sc.nextLine();
                if(line.equals("quit")) {
                    return;
                }
                var stpP=STPParser.parse(line);

                if(stpP.isEmpty()) {
                    System.out.println("Pas compris");
                    continue;
                }
                complexTreatment.visit(stpP.get());
            }
        }
    }
}

/**
 * Quel principe SOLID n'est pas implémenté par la librairie stp ?
 * Open close principle
 *
 * Comment pourrait-on résoudre le problème en utilisant le polymorphisme ? Est-ce que c'est envisageable dans cette situation ?
 * Il faut creer plusieurs methodes utilisés par chaque classe cependant certaines methodes peuvent avoir trop de responsabilités
 *
 * Quel patron permet d'ajouter des nouvelles opérations aux classes implémentant l'interface STPCommand sans modifier ces classes ?
 * Visitor
 *
 *
 */