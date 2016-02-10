package de.eonas.addressbook;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.application.ResourceWrapper;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

public class ResourceHandlerWrapperImpl extends
        ResourceHandlerWrapper {

    private final ResourceHandler wrapped;

    public ResourceHandlerWrapperImpl(final ResourceHandler wrapped)
    {
        this.wrapped = wrapped;
    }

    @Override
    public ResourceHandler getWrapped()
    {
        return wrapped;
    }

    @Override
    public Resource createResource(final String resourceName, final String libraryName)
    {
        final Resource resource = super.createResource(resourceName, libraryName);
        final ResourceWrapper wrapper = new ResourceWrapper() {
            @Override
            public Resource getWrapped() {
                return resource;
            }

 /*           @Override
            public Map<String, String> getResponseHeaders() {
                Map<String, String> responseHeaders1 = super.getResponseHeaders();
                HashMap<String,String> myMap = new HashMap<String, String>();
                myMap.put("Cache-Control", "max-age=3600");
                return myMap;
            }
            */
        };
        return resource;
    }

    /**
     * @see javax.faces.application.ResourceHandlerWrapper#libraryExists(java.lang.String)
     */
    @Override
    public boolean libraryExists(final String libraryName)
    {
            return super.libraryExists(libraryName);
    }

    /**
     * @see javax.faces.application.ResourceHandlerWrapper#isResourceRequest(javax.faces.context.FacesContext)
     */
    @Override
    public boolean isResourceRequest(final FacesContext context)
    {
        return super.isResourceRequest(context);
    }

}