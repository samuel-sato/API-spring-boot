package one.digitalInovation.personAPI.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @Size(min = 2, max = 150)
    private String description;
}
