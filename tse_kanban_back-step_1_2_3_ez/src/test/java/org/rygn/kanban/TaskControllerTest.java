package org.rygn.kanban;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.rygn.kanban.domain.Developer;
import org.rygn.kanban.service.DeveloperService;
import org.rygn.kanban.service.TaskService;
import org.rygn.kanban.utils.Constants;
import org.rygn.kanban.domain.Task;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;

public class TaskControllerTest extends ControllerTest {
	private TaskService taskService;
	private DeveloperService developerService;
	@Test
	public void testGetTasks() throws Exception {
		this.mvc.perform(get("/tasks")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].title", is("task1")))
				.andExpect(jsonPath("$[0].nbHoursForecast", is("0")))
				.andExpect(jsonPath("$[0].nbHoursReal", is("0")))
				.andExpect(jsonPath("$[0].status.label", is("TODO")))
				.andExpect(jsonPath("$[0].type.label", is("FEATURE")))
				.andExpect(jsonPath("$[0].developers[0].email", is("dev1@dev.dev")));
				}
	@Test
	public void testGetTask() throws Exception {
		Developer developer = this.developerService.findAllDevelopers().iterator().next();
		Task task = new Task();
		task.setTitle("task2");
		task.setNbHoursForecast(0);
		task.setNbHoursReal(0);
		task.setType(this.taskService.findTaskType(Constants.TASK_TYPE_BUG_ID));
		task.addDeveloper(developer);
		
		ObjectMapper mapper = new ObjectMapper();
		byte[] taskAsBytes = mapper.writeValueAsBytes(task);
		
		
		mvc.perform(get("/tasks")
				.contentType(MediaType.APPLICATION_JSON).content(taskAsBytes))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		Collection<Task> tasks = this.taskService.findAllTasks();
		Assert.assertEquals(2, tasks.size());
		boolean found = false;
		for (Task currentTask : tasks) {
			if (currentTask.getTitle().equals("task2")) {
				found = true;
				Assert.assertEquals(Constants.TASK_STATUS_TODO_LABEL, currentTask.getStatus().getLabel());
				this.taskService.deleteTask(currentTask);
			}
		}
		Assert.assertTrue(found);
				
	}

}
