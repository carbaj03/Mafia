package com.acv.mafia.view.activity.support;

import org.robolectric.RuntimeEnvironment;

public class ResourceLocator {
    public static String getString( int stringId ) {
        return RuntimeEnvironment.application.getString( stringId );
    }
}
