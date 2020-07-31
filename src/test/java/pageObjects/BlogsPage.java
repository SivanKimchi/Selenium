package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class BlogsPage {


    //members
    private WebDriver driver;

    @FindBy(css = "#index-main-page-search div[class^='dropdown-surface--anchor'] div[id^='dropdown-'] div[class^='autocomplete-input']")
    public WebElement searchBlogsBar;

    @FindBy(css = "#modals div:nth-child(2) div[id*='dropdown'] div[class*='bg-white shadow-surface'] input")
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

    @FindBy (css = "main[class='right-col'] div[class='flex items-start'] div:nth-child(2) div a")
    public WebElement blogName;

    @FindBy (xpath = "//*[contains(@id, 'dropdown')]/div/img")
    public WebElement blogAuthorImg;

    @FindBy (xpath = "//*[@id='app']/section[3]/main/div[2]/div[1]/div[2]/div[1]/div[2]/button")
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

    @FindBy (xpath = "//*[@id='modals']/div[9]/div[2]")
    public WebElement saveForLaterAddFolderBox;

    @FindBy (xpath = "//*[@id='modals']/div[9]/div[2]/div[2]/div/div[2]//div[1]/input")
    public WebElement saveForLaterAddFolder;

    @FindBy (xpath = "//div[1]/section[3]/main/div[4]/div[2]/div[1]/div/div[1]/button")
    public WebElement saveForLaterBottom;

    @FindBy (css = "div[class*='flex items-center print:hidden'] a span[class='icon icon-facebook text-2xl']")
    public WebElement shareOnFacebook;

    @FindBy (css = "div[class='flex items-center print:hidden hidden md:flex'] a span[class='icon icon-facebook text-2xl']")
    public WebElement shareOnFacebookBottom;

    @FindBy (css = "div[class='flex items-center print:hidden hidden md:flex'] a span[class='icon icon-whatsapp text-2xl']")
    public WebElement shareOnWhatsapp;

    @FindBy (css = "div[class='flex items-center print:hidden hidden md:flex'] a span[class='icon icon-whatsapp text-2xl']")
    public WebElement shareOnWhatsappBottom;

    @FindBy (css = "div[class='flex items-center print:hidden mr-3 mt-3 lg:mt-0'] a span[class='icon icon-printer text-2xl']")
    public WebElement printPost;

    @FindBy (xpath = "//*[@id='sidebar']/print-preview-header//h1")
    public WebElement printerAlertTitle;


    @FindBy (className = "cancel-button")
    public WebElement printerCancel;

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

    @FindBy (xpath = "//*[@id='app']/section[3]/main/div[4]/div[1]/div/button/span[2]")
    public WebElement likePostBottom;

    @FindBy (xpath = "//*[@id='app']/section[3]/main/div[4]/div[1]/div/span")
    public WebElement likePostNumberBottom;


    @FindBy (xpath = "//span[contains(@class, 'icon icon-thumbs-up')/following-sibling::span[1]]")
    public WebElement numOfLikes;  //optional

    @FindBy (xpath = "//*[contains(@class, 'icon icon-flag')]")
    public WebElement flagPost;

    @FindBy (css = "[id='app'] section:nth-child(7) main section h2")
    public WebElement commentsHeadline;

    @FindBy (css = "div[id='app'] div[id='comments'] div[class='flex justify-center'] a:nth-of-type(1)")
    public WebElement loginToInteract;

    @FindBy (css = "div[id='app'] div[id='comments'] div[class='flex justify-center'] a:nth-of-type(2)")
    public WebElement loginViaFacebookToInteract;

    @FindBy (xpath = "//*[@id=\"modals\"]/div[8]/div[2]/div[2]//a[1]")
    public WebElement loginToInteractFollowPost;

    @FindBy (xpath = "//*[@id=\"modals\"]/div[8]/div[2]/div[2]//a[2]")
    public WebElement loginViaFacebookToInteractFollowPost;

    @FindBy (xpath = "//*[@id=\"modals\"]/div[9]/div[2]/div[2]//a[1]")
    public WebElement loginToInteractSavePost;

    @FindBy (xpath = "//*[@id=\"modals\"]/div[9]/div[2]/div[2]//a[2]")
    public WebElement loginViaFacebookToInteractSavePost;

    @FindBy (xpath = " //*[@id=\"modals\"]/div[10]/div[2]/div[2]//a[1]")
    public WebElement loginToInteractLikePost;

    @FindBy (xpath = " //*[@id=\"modals\"]/div[10]/div[2]/div[2]//a[2]")
    public WebElement loginViaFacebookToInteractLikePost;


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

    @FindBy (xpath = "//*[@id='modals']/div[7]/div[2]")
    public WebElement needToSignIn;

    @FindBy (xpath = "//*[@id='modals']/div[10]/div[2]")
    public WebElement needToSignInBottomLike;

    @FindBy (xpath = "//*[@id='modals']/div[8]/div[2]")
    public WebElement needToSignInFromSavePost;

    @FindBy (xpath = "//*[@id='modals']/div[9]/div[contains(@aria-labelledby, 'dropdown')]//ul[@class='p-4 overflow-auto']/li//input")
    public List<WebElement> savedPostsFolderCheckedBox;  //last

    @FindBy (css = "div[class*='toast-info']")
    public WebElement blogCreatedAlert;


    public static Logger log = LogManager.getLogger(BlogsPage.class.getName());


    //constructor
    public BlogsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


//    //init
//    public static BlogsPage initBlogsPage(WebDriver driver) {
//
//        return PageFactory.initElements(driver,BlogsPage.class);
//    }



    public void skipAd(){
        try {
            skipToPageButton.click();
            log.debug("Skipped ad page");
        } catch (Exception e) {
            log.error("No ad page was skipped");
        }
    }

    public void scroll(WebElement waitForVisibilityOf) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", waitForVisibilityOf);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        log.debug("Scrolled to element");

    }


    public void moveToNextTab() {

        String parentId = driver.getWindowHandle();
        Set<String> windowsIds = driver.getWindowHandles();
        Iterator<String> it = windowsIds.iterator();
        String childWindow= "";

        while (it.hasNext()){
            childWindow = it.next();
        }
        driver.switchTo().window(childWindow);
        log.info("Switched to next window handle");
    }


    public void searchBlogPost(String searchPostAbout) throws InterruptedException {

        searchBlog(searchPostAbout);

        if (searchPostAbout.equals("איסלנד")) {
            //  ** search for MY Iceland blog posts **
            searchBlogFreeText.sendKeys("איסלנד - ספטמבר 2017", Keys.ENTER);
            driver.navigate().refresh();
            Assert.assertEquals(myBlogPosts.size(), 2);
            log.info("Searched for specific Iceland posts. I have two of them! :)");

        } else if (searchPostAbout.equals("נורווגיה")) {
            //  ** search for MY Norway blog posts **
            searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
            driver.navigate().refresh();
            Assert.assertEquals(myBlogPosts.size(), 2);
            log.info("Searched for specific Norway posts. I have two of them! :)");

        } else if (searchPostAbout.equals("ארה\"ב") || searchPostAbout.equals("סקוטלנד") || searchPostAbout.equals("פראג") || searchPostAbout.equals("גרמניה")) {
            //  ** search for MY blog posts **

            driver.navigate().to("https://www.lametayel.co.il/blogs/176606");
            log.debug("Navigated to specific blog");
            Assert.assertEquals(myBlog.getText(), "הבלוג של sivanki");
            log.info("Search completed- Yay! I've also been to this destination. Check out my blog :)" + myBlog.getText());
        }
    }


    public void searchBlog(String searchFor) throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.mainMenuBlogs.click();
        wait.until(ExpectedConditions.visibilityOf(searchBlogsBar));
        log.debug("Entered Blogs page");
        searchBlogsBar.click();
       // searchBlogsInput.clear();
        wait.until(ExpectedConditions.visibilityOf(searchBlogsInput));
        log.debug("Clicked blogs search bar");
        searchBlogsInput.sendKeys(searchFor);
        Thread.sleep(3000);
        searchBlogsInput.sendKeys(Keys.ENTER);
        log.debug("Inserted blog search term");

        wait.until(ExpectedConditions.visibilityOf(blogPostsHeader));
        Assert.assertTrue(blogPostsHeader.getText().contains(searchFor));
        log.info("Entered blog search results page");
    }




    public void suggestedBlogs() {

        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.mainMenuBlogs.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(systemSuggestions));
        log.debug("Entered Blogs page");
        scroll(systemSuggestions);
        Assert.assertEquals(suggestedBlogPosts.size(), 9);
        log.info("There are default " + suggestedBlogPosts.size() + " suggested blog posts");

        scroll(postsFromBlogs);
        Assert.assertEquals(recentBlogPosts.size(), 30);      //should be 30
        log.info("There are default " + recentBlogPosts.size() + " recent posts from blogs");

        scroll(nextSectionOfBlogPostsButton);
        nextSectionOfBlogPostsButton.click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        log.debug("Entered next blogs page");
        Assert.assertEquals(nextPageBlogPosts.size(), 30);      //should be 30
        log.info("The number of blog posts in the next page is also " + nextPageBlogPosts.size());

    }



    public void createABlogPost(String insertPostHeadline, String insertPostContent, String insertDestinationTag) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.logInButton.click();
        homePage.logIntoSite();
        skipAd();
        homePage.userMenu.click();
        homePage.userMenuAddNewBlogPost.click();
        log.debug("Clicked on 'add a new blog post' from user menu");

        skipAd();

        // make post private
        makePostPrivate();

        //post content
        scroll(postHeadline);
        postHeadline.sendKeys(insertPostHeadline);
        log.debug("Inserted blog headline");
        postContent.sendKeys(insertPostContent);
        log.debug("Inserted blog content");

        //destination tags
        addDestinationTags(insertDestinationTag, 1, 1, 1, 1);
        scroll(saveBlogPostButton);
        saveBlogPostButton.click();
        log.debug("Blog post has been saved");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(blogCreatedAlert)));
        Assert.assertEquals(blogCreatedAlert.getText(), "בלוג שלך נוצר");

        //site changed the behavior
