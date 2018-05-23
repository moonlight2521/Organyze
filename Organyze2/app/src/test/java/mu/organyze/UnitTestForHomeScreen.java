package mu.organyze;

import android.app.Activity;
import android.widget.TextView;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.widget.Button;
import static org.mockito.Mockito.*;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;


/**
 * Created by zunlin on 11/16/17.
 */
//mock creation
@RunWith(AndroidJUnit4.class)
public class UnitTestForHomeScreen {
//Rules for the activity.
    @Rule
    public ActivityTestRule<HomeScreen> mActivityRule = new ActivityTestRule(HomeScreen.class);
//testing logout button.
    @Test
    public void checkLogOutButton() throws Exception {
        Button buttonLogOut = mock(Button.class);
        when(buttonLogOut.getId()).thenReturn(R.id.buttonLogOut);

        HomeScreen activity = mActivityRule.getActivity();
        activity.onClick(buttonLogOut);
        //assert contains after LogOut button is push
    }
//testing store button.
    @Test
    public void checkStoreButton() throws Exception {
        Button storeButton = mock(Button.class);
        when(storeButton.getId()).thenReturn(R.id.buttonStoreData);

        HomeScreen activity = mActivityRule.getActivity();
        activity.onClick(storeButton);
        //assert contains after storeButton is push
    }
//testing search button.
    @Test
    public void checkSearchButton() throws Exception {
        Button searchButton = mock(Button.class);
        when(searchButton.getId()).thenReturn(R.id.buttonSearch);

        HomeScreen activity = mActivityRule.getActivity();
        activity.onClick(searchButton);
        //assert contains after searchButton button is push
    }
//testing ranking button.
    @Test
    public void checkRankingButton() throws Exception {
        Button rankingButton = mock(Button.class);
        when(rankingButton.getId()).thenReturn(R.id.buttonRankings);

        HomeScreen activity = mActivityRule.getActivity();
        activity.onClick(rankingButton);
        //assert contains after LogOut button is push
    }
}

