package one.digitalInovation.personAPI.mapper;

import one.digitalInovation.personAPI.dto.request.DepartmentDTO;
import one.digitalInovation.personAPI.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    Department toModel(DepartmentDTO departmentDTO);

    DepartmentDTO toDTO(Department department);
}
