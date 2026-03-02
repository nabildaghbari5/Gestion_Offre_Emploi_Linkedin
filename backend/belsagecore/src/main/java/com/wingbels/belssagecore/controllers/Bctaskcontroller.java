package com.wingbels.belssagecore.controllers;

import com.wingbels.belssagecore.servicesImp.request.FilterTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.entities.Bctask;
import com.wingbels.belssagecore.services.Bctaskservice;

@RestController
@RequestMapping("/api/core/task")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Bctaskcontroller {
	@Autowired
	Bctaskservice bctaskservice;

	@PostMapping("/taskcreation")
	public ResponseEntity<?> taskcareer(@RequestBody Bctask task) {
		try {
			return ResponseEntity.ok(bctaskservice.createTask(task));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/taskdelete/{idtask}")
	public ResponseEntity<?> delete(@PathVariable Long idtask) {
		try {
			bctaskservice.delete(idtask);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@PutMapping("/taskupdate")
	public ResponseEntity<?> updateCareer(@RequestBody Bctask task) {
		try {
			return ResponseEntity.ok(bctaskservice.updateTask(task));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@GetMapping("/listAlltasks")
	public ResponseEntity<?> findalltasks() {
		try {
			return ResponseEntity.ok(bctaskservice.findall());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@GetMapping("/listTaskByemp/{idemp}")
	public ResponseEntity<?> findtasksEmp(@PathVariable Bcemployees emp) {
		try {
			return ResponseEntity.ok(bctaskservice.findtaskEmp(emp));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@GetMapping("/get-task/{id}")
	public ResponseEntity<?> getTaskById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(bctaskservice.findtaskbyid(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(-1);
		}
	}

	@PostMapping("/filter-task")
	public ResponseEntity<?> filterTasks(@RequestBody FilterTask task){
		try{
			return ResponseEntity.ok(bctaskservice.filterTasks(task));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
