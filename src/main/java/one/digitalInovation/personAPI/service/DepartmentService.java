package one.digitalInovation.personAPI.service;

import one.digitalInovation.personAPI.dto.request.DepartmentDTO;
import one.digitalInovation.personAPI.dto.request.PersonDTO;
import one.digitalInovation.personAPI.dto.response.MessageResponseDTO;
import one.digitalInovation.personAPI.entity.Department;
import one.digitalInovation.personAPI.exception.DepartmentNotFoundException;
import one.digitalInovation.personAPI.mapper.DepartmentMapper;
import one.digitalInovation.personAPI.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper = DepartmentMapper.INSTANCE;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public MessageResponseDTO createDepartment(DepartmentDTO departmentDTO){

        Department departmentToSave = departmentMapper.INSTANCE.toModel(departmentDTO);

        Department savedDepartment = departmentRepository.save(departmentToSave);

        return MessageResponseDTO
                .builder()
                .message("Created department whit ID " + savedDepartment.getId())
                .build();
    }

    public List<DepartmentDTO> listAll(){
        List<Department> departmentList = (List<Department>) departmentRepository.findAll();
        return departmentList.stream()
                .map(departmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DepartmentDTO findById(Long id) throws DepartmentNotFoundException {
        Department department = verifyIfExistsDepartment(id);
        return departmentMapper.toDTO(department);
    }

    public MessageResponseDTO updateById(Long id, DepartmentDTO departmentDTO) throws DepartmentNotFoundException {
        verifyIfExistsDepartment(id);
        Department departmentToUpdate = departmentMapper.toModel(departmentDTO);
        Department departmentSaved = departmentRepository.save(departmentToUpdate);

        return MessageResponseDTO
                .builder()
                .message("Updated department with ID " + departmentSaved.getId())
                .build();
    }

    public Department verifyIfExistsDepartment(Long id) throws DepartmentNotFoundException {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

}
