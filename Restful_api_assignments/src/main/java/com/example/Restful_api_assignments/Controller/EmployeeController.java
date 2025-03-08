package com.example.Restful_api_assignments.Controller;

import com.example.Restful_api_assignments.Entity.Employee;
import com.example.Restful_api_assignments.Entity.Employee_2;
import com.example.Restful_api_assignments.Exceptions.UserNotFoundException;
import com.example.Restful_api_assignments.Repository.EmployeeRepository;
import com.example.Restful_api_assignments.Service.EmployeeService;
import com.example.Restful_api_assignments.Service.EmployeeService_2;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController

public class EmployeeController {
    private final MessageSource messageSource;
    private final EmployeeService employeeService;
    private final EmployeeService_2 employeeService_2;
    @Autowired
    public EmployeeController(MessageSource messageSource, EmployeeService employeeService, EmployeeService_2 employeeService2) {
        this.messageSource = messageSource;
        this.employeeService = employeeService;
        employeeService_2 = employeeService2;
    }
    @GetMapping("/test")
    @Operation(summary = "test uri",description = "test uri")
    public String testApi(){
        return "Welcome Spring Boot!";
    }
    @Operation(summary = "Hello msg displayer",description = "displays the hello message as per the language in the header")
    @GetMapping("/msg")
    public String helloMsg(@RequestParam String username){
        Locale locale = LocaleContextHolder.getLocale();
        return (messageSource.getMessage("hello.message",null,"hi ,",locale)+" "+username);
    }


