package mu.organyze;

/**
 * Created by zunlin on 11/17/17.
 */
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
public class UnitTestForProfessionActivity {
    @Rule
    public ActivityTestRule<ProfessionActivity> mActivityRule = new ActivityTestRule(ProfessionActivity.class);

    @Test
    public void checkBartenderButton() throws Exception {
        Button bartenderButton = mock(Button.class);
        when(bartenderButton.getId()).thenReturn(R.id.bartender_button);

        ProfessionActivity activity = mActivityRule.getActivity();
        activity.onClick(bartenderButton);
        //assert contains after LogOut button is push
    }
    @Test
    //User story 11
    public void checkStoreManagerButton() throws Exception {
        Button storeManagerButton = mock(Button.class);
        when(storeManagerButton.getId()).thenReturn(R.id.store_button);

        ProfessionActivity activity = mActivityRule.getActivity();
        activity.onClick(storeManagerButton);
        //assert contains after storeManager button is push
    }

    @Test
    public void checkWareHouseButton() throws Exception {
        Button wareHouseButton = mock(Button.class);
        when(wareHouseButton.getId()).thenReturn(R.id.warehouse_button);

        ProfessionActivity activity = mActivityRule.getActivity();
        activity.onClick(wareHouseButton);
        //assert contains after wareHouse button is push
    }

    @Test
    public void checkFamilyButton() throws Exception {
        Button familyButton = mock(Button.class);
        when(familyButton.getId()).thenReturn(R.id.family_button);

        ProfessionActivity activity = mActivityRule.getActivity();
        activity.onClick(familyButton);
        //assert contains after family button is push
    }

    @Test
    //User story 9
    public void checkGymButton() throws Exception {
        Button gymButton = mock(Button.class);
        when(gymButton.getId()).thenReturn(R.id.gym_button);

        ProfessionActivity activity = mActivityRule.getActivity();
        activity.onClick(gymButton);
        //assert contains after gym button is push
    }

    @Test
    //user story 12
    public void checkRetailButton() throws Exception {
        Button retailButton = mock(Button.class);
        when(retailButton.getId()).thenReturn(R.id.retail_button);

        ProfessionActivity activity = mActivityRule.getActivity();
        activity.onClick(retailButton);
        //assert contains after retail button is push
    }

}
