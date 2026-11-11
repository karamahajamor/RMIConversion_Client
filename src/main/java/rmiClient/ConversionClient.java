package rmiClient;

import rmiService.IConversion;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConversionClient {

    // Ce nom doit être identique à celui utilisé dans ConversionServer.
    private static final String NOM_SERVICE = "ConversionService";

    public static void main(String[] args) {
        try {
            // Chercher l'annuaire RMI sur le même ordinateur, port par défaut 1099.
            Registry registry =
                    LocateRegistry.getRegistry("localhost", 1099);

            // Chercher dans l'annuaire la référence de l'objet distant.
            IConversion conversion =
                    (IConversion) registry.lookup("BK");

            // Appeler la méthode distante avec le montant demandé : 500 euros.
            double resultat = conversion.convertirMontant(500.0);

            System.out.println("Montant en euros : 500.0");
            System.out.println("Montant converti en dinars : " + resultat);

        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel au service RMI :");
            e.printStackTrace();
        }
    }
}