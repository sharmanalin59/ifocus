package org.dao;
/**
 * @author : nalin sharma
 *
 */
import java.util.List;

import org.domain.SystemDefault;
import org.springframework.stereotype.Repository;

@Repository
public class SystemDefaultImpl extends AbstractJpaDAO<SystemDefault> implements SystemDefaultDAO{

	public SystemDefaultImpl(){
		setClazz(SystemDefault.class);
	}
	public SystemDefault getSystemDefault() {
		List<SystemDefault> systemDefaults = findAll();
		if(systemDefaults != null && systemDefaults.size()>0)
		return systemDefaults.get(0);
		return null;
	}

}
