import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAndDeleteMultiplePosts extends BaseTest {

    @Test
    @DisplayName("Create 10 posts and then delete all the posts present in the profile page")
    public void test_createAndDeleteMultiplePosts2() {
        //navigate to website - comes from Base test
        //Navigate and login
        loginToSkilloAsDefaultUser();

        //Open profile page
        skilloHeader.clickOnProfileButton();

        //Create posts
        newPostPage.createPosts(10);

        //Load all posts
        profilePage.loadAllPosts();

        //Delete posts
        profilePage.deleteAllPosts();

        //Assert that posts are deleted
        Assertions.assertTrue(profilePage.isNoPostsHereIconPresent(), "No posts here icon is not present");
    }
}
