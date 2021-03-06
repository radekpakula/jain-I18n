/* 
 * Copyright 2012 Lokesh Jain.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.jain.addon.authentication;

import java.io.Serializable;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HasComponents;

/**
 * <code>JLoginHandler<code> is a class to handle login and logout events <br/>
 * @author Lokesh Jain
 * @since Aug 28, 2012
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class JLoginHandler implements Serializable {
	/**
	 * Once user log in into the application we need to call this API by passing a root.<br/>
	 * This calls out all the {@link JNILoginListner} components onLogin method.  
	 * @param container
	 */
	public static void onLogin (HasComponents container) {
		for (Component component : container) {
			if (component instanceof JNILoginListner)
				((JNILoginListner) component).onLogin();
			
			if (component instanceof ComponentContainer)
				onLogin((ComponentContainer)component);
		}
	}
}
