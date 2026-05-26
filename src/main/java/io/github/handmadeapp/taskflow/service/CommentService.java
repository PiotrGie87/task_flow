package io.github.handmadeapp.taskflow.service;

import java.util.List;

import io.github.handmadeapp.taskflow.entity.Comment;

public interface CommentService
{
  List<Comment> findAll();

  Comment findById(Long id);

  Comment save(Comment comment);

  void deleteById(Long id);

  List<Comment> findByTaskId(Long taskId);

  List<Comment> findByUserId(Long userId);
}
