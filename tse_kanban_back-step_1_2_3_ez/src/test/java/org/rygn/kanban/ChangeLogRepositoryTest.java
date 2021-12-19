package org.rygn.kanban;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rygn.kanban.dao.ChangeLogRepository;
import org.rygn.kanban.dao.TaskRepository;
import org.rygn.kanban.domain.ChangeLog;
import org.rygn.kanban.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
public class ChangeLogRepositoryTest {

	@Autowired
    private TaskRepository taskRepository;
	
	@Autowired
    private ChangeLogRepository changeLogRepository;
		
	@Test
	public void testFindByTaskId() {
		
		Task task = this.taskRepository.findAll().iterator().next();
		
		ChangeLog changeLog = new ChangeLog();
		changeLog.setOccured(LocalDateTime.now());
		changeLog.setSourceStatus(task.getStatus());
		changeLog.setTargetStatus(task.getStatus());
		changeLog.setTask(task);
		
		this.changeLogRepository.save(changeLog);
				
		List<ChangeLog> changeLogs = this.changeLogRepository.findByTaskId(task.getId());
		
		Assert.assertEquals(1, changeLogs.size());
	}
	
}