//        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(postHeader)));
//        Assert.assertEquals(postHeader.getText(), insertPostHeadline);
        log.info("Blog created");

        Thread.sleep(5000);
        //delete post
        deletePost();

    }



    public void createInvalidBlogPost(String emptyPostHeadline, String insertValidPostHeadline, String insertEmptyPostContent, String insertValidPostContent, String insertDestinationTag) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.logInButton.click();
        homePage.logIntoSite();
        skipAd();
        homePage.userMenu.click();
        homePage.userMenuAddNewBlogPost.click();

        skipAd();

        // make post private
        makePostPrivate();

        //post content
        scroll(postHeadline);
        postHeadline.sendKeys(emptyPostHeadline);
        log.debug("Inserted invalid headline");
        postContent.sendKeys(insertValidPostContent);
        log.debug("Inserted valid content");
        //destination tag
        blogDestinations.sendKeys(insertDestinationTag);
        Thread.sleep(3000);
        blogDestinations.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        blogDestinations.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        log.debug("Inserted valid destination tag");

        scroll(saveBlogPostButton);
        saveBlogPostButton.click();
        log.debug("Saved blog");
        scroll(postHeadline);
        Assert.assertTrue(invalidPostErrorMessage.isDisplayed());
        log.debug("Headline is invalid");
        invalidPostErrorMessage.click();
        Assert.assertTrue(invalidHeadlineErrorMessage.getText().equals("לא לשכוח לתת כותרת"));
        log.info("Post can't be saved without a headline");

        postHeadline.sendKeys(insertValidPostHeadline);
        log.debug("Inserted valid headline");
        postContent.clear();
        postContent.sendKeys(insertEmptyPostContent);
        log.debug("Inserted invalid content");
        scroll(saveBlogPostButton);
        saveBlogPostButton.click();
        log.debug("Saved blog");

        scroll(postContent);
        Assert.assertTrue(invalidPostErrorMessage.isDisplayed());
        log.debug("Content is invalid");
        invalidPostErrorMessage.click();
        Assert.assertTrue(invalidContentErrorMessage.getText().equals("אופס, צריך לכתוב כאן משהו"));
        log.info("Post can't be saved without a content");

        postContent.sendKeys(insertValidPostContent);
        log.debug("Inserted valid content");
        removeDestinationTag.click();
        log.debug("Removed destonation tag");
        scroll(saveBlogPostButton);
        saveBlogPostButton.click();
        log.debug("Saved blog");
        scroll(blogDestinations);
        Assert.assertTrue(invalidPostErrorMessage.isDisplayed());
        log.debug("Destination tag must be inserted");
        invalidPostErrorMessage.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(invalidDestinationTagErrorMessage.getText().equals("צריך לבחור לפחות יעד אחד"));
        log.info("Post can't be saved without at least 1 Destination Tag");

    }



        public void makePostPrivate(){

        scroll(blogPermissions);
        makeBlogPostPrivate.click();
        Assert.assertTrue(blogPermissionsPrivateDiv.getAttribute("class").contains("icon-radio-checked"));
        log.info("Blog post is now private");
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
        log.debug("First destination tag chosen by arrow down");

        scroll(blogDestinationListDiv);
        blogDestinationTagList.get(typeOfDestinationIndex).click();  //יבשת
        log.debug("Second destination-tag type clicked");
        blogDestinationContinentOptions.get(continentIndex).click(); //אירופה
        log.debug("Second destination-tag continent clicked");
        blogDestinationCountryOptions.get(countryIndex).click(); //אוסטריה
        log.debug("Second destination-tag country clicked");
        blogDestinationCityOptions.get(cityIndex).click(); //אינסברוק
        log.debug("Second destination-tag city clicked");
        addDestinationTag.click();
        log.debug("Second destination tag chosen (4 part pick)");
        Assert.assertTrue(destinationTagsChosen.getText().contains(destinationTag));
        log.info("First destination tag is displayed");
        Assert.assertTrue(destinationTagsChosen.getText().contains( blogDestinationCityOptions.get(cityIndex).getText()));
        log.info("Second destination tag is displayed");

    }


    public void deletePost() throws InterruptedException {

        /*   site changed the behavior
        WebDriverWait wait = new WebDriverWait(driver,10);

        userMenuFromBlogsPage.click();
        Thread.sleep(3000);
        userMenuMyBlogFromBlogsPage.click();
        log.debug("Entered my created blog");
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(myDrafts)));
        myDrafts.click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(editPost)));
        log.debug("Entered my draft (private post)");
        editPost.click();
        Thread.sleep(5000);
         */

        scroll(deletePost);
        Thread.sleep(8000);
        deletePost.click();
        log.debug("Clicked on Delete post");
        Thread.sleep(3000);
        finalDelete.click();
        log.info("Blog deleted");
    }



    public void createANewBlogFromBlogsPage() throws InterruptedException {

        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);

        homepage.mainMenuBlogs.click();

        skipAd();

        try {
            if (userMenuFromBlogsPage.isDisplayed()){
                scroll(writeABlog);
                writeABlog.click();
                Thread.sleep(2000);
                Assert.assertTrue(driver.getCurrentUrl().contains("add/blog"));
                log.info("User is logged in and can create a blog");
            }
        } catch (Exception e) {
            log.info("User is not logged in");
            Thread.sleep(2000);
            scroll(writeABlog);
            writeABlog.click();
            log.debug("Clicked on adding a blog");
            wait.until(ExpectedConditions.visibilityOf(homepage.logInForm));
            log.debug("User needs to log in");
            homepage.logIntoSite();
            Thread.sleep(3000);
            Assert.assertTrue(driver.getCurrentUrl().contains("add/blog"));
            log.info("User is now logged in and can create a blog");
        }

    }




    public void checkForMandatoryBlogAttributes(String blog) throws InterruptedException {

        HomePage homepage = new HomePage(driver);

        // blog attributes:
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(blogName));

        topOfPostElements(blog);

        bottomOfPostElements();

        postComments();

        moreOfUserPosts();

        relatedPosts();

    }


    public void topOfPostElements(String blog){

        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertEquals(blogName.getText(), blog);
        Assert.assertTrue(blogAuthorImg.isDisplayed());
        Assert.assertTrue(followBlog.isDisplayed());
        log.debug("Blog name, author image and follow icon display on top");

        try {
            Assert.assertTrue(blogDescription.isDisplayed());
            log.debug("In this blog, there is also blog description");
        } catch (Exception e){
            log.debug("There is no description to blog");
        }

        Assert.assertTrue(blogAuthorImgInsidePost.isDisplayed());
        log.debug("Author image also appears under post headline");
        Assert.assertTrue(blogAuthorNameInsidePost.isDisplayed());
        Assert.assertTrue(blogName.getText().contains(blogAuthorNameInsidePost.getText()));
        log.debug("Author name also appears under post headline");
        Assert.assertTrue(followBlogInsidePost.isDisplayed());
        log.debug("You can 'follow' blog from top");
        Assert.assertTrue(publishedDate.isDisplayed());
        log.debug("Blog post was published on " + publishedDate.getText());
        Assert.assertTrue(viewCount.isDisplayed());
        log.debug("Blog post has " + viewCount.getText() + " views");
        Assert.assertTrue(saveForLater.isDisplayed());
        log.debug("SaveForLater appears on top");

        try {
            Assert.assertTrue(numOfLikes.isDisplayed());
            log.debug("Post has " + numOfLikes + " likes");

        } catch (Exception e) {
            log.debug("Post has no 'likes' yet");
        }

        Assert.assertTrue(shareOnFacebook.isDisplayed());
        log.debug("Facebook share button is displayed on top");
        Assert.assertTrue(shareOnWhatsapp.isDisplayed());
        log.debug("WhatsApp share button is displayed on top");
        Assert.assertTrue(printPost.isDisplayed());
        log.debug("Print button is displayed on top");

        scroll(mainPostImg);
        Assert.assertFalse(mainPostImg.getAttribute("class").contains("--hidden"));
        mainPostImg.click();
        log.debug("Clicked on post main image");
        wait.until(ExpectedConditions.attributeContains(mainPostImg, "class", "--hidden"));
        log.debug("Image is zoomed");
        driver.navigate().refresh();

        Assert.assertTrue(content.isDisplayed());
        log.debug("Post content is displayed");
    }



    public void bottomOfPostElements(){

        scroll(postDestinations.get(1));
        Assert.assertFalse(postDestinations.isEmpty());    //must have at least 1 destination tag
        log.debug("There are " + postDestinations.size() + " destinations in this blog post");

        Assert.assertTrue(likePost.isDisplayed());
        log.debug("'Like' post is also visible on bottom");
        Assert.assertTrue(saveForLaterBottom.isDisplayed());
        log.debug("'SaveForLater' is also visible on bottom");
        Assert.assertTrue(shareOnFacebookBottom.isDisplayed());
        log.debug("'Facebook share' is also visible on bottom");
        Assert.assertTrue(shareOnWhatsappBottom.isDisplayed());
        log.debug("'WhatsApp share' is also visible on bottom");
        Assert.assertTrue(printPostBottom.isDisplayed());
        log.debug("Print is also visible on bottom");
        Assert.assertTrue(flagPost.isDisplayed());
        log.debug("Flag post is visible on bottom");
        Assert.assertTrue(blogAuthorImgBottom.isDisplayed());
        log.debug("Author image is also visible on bottom");
        Assert.assertTrue(blogAuthorNameBottom.isDisplayed());
        log.debug("Author name is also visible on bottom");
        Assert.assertTrue(followBlogBottom.isDisplayed());
        log.debug("'Follow' blog is also visible on bottom");

    }


    public void postComments() throws InterruptedException {

        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        scroll(commentsHeadline);
        wait.until(ExpectedConditions.visibilityOf(commentsHeadline));

        try {
            Assert.assertTrue(addComment.isDisplayed());
            Assert.assertTrue(sendCommentButton.isDisplayed());
            log.debug("Comments box is visible --user is logged in");

        } catch (Exception e) {
            log.debug("User must log in to add a comment");
            Assert.assertTrue(loginToInteract.isDisplayed());
            loginToInteract.sendKeys(Keys.CONTROL + "t", Keys.ENTER);
            moveToNextTab();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            Assert.assertTrue(homepage.logInForm.isDisplayed());
            log.debug("Clicked on 'log in to interact'");

            ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.close();
            driver.switchTo().window(windows.get(0));

            wait.until(ExpectedConditions.visibilityOf(loginViaFacebookToInteract));
            loginViaFacebookToInteract.sendKeys(Keys.CONTROL + "t", Keys.ENTER);
            moveToNextTab();
            log.debug("Clicked on 'log in from facebook' to interact");
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            Assert.assertTrue(driver.getTitle().contains("Facebook"));
            driver.close();
            driver.switchTo().window(windows.get(0));
        }

        try {
            scroll(publishedComments.get(1));
            log.debug("Number of comments to post: " + publishedComments.size() );

        } catch (Exception e) {

            log.debug("There are currently no comments to post");
        }
    }


    public void moreOfUserPosts(){

        try {
            scroll(mostViewedPostSection);
            log.debug("Most Viewed user posts list has " + mostViewedPostsList.size() + "posts" );
            scroll(linkToAllAuthorsPosts);
            Assert.assertTrue(linkToAllAuthorsPosts.isDisplayed());
            log.debug("User has even more posts in blog");

        } catch (Exception e) {
            log.debug("User does not have more posts");
        }
    }


    public void relatedPosts(){

        scroll(relatedPostsSection);
        Assert.assertEquals(relatedPostsList.size(), 4);
        Assert.assertTrue(linkToAllRelatedPosts.isDisplayed());
        log.debug("There are " + relatedPostsList.size() + " more recommended posts about this destination, and a link to even more posts");
    }




    //** print doesn't work , views-no way to test number being changed , comment-I don't want to comment on my posts
    public void interactWithBlogPost(){

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(followBlog));

        //follow
        followBlog();

        //save post
        savePost();

        //sharing
        sharePost();

        //like post
        likePost();
    }


    public void followBlog(){

        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(followBlog));

        followBlog.click();
        log.debug("Clicked on 'follow'");

        try {
            wait.until(ExpectedConditions.visibilityOf(loginToInteractFollowPost));
            wait.until(ExpectedConditions.visibilityOf(loginViaFacebookToInteractFollowPost));
            log.debug("User needs to log in to interact with blog");

            loginToInteractFollowPost.click();
            homepage.logIntoSite();

            skipAd();

            wait.until(ExpectedConditions.visibilityOf(followBlog));
            followBlog.click();
            log.debug("Clicked on 'follow' as signed in user");

        } catch (Exception e) {
            log.debug("User is already signed in and can follow blog");
        }

        wait.until(ExpectedConditions.attributeContains(followBlog, "class", "bg-orange"));
        log.info("'Follow' button has been clicked. User is now following blog.");

        //undo
        followBlog.click();
        log.info("End of test - cancelled 'follow blog'");

    }


    public void savePost(){

        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(saveForLater));
        saveForLater.click();
        log.debug("Clicked on 'save post'");

        try {
            wait.until(ExpectedConditions.visibilityOf(loginToInteractSavePost));
            wait.until(ExpectedConditions.visibilityOf(loginViaFacebookToInteractSavePost));
            log.debug("User needs to log in to interact with blog");

            loginToInteractSavePost.click();
            homepage.logIntoSite();
            skipAd();

            wait.until(ExpectedConditions.visibilityOf(saveForLater));
            saveForLater.click();
            log.debug("User is now signed in and clicked on 'save post'");

        } catch (Exception e) {
            log.debug("User is already signed in and can save blog post");
        }

        wait.until(ExpectedConditions.visibilityOf(saveForLaterAddFolderBox));
        saveForLaterAddFolder.sendKeys("SavedPosts",(Keys.ENTER));
        log.debug("Entered a folder name for saved items");
        wait.until(ExpectedConditions.attributeContains(saveForLater, "class", "bg-orange"));
        log.info("'Save For Later' button has been clicked. Post is saved.");

        //undo
        saveForLater.click();
        wait.until(ExpectedConditions.visibilityOf(saveForLaterAddFolderBox));
        savedPostsFolderCheckedBox.get(savedPostsFolderCheckedBox.size()-1).click();
        log.info("End of test - cancelled 'save for later'");
    }


    public void sharePost(){

        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        //facebook share
        try {
            shareOnFacebook.click();
        } catch (StaleElementReferenceException e) {
            log.error("Facebook button is stale");
            WebElement facebookButton = driver.findElement(By.xpath("//*[@id=\"app\"]/section[3]/main/div[2]/div[2]/a[1]/span"));
            facebookButton.click();
        }

        log.debug("Clicked on facebook share");
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        OrderWidgetOnHomePage o = new OrderWidgetOnHomePage(driver);
        o.moveToNextTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"));
        log.debug("Navigated to facebook page");
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(windows.get(0));
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        //whatsapp share
        try {
            shareOnWhatsapp.click();
        } catch (StaleElementReferenceException f){
            log.error("Whatsapp button is stale");
            WebElement whatsappButton = driver.findElement(By.xpath("//*[@id=\"app\"]/section[3]/main/div[2]/div[2]/a[2]/span"));
            whatsappButton.click();
        }
        log.debug("Navigated back and clicked on WhatsApp share");
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        o.moveToNextTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("api.whatsapp.com"));
        log.debug("Navigated to whatsapp page");

        driver.close();
        driver.switchTo().window(windows.get(0));
        log.info("Navigated to all sharing options and back");
    }


    public void likePost() {

        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(likePostBottom));
        scroll(likePostBottom);

        try {     //number of likes is shown
            Assert.assertTrue(likePostNumberBottom.isDisplayed());
            int numberOfLikes = Integer.parseInt(likePostNumberBottom.getText());
            log.debug("This post has " + numberOfLikes + "'likes'");
            likePostBottom.click();
            log.debug("Clicked 'like'");

            try {
                wait.until(ExpectedConditions.visibilityOf(needToSignInBottomLike));
                wait.until(ExpectedConditions.visibilityOf(loginToInteractLikePost));
                wait.until(ExpectedConditions.visibilityOf(loginViaFacebookToInteractLikePost));
                log.debug("User needs to log in to interact with blog");

                loginToInteractLikePost.click();
                homepage.logIntoSite();
                skipAd();

                scroll(likePostBottom);
                wait.until(ExpectedConditions.visibilityOf(likePostBottom));
                likePostBottom.click();
                log.debug("Clicked 'like'");

            } catch (Exception a) {
                log.debug("User is already signed in and clicked on 'like' blog post");
            }

            wait.until(ExpectedConditions.attributeContains(likePostBottom, "class", "text-green"));
            wait.until(ExpectedConditions.visibilityOf(likePostNumberBottom));
            log.info("Now the post has " + numberOfLikes+1 + " 'likes'");

        } catch (Exception e){   //number of likes is not shown
            log.info("This post doesn't have 'likes' yet");
            likePostBottom.click();
            log.debug("Clicked 'like'");

            try {
                wait.until(ExpectedConditions.visibilityOf(needToSignInBottomLike));
                wait.until(ExpectedConditions.visibilityOf(loginToInteractLikePost));
                wait.until(ExpectedConditions.visibilityOf(loginViaFacebookToInteractLikePost));
                log.debug("User needs to log in to interact with blog");

                loginToInteractLikePost.click();
                homepage.logIntoSite();
                skipAd();

                scroll(likePostBottom);
                wait.until(ExpectedConditions.visibilityOf(likePostBottom));
                likePostBottom.click();
                log.debug("Clicked 'like'");

            } catch (Exception a) {
                log.info("User is already signed in and clicked on 'like' blog post");
            }

            wait.until(ExpectedConditions.attributeContains(likePostBottom, "class", "text-green"));
            wait.until(ExpectedConditions.visibilityOf(likePostNumberBottom));
            log.info("Now the post has 1 'like'");
        }

        //undo
        likePostBottom.click();
        log.info("End of test - cancelled 'like post'");
    }

}
