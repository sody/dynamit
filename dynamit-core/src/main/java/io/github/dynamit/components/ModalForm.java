package io.github.dynamit.components;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

/**
 * @author Ivan Khalopik
 */
public class ModalForm extends Modal {

    @Parameter
    private Object[] context;

    @Inject
    private Request request;

    public Object[] getContext() {
        return context;
    }

    public String getZoneId() {
        return isLazy() ? getClientId() : null;
    }

    @OnEvent(value = EventConstants.FAILURE)
    Object failure() {
        return request.isXHR() ? getModal() : null;
    }
}