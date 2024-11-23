package fr.uge.visitor.exo3;


import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    public static List<File> findFilesWithExtension(Path directory, String extension) throws IOException {
        Objects.requireNonNull(directory);
        Objects.requireNonNull(extension);
        var dir = Directory.of(directory);
        var searchedFiles = new ArrayList<File>();
        dir.content().stream().forEach(p->{switch(p){
            case File f ->{
                if(f.extension().endsWith(extension)){
                    searchedFiles.add(f);
                }
            }
            case Directory d ->{
                try{
                    searchedFiles.addAll(findFilesWithExtension(d.path(),extension));
                }catch (IOException e){
                    e.getCause();
                }
            }
        }});
        return searchedFiles;
    }

    public static void main(String[] args) throws IOException {
        Directory.of(Path.of("./root/Philosophe"));

        Directory.of(Path.of("./root/Philosophe/Grec"));
        File.of(Path.of("./root/Philosophe/Grec/Socrate.txt"));
        File.of(Path.of("./root/Philosophe/Grec/Thales.txt"));
        File.of(Path.of("./root/Philosophe/Grec/Platon.csv"));

        Directory.of(Path.of("./root/Philosophe/Francais"));
        File.of(Path.of("./root/Philosophe/Francais/Diderot.txt"));
        File.of(Path.of("./root/Philosophe/Francais/Descartes.txt"));
        File.of(Path.of("./root/Philosophe/Francais/Rousseau.csv"));
        File.of(Path.of("./root/Philosophe/Francais/Montaigne.csv"));

        File.of(Path.of("./root/Philosophe/JackMa.txt"));

        System.out.println(findFilesWithExtension(Path.of("./root/Philosophe"),"txt"));

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