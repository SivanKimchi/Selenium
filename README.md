# Selenium
* My private web automation project (Lametayel.co.il website) for practicing <b>Selenium-Java</b>. <br/><br/>
* Project is built on <b>Maven</b>, using <b>JUnit</b> testing framework and <b>Page Object Model/Page Factory.</b> <br/>
* Passwords, users, paths, etc., are stored on _gitignore_ file (JsonValues.json), but template is available in JsonValues.json.template <br/>
* Some @Tests use <b>Log4j</b> logging (to file/html), and there is also an example of <b>Extent Reports</b> <br/>
* Some @Tests are ran from local <b>Jenkins</b>  (when schedule, such as daily execution, is required) <br/>
* Project also implements <b>notifications by email</b> (two different email classes/methods), <b>AutoIT</b> script (for instance, adding a local picture to blog), <b>data extraction from local Excel</b> file, connection to <b>local mysql database</b>, <b>screenshots</b> on failure, and more<br/>
* Generally I used css Selector for better performance, but also xpath and other locators (+simple regex) <br/>
<br/>
--More details in "Test plan" excel file
