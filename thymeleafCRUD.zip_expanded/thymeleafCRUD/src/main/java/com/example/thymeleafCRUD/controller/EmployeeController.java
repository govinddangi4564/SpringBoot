package com.example.thymeleafCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleafCRUD.entity.Employee;
import com.example.thymeleafCRUD.service.EmployeeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService service;

	@GetMapping("/")
	public String getEmployee(Model model) {
		model.addAttribute("employees", service.viewEmployee());
		return "index";
	}

	@GetMapping("/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}

	@PostMapping("/add")
	public String saveEmployee(@ModelAttribute Employee employee) {
		service.addEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable Long id, Model model) {
		Employee employee = service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update";
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
		service.updateEmployee(employee.getId(), employee);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return "redirect:/";
	}
}
