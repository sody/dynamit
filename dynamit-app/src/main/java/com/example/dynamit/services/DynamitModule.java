package com.example.dynamit.services;

import com.example.dynamit.internal.UserServiceImpl;
import org.apache.tapestry5.ComponentParameterConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;

/**
 * @author Ivan Khalopik
 */
public class DynamitModule {

    public static void bind(final ServiceBinder binder) {
        binder.bind(UserService.class, UserServiceImpl.class);
    }

    @ApplicationDefaults
    @Contribute(SymbolProvider.class)
    public void contributeApplicationDefaults(final MappedConfiguration<String, Object> configuration) {
        configuration.add(ComponentParameterConstants.ZONE_SHOW_METHOD, "none");
        configuration.add(ComponentParameterConstants.ZONE_UPDATE_METHOD, "none");
    }

}
