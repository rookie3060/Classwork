package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;
	public Optional<MODEL>getStudent(int id){
		return repository.findById(id);
	}
public String updateDetails(MODEL mod) {
	repository.save(mod);
	return "updated";
}

public String deleteDetails(int no) {
	repository.deleteById(no);
	return "Id deleted";
}
public List<MODEL>setPages(@PathVariable int offset,@PathVariable int pageSize){
	Page<MODEL> page=repository.findAll(PageRequest.of(offset, pageSize));
	return page.getContent();
}
public List<MODEL> getSort(String field){
	return repository.findAll(Sort.by(Sort.Direction.DESC,field));
}
}
