package fr.uge.visitor.exo3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class Application {

    public static List<String> findFilesWithExtension(Path directory, String extension) throws IOException {
        Objects.requireNonNull(directory);
        Objects.requireNonNull(extension);
        var d = Directory.of(directory);
        return null;
    }

    public static void main(String[] args) {

    }
}
/**
 * Ecrivez une hiérarchie de classes permettant de représenter un système de fichier
 * contenant à la fois des fichiers et des répertoires.
 * Pour les fichiers, on donnera le Path, le nom du fichier et l'extension et
 * pour les répertoires, on donnera le Path, le nom du répertoire et son contenu.
 * Quel design pattern avez-vous utilisé ?
 *
 * Composite est le design pattern que j'ai utilisé
 *
 */