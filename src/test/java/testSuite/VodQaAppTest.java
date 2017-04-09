package testSuite;

import org.testng.annotations.Test;

public class VodQaAppTest extends BaseTestConfiguration {

    @Test
    public void verifyHorizontalSwipping() {
        loginScreen.clickSubmit();
        homeScreen.clickSlider();
        sliderScreen.slideHalf();
    }

    @Test
    public void verifySearchMovies() {
        loginScreen.clickSubmit();
        homeScreen.clickVerticalSwipe();
        verticalSwipingScreen.swipeScrollView();
        verticalSwipingScreen.swipeScrollView();
    }
}
