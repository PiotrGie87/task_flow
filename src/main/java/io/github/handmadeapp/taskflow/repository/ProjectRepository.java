
package io.github.handmadeapp.taskflow.repository;

import io.github.handmadeapp.taskflow.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>
{
}