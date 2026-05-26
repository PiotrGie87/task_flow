/******************************************************************************
 * Copyright (c) 2020 Objective
 * All rights reserved
 *
 * This software is the confidential and proprietary information of Objective.
 * You shall not disclose this confidential information and shall use it only
 * in accordance with the terms of the license agreement you entered into with
 * Objective.
 *******************************************************************************/
package io.github.handmadeapp.taskflow.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@Getter
@Setter
public class Comment
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String text;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
  @JoinColumn(name = "task_id")
  private Task task;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
}