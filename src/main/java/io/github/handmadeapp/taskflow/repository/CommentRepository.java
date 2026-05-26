
package io.github.handmadeapp.taskflow.repository;

import java.util.List;

import io.github.handmadeapp.taskflow.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
  List<Comment> findByTaskId(Long taskId);
  List<Comment> findByUserId(Long userId);
}