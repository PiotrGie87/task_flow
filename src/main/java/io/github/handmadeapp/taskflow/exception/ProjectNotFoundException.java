
package io.github.handmadeapp.taskflow.exception;

public class ProjectNotFoundException extends RuntimeException
{
  public ProjectNotFoundException(String message)
  {
    super(message);
  }
}