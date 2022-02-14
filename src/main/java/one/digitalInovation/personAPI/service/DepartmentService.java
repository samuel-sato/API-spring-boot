package one.digitalInovation.personAPI.service;

import one.digitalInovation.personAPI.dto.response.MessageResponseDTO;
import one.digitalInovation.personAPI.entity.Department;
import one.digitalInovation.personAPI.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public MessageResponseDTO createDepartment(Department department){

        Department savedDepartment = departmentRepository.save(department);

        return MessageResponseDTO
                .builder()
                .message("Created department whit ID " + savedDepartment.getId())
                .build();
    }
}
