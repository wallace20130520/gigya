/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */

package de.hybris.jgroups.patch.setup;

import java.io.InputStream;

import de.hybris.jgroups.patch.constants.JgroupspatchConstants;
import de.hybris.jgroups.patch.service.JgroupspatchService;
import de.hybris.platform.core.initialization.SystemSetup;

import static de.hybris.jgroups.patch.constants.JgroupspatchConstants.PLATFORM_LOGO_CODE;


@SystemSetup(extension = JgroupspatchConstants.EXTENSIONNAME)
public class JgroupspatchSystemSetup {

    private final JgroupspatchService jgroupspatchService;

    public JgroupspatchSystemSetup(final JgroupspatchService jgroupspatchService) {
        this.jgroupspatchService = jgroupspatchService;
    }

    @SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
    public void createEssentialData() {
        jgroupspatchService.createLogo(PLATFORM_LOGO_CODE);
    }

    private InputStream getImageStream() {
        return JgroupspatchSystemSetup.class.getResourceAsStream("/jgroupspatch/sap-hybris-platform.png");
    }
}
