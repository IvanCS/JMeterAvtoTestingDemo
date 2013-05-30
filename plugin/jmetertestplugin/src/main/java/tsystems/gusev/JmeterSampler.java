package tsystems.gusev;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.hibernate.service.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.tsystems.JMeterAvtoTestingDemo.backend.ejbs.interfaces.IUserService;

public class JmeterSampler extends AbstractSampler {
	
	private IUserService userService;
	
	private int count = 0;

	public SampleResult sample(Entry arg0) {
		SampleResult result = new SampleResult();
		result.sampleStart();
		if (count == 0)
		{
			init();
		}
		count++;
		Boolean res = userService.checkCredentials(getLogin(),getPassword());
		result.latencyEnd();
		result.setDataType(SampleResult.TEXT);
		result.setResponseData(res.toString());
		result.setSampleLabel("Response");
		result.setSuccessful(true);
		result.sampleEnd();
		return result;
	}
	
	private void init() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("spring.xml");
		SpringBeanProvider beanProvider  =  applicationContext.getBean(SpringBeanProvider.class);
		userService = beanProvider.getService();
		}
	
	
	public String getLogin()
	{
		return this.getPropertyAsString(JMeterSamplerGui.LOGIN);
	}
	
	public String getPassword()
	{
		return this.getPropertyAsString(JMeterSamplerGui.PASSWORD);
	}

}
