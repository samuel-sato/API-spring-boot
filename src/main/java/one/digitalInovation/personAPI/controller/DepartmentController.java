package one.digitalInovation.personAPI.controller;

import one.digitalInovation.personAPI.dto.request.DepartmentDTO;
import one.digitalInovation.personAPI.dto.response.MessageResponseDTO;
import one.digitalInovation.personAPI.entity.Department;

import one.digitalInovation.personAPI.exception.DepartmentNotFoundException;
import one.digitalInovation.personAPI.repository.DepartmentRepository;
import one.digitalInovation.personAPI.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

   private DepartmentService departmentService;

   @Autowired
   public DepartmentController(DepartmentService departmentService){
       this.departmentService = departmentService;
   }

    @GetMapping("/teste")
    public String getTeste(){
        return "Departamento funcionando";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createDepartmen(@RequestBody @Valid DepartmentDTO departmentDTO){
        return departmentService.createDepartment(departmentDTO);
    }

    @GetMapping()
    public List<DepartmentDTO> listAll(){
       return departmentService.listAll();
    }

    @GetMapping("/{id}")
    public DepartmentDTO findById(@PathVariable Long id) throws DepartmentNotFoundException {
       return  departmentService.findById(id);
    }

    @PutMapping("/{id}")
    public  MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid DepartmentDTO departmentDTO) throws DepartmentNotFoundException {
       return  departmentService.updateById(id, departmentDTO);
    }

}
