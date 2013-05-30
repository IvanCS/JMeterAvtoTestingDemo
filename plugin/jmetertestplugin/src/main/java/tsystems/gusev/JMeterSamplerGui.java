/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/*
 * Example Sampler GUI (non-beans version)
 */

package tsystems.gusev;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

public class JMeterSamplerGui extends AbstractSamplerGui {

	private JTextField login ;
	
	private JTextField password ;
	
	public final static String LOGIN = "JMeterSampler.LOGIN"; 
	
	public final static String PASSWORD = "JMeterSampler.PASSWORD"; 
	
	public JMeterSamplerGui() {
		
		setLayout(new BorderLayout(0, 5));
		setBorder(makeBorder());
		add(makeTitlePanel(), BorderLayout.NORTH);
		
		VerticalPanel mainpanel = new VerticalPanel();
		mainpanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Properties"));
		
		JPanel loginPanel = new JPanel(new BorderLayout(5, 0));
		JLabel loginLabel = new JLabel("Login:");
		loginPanel.add(loginLabel, BorderLayout.WEST);
		login = new JTextField(5);
		login.setText("2809");
		loginLabel.setLabelFor(login);
		loginPanel.add(login, BorderLayout.CENTER);
		mainpanel.add(loginPanel);
		
		JPanel passwordPanel = new JPanel(new BorderLayout(5, 0));
		JLabel passwordLabel = new JLabel("Password");
		passwordPanel.add(passwordLabel, BorderLayout.WEST);
		password = new JTextField(5);
		password.setText("2809");
		passwordLabel.setLabelFor(password);
		passwordPanel.add(password, BorderLayout.CENTER);
		mainpanel.add(passwordPanel);
		add(mainpanel);
		
	}
	
	
	public TestElement createTestElement() {
		JmeterSampler sampler = new JmeterSampler();
		modifyTestElement(sampler);
		return sampler;
	}

	public String getLabelResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStaticLabel() {
		// TODO Auto-generated method stub
		return "JustSampler";
	}

	public void modifyTestElement(TestElement arg0) {
		arg0.setProperty(LOGIN, login.getText());
		arg0.setProperty(PASSWORD, password.getText());
		configureTestElement(arg0);
	}
	
	@Override
	public void configure(TestElement element) {
		super.configure(element);
		login.setText(element.getPropertyAsString(LOGIN));
		password.setText(element.getPropertyAsString(PASSWORD));
	}

}
