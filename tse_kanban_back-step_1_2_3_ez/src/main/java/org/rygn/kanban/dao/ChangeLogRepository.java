package org.rygn.kanban.dao;

import java.util.List;

import org.rygn.kanban.domain.ChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {

	List<ChangeLog> findByTaskId(Long taskId);
}
