package com.infosys.employee_service.controller;

import com.infosys.employee_service.model.DepartmentDTO;
import com.infosys.employee_service.model.Employee;
import com.infosys.employee_service.model.EmployeeResponseDTO;
import com.infosys.employee_service.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping
    public List<EmployeeResponseDTO> findAll() {
        List<Employee> employees = employeeRepo.findAll(); // assuming it's a blocking call
        List<EmployeeResponseDTO> result = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        for (Employee employee : employees) {
            DepartmentDTO departmentDTO = restTemplate.getForObject(
                    "http://localhost:8081/department/" + employee.getDepartmentId(),
                    DepartmentDTO.class
            );

            if (departmentDTO != null) {
                EmployeeResponseDTO dto = new EmployeeResponseDTO();
                dto.setDeptId(departmentDTO.getDeptId());
                dto.setDeptName(departmentDTO.getDeptName());
                dto.setManagerId(departmentDTO.getManagerId());

                dto.setEmployeeId(employee.getEmpId());
                dto.setEmployeeName(employee.getEmployeeName());
                dto.setEmployeeSalary(employee.getEmployeeSalary());

                result.add(dto);
            }
        }

        return result;
    }

    @PostMapping
    public Mono<ResponseEntity<EmployeeResponseDTO>> addEmployee(@RequestBody Employee employee) {
        employeeRepo.save(employee);
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/department/"+ employee.getDepartmentId())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .map(departmentDTO -> {
                    EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
                    employeeResponseDTO.setDeptId(departmentDTO.getDeptId());
                    employeeResponseDTO.setDeptName(departmentDTO.getDeptName());
                    employeeResponseDTO.setManagerId(departmentDTO.getManagerId());

                    employeeResponseDTO.setEmployeeName(employee.getEmployeeName());
                    employeeResponseDTO.setEmployeeSalary(employee.getEmployeeSalary());
                    employeeResponseDTO.setEmployeeId(employee.getEmpId());

                    return ResponseEntity.ok(employeeResponseDTO);
                });
    }

}
