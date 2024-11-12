package fr.uge.visitor;

import com.evilcorp.stp.STPParser;
import java.util.Scanner;

public class Triviale {


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            while(sc.hasNextLine()){
                var name = STPParser.parse(sc.nextLine());
                if(!name.isEmpty()){
                    System.out.println(name.orElseThrow());
                }
                else{
                    System.out.println("Pas compris");
                }

            }
        }
    }
}

/**
 * Quel principe SOLID n'est pas implémenté par la librairie stp ?
 * Liskov substitution principle
 *
 *
 * Comment pourrait-on résoudre le problème en utilisant le polymorphisme ? Est-ce que c'est envisageable dans cette situation ?
 * Visitor
 *
 * Quel patron permet d'ajouter des nouvelles opérations aux classes implémentant l'interface STPCommand sans modifier ces classes ?
 * Adapter
 *
 *
 */