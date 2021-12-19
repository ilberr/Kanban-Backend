package org.rygn.kanban.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChangeLog {

	private @Id @GeneratedValue Long id;
	
	private LocalDateTime occured;
	
	@ManyToOne
	private Task task;
	
	@ManyToOne
	private TaskStatus targetStatus;
	
	@ManyToOne
	private TaskStatus sourceStatus;
	
	public ChangeLog() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOccured() {
		return occured;
	}

	public void setOccured(LocalDateTime occured) {
		this.occured = occured;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskStatus getTargetStatus() {
		return targetStatus;
	}

	public void setTargetStatus(TaskStatus targetStatus) {
		this.targetStatus = targetStatus;
	}

	public TaskStatus getSourceStatus() {
		return sourceStatus;
	}

	public void setSourceStatus(TaskStatus sourceStatus) {
		this.sourceStatus = sourceStatus;
	}
	
	
}
