package riccardomamoli.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long ISBN) {
        super("L'elemento con id " + ISBN + " non è stato trovato");
    }
}