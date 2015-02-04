package org.dao;

import java.util.List;

import org.domain.Role;

public interface RoleDAO {
  public List<Role> getRoles();
  public Role getRole(int roleId);
  public List<Role> getRoles(List<Integer> roleIds);
}
