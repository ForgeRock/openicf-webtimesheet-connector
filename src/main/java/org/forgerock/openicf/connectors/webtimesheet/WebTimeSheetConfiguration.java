/*
 * Copyright 2013-2017 ForgeRock AS. All Rights Reserved
 *
 * Use of this code requires a commercial software license with ForgeRock AS.
 * or with one of its affiliates. All use shall be exclusively subject
 * to such license between the licensee and ForgeRock AS.
 */

package org.forgerock.openicf.connectors.webtimesheet;

import org.identityconnectors.common.Assertions;
import org.identityconnectors.common.StringUtil;
import org.identityconnectors.common.security.GuardedString;
import org.identityconnectors.framework.spi.AbstractConfiguration;
import org.identityconnectors.framework.spi.ConfigurationProperty;


/**
 * Extends the {@link AbstractConfiguration} class to provide all the necessary
 * parameters to initialize the WebTimeSheet Connector.
 *
 * @author Robert Jackson - <a href='http://www.nulli.com'>Nulli</a>
 */
public class WebTimeSheetConfiguration extends AbstractConfiguration {

private String wtsHost = null;
    private int wtsPort = 443;
    private String wtsURI = null;
    
    //TODO modify to use the FetchRemoteApiUrl with company key to be more dynamic
    
    private String adminUid = null;
    private GuardedString adminPassword = null;




    /**
     * Constructor
     */
    public WebTimeSheetConfiguration() {
    }

    /**
     * Accessor for the wtsURI property.
     */
    @ConfigurationProperty(displayMessageKey = "WTS_URI_PROPERTY_DISPLAY", helpMessageKey = "WTS_URI_PROPERTY_HELP", required = true)
    public String getWtsURI() {
        return wtsURI;
    }

    /**
     * Accessor for the adminUid property.
     */
    @ConfigurationProperty(displayMessageKey = "WTS_ADMIN_UID_PROPERTY_DISPLAY", helpMessageKey = "WTS_ADMIN_UID_PROPERTY_HELP",  required = true)
    public String getAdminUid() {
        return adminUid;
    }

    /**
     * Accessor for the adminPassword property.
     */
    @ConfigurationProperty(displayMessageKey = "WTS_ADMIN_PWD_PROPERTY_DISPLAY", helpMessageKey = "WTS_ADMIN_PWD_PROPERTY_HELP", required = true, confidential = true)
    public GuardedString getAdminPassword() {
        return adminPassword;
    }

    /**
     * Accessor for the wtsHost property.
     */
    @ConfigurationProperty(displayMessageKey = "WTS_HOST_PROPERTY_DISPLAY", helpMessageKey = "WTS_HOST_PROPERTY_HELP",  required = true)
    public String getWtsHost() {
        return wtsHost;
    }

    /**
     * Accessor for the wtsPort property.
     */
    @ConfigurationProperty(displayMessageKey = "WTS_PORT_PROPERTY_DISPLAY", helpMessageKey = "WTS_PORT_PROPERTY_HELP",  required = true)
    public int getWtsPort() {
        return wtsPort;
    }

    /**
     * Setter for the wtsURI property.
     */
    public void setWtsURI(String wtsURI) {
        this.wtsURI = wtsURI;
    }

    /**
     * Setter for the wtsHost property.
     */
    public void setWtsHost(String wtsHost) {
        this.wtsHost = wtsHost;
    }

    /**
     * Setter for the wtsPort property.
     */
    public void setWtsPort(int wtsPort) {
        this.wtsPort = wtsPort;
    }

    /**
     * Setter for the adminPassword property.
     */
    public void setAdminPassword(GuardedString adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     * Setter for the adminUid property.
     */
    public void setAdminUid(String adminUid) {
        this.adminUid = adminUid;
    }

    /**
     * {@inheritDoc}
     */
    public void validate() {
        if (StringUtil.isBlank(wtsURI)) {
            throw new IllegalArgumentException("URI cannot be null or empty.");
        }
        if (StringUtil.isBlank(wtsHost)) {
            throw new IllegalArgumentException("Host cannot be null or empty.");
        }
        if (1 > wtsPort || wtsPort > 65535) {
            throw new IllegalArgumentException("Port must be in range of [1-65535]");
        }

        if (StringUtil.isBlank(adminUid)) {
            throw new IllegalArgumentException("Admin UID cannot be null or empty.");
        }
        Assertions.nullCheck(adminPassword, "adminPassword");
    }

}
