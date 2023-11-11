import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // demander au joueur 1 de saisir un mot
        Scanner scan = new Scanner(System.in);
        System.out.print("Joueur 1, saisissez un mot à faire deviner au joueur 2: ");
        String mot = scan.nextLine();

        //compter le nombre de caractères du mot
        int nombreCaracteres = mot.length();

        //créer un tableau visible pour chaque caractère du mot
        char[] tableauVisible = new char[nombreCaracteres];
        //intégrer chaque caractère de la phrase dans le tableau
        for (int i = 0; i < tableauVisible.length; i++) {
            tableauVisible[i] = mot.charAt(i);
        }

        //créer un tableau vide du nombre de caractères du mot, qui sera démasqué le long du jeu
        char[] tableauMasque = new char[nombreCaracteres];
        for (int i = 0; i < tableauMasque.length; i++) {
            tableauMasque[i] = '-';
            System.out.print(tableauMasque[i]);
        }

        //initialise le nombre d'erreurs à 0
        int erreur = 0;

        boolean sortie = false;

        //boucle qui demande un caractère tant que le mot n'est pas trouvé ou tant qu'il n'y a pas 5 erreurs
        while (sortie == false) {

            //demander à l'utilisateur de saisir un caractère
            System.out.println();
            System.out.println("Joueur 2: Saisissez un caractère");
            char caractere = scan.nextLine().charAt(0);

            //vérifier si le caractère est présent dans le mot:
            // parcourir la liste pour vérifier la présence de ce caractère
            for (int i = 0; i < tableauVisible.length; i++) {
                if (tableauVisible[i] == caractere) {
                    tableauMasque[i] = caractere;
                }
            }

            //Ajouter une erreur si le caractère n'est pas dans la liste
            if (!check(tableauVisible, caractere)) {
                erreur += 1;
                System.out.println("Vous avez fait une erreur, vous en êtes à " + erreur + " erreurs sur 5.");
            }

            //afficher à nouveau le mot masqué
            for (int i = 0; i < tableauMasque.length; i++) {
                System.out.print(tableauMasque[i]);
            }

            //conditions de sortie du jeu
            //si 5 erreurs, on sort du jeu
            if (erreur == 5) {
                sortie = true;
                System.out.println();
                System.out.println("Perdu, vous avez fait 5 erreurs !");
            }

            // ou si mot trouvé totalement on sort également du jeu
            if (Arrays.equals(tableauVisible, tableauMasque)) {
                sortie = true;
                System.out.println();
                System.out.println("Bravo, vous avez gagné !");
            }
        }

    }//fin du main

    //fonction qui vérifie si le caractère n'est pas présent dans le mot
    public static boolean check(char[] tab, int val) {
        boolean comparaisonCaractere = false;
        for (char caractere : tab) {
            if (caractere == val) {
                comparaisonCaractere = true;
                break;
            }
        }
        return comparaisonCaractere;
    }
}


