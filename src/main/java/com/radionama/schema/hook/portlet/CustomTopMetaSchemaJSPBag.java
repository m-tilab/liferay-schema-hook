package com.radionama.schema.hook.portlet;

import com.liferay.portal.deploy.hot.CustomJspBag;
import com.liferay.portal.kernel.url.URLContainer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"context.id=MyCustomJspBag", 
			"context.name=Test Custom JSP Bag",
			"service.ranking:Integer=100"
		}
	)
public class CustomTopMetaSchemaJSPBag implements CustomJspBag {
	
	 @Activate
	    protected void activate(BundleContext bundleContext) {
		 try {
			
	        _bundle = bundleContext.getBundle();

	        _customJsps = new ArrayList<>();

	        Enumeration<URL> entries = _bundle.findEntries(
	            getCustomJspDir(), "*.jsp", true);

	        while (entries.hasMoreElements()) {
	            URL url = entries.nextElement();

	            _customJsps.add(url.getPath());
	        }
	    }catch (Exception e) {
	    	e.getStackTrace();
		}
	 }
	
	@Override
	public String getCustomJspDir() {
		
		return "META-INF/jsps/";
	}

	@Override
	public List<String> getCustomJsps() {
		
		return _customJsps;
	}

	@Override
	public URLContainer getURLContainer() {

		return _urlContainer;
	}

	@Override
	public boolean isCustomJspGlobal() {

		return true;
	}

	private final URLContainer _urlContainer = new URLContainer() {

		@Override
		public URL getResource(String name) {
			return _bundle.getEntry(name);
		}
		public Set<String> getResources(String path) {
			Set<String> paths = new HashSet<>();
			for (String entry : _customJsps) {
				if (entry.startsWith(path)) {
					paths.add(entry);
				}
			}
			return paths;
		}
	};
	private List<String> _customJsps;

    private Bundle _bundle;	
}	