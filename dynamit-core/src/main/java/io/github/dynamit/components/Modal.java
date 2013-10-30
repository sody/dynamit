package io.github.dynamit.components;

import io.github.dynamit.base.components.AbstractClientElement;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Any;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.corelib.mixins.RenderInformals;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.runtime.RenderCommand;
import org.apache.tapestry5.runtime.RenderQueue;

/**
 * @author Ivan Khalopik
 */
@SupportsInformalParameters
//@Import(library = "bootstrap/modal")
public class Modal extends AbstractClientElement {

    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property(write = false)
    @Parameter
    private Block footer;

    @Parameter
    private boolean lazy;

    @Parameter
    private boolean visible;

    @Parameter(name = "class", defaultPrefix = BindingConstants.LITERAL)
    private String className;

    @Property(write = false)
    private RenderCommand showModal = new RenderCommand() {
        @Override
        public void render(final MarkupWriter writer, final RenderQueue queue) {
            if (isVisible() || isLazy()) {
                // open modal if it is visible or lazy opened
                getJavaScriptSupport().addInitializerCall("modal", new JSONObject()
                        .put("id", getClientId()));
            }
        }
    };

    @Component(inheritInformalParameters = true)
    @MixinClasses(RenderInformals.class)
    private Any container;

    @Component(inheritInformalParameters = true)
    private Zone zone;

    @Component
    private Any modal;

    @Inject
    private Block modalBlock;

    public String getTitle() {
        return title;
    }

    public boolean isLazy() {
        return lazy;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public Block getBody() {
        return modalBlock;
    }

    public String getContainerClass() {
        return className != null ?
                className + " modal" :
                "modal";
    }

    public Any getModal() {
        return modal;
    }
}