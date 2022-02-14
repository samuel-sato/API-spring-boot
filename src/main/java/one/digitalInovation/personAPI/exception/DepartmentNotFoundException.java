package one.digitalInovation.personAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends Exception{
    public DepartmentNotFoundException(Long id) {
        super("Department not found with ID " + id);
    }
}
