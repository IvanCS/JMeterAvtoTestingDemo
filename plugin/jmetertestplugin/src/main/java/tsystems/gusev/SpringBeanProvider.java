package tsystems.gusev;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IUserService;

public class SpringBeanProvider {
	
	private IUserService service;

	public IUserService getService() {
		return service;
	}

	public void setService(IUserService service) {
		this.service = service;
	}
}
