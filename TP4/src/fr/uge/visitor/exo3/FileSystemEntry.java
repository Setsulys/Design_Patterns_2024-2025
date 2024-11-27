package fr.uge.visitor.exo3;

import java.io.IOException;
import java.nio.file.Path;

public sealed interface FileSystemEntry permits Directory,File{

}

