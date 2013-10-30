package io.github.dynamit.base.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ClientBodyElement;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * @author Ivan Khalopik
 */
public class AbstractClientElement implements ClientBodyElement {

    @Parameter(name = "id", defaultPrefix = BindingConstants.LITERAL)
    private String clientId;

    private String assignedClientId;

    @Inject
    private ComponentResources resources;

    @Environmental
    private JavaScriptSupport jsSupport;

    public String getClientId() {
        return resources.isBound("id") ? clientId : assignedClientId;
    }

    @Override
    public Block getBody() {
        return resources.getBody();
    }

    protected JavaScriptSupport getJavaScriptSupport() {
        return jsSupport;
    }

    protected ComponentResources getResources() {
        return resources;
    }

    @SetupRender
    void setupId() {
        assignedClientId = resources.isBound("id") ?
                clientId :
                jsSupport.allocateClientId(resources);
    }
}
