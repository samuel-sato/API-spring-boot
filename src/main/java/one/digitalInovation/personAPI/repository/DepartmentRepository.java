package one.digitalInovation.personAPI.repository;

import one.digitalInovation.personAPI.entity.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
}
