package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
@Autowired
StudentRepository serviceRepository;
@Autowired
StudentService service;

@GetMapping("/getValues")
    List<MODEL> getList () {
	return serviceRepository.findAll();
	
}
@PostMapping("/post")
   public MODEL create(@RequestBody MODEL mod) {
	return serviceRepository.save(mod);
}
@GetMapping("/getvalues/{no}")
public Optional<MODEL>getbyid(@PathVariable int no ){
	return service.getStudent(no);
}
@PutMapping("/put")
public String update(@RequestBody MODEL mod)
{
	return service.updateDetails(mod);}
@DeleteMapping("/delete")
public String delete(@RequestParam int no) {
	return service.deleteDetails(no);
}
@GetMapping("/student/{offset}/{pageSize}")
public List<MODEL> studentWithPagination(@PathVariable int offset,@PathVariable int pageSize){
	return service.setPages(offset,pageSize);
}
@GetMapping("/student/{field}")
public List<MODEL> studentSortList (@PathVariable String field){
	return service.getSort(field);
}
	
}

