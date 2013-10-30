package com.example.dynamit.components;

import org.apache.tapestry5.Binding;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.BindingSource;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
@SupportsInformalParameters
@Import(
        stylesheet = {
                "context:css/bootstrap.css",
                "context:css/ui.css"
        },
        library = {
                "context:js/jquery.js",
                "context:js/bootstrap.js",
                "context:js/ui.js"
        })
public class Layout {

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String subtitle;

    @Property
    @Inject
    @Symbol(SymbolConstants.APPLICATION_VERSION)
    private String applicationVersion;

    @Property
    @Inject
    @Symbol(SymbolConstants.TAPESTRY_VERSION)
    private String tapestryVersion;

    @Inject
    private ComponentResources resources;

    @Inject
    private Messages messages;

    @Inject
    private BindingSource bindingSource;

    Binding defaultTitle() {
        return bindingSource.newBinding("Page title", resources.getContainerResources(), BindingConstants.PROP, "title");
    }

    Binding defaultSubtitle() {
        return bindingSource.newBinding("Page subtitle", resources.getContainerResources(), BindingConstants.PROP, "subtitle");
    }

    public String getCopyrightMessage() {
        return messages.format("message.copyright", "sod_y");
    }
}
