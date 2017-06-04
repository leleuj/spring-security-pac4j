package org.pac4j.springframework.security.profile;

import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.springframework.security.util.SpringSecurityHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;

/**
 * Specific profile manager for Spring Security.
 *
 * @author Jerome Leleu
 * @since 2.0.1
 */
public class SpringSecurityProfileManager extends ProfileManager<CommonProfile> {

    private RememberMeServices rememberMeServices;

    public SpringSecurityProfileManager(final WebContext context) {
        super(context);
    }

    @Override
    public void save(final boolean saveInSession, final CommonProfile profile, final boolean multiProfile) {
        super.save(saveInSession, profile, multiProfile);

        final Authentication auth = SpringSecurityHelper.populateAuthentication(retrieveAll(saveInSession));
        if (auth != null && rememberMeServices != null) {
            final J2EContext j2EContext = (J2EContext) context;
            rememberMeServices.loginSuccess(j2EContext.getRequest(), j2EContext.getResponse(), auth);
        }
    }

    public RememberMeServices getRememberMeServices() {
        return rememberMeServices;
    }

    public void setRememberMeServices(final RememberMeServices rememberMeServices) {
        this.rememberMeServices = rememberMeServices;
    }
}
