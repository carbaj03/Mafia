package com.acv.mafia.view.activity;

import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.acv.mafia.BuildConfig;
import com.acv.mafia.R;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.acv.mafia.view.activity.support.ResourceLocator.getString;
import static com.acv.mafia.view.activity.support.ViewLocator.getFragment;
import static com.acv.mafia.view.activity.support.ViewLocator.getToolbar;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class HomeActivityTest {

    HomeActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(HomeActivity.class);
    }

    public void testContainsUserListFragment() {

        Fragment userListFragment = getFragment(activity, R.id.container);
        assertThat(userListFragment, is(notNullValue()));
    }

    @Test
    public void testTitleIsVisible() throws Exception {

        Toolbar toolbar = getToolbar(activity, R.id.toolbar);
        assertNotNull(toolbar);
        Assert.assertThat(toolbar.getTitle().toString(),
                equalTo(getString(R.string.app_name)));
    }
}