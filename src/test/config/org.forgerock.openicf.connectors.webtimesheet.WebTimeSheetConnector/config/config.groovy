/*
 * Copyright 2011-2017 ForgeRock AS. All Rights Reserved
 *
 * Use of this code requires a commercial software license with ForgeRock AS.
 * or with one of its affiliates. All use shall be exclusively subject
 * to such license between the licensee and ForgeRock AS.
 */

/* +---------------------------------------------------+
 *  ----------- Contract Tests configuration ------------
 *  +---------------------------------------------------+
 */

import org.identityconnectors.common.security.GuardedString

// Connector WRONG configuration for ValidateApiOpTests
connector.i1.wrong.host=""
connector.i2.wrong.login=""
connector.i3.wrong.password=new GuardedString("".toCharArray())


configuration{
    wtsURI ="__configureme__"
    adminUid = "__configureme__"
    adminPassword = new GuardedString("__configureme__".toCharArray())
    xadminPassword = "__configureme__"
    wtsHost = "__configureme__"
    wtsPort = 443
}

testsuite {
    // path to bundle jar - property is set by ant - leave it as it is
    bundleJar=System.getProperty("bundleJar")
    bundleName=System.getProperty("bundleName")
    bundleVersion=System.getProperty("bundleVersion")
    connectorName=System.getProperty("connectorName")
} // testsuite

HOST="0.0.0.0"
