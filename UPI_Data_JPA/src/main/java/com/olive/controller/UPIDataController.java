package com.olive.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olive.entity.UPIEntity;
import com.olive.repository.UPIRepository;

@Controller
public class UPIDataController {
	
	@Autowired
	private UPIRepository upiRepo;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/getAllUPIData")
	public String getAllUPIData(@RequestParam("pn") Integer pageNo,Model model) {
		int pageSize = 50;
		
		PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize);
		Page<UPIEntity> upis = upiRepo.findAllUPIData(pageRequest);
		int totalPages = upis.getTotalPages();
	
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("upis", upis.getContent());
		return "view_all_upi_data";
		
	}
	
	@GetMapping("/getAllUPIDataByPM/{pn}")
	public @ResponseBody List<UPIEntity> getAllUPIDataByPM(@PathVariable Integer pn) {
		int pageSize = 50;
		
		PageRequest pageRequest = PageRequest.of(pn - 1, pageSize);
		Page<UPIEntity> upis = upiRepo.findAllUPIData(pageRequest);
		
		return upis.getContent();
		
	}
}
