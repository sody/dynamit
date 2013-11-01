package com.example.dynamit.components;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;

/**
 * @author Ivan Khalopik
 */
public class ModalForm extends Modal {

    @Parameter
    private Object[] context;

    public Object[] getContext() {
        return context;
    }

    public Object show(final Object... context) {
        this.context = context;

        return super.show();
    }

    @OnEvent(value = EventConstants.FAILURE)
    Object failure() {
        return getBody();
    }
}