/*
 * Copyright 2013-2017 ForgeRock AS. All Rights Reserved
 *
 * Use of this code requires a commercial software license with ForgeRock AS.
 * or with one of its affiliates. All use shall be exclusively subject
 * to such license between the licensee and ForgeRock AS.
 */

package org.forgerock.openicf.connectors.webtimesheet;

/**
 * Class to represent a WebTimeSheet Connection
 *
 * @author Robert Jackson - <a href='http://www.nulli.com'>Nulli</a>
 */
public class WebTimeSheetConnection {

    

    private final WebTimeSheetConfiguration _configuration;
    // private RTAPIClient rtapi;
    private RepliConnectClient rcc;
    
    //TODO create a _SESSION_ with RepliConnect API begin/end commands
    

/*
    public WebTimeSheetConnection(WebTimeSheetConfiguration cfg) {
        _configuration = cfg;
        rtapi = new RTAPIClient(_configuration.getURLProperty(),
                _configuration.getAppNameProperty(),
                _configuration.getAppPasswordProperty(),
                _configuration.getAdminUidProperty(),
                _configuration.getAdminPasswordProperty());

    }
 *
 *
 */

     public WebTimeSheetConnection(WebTimeSheetConfiguration cfg) {
        _configuration = cfg;
        rcc = new RepliConnectClient(cfg);



    }

    /**
     * Release internal resources
     */
    public void dispose() {
       rcc = null;
    }

    /**
     * If internal connection is not usable, throw IllegalStateException
     */
    public void test() {
       rcc.testConnection();
    }

    /**
     * get client
     */
    public RepliConnectClient getClient() {
       return rcc;
    }

}
