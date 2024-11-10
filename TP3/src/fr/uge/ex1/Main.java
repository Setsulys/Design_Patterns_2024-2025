package fr.uge.ex1;

public class Main {
    public static void main(String[] args) {
/*        Duck duck1 = new RegularDuck();
        duck1.quack();
        Duck duck2 = new LoggedDuck(new RegularDuck());
        duck2.quack();
        duck1.quack();
        duck2.quack();*/
        Duck duck = new LoggedDuck(new RegularDuck());
        duck.quackManyTimes(2);
    }
}
/**
 * Expliquez pourquoi votre décorateur ne logge aucun quack avec le code ci-dessous:
 *
 * Parce qu'on ne passe pas par le quack du LoggedDuck
 *
 *
 * Mettez le code de quackManyTimes en default dans l'interface. Expliquez pourquoi on obtient bien le comportement attendu. Est-ce que cette solution est robuste ?
 *
 * On Obtient le comportement attendu car on utilisera le quackmanytime de l'interface et non celui des autres Duck
 * Ce n'est pas robuste car on a pas a override quackManyTimes et on aura pas le comportement voulu si on recree quackManyTimes
 *
 */
