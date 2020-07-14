package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class BlogsPage {


    //members
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='index-main-page-search']/div[2]/div/div[1]/span[2]")
    public WebElement searchBlogsBar;

    @FindBy(xpath = "//*[@id='index-main-page-search']/div[2]/div/div[2]/ul/div/li/input")
    public WebElement searchBlogsInput;


    @FindBy(css = "div[class='mdc-menu-surface--anchor h-full cursor-pointer'] div div")
    public WebElement searchBlogsButton;

    @FindBy(css = "div[class='mt-10 md:mt-20'] article div:nth-of-type(2) a span")
    public WebElement writeABlog;

    @FindBy(xpath = "//*[text()='המלצות המערכת']")
    public WebElement systemSuggestions;

    @FindBy(css = "div[id='app'] div main article:nth-child(6) div div article")
    public List<WebElement> suggestedBlogPosts;

    @FindBy(xpath = "//*[text()='פוסטים מתוך הבלוגים של למטייל']")
    public WebElement postsFromBlogs;


    //REGULAR EXPRRESSION
    @FindBy(css = "div[id='app'] div main article:nth-child(7) article[class*='post-card']")   //should be 30
    public List<WebElement> recentBlogPosts;

    @FindBy(css = "div[id='results-container'] article[class*='post-card']")
    public List<WebElement> nextPageBlogPosts;

    @FindBy(css = "li[class='page-item'] a")
    public WebElement nextSectionOfBlogPostsButton;

    @FindBy(css = "div:nth-of-type(1) main section:nth-of-type(1) div:nth-of-type(2) h2")
    public WebElement blogPostsHeader;

    @FindBy(xpath = "//*[@id='app']/section[3]/main/h1")
    public WebElement postHeader;

    @FindBy(css = "section[class='mb-10'] div:nth-of-type(2) label input")
    public WebElement searchBlogFreeText;

    @FindBy(css = "div[id='results-container'] article")   //size:2
    public List<WebElement> myBlogPosts;


    @FindBy(css = "[id='app'] section div h1")
    public WebElement myBlog;

    @FindBy(xpath = "//button[contains(text(), 'דלג לאתר')]")
    public WebElement skipToPageButton;

    @FindBy(id = "blog_permissions")
    public WebElement blogPermissions;

    @FindBy(xpath = "//*[@id='blog_permissions']/label[2]/div/ins")
    public WebElement makeBlogPostPrivate;

    @FindBy(xpath = "//*[@id='blog_permissions']/label[2]/div")
    public WebElement blogPermissionsPrivateDiv;

    @FindBy(css = "input[name='edit[title]']")
    public WebElement postHeadline;

    @FindBy(css = "input[name='uploadfile']")
    public WebElement addPictureToPost;

    @FindBy(css = "div[id='cke_1_contents'] div[role='textbox']")
    public WebElement postContent;

    @FindBy(id = "form_dest_autocomplete")
    public WebElement blogDestinations;

    @FindBy(css = "a[id='form_dest_show_selects']")
    public WebElement blogDestinationPickFromList;

    @FindBy(css = "div[id='form_dest_selects_wrapper']")
    public WebElement blogDestinationListDiv;

    @FindBy(css = "div[id='dests_chained_select'] span span")
    public List<WebElement> blogDestinationTagList;   //4

    @FindBy(css = "div[id='dests_chained_select'] span ul li")
    public List<WebElement> blogDestinationContinentOptions;

    @FindBy(css = "ul[id='search_countrySelectBoxItOptions'] li")
    public List<WebElement> blogDestinationCountryOptions;

    @FindBy(css = "ul[id='search_citySelectBoxItOptions'] li")
    public List<WebElement> blogDestinationCityOptions;

    @FindBy(id = "form_dest_add_selection")
    public WebElement addDestinationTag;

    @FindBy(id = "saved_locs_display")
    public WebElement destinationTagsChosen;


    @FindBy(css = "button[type='submit'][name='op']")
    public WebElement saveBlogPostButton;


    @FindBy(xpath = "//*[contains(@id,'dropdown')]/div/div/span[1]")
    public WebElement userMenuFromBlogsPage;


    @FindBy(css = "div[id='modals'] div:nth-child(2) li:nth-child(8)")
    public WebElement userMenuMyBlogFromBlogsPage;

    @FindBy(xpath = "//*[@id='app']/section[4]/main/div[2]/a")
    public WebElement myDrafts;


    @FindBy(xpath = "//*[@id='app']/section[3]/main/div[1]/div/article/a[2]/span")
    public WebElement editPost;

    @FindBy(css = "button[value='מחק']")
    public WebElement deletePost;

    @FindBy(css = "form[id='node_delete_confirm'] button[value='מחק']")
    public WebElement finalDelete;

    @FindBy (css = "div[class='toast-message']")
    public WebElement invalidPostErrorMessage;

    @FindBy (css = "div[class='form-group'] div label")
    public WebElement invalidHeadlineErrorMessage;

    @FindBy (css = "div[class='cke_inner cke_reset'] label")
    public WebElement invalidContentErrorMessage;

    @FindBy (css = "ul[id='saved_locs_display'] li a span")
    public WebElement removeDestinationTag;

    @FindBy (css ="div[id='form_choose_dest_wrapper'] label[class='error']")
    public WebElement invalidDestinationTagErrorMessage;

    @FindBy (css = "div[class='flex items-start'] div:nth-of-type(2) div a")
    public WebElement blogName;

    @FindBy (xpath = "//*[contains(@id, 'dropdown')]/div/img")
    public WebElement blogAuthorImg;

    @FindBy (css = "div[class='flex items-start'] div:nth-of-type(2) div:nth-of-type(2) button")
    public WebElement followBlog;

    @FindBy (xpath = "//div[class='flex items-start']/following-sibling::div[1]")
    public WebElement blogDescription;  // optional

    //relative xpath
    @FindBy (xpath= "//div[@class='flex items-center']//div[contains(@id, 'dropdown')]/div/img")
    public WebElement blogAuthorImgInsidePost;


    @FindBy (xpath= "//div[contains(@class,'py-8 border-b border-grey-300')]//div[contains(@id, 'dropdown')]/div/img")
    public WebElement blogAuthorImgBottom;

    @FindBy (xpath= "//*[contains(@id, 'dropdown-')]/div/address/span")
    public WebElement blogAuthorNameInsidePost;

    @FindBy (xpath ="//*[@id='app']/section[3]/main/div[5]/div/div[2]/div[1]/a")
    public WebElement blogAuthorNameBottom;


    @FindBy (xpath = "//*[@id='app']/section[3]/main/div[2]/div[1]/div[2]/div[1]/div[2]/button")
    public WebElement followBlogInsidePost;

    @FindBy (xpath = "//*[@id='app']/section[3]/main/div[5]/div/div[2]/div[3]/div/button")
    public WebElement followBlogBottom;

    @FindBy (xpath = "//*[@id='app']/section[3]/main/div[2]/div[1]/div[2]/div[2]/div[1]/time")
    public WebElement publishedDate;

    @FindBy (xpath = "//*[@id='app']/section[3]/main/div[2]/div[1]/div[2]/div[2]/div[2]/div/span[2]")
    public WebElement viewCount;

    @FindBy (xpath = "//div[1]/section[3]/main/div[2]/div[2]/div/div[1]/button")
    public WebElement saveForLater;

    @FindBy (xpath = "//div[1]/section[3]/main/div[4]/div[2]/div[1]/div/div[1]/button")
    public WebElement saveForLaterBottom;

    @FindBy (css = "div[class='flex items-center print:hidden mr-3 mt-3 lg:mt-0'] a span[class='icon icon-facebook text-2xl']")
    public WebElement shareOnFacebook;

    @FindBy (css = "div[class='flex items-center print:hidden hidden md:flex'] a span[class='icon icon-facebook text-2xl']")
    public WebElement shareOnFacebookBottom;

    @FindBy (css = "div[class='flex items-center print:hidden mr-3 mt-3 lg:mt-0'] a span[class='icon icon-whatsapp text-2xl']")
    public WebElement shareOnWhatsapp;

    @FindBy (css = "div[class='flex items-center print:hidden hidden md:flex'] a span[class='icon icon-whatsapp text-2xl']")
    public WebElement shareOnWhatsappBottom;

    @FindBy (css = "div[class='flex items-center print:hidden mr-3 mt-3 lg:mt-0'] a span[class='icon icon-printer text-2xl']")
    public WebElement printPost;

    @FindBy (css = "div[class='flex items-center print:hidden hidden md:flex'] a span[class='icon icon-printer text-2xl']")
    public WebElement printPostBottom;

    @FindBy (css = "figure img")
    public WebElement mainPostImg;


    @FindBy (xpath = "//div[contains(@class, 'post-content')]")
    public WebElement content;

    @FindBy (css = "section[class='mt-8'] ul li")
    public List<WebElement> postDestinations;

    @FindBy (xpath = "//*[contains(@class, 'icon icon-thumbs-up')]")
    public WebElement likePost;

    @FindBy (xpath = "//span[contains(@class, 'icon icon-thumbs-up')/following-sibling::span[1]]")
    public WebElement numOfLikes;  //optional

    @FindBy (xpath = "//*[contains(@class, 'icon icon-flag')]")
    public WebElement flagPost;

    @FindBy (css = "[id='app'] section:nth-child(7) main section h2")
    public WebElement commentsHeadline;

    @FindBy (xpath = "//a[contains(@class, 'add-favorite-login')]")
    public WebElement loginToComment;

    @FindBy (xpath = "//a[contains(@class, 'add-tip-login-facebook')]")
    public WebElement loginViaFacebookToComment;

    @FindBy (css = "div[id='comments'] div div div textarea")
    public WebElement addComment;

    @FindBy (css = "div[id='comments'] div div div div button")
    public WebElement sendCommentButton;

    @FindBy (css = "div[id='comments'] div ul li")
    public List<WebElement> publishedComments;    //optional

    @FindBy (css = "section[class='mt-12 sm:mt-30']")
    public WebElement mostViewedPostSection;

    @FindBy (css = "section[class='mt-12 sm:mt-30'] div div article a")
    public List<WebElement> mostViewedPostsList;   //should be 3

    @FindBy (xpath = "//*[@id='app']/section[3]/main/section[3]/div[2]/a/span")
    public WebElement linkToAllAuthorsPosts;

    @FindBy (xpath = "//section[contains(@class, 'related-posts')]")
    public WebElement relatedPostsSection;

    @FindBy (xpath = "//section[contains(@class, 'related-posts')]/div/div")
    public List<WebElement> relatedPostsList;   //should be 4

    @FindBy (xpath = "//*[@id='app']/section[4]/div[2]/a")
    public WebElement linkToAllRelatedPosts;


    //and more articles and Things To Do in the city


    public void searchBlogPost(String searchPostAbout) throws InterruptedException {

        searchBlog(searchPostAbout);


        if (searchPostAbout.equals("איסלנד")) {
            //  ** search for MY Iceland blog posts **
            searchBlogFreeText.sendKeys("איסלנד - ספטמבר 2017", Keys.ENTER);
            driver.navigate().refresh();
            Assert.assertEquals(myBlogPosts.size(), 2);
            System.out.println("I have two posts about Iceland :)");

        } else if (searchPostAbout.equals("נורווגיה")) {
            //  ** search for MY Norway blog posts **
            searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
            driver.navigate().refresh();
            Assert.assertEquals(myBlogPosts.size(), 2);
            System.out.println("I have two posts about Norway :)");

        } else if (searchPostAbout.equals("ארה\"ב") || searchPostAbout.equals("סקוטלנד") || searchPostAbout.equals("פראג") || searchPostAbout.equals("גרמניה")) {
            //  ** search for MY blog posts **

            driver.navigate().to("https://www.lametayel.co.il/blogs/176606");
            System.out.println("Yay! I've also been to this destination. Check out my blog :) " + myBlog.getText());
            Assert.assertEquals(myBlog.getText(), "הבלוג של sivanki");


        }
    }


    public void searchBlog(String searchFor) throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.mainMenuBlogs.click();

        wait.until(ExpectedConditions.visibilityOf(searchBlogsBar));
        searchBlogsBar.click();

        searchBlogsInput.clear();
        searchBlogsInput.sendKeys(searchFor);
        Thread.sleep(3000);
        searchBlogsInput.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(blogPostsHeader));
        Assert.assertTrue(blogPostsHeader.getText().contains(searchFor));
    }



    public void scroll(WebElement waitForVisibilityOf) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", waitForVisibilityOf);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }



    public void suggestedBlogs() {
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.mainMenuBlogs.click();
        wait.until(ExpectedConditions.visibilityOf(systemSuggestions));
        scroll(systemSuggestions);
        Assert.assertEquals(suggestedBlogPosts.size(), 9);
        System.out.println("There are default " + suggestedBlogPosts.size() + " suggested blog posts");

        scroll(postsFromBlogs);
        Assert.assertEquals(recentBlogPosts.size(), 30);      //should be 30
        System.out.println("There are default " + recentBlogPosts.size() + " recent posts from blogs");

        scroll(nextSectionOfBlogPostsButton);
        nextSectionOfBlogPostsButton.click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(nextPageBlogPosts.size(), 30);      //should be 30
        System.out.println("The number of blog posts in the next page is also " + nextPageBlogPosts.size());

    }



    public void createABlogPost(String insertPostHeadline, String insertPostContent, String insertDestinationTag) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.logInButton.click();
        homePage.logIntoSite();
        homePage.userMenu.click();
        homePage.userMenuAddNewBlogPost.click();

        try {
            skipToPageButton.click();
        } catch (Exception e) {
            System.out.println("no ad page was skipped");
        }

        // make post private
        makePostPrivate();

        //post content
        scroll(postHeadline);
        postHeadline.sendKeys(insertPostHeadline);
        postContent.sendKeys(insertPostContent);

        //destination tags
        addDestinationTags(insertDestinationTag, 1, 1, 1, 1);

        saveBlogPostButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(postHeader)));
        Assert.assertEquals(postHeader.getText(), insertPostHeadline);
        System.out.println("Blog created");

        //delete post
        deletePost();

    }



    public void createInvalidBlogPost(String emptyPostHeadline, String insertValidPostHeadline, String insertEmptyPostContent, String insertValidPostContent, String insertDestinationTag) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.logInButton.click();
        homePage.logIntoSite();
        homePage.userMenu.click();
        homePage.userMenuAddNewBlogPost.click();

        try {
            skipToPageButton.click();
        } catch (Exception e) {
            System.out.println("no ad page was skipped");
        }

        // make post private
        makePostPrivate();

        //post content
        scroll(postHeadline);
        postHeadline.sendKeys(emptyPostHeadline);
        postContent.sendKeys(insertValidPostContent);
        //destination tag
        blogDestinations.sendKeys(insertDestinationTag);
        Thread.sleep(3000);
        blogDestinations.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        blogDestinations.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        scroll(saveBlogPostButton);
        saveBlogPostButton.click();
        scroll(postHeadline);
        Assert.assertTrue(invalidPostErrorMessage.isDisplayed());
        invalidPostErrorMessage.click();
        Assert.assertTrue(invalidHeadlineErrorMessage.getText().equals("לא לשכוח לתת כותרת"));
        System.out.println("Post can't be saved without a headline");

        postHeadline.sendKeys(insertValidPostHeadline);
        postContent.clear();
        postContent.sendKeys(insertEmptyPostContent);
        scroll(saveBlogPostButton);
        saveBlogPostButton.click();

        scroll(postContent);
        Assert.assertTrue(invalidPostErrorMessage.isDisplayed());
        invalidPostErrorMessage.click();
        Assert.assertTrue(invalidContentErrorMessage.getText().equals("אופס, צריך לכתוב כאן משהו"));
        System.out.println("Post can't be saved without a content");

        postContent.sendKeys(insertValidPostContent);
        removeDestinationTag.click();
        scroll(saveBlogPostButton);
        saveBlogPostButton.click();
        scroll(blogDestinations);
        Assert.assertTrue(invalidPostErrorMessage.isDisplayed());
        invalidPostErrorMessage.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(invalidDestinationTagErrorMessage.getText().equals("צריך לבחור לפחות יעד אחד"));
        System.out.println("Post can't be saved without at least 1 Destination Tag");

    }



        public void makePostPrivate(){
        scroll(blogPermissions);
        makeBlogPostPrivate.click();
        Assert.assertTrue(blogPermissionsPrivateDiv.getAttribute("class").contains("icon-radio-checked"));
        System.out.println("Blog post is private");
    }



    public void addDestinationTags (String destinationTag, int typeOfDestinationIndex, int continentIndex, int countryIndex, int cityIndex) throws InterruptedException {
        blogDestinations.sendKeys(destinationTag);
        Thread.sleep(3000);
        blogDestinations.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        blogDestinations.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        blogDestinationPickFromList.click();
        Thread.sleep(3000);

        scroll(blogDestinationListDiv);
        blogDestinationTagList.get(typeOfDestinationIndex).click();  //יבשת
        blogDestinationContinentOptions.get(continentIndex).click(); //אירופה
        blogDestinationCountryOptions.get(countryIndex).click(); //אוסטריה
        blogDestinationCityOptions.get(cityIndex).click(); //אינסברוק
        addDestinationTag.click();

        Assert.assertTrue(destinationTagsChosen.getText().contains(destinationTag));
        Assert.assertTrue(destinationTagsChosen.getText().contains( blogDestinationCityOptions.get(cityIndex).getText()));

    }


    public void deletePost() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);

        userMenuFromBlogsPage.click();
        Thread.sleep(3000);
        userMenuMyBlogFromBlogsPage.click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(myDrafts)));
        myDrafts.click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(editPost)));
        editPost.click();
        Thread.sleep(5000);
        scroll(deletePost);
        Thread.sleep(8000);
        deletePost.click();
        Thread.sleep(3000);
        finalDelete.click();
        System.out.println("Blog deleted");
    }



    public void createANewBlogFromBlogsPage() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);

        homepage.mainMenuBlogs.click();

        try {
            skipToPageButton.click();
        } catch (Exception e) {
            System.out.println("no ad page was skipped");
        }

        try {
            if (userMenuFromBlogsPage.isDisplayed()){
                scroll(writeABlog);
                writeABlog.click();
                Thread.sleep(2000);
                Assert.assertTrue(driver.getCurrentUrl().contains("add/blog"));
            }
        } catch (Exception e) {
            System.out.println("User is not logged in");
            Thread.sleep(2000);
            scroll(writeABlog);
            writeABlog.click();

            wait.until(ExpectedConditions.visibilityOf(homepage.logInForm));
            homepage.logIntoSite();
            Thread.sleep(3000);
            Assert.assertTrue(driver.getCurrentUrl().contains("add/blog"));
        }

    }




    public void checkForMandatoryBlogAttributes(String blog) {

        HomePage homepage = new HomePage(driver);

        // blog attributes:
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(blogName));
        Assert.assertEquals(blogName.getText(), blog);
        Assert.assertTrue(blogAuthorImg.isDisplayed());
        Assert.assertTrue(followBlog.isDisplayed());

        try {
            Assert.assertTrue(blogDescription.isDisplayed());
            System.out.println("In this blog, there is also blog description");
        } catch (Exception e){
            System.out.println("There is no description to blog");
        }

        Assert.assertTrue(blogAuthorImgInsidePost.isDisplayed());
        System.out.println("Author image also appears under post headline");
        Assert.assertTrue(blogAuthorNameInsidePost.isDisplayed());
        Assert.assertTrue(blogName.getText().contains(blogAuthorNameInsidePost.getText()));
        System.out.println("Author name also appears under post headline");
        Assert.assertTrue(followBlogInsidePost.isDisplayed());
        System.out.println("You can 'follow' blog from top");
        Assert.assertTrue(publishedDate.isDisplayed());
        System.out.println("Blog post was published on " + publishedDate.getText());
        Assert.assertTrue(viewCount.isDisplayed());
        System.out.println("Blog post has " + viewCount.getText() + " views");
        Assert.assertTrue(saveForLater.isDisplayed());

        try {
            Assert.assertTrue(numOfLikes.isDisplayed());
            System.out.println("Post has " + numOfLikes + " likes");

        } catch (Exception e) {
            System.out.println("Post has no 'likes' yet");
        }

        System.out.println("SaveForLater appears on top");
        Assert.assertTrue(shareOnFacebook.isDisplayed());
        System.out.println("Facebook share button is displayed on top");
        Assert.assertTrue(shareOnWhatsapp.isDisplayed());
        System.out.println("WhatsApp share button is displayed on top");
        Assert.assertTrue(printPost.isDisplayed());
        System.out.println("Print button is displayed on top");

        scroll(mainPostImg);
        Assert.assertFalse(mainPostImg.getAttribute("class").contains("--hidden"));
        mainPostImg.click();
        wait.until(ExpectedConditions.attributeContains(mainPostImg, "class", "--hidden"));
        System.out.println("Image is zoomed");
        driver.navigate().refresh();

        Assert.assertTrue(content.isDisplayed());
        System.out.println("Post content is displayed");

        scroll(postDestinations.get(1));
        Assert.assertFalse(postDestinations.isEmpty());
        System.out.println("There are " + postDestinations.size() + " destinations in this blog post");
        Assert.assertTrue(likePost.isDisplayed());
        System.out.println("'Like' post is also visible on bottom");
        Assert.assertTrue(saveForLaterBottom.isDisplayed());
        System.out.println("'SaveForLater' is also visible on bottom");
        Assert.assertTrue(shareOnFacebookBottom.isDisplayed());
        System.out.println("'Facebook share' is also visible on bottom");
        Assert.assertTrue(shareOnWhatsappBottom.isDisplayed());
        System.out.println("'WhatsApp share' is also visible on bottom");
        Assert.assertTrue(printPostBottom.isDisplayed());
        System.out.println("Print is also visible on bottom");
        Assert.assertTrue(flagPost.isDisplayed());
        System.out.println("Flag post is visible on bottom");
        Assert.assertTrue(blogAuthorImgBottom.isDisplayed());
        System.out.println("Author image is also visible on bottom");
        Assert.assertTrue(blogAuthorNameBottom.isDisplayed());
        System.out.println("Author name is also visible on bottom");
        Assert.assertTrue(followBlogBottom.isDisplayed());
        System.out.println("'Follow' blog is also visible on bottom");

        scroll(commentsHeadline);

        try {
            Assert.assertTrue(addComment.isDisplayed());
            Assert.assertTrue(sendCommentButton.isDisplayed());
            System.out.println("Comments box is visible --user is logged in");

        } catch (Exception e) {
            System.out.println("User must log in to add a comment");
            Assert.assertTrue(loginToComment.isDisplayed());
            loginToComment.click();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            Assert.assertTrue(homepage.logInForm.isDisplayed());
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOf(loginViaFacebookToComment));
            scroll(loginViaFacebookToComment);
            loginViaFacebookToComment.click();
            Assert.assertTrue(driver.getTitle().contains("Facebook"));
            driver.navigate().back();
        }

        try {
            scroll(publishedComments.get(1));
            System.out.println("Number of comments to post: " + publishedComments.size() );

        } catch (Exception e) {

            System.out.println("There are currently no comments to post");
        }

        try {
            scroll(mostViewedPostSection);
            System.out.println("Most Viewed user posts list has " + mostViewedPostsList.size() + "posts" );
            scroll(linkToAllAuthorsPosts);
            Assert.assertTrue(linkToAllAuthorsPosts.isDisplayed());
            System.out.println("User has even more posts in blog");

        } catch (Exception e) {
            System.out.println("User does not have more posts");
        }

        scroll(relatedPostsSection);
        Assert.assertEquals(relatedPostsList.size(), 4);
        Assert.assertTrue(linkToAllRelatedPosts.isDisplayed());
        System.out.println("There are " + relatedPostsList.size() + " more recommended posts about this destination, and a link to even more posts");

    }



    //constructor
    public BlogsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
