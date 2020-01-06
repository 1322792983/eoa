package com.situ.eoa.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.eoa.role.domain.Role;

@Repository
public interface RoleDao {
	Long save(Role role);

	void update(Role role);

	void delete(Long rowId);

	Role get(Long rowId);

	List<Role> find();
	
	Role getByName(String roleName);
	
	List<Role> findByPage(@Param("searchRole")Role searchRole,@Param("firstResult") Integer firstResult, @Param("maxResults") Integer maxResults);
	
	Integer getCount(@Param("searchRole")Role searchRole);
}
