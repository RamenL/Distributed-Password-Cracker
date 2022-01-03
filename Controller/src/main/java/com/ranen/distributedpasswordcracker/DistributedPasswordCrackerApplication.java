package com.ranen.distributedpasswordcracker;

import com.ranen.distributedpasswordcracker.agent.AgentMapping;
import com.ranen.distributedpasswordcracker.passwordmanager.PasswordManager;
import com.ranen.distributedpasswordcracker.tasks.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SpringBootApplication
@RestController
public class DistributedPasswordCrackerApplication {

	private AgentMapping agentMapping = new AgentMapping();
	private PasswordManager passwordManager = new PasswordManager();

	public static void main(String[] args) {
		SpringApplication.run(DistributedPasswordCrackerApplication.class, args);
	}

	@GetMapping("/")
	public Map<String, String> getFinishedWorkItems() {
		return passwordManager.getCompletedWorkItems();
	}

	@PostMapping("/new")
	public void addPasswordToCrack(@RequestParam(value = "password") String password) {
		passwordManager.addWorkItem(password);
	}

	//@RequestParam(value = "name", defaultValue = "World") String name
	@GetMapping("/request")
	public Task requestWork(HttpServletRequest request) {
		return agentMapping.assignWorkToNode(request.getRemoteAddr());
	}

	@PostMapping("/update")
	public boolean reportWork(@RequestParam(value = "password") String password, HttpServletRequest request) {
		//check that task is still being updated. We use the password to see if it's still valid
		return true;
	}

	//report work
	//length

	//add more work
}