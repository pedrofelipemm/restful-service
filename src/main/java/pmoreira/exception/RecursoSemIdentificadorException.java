package pmoreira.exception;

public class RecursoSemIdentificadorException extends Exception {

    private static final long serialVersionUID = 1L;

    public RecursoSemIdentificadorException(String recurso) {
        super(recurso + " não encontrado!");
    }
}
