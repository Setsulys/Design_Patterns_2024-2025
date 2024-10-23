package fr.uge.poo.uberclient.question1;

import fr.uge.poo.uberclient.question1.UberClient.Step;


public class Main {
	public static void main(String[] args) {
		//var arnaud = new UberClient("Arnaud","Carayol",1,List.of(1,2,5,2,5,1,1,1),List.of("arnaud.carayol@univ-eiffel.fr","arnaud.carayol@u-pem.fr"),List.of("07070707070707"));
		//var youssef = new UberClient("Youssef", "Bergeron", List.of(5), List.of("youssefbergeron@outlook.fr"),List.of());
		//var yassine = new Builder().firstName("Yassine").lastName("Benmechich").email(List.of("yaskow@hotmail.fr")).grade(List.of(5)).phoneNumber(List.of("0606060606"));
		var christophe = Step.newBuilder().firstName("Christophe").lastName("Haidamous").uid(56).grade(4).email("christophe.haidamous@univ-eiffel.fr").phoneNumber("0606060606").build();
		System.out.println(christophe);

		var arnaud = Step.newBuilder().firstName("Arnaud").lastName("Carayol").uid(1).grade(5).email("arnaud.carayol@univ-eiffel.fr").phoneNumber("0707070707").build();

		//var average=
		System.out.println(arnaud.exportView(new ToHTML()));
		System.out.println(arnaud.exportView(new ToHTMLSimple()));
		System.out.println(arnaud.exportView(new ToHTMWithAverageOverLast7Grades()));
		System.out.println(arnaud.exportView(new ToHtmlWithEmails()));
		System.out.println(arnaud.exportView(new ToHtmlWithEmailsAndAverageOverLast5Grades()));
		System.out.println(arnaud.exportView(new ToHTMWithAverageOverLast7Grades(),grades -> grades.stream().limit(7)
				.mapToLong(l -> l)
				.average()
				.orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"))));
	}
}
/* 
 * Est-ce que l'on peut supprimer les vérifications dans la méthode build ?
 * 
 * Non on peut pas supprimer les vérification dans la méthode build
 * 
 * 
 * 
 * Le code produit à la question précédente est à destination de l'IDE et pas de l'utilisateur, il ne respecte pas les principes SOLID. 
 * Quel principe n'est pas respecté par ce code ? Il ne faut pas abuser de ce genre d'astuces.
 * 
 * On ne respecte pas l'interface segregation principle
 * 
 * 
 * 
 * Quel principe SOLID n'est plus respecté par la classe UberClient ?
 * 
 *  le principe SOLID non respecté est la Single-responsibility principle
 */