    @Operation(summary = "Get all Employees", description = "Returns the list of all the Employees")
    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @Operation(summary = "V2: Get all Employees", description = "V2: Returns the list of all the Employees")
    @GetMapping("/employees/v2")
    public ResponseEntity<List<Employee_2>> getAllEmployeesV2(){
        List<Employee_2> employees = employeeService_2.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @Operation(summary = "V2-Params: Get all Employees", description = "V2-Params: Returns the list of all the Employees")
    @GetMapping(value = "/employees",params = "version=2")
    public ResponseEntity<List<Employee_2>> getAllEmployeesV2Params(){
        List<Employee_2> employees = employeeService_2.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @Operation(summary = "V2-Headers: Get all Employees",
            description = "V2-Headers: Returns the list of all the Employees using X-API-VERSION header")
    @GetMapping(value = "/employees", headers = "X-API-VERSION=2")
    public ResponseEntity<List<Employee_2>> getAllEmployeesV2Headers() {
        List<Employee_2> employees = employeeService_2.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @Operation(summary = "V2-MIME: Get all Employees",
            description = "V2-MIME: Returns the list of all the Employees using Accept header")
    @GetMapping(value = "/employees", produces = "application/vnd.company.app-v2+json")
    public ResponseEntity<List<Employee_2>> getAllEmployeesV2Mime() {
        List<Employee_2> employees = employeeService_2.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    //    @Operation(summary = "Get Employee by Id", description = "Returns the details of the Employee By Id")
//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> getAllEmployeeById(@PathVariable Long id){
//        Employee employee= employeeService.getEmployeeById(id);
//        if(employee==null)
//            throw new UserNotFoundException("User not found with id "+id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }
    @Operation(summary = "Get Employee by Id", description = "Returns the details of the Employee By Id")
    @GetMapping("/employees/{id}")
    public EntityModel<Employee> getAllEmployeeById(@PathVariable Long id){
        Employee employee= employeeService.getEmployeeById(id);
        EntityModel<Employee> entityModel = EntityModel.of(employee);
        if(employee==null)
            throw new UserNotFoundException("User not found with id "+id);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllEmployees());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @Operation(summary = "V2: Get Employee by Id", description = "V2: Returns the details of the Employee By Id")
    @GetMapping("/employees/v2/{id}")
    public EntityModel<Employee_2> getAllEmployeeByIdV2(@PathVariable Long id){
        Employee_2 employee= employeeService_2.getEmployeeById(id);
        EntityModel<Employee_2> entityModel = EntityModel.of(employee);
        if(employee==null)
            throw new UserNotFoundException("User not found with id "+id);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllEmployeesV2());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @Operation(summary = "V2-params: Get Employee by Id", description = "V2-params: Returns the details of the Employee By Id")
    @GetMapping(value = "/employees/{id}" , params = "version=2")
    public EntityModel<Employee_2> getAllEmployeeByIdV2Params(@PathVariable Long id){
        Employee_2 employee= employeeService_2.getEmployeeById(id);
        EntityModel<Employee_2> entityModel = EntityModel.of(employee);
        if(employee==null)
            throw new UserNotFoundException("User not found with id "+id);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllEmployeesV2());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @Operation(summary = "V2-Headers: Get Employee by Id",
            description = "V2-Headers: Returns the details of the Employee By Id using X-API-VERSION header")
    @GetMapping(value = "/employees/{id}", headers = "X-API-VERSION=2")
    public EntityModel<Employee_2> getEmployeeByIdV2Headers(@PathVariable Long id) {
        Employee_2 employee = employeeService_2.getEmployeeById(id);

        if (employee == null) {
            throw new UserNotFoundException("User not found with id " + id);
        }

        EntityModel<Employee_2> entityModel = EntityModel.of(employee);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllEmployeesV2Headers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }
    @Operation(summary = "V2-MIME: Get Employee by Id",
            description = "V2-MIME: Returns the details of the Employee By Id using Accept header")
    @GetMapping(value = "/employees/{id}", produces = "application/vnd.company.app-v2+json")
    public EntityModel<Employee_2> getEmployeeByIdV2Mime(@PathVariable Long id) {
        Employee_2 employee = employeeService_2.getEmployeeById(id);

        if (employee == null) {
            throw new UserNotFoundException("User not found with id " + id);
        }

        EntityModel<Employee_2> entityModel = EntityModel.of(employee);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllEmployeesV2Mime());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }


    @Operation(summary = "Delete Employee by Id", description = "Delete the details of the Employee By Id from database")
    @DeleteMapping ("/employees/{id}")
    public ResponseEntity<String> deleteEmployees(@PathVariable Long id){
        employeeService.removeEmployeeById(id);
        return new ResponseEntity<>("Employee Removed", HttpStatus.OK);
    }
    @Operation(summary = "Update Employee Details", description = "Update the details of the Employee. Id is must and rest provides only thise which you need change")
    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployees(@Valid @RequestBody Employee employee){
        Employee employee1=employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }
    @Operation(summary = "Add a Employee", description = "Adds the Employee to database. { Id=GENERATED Automatically, name,age")
    @PostMapping(value="/employees",consumes = {"application/xml","application/json"})
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
    @Operation(summary = "V2: Add a Employee", description = "V2: Adds the Employee to database. { Id=GENERATED Automatically, name,age")
    @PostMapping(value="/employees/v2",consumes = {"application/xml","application/json"})
    public ResponseEntity<Employee_2> saveEmployeeV2(@Valid @RequestBody Employee_2 employee){
        Employee_2 employee1 = employeeService_2.addEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
    @Operation(summary = "V2-Params: Add a Employee", description = "V2-params: Adds the Employee to database. { Id=GENERATED Automatically, name,age")
    @PostMapping(value="/employees",consumes = {"application/xml","application/json"},params = "version=2")
    public ResponseEntity<Employee_2> saveEmployeeV2Params(@Valid @RequestBody Employee_2 employee){
        Employee_2 employee1 = employeeService_2.addEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
    @Operation(summary = "V2-Headers: Add an Employee",
            description = "V2-Headers: Adds the Employee to the database using X-API-VERSION header. { Id=GENERATED Automatically, firstName, lastName, address, age }")
    @PostMapping(value = "/employees", consumes = {"application/xml", "application/json"}, headers = "X-API-VERSION=2")
    public ResponseEntity<Employee_2> saveEmployeeV2Headers(@Valid @RequestBody Employee_2 employee) {
        Employee_2 savedEmployee = employeeService_2.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @Operation(summary = "V2-MIME: Add an Employee",
            description = "V2-MIME: Adds the Employee to the database using Accept header. { Id=GENERATED Automatically, firstName, lastName, address, age }")
    @PostMapping(value = "/employees", consumes = {"application/xml", "application/json"}, produces = "application/vnd.company.app-v2+json")
    public ResponseEntity<Employee_2> saveEmployeeV2Mime(@Valid @RequestBody Employee_2 employee) {
        Employee_2 savedEmployee = employeeService_2.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(summary = "Add the list of Employees", description = "Adds the list of Employee to database. { Id=GENERATED Automatically, name,age")
    @PostMapping("/employees/all")
    public ResponseEntity<List<Employee>> saveAllEmployee(@Valid @RequestBody List<Employee> employees){
        List<Employee> employee1 = employeeService.addAllEmployees(employees);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
    @Operation(summary = "V2: Add the list of Employees", description = "V2: Adds the list of Employee to database. { Id=GENERATED Automatically, name,age")
    @PostMapping("/employees/all/v2")
    public ResponseEntity<List<Employee_2>> saveAllEmployeeV2(@Valid @RequestBody List<Employee_2> employees){
        List<Employee_2> employee1 = employeeService_2.addAllEmployees(employees);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
    @Operation(summary = "V2-params: Add the list of Employees", description = "V2-params: Adds the list of Employee to database. { Id=GENERATED Automatically, name,age")
    @PostMapping(value = "/employees/all",params = "version=2")
    public ResponseEntity<List<Employee_2>> saveAllEmployeeV2Params(@Valid @RequestBody List<Employee_2> employees){
        List<Employee_2> employee1 = employeeService_2.addAllEmployees(employees);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
    @Operation(summary = "V2-Headers: Add a list of Employees",
            description = "V2-Headers: Adds a list of Employees to the database using X-API-VERSION header. { Id=GENERATED Automatically, firstName, lastName, address, age }")
    @PostMapping(value = "/employees/all", consumes = {"application/xml", "application/json"}, headers = "X-API-VERSION=2")
    public ResponseEntity<List<Employee_2>> saveAllEmployeesV2Headers(@Valid @RequestBody List<Employee_2> employees) {
        List<Employee_2> savedEmployees = employeeService_2.addAllEmployees(employees);
        return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }
    @Operation(summary = "V2-MIME: Add a list of Employees",
            description = "V2-MIME: Adds a list of Employees to the database using Accept header. { Id=GENERATED Automatically, firstName, lastName, address, age }")
    @PostMapping(value = "/employees/all", consumes = {"application/xml", "application/json"}, produces = "application/vnd.company.app-v2+json")
    public ResponseEntity<List<Employee_2>> saveAllEmployeesV2Mime(@Valid @RequestBody List<Employee_2> employees) {
        List<Employee_2> savedEmployees = employeeService_2.addAllEmployees(employees);
        return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }


    @GetMapping("/filtered-name/{id}")
    public ResponseEntity<MappingJacksonValue> filteredEmployees(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee==null)
            throw new UserNotFoundException("Employee not Found");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employee);
        SimpleBeanPropertyFilter filter1 = SimpleBeanPropertyFilter.filterOutAllExcept("name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("filter1",filter1);
        mappingJacksonValue.setFilters(filters);
        return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
    }
}
