
package io.github.handmadeapp.taskflow.service.impl;

import java.util.List;

import io.github.handmadeapp.taskflow.entity.Comment;
import io.github.handmadeapp.taskflow.repository.CommentRepository;
import io.github.handmadeapp.taskflow.service.CommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService
{
  private final CommentRepository commentRepository;

  @Override
  public List<Comment> findAll()
  {
    return List.of();
  }

  @Override
  public Comment findById(Long id)
  {
    return null;
  }

  @Override
  public Comment save(Comment comment)
  {
    return null;
  }

  @Override
  public void deleteById(Long id)
  {

  }

  @Override
  public List<Comment> findByTaskId(Long taskId)
  {
    return List.of();
  }

  @Override
  public List<Comment> findByUserId(Long userId)
  {
    return List.of();
  }
}