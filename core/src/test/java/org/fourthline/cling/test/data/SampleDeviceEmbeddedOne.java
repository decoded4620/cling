/*
 * Copyright (C) 2013 4th Line GmbH, Switzerland
 *
 * The contents of this file are subject to the terms of either the GNU
 * Lesser General Public License Version 2 or later ("LGPL") or the
 * Common Development and Distribution License Version 1 or later
 * ("CDDL") (collectively, the "License"). You may not use this file
 * except in compliance with the License. See LICENSE.txt for more
 * information.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */

package org.fourthline.cling.test.data;

import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.DeviceDetails;
import org.fourthline.cling.model.profile.RemoteClientInfo;
import org.fourthline.cling.model.profile.DeviceDetailsProvider;
import org.fourthline.cling.model.meta.DeviceIdentity;
import org.fourthline.cling.model.meta.Icon;
import org.fourthline.cling.model.meta.ManufacturerDetails;
import org.fourthline.cling.model.meta.ModelDetails;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.DeviceType;
import org.fourthline.cling.model.types.UDADeviceType;
import org.fourthline.cling.model.types.UDN;

import java.net.URI;

/**
 * @author Christian Bauer
 */
@SuppressWarnings({"rawtypes"})
public class SampleDeviceEmbeddedOne extends SampleDevice {

    public SampleDeviceEmbeddedOne(DeviceIdentity identity, Service service, Device embeddedDevice) {
        super(identity, service, embeddedDevice);
    }

    @Override
    public DeviceType getDeviceType() {
        return new UDADeviceType("MY-DEVICE-TYPE-TWO", 2);
    }

    @Override
    public DeviceDetails getDeviceDetails() {
        return new DeviceDetails(
                "My Testdevice Second",
                new ManufacturerDetails("4th Line", "http://www.4thline.org/"),
                new ModelDetails("MYMODEL", "TEST Device", "ONE", "http://www.4thline.org/this_is_the_embedded_model"),
                "000da201238d",
                "100000000002",
                "http://www.4thline.org/some_other_user_interface");

    }

    @Override
    public DeviceDetailsProvider getDeviceDetailsProvider() {
        return new DeviceDetailsProvider() {
            public DeviceDetails provide(RemoteClientInfo info) {
                return getDeviceDetails();
            }
        };
    }

    @Override
    public Icon[] getIcons() {
        return new Icon[]{
                new Icon("image/png", 32, 32, 8, URI.create("icon3.png"))
        };
    }

    public static UDN getEmbeddedOneUDN() {
        return new UDN("MY-DEVICE-456");
    }

}
