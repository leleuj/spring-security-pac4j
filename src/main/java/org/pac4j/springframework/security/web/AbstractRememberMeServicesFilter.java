package org.pac4j.springframework.security.web;

import org.springframework.security.web.authentication.RememberMeServices;

import javax.servlet.Filter;

/**
 * A filter for which a {@link RememberMeServices} can be set.
 *
 * @author Jerome Leleu
 * @since 2.2.0
 */
public abstract class AbstractRememberMeServicesFilter implements Filter {

    private RememberMeServices rememberMeServices;

    public RememberMeServices getRememberMeServices() {
        return rememberMeServices;
    }

    public void setRememberMeServices(final RememberMeServices rememberMeServices) {
        this.rememberMeServices = rememberMeServices;
    }
}
