package fr.uge.poo.uberclient.question1;

import java.util.List;

import fr.uge.poo.uberclient.question1.UberClient.Builder;

public class main {
	   public static void main(String[] args) {
	        var arnaud = new UberClient("Arnaud","Carayol",1,List.of(1,2,5,2,5,1,1,1),List.of("arnaud.carayol@univ-eiffel.fr","arnaud.carayol@u-pem.fr"),List.of("07070707070707"));
	        var youssef = new UberClient("Youssef", "Bergeron", List.of(5), List.of("youssefbergeron@outlook.fr"),List.of());
	        var yassine = new Builder().firstName("Yassine").lastName("Benmechich").email(List.of("yaskow@hotmail.fr")).grades(List.of(5)).phoneNumbers(List.of("0606060606"));
	    }
}
