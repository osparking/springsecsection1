package com.bumsoap.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenAuthenticationConverter;

public class KeycloakOpaqueRoleConverter implements OpaqueTokenAuthenticationConverter {
    /**
     * @param introspectedToken      the bearer token used to perform token introspection
     * @param authenticatedPrincipal the result of token introspection
     * @return
     */
    @Override
    public Authentication convert(String introspectedToken,
                                  OAuth2AuthenticatedPrincipal authenticatedPrincipal) {
        return null;
    }
}
