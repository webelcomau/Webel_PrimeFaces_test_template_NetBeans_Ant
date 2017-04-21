## Webel_PrimeFaces_test_template_NetBeans_Ant
A template project for preparing mini [NetBeans IDE](https://netbeans.org/) Ant-based web apps for testing and demonstrating suspected issues with the [PrimeFaces](https://www.primefaces.org/) UI framework/toolkit for [JavaServer Faces (JSF)](http://www.oracle.com/technetwork/java/javaee/javaserverfaces-139869.html) and Java EE.

------

#### *Did you [ZIP-download](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant/archive/master.zip) (or [fork](https://help.github.com/articles/fork-a-repo/)) this project to copy then adapt ?* 

​Then please delete :scissors: and replace :pencil2: this long `README.md` file immediately **after reading it all** !

#### *Q: Why the long README ?*

Because this is a template project - designed to be **spawned then adapted** - the GitHub Wiki system is deliberately not used. Please do read this entire README, it contains some important information about how to easily **spawn and adapt** test projects from this project and how to submit them to support teams and forums. It also contains some tips on using Git and GitHub, and there is a comprehensive set of reference links for JSF and PrimeFaces at the bottom of this README.

------

## Foreword

This project is developed and maintained by Darren Kelly (a.k.a. "Dr Darren") of [Webel IT Australia](https://www.webel.com.au) and [GreenSoft Australia Pty Ltd](http://www.greensoftaustralia.com) for our own purposes for quickly developing one-off JavaServer Faces (JSF) test web apps that use the [PrimeFaces](https://www.primefaces.org) UI framework/toolkit for JSF, for submission to the PrimeFaces support team, the PrimeFaces community forum, and public forums such as Stackoverflow. 

*It is offered to the JSF community (without any warranty or guarantee of fitness for any purpose) in the hope that it may also be of use to others for developing your own **adapted** mini test web app projects.*

**This project does not offer GitHub collaboration invitations or accept pull requests from forks !** 

You are however welcome to provide feedback and make suggestions about the use of JSF and PrimeFaces in the template project test examples via the GitHub [issues reporting](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant/issues) mechanism. If it does not run for you, install [NetBeans IDE](https://netbeans.org/)  fresh, follow this README, then it will :+1:.

**This project is NOT commercially supported, and response to any issue reports may be sporadic.**

### Disclaimer

​This project is not officially endorsed by [PrimeTek Informatics](http://primetek.com.tr/), developers of the [PrimeFaces](https://www.primefaces.org) JSF toolkit; It is up to the PrimeFaces support team or community forum volunteers :sleeping: to determine whether any **adaptations** of this project you make and submit to them meet their requirements for issue test case submissions. 

​Similarly, if you make test cases available to, for example, the public Stackoverflow forums it is up to the developers volunteering :sleeping: to help you to determine whether any **adaptations** of this project you make and submit for them to test meet their requirements for [Minimal, Complete, and Verifiable](http://stackoverflow.com/help/mcve) examples.

### Disclaimer: PrimeFaces tests vs core JavaServer Faces (JSF) tests

You may choose to submit a **copied then adapted** test using this template to the core [JavaServer Faces  JIRA issue tracking system](https://java.net/jira/browse/JAVASERVERFACES/), it is up to [Oracle and the Java Community](http://www.oracle.com/technetwork/java/community/index.html) members to decide whether they'll accept a test that includes PrimeFaces content.



## Description

A famous "quote" [often attributed to Einstein](http://quoteinvestigator.com/2011/05/13/einstein-simple/), who probably actually said something not quite as simple:

> "Everything Should Be Made as Simple as Possible, But Not Simpler"
>

 As software developers encountering issues, we are frequently told by 3rd-party software support team members that we are not to submit complex real-world web apps demonstrating suspected bugs/issues that we encounter while working on our complex real-world web apps. However, experience shows that:

- It can be extremely difficult to reproduce some problems in overly-simplified mini test web apps.
- It can be very time-consuming :hourglass: preparing suitable test web apps completely from scratch.

This test web app template is designed to at least help address that 2nd point. It provides some JSF XHTML example test pages and some supporting Java classes for you to **copy then adapt** to quickly prepare your own test cases, along with some developer comments to help you on your way. Read on for how it works.



### About licensing and strict indications of authorship

*But first, the boring-yet-important part :sleepy:. C'mon, wake up, or you'll do something wrong !*

This project is intended to be **copied then adapted** by others, so the [GNU GPLv3.0 License](https://choosealicense.com/licenses/gpl-3.0/) is used; if you offer it **adapted** to others that same license must be used. [PrimeFaces](https://www.primefaces.org/license/) itself uses the [Apache License 2.0](https://choosealicense.com/licenses/apache-2.0/).

There are however some very specific additional conditions concerning indications of authorship when **copying then adapting** JSF XHTML pages and Java code pages from this template project. Simply put:

> ​*I don't mind people **copying then adapting** :innocent: this template project code at all, that it what is for.*
>
> ​*I do mind code introduced by other developers inadvertently appearing to be attributed :rage: to me .*
>
> (Dr Darren)
>

​Therefore please, when you wish to reuse any of the included code examples, please DO steal them :cop: completely, don't just "borrow" them in-place :punch::

- When you **copy then adapt** a JSF XHTML file, please immediately **rename it and re-author it**  😀 using a free-style authorship indication in an XML header comment near the top of each XHTML page:
  - `<!-- Author: Somebody Else from AnotherCompany -->`
  - There are some diagnostic JSF composite components like `<util:warn value="warning message"/>` . You are welcome to use them **as is**, just include this namespace: `xmlns:util="http://xmlns.jcp.org/jsf/composite/util`.
  - But if you want to **adapt** any of them please **copy, rename, and re-author** 😃 them first.
- ​Please DO NOT simply directly edit any Java classes in or under `com.webel.test` packages :scream: !
- ​Please DO NOT use `com.webel.test` packages/sub-packages for **copied and adapted** Java classes :astonished: !
  - Instead, please create a new package elsewhere indicating your own organisation `com.anothercompany.test` and copy your  - preferrably **renamed** - Java class(es) into it :wink:.
  - ​Then please immediately simply **re-author** :grinning: the Javadoc `@author` tag in the class docs of each **copied and adapted** class from `@author Darren Kelly (Webel IT Australia)` to `@author Somebody Else`.

Then the code is yours to do whatever you like with :yum:. I prefer this over using "originally authored by" or "adapted from" - polite as it seems - as that still does not make it clear who authored what.

​Also, this **copy, re-package, re-name, re-author** process helps preserve the `/web/examples` JSF test case pages. You are welcome to completely delete :scissors: those from the web app once you've prepared your own test(s), along with the `com.webel.test.primefaces.ViewBean` backing bean Java class that drives them if you are not using it and you are absolutely sure you don't need it for reference.



### What does the mini test web app do (out of the box) ?

When you run it it offers an `index.xhtml` home page with some (easily removed) explanatory help panels and links to some example PrimeFaces test pages. The home page acts as a launch-pad to the actual test(s):

- ​BTW, please DO NOT develop your own test(s) directly in the `index.xhtml` home page :angry: ! Link to your test(s) from it.

There is a **dynamic, interrogative, header** (on every JSF page with `<ui:include src="/common.xhtml"/>`) that shows:

1. The running Mojarra (JSF implementation) version.
2. The running PrimeFaces build version.
3. The running Java version.
4. A link back to the home (index) page, which has links to the actual test pages.

Behind the scenes it has a simple `FakeEntity` and `FakeQuery` system that mimics simple database interactions; there is no actual database used. On startup, it is pre-populated with a couple of fake entities to get you started, so you can easily populate PrimeFaces components for testing. (More on that below.)

It offers three `/web/examples` test pages:

1. A CDI-compatible `@ViewScoped` page with a row-editable `p:dataTable`, being one of the most powerful and useful PrimeFaces components. It also has a `p:commandButton` for adding new fake entity items:
   - There is some basic JSF validation and `p:inputNumber` validation.
2. A simple view page with a `p:panelGrid` for showing a fake entity by `id`, gleaned using `f:viewParam`:
   - The view page has an `h:link` to a simple edit page for the same fake entity, by `id`.
3. A simple edit page with a `p:panelGrid` for editing a fake entity by `id`, gleaned using `f:viewParam`:
   - There is some basic JSF validation and `p:inputNumber` validation.
   - Saving the edit form successfully redirects you back to the view page for that fake entity.

All of these are managed by a CDI-compatible @ViewScoped backing bean, which in turn leverages a `FakeQuery` which mimics some JPA entity database queries (see below for more detail on how it works).

That's deliberately all it **does**. However, it **offers** some other useful features under-the-hood (see below).



### How do I run the mini test web app (as is, out of the box) ?

1. You need  [NetBeans IDE](https://netbeans.org/) (currently version 8.2 as of Apr 2017), which includes the Glassfish-4.1.1 server. 
2. You need to ensure that the Glassfish-4.1.1 server is assigned as a server in your NetBeans configuration. If it is not already, please refer to sub-section **2.1.4.2 To Add GlassFish Server as a Server Using NetBeans IDE** within the [2.1 Required Software](https://docs.oracle.com/javaee/7/tutorial/usingexamples001.htm#GEXAJ) section in the The Java EE Tutorial 7.
   - BTW: If you have installed and use [Payara](http://www.payara.fish) (currently Payara41, v171), do please be aware that somebody else running your test may then not have the identical server setup :disappointed:! It's unlikely that the choice of server (as opposed to the running Mojarra JSF implementation version) will have a valid impact on a PrimeFaces test, so it's best to set Glassfish-4.1.1 as the server for your test project, even if you usually prefer Payara. See also below about installing and using alternative Mojarra versions or other JSF implementation versions just for your test project.
3. From the [GitHub project page](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant) perform a ZIP-Archive download by clicking on the **Clone or download** button once then choose **Download ZIP** (or just use [this master archive download link](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant/archive/master.zip)):
   - Please **DO NOT use the full Git clone option** ! It's better to "re-Git" an archive download locally if you think your own test case development is complex enough to need Git, see below for detailed instructions.
   - ​Experts :sunglasses: may nevertheless insist on [forking](https://help.github.com/articles/fork-a-repo/) **then adapting** this project. If you do, please follow the special instructions concerning re-authoring :innocent:at the top of this README, and the instructions below about renaming the test page titles :angel:. **Pull requests from forks will however NOT be accepted :-1:.**
4. Unzip the downloaded `Webel_PrimeFaces_test_template_NetBeans_Ant-master.zip` somewhere:
   - It will unzip as a folder `Webel_PrimeFaces_test_template_NetBeans_Ant-master`.
5. Open that project folder in NetBeans IDE using **File > Open Project ...**
6. **Clean and Build** the project in NetBeans IDE (right click on the project node in the *Projects* window).
7. It's best to ensure your Glassfish web app server does not have any other deployed apps running; if it does, undeploy them first. It's also a good idea to restart the server first. See the *Services* window.
8. **Run** the project, it will open the `index.xhtml `home page in the whatever browser is set for NetBeans.


#### *Q: It's not running :cry:, what do I do ?*

Make sure your Java run-time is up-to-date for your system (it was developed on a Mac, but should run on most operating systems, because Java does, and NetBeans IDE does). Make sure you have a fresh install of NetBeans IDE **8.2**; then repeat the steps above. It **will** run. Sorry, I don't accept "support" Issue requests on getting it to run, only suggestions concerning JSF and PrimeFaces and on improving the template code.



### It's running 👏 , what do I do now (BEFORE adapting the project) ?

*Firstly, notice the web page header with details about the running PrimeFaces, JSF Mojarra, and Java versions :+1:.*

Please then **invest** some time to read the instructions in the **initially-collapsed** help panels (click on them to open them) in the home (index) page :innocent::

- ​Later, once you've read all of the help panels  - and once you are ready to **adapt** the project - you may comment out or simply delete :scissors: from the `index.html` the `<ui:include .. />` used for each help panel.

- There are 3 test case links in a fieldset at the bottom (deliberately) of the page. Please click on each one in turn and experiment. You can always navigate back via the **Home** button link at the top of each page:

  - When you create your own test cases you will not be using those exact test links or those exact test pages, but you may **copy, re-author, then adapt** them and create an `<h:link>` for each NEW test.



#### Q: It's meant to be a simple test web app. Why doesn't it look simple (yet) ?

​*Your final **adapted project** home page will only show the diagnostic header, a page title, an "About" panel, and a fieldset with links to one or more test case pages. It will take you only a minute or so (literally) to strip out  :scissors: the help panels and example test case links if you follow the instructions below :smiley:.*



### How do I adapt the project for my own tests ?

​You've read the instructions at the top about **re-authoring** **copied then adapted** XHTML pages and Java code, right :innocent: ? And you've read all of the help boxes and panels on the home page, right :+1: ? Time to adapt !

#### Please first immediately perform these steps :cop:

1. In NetBeans IDE **rename the project**:
   - From `Webel_PrimeFaces_test_template`
   - To `[YourCompany]_PrimeFaces_test_[testname]`
     - If you are preparing a test for a specific issue support ticket consider using the issue number in the `[testname]` part !
   - You can do this in the main NetBeans IDE *Projects* window by right-clicking on the project and choosing **Rename...**
      - Please make sure you tick the **[✔] Also Rename Project Folder** option !
2. In the top level `/web/index.xhtml`:
   - At the very top find the `<ui:param name="title" value=" …"/>` and give it a meaningful new page title, which should indicate what one or more comparitive tests concern:
     - `<ui:param name="title" value="PrimeFaces: test web app: [PLEASE RENAME]"/>`
   - **DO NOT comment out or delete the following line**, it should be at the top of the `<h:body>` of every JSF page or JSF template, so that the date/time diagnostics and library versions appear in the page header every time a page is served:
     - `<ui:include src="/common.xhtml"/>`
     - It can't yet interrogate live the NetBeans IDE version or the Glassfish server version, so you may wish to edit it directly to change the statements about those to match your test setup.
   - ​Comment out or simply delete :scissors: every `<ui:include ... />` for help panels and help boxes:
     - You may then also completely delete the entire `/web/help` folder if you wish :relieved:.
   - Comment out the `<ui:include ... />` for the default test links (it's best to keep the referenced file in case you want to examine the examples again later, unless you've done this all before):
     - `<!-- <ui:include src="/include/default_test_links.xhtml"/> -->`
3. Then **Clean and Build** and **Run** your renamed test web app **before** making any other JSF/XHTML code or Java class code modifications:
   {0}. You should see a home page with a diagnostic header, a title describing the test you will create, a `p:panel` that you will use to describe your test in more detail, and a fieldset with a link to a STUB test page (and with none of those initially-included help panels and help boxes you read thoroughly before  😏 still showing).

#### You are now ready to start creating your own test web app variation with **new** test pages :grinning:

- Create a JSF test page. Please place it under `/web/test/`, NOT `/web/examples` :cop:. Keep it simple at first, and **please make sure you "test" something known to work first** :satisfied:, not something that fails:
  - There is a template "stub" test page  `/web/test/0.xhtml` that does almost nothing (except show you how to use the `<ui:include src="/common.xhtml"/>` and `<ui:param name="title" value=".."/>`). You may copy it as a starting point for a completely new test page.
  - But, if you want to populate a PrimeFaces component with some data, you may wish to **copy, re-author, then adapt** one of the existing test pages under `/web/examples/` for `FakeEntity`:
    - ​If so, DO please **re-author it** :innocent: completely to you (remove "Darren Kelly (Webel IT Australia)" from the free-style XML comment) and insert your own test's title description in `<ui:param name="title" value="[YOUR TEST PAGE TITLE]"/>`.
  - Your test page has the dynamic diagnostics header in it right at the top, yes ? :+1:
    - `<ui:include src="/common.xhtml"/>`
- In `/web/index.xhtml`, find this `p:panel` and give it a descriptive `header` and contents about your test(s):
  - `<p:panel header="About this mini test web app" .. >`
  - ​If you are reporting on an issue with an external issue tracking support page consider including a :link: hyperlink to it there, including the issue/ticket number - if you have one - in the link name.
  - At the bottom there is a simple `<fieldset>` around some `<ol> <li>` list items with this legend:
    - `<legend>Links to test pages</legend>`
    - Place a well-described `<h:link>` to your test page inside a list item `<li>…</li>`.
      - ​There is an example `<h:link>` there inside a list item `<li>…</li>` for the stub test page `/web/test/0.xhtml`, just comment it out or delete :scissors: it.
- Then **Clean and Build** and **Run** and see whether your test web app and test JSF page runs ok 😌:
  - You may then if you wish  completely delete the entire `/web/examples` folder if you are sure you are not going to need to **copy then adapt** any of them for your own test cases. (But don't delete the `FakeQuery`, `FakeEntity`, and `ViewBean` Java classes yet.)

​Congratulations :+1: ! You are off and running with your own version of the test web app with your own tests. It's time to find out what else the template web app offers to make preparing your tests easier.



#### *Q: Why does this mini test web app template use Ant not Maven ? Maven is so cool.*

This particular test web app deliberately does not use Maven. It uses the most basic Ant-based NetBeans web app project type designed to be used completely offline, with the simplest possible folder structure, and without any Maven setup. (Maven is indeed very cool, and a Maven-based version might also be offered later too.)  See below for instructions on how to easily change JSF Mojarra and PrimeFaces versions.

### How to configure alternative Mojarra (JSF implementation) and PrimeFaces JAR libraries for comparitive tests

Often to investigate an issue one needs to experiment with different library versions and compare test runs.  This is quite easily done with this mini NetBeans web app. By default this web app will use the Mojarra bundled with your web app server (Glassfish as bundled with NetBeans, or Payara if you installed it extra), and a recent PrimeFaces community edittion version is included as a JAR under the `./lib` folder.

**To run against a specific Mojarra (or other JSF implementation) version:**

- There are some Mojarra versions already under the `./lib` folder for you to choose from, or, if you need to test against another version:

  -  Download a Mojarra implementation JAR [from the Glassfish Maven repository](https://maven.java.net/content/repositories/releases/org/glassfish/javax.faces/) (you don't need Maven) and place the clearly named and versioned `javax.faces-[version].jar` in the `./lib` folder of your project. DO NOT over-write your server's version :cop:, as it may impact on other JSF web applications, and it's a bit tedious if you want to experiment quickly.

- Assign one from the NetBeans IDE *Projects* window from the **Libraries** node for your project by right clicking and using just **Add JAR** (not as a full NetBeans Library) and **use the relative path** option.

- Then uncomment BOTH LINES indicated in the `/web/WEB-INF/glassfish-web.xml` to `useBundledJsf`:

- ```xml
  <class-loader delegate="false" />
  <property name="useBundledJsf" value="true" />
  ```

- **Clean and Build** then **Run**; the `common.xhtml` header will show you whether it caught the new version.

**To run a specific Primefaces version:**

- You can directly download [Community Edition JARs for PrimeFaces](https://www.primefaces.org/downloads/)  from the main PrimeFaces site (you may have to scroll down a bit) or latest ELITE and PRO versions if you are a subscribed customer.

- Place a clearly named and versioned `primefaces-[version].jar` in the `./lib` folder of your project.

- In the *Projects* window under the **Libraries** node for your project you might have to remove any existing Primefaces jar library assignment. (It won't delete the actual JAR from the `./lib`, it just un-assigns it.)

- Assign the new one from the *Projects* window from the **Libraries** node for your project by right-clicking and using just **Add JAR** (not as a full NetBeans Library) and **use the relative path** option.

- **Clean and Build** then **Run**; the `common.xhtml` header will show you whether it caught the new version.

  ​



### About the provided fake entities and fake queries test system (and why you may not need real EJBs or a real database)

Behind the scenes this mini web app offers three main Java classes:

- `FakeEntity`: a POJO with some basic primitive fields one can get and set:
  - It has a special field `detached` to mimic JPA detachment.
- `FakeQuery`: simulates some classic JPA EntityManager CRUD interactions with `FakeEntity` items using a map of fake entities. It does not actually write to a database, and it is not an actual EJB (or even used as an injected CDI bean).
- `ViewBean`: a CDI-compliant `@ViewScoped` JSF backing bean. It offers the ability to interact with`FakeEntity` items "fetched" via `FakeQuery`, almost like a real EJB query:
  - Importantly, it performs lazy loading in `getEntities()` via `fetchEntities()`, on first access or after a `reset()`. See the example `/web/dataTable.xhtml` test page (and the explanation below).
  - It also offers a `setId(Long id)` for use with `f:viewParam` in the `view.xhtml` and `edit.xhtml` example test pages for individual `FakeEntity` items.
  - ​`ViewBean` also has some simple formatted diagnostic logging methods. (On other projects I use a nice reusable log4j-based universal logger-wrapper system for this, but sometimes when I include it in such issue report test apps some :alien: support people complain :-1:  that it is not minimal enough.)

​You are most welcome to **copy then adapt** `FakeEntity`, `FakeQuery`, and `ViewBean`  as you require, that is what this template test app is for, but if you do, please follow the **re-naming, re-packaging, and re-authoring** instructions at the top of this README :innocent: ! (Or just use them exactly as they are if they do all you need to populate and test some PrimeFaces components.)

You may of course introduce actual @EJBs. However, using actual database interaction makes your test web app far less portable and much harder to share. You may also use CDI bean injection in your tests, but keep in mind your focus here should be on testing JSF and PrimeFaces, not underlying Java EE.

You will probably be able to prepare most JSF and PrimeFaces tests just using the simple `FakeQuery` and `FakeEntity` system offered here (although they can't imitate the full JPA query detach/merge process).



#### More about lazy loading/fetching in entity getters vs @PostConstruct in JSF

One of the biggest problems newcomers to JSF encounter is that a JSF page load has many phases, and getter methods of backing beans are often invoked multiple times during a single page load. If you perform a naive database fetch in a getter every time, that database fetch is invoked multiple times :facepunch:. This is bad not only for performance reasons :hourglass:, but it means (depending on the chosen scope and the JSF user interface interactions) that changes made by a user may appear "not to take", because they are over-written by the repeated database fetch. This is a particular concern with @ViewScoped and @SessionScoped, and especially causes problems during AJAX calls. This is NOT a problem with or fault of JSF; it may be a problem with how you are using JSF :baby:.

There are 2 main easy solutions (strategies) experienced JSF users use :smirk:: 

- Load all entities you wish to operate on once, in advance, from database, in a @PostConstruct method.
- Lazy load entities in getter methods, fetching from database only when a field behind the getter is `null`. This approach has the advantage that one can use a `reset()` action or action listener method to reset fields to `null` so that entities will be re-fetched (refreshed) whenever desired. This is illustrated in `ViewBean` and `/web/examples/dataTable.xhtml` for the `p:commandButton` that adds a new entity row to the table.

In any case, if you don't use at least one of these methods, and you think you are having problems with a JSF component, the first thing any JSF support team will tell you is to use one of the above methods :ok_hand:!



#### About the provided mini diagnostic composite components

There are some diagnostic composite components under `/web/resources/util/`. You'll see them used in the help panels included in the `index.xhtml`. If you wish to add new composite components, consider creating your own folder for them such as `/web/resources/mine` :angel:.

​There is also a template composite component you can copy at `/web/resources/util/0.xhtml`. This illustrates a well known trick using a DIV-wrapper (or SPAN-wrapper) for making composite components easily renderable by component id, as explained in answers by JSF expert :sunglasses: Bauke Scholtz ([BalusC](https://github.com/BalusC)) at:

- [Rerendering composite component by ajax](http://stackoverflow.com/questions/18379689/rerendering-composite-component-by-ajax/)
- [Using id-attribute in JSF 2 composite component with targets](http://stackoverflow.com/questions/20053256/using-id-attribute-in-jsf-2-composite-component-with-targets)



#### About the CSS style file

There is a `styles.css` CSS style file at `/web/resources/styles.css`, which is included via `common.xhtml` and is hence available to every JSF test page, because you are including `common.xhtml` in every JSF page :+1:.

*The idea of having at least one style file is that too much inline CSS makes XHTML code hard to read.*

Please feel free to add your own style classes directly in that CSS file **at the bottom at the spot indicated by a comment**. Please don't make them complicated, and please don't ever use them to hide data or any served information in test pages.



### About submitting your test case to a support team

To prepare and share a simple test web app illustrating a problem, you may not need a new GitHub project.

Before you go over-board :hourglass:forking this project or Git-if-ying the **adapted** archive ZIP-download project, please consider first how you are going to submit it to the support team. Here are some simple options:

- Share it as a ZIP, TGZ, or other compressed archive bundle via a Dropbox link (or using another cloud service such as Google Drive, iCloud, etc). You can email the link to a support email channel or add it to a support team's issue tracking system.
- Upload it as a compressed archive bundle to the support team's issue tracking system, if it supports it:
  - If it's small enough, attach it to a direct support email, but only if asked to first by a support team.

Even if you are sharing your test in WWW-public for Stackoverflow, you can still use a shared Dropbox link or other cloud service link (assuming you trust it). Or maybe you have your own trusted web or ftp server.

### But I do want to use Git on my copied then adapted test web app, because my test case is quite complex, and I just love Git so much

*Git is wonderful :+1:, and when preparing more complex test apps it can be useful to track your changes.*

The recommended way to use Git with **adaptations** of this project is NOT to [fork](https://help.github.com/articles/fork-a-repo/) this project but instead to:

1. Perform a [ZIP-archive Download](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant/archive/master.zip) of the master branch, and rename the project (see details above).
2. Run the **renamed** mini web app once as described above, before making any of your own tests, and read the help on the index (home) page - unless you've read it all before because you are a returning "customer". If you haven't already, try out the example test page links.
3. ​Delete :scissors: the `<ui:include ..>` for the help panels in `/web/index.xhtml` and the entire `/web/help` folder.
4. **Delete this README.me** immediately after reading it and create your own that explains **your** test case.
5. If you've already seen them AND you are absolutely sure don't need them as a starting point, just delete the `/web/examples/` test JSF pages folder. (But don't delete the `FakeQuery`, `FakeEntity`, and `ViewBean` Java classes yet, they may prove useful.)
6. Start a new Git project locally using `git init` with your own credentials. 

​You may like to keep or adapt the (Mac-friendly) `.gitignore` and `.gitattributes` files in your project, which are both by default included in the ZIP-archive download. Note that  `/nbproject/private` is excluded from git commits and the archive download, because it may contain full paths that reference your development machine username :smiling_imp:, which is best kept out of any projects (and Git repositories) used just for testing. Likewise, the `.gitignore` excludes `rebel.xml` config files from [JRebel](https://zeroturnaround.com/software/jrebel/)  (:+1:) hot reload :yum: technology.

Using Git locally still does not mean you need a GitHub project just for a mini test app; you can always just [create a Git archive bundle from the command line](https://git-scm.com/docs/git-archive) for submission via the channels listed above. But if it's a complex test web app and you really want to share it with the world:

- ​See these instructions first :cop: about [Adding an existing project to GitHub using the command line](https://help.github.com/articles/adding-an-existing-project-to-github-using-the-command-line/). Then push your **adapted** project to [a **new** GitHub project repo](https://help.github.com/articles/create-a-repo/), where a support team can easily download it as a ZIP-archive for testing. 

Also, if you wish to make your Git test case project public (rather than [inviting a collaborator to a private repository](https://help.github.com/articles/inviting-collaborators-to-a-personal-repository/)), make sure you follow these GitHub instructions about [keeping your email private](https://help.github.com/articles/keeping-your-email-address-private/) :wink:.

*Then you can [go crazy with your README.md](https://help.github.com/articles/basic-writing-and-formatting-syntax) or a GitHub wiki if you have too much time :hourglass:on your hands.*



### Some useful links for developing JSF test case projects and reporting issues

Many suspected PrimeFaces issues are in fact either **core** JSF issues (Mojarra implementation issues) or just **mis-understandings** :confused:about how core JSF works. Note that PrimeFaces makes much of the slog-work of core JSF redundant :smiley:, but you should still command core JSF fully to get the most out of PrimeFaces:

- ​If it concerns a genuine **core** JSF issue (and you are sure you really command :sunglasses: core JSF):

  - Please report it at https://java.net/jira/browse/JAVASERVERFACES !
  - NetBeans 8.2 with GlassFish 4.1.1 is bundled with sleepy-old JSF version 2.2.8-12. Before reporting an issue, try out (using the `useBundledJsf` Library version approach described above) [the latest Mojarra](https://maven.java.net/content/repositories/releases/org/glassfish/javax.faces/) for JSF2.3, it does solve a lot of previous known issues.

- ​If you have not yet read the entire [Web Tier](https://docs.oracle.com/javaee/7/tutorial/partwebtier.htm#BNADP) section of the Java EE 7 Tutorial about JSF you may find support teams and forum helpers :sleeping: sending you back there again and again to read it all :stuck_out_tongue_closed_eyes:.

  - If you still don't know basic JSF well enough you might get told by support teams or forums that you should by now have read either or both of these excellent books from genuine experts behind JSF:
    - [Core JavaServer Faces (4th Edition)](https://www.amazon.ca/Core-JavaServer-Faces-David-Geary/dp/0133795748) covers most of JSF2.2 (and has a chapter on PrimeFaces).
    - [JavaServer Faces (2.0) : The Complete Reference](http://www.goodreads.com/book/show/7213221-javaserver-faces-2-0): from 2010. Although it desperately needs an update for JSF2.3, it is still essential reading.
  - [The JSF 2.0 Cookbook](https://www.packtpub.com/web-development/jsf-20-cookbook) from 2010 is good (but likewise desperately needs updating for JSF2.3). The same author Anghel Leonard however now also offers [Mastering JavaServer Faces 2.2](https://www.packtpub.com/application-development/mastering-javaserver-faces-22) from 2014.
  - Both of these from Arjan Tijms' Weblog are highly recommended:
    - [What's new in JSF2.2](http://arjan-tijms.omnifaces.org/p/jsf-22.html) from 2013.
    - [What's new in JSF2.3](http://arjan-tijms.omnifaces.org/p/jsf-23.html) from 2016.

  - And from Andy Schwartz's Weblog 2009: [What's New in JSF2](https://andyschwartz.wordpress.com/2009/07/31/whats-new-in-jsf-2/) (has some good further reading links).

- For suspected **PrimeFaces** issues:

  - Always inspect the examples at the [PrimeFaces Showcase](https://www.primefaces.org/showcase/) first !
  - Make sure you've read the [PrimeFaces Documentation](https://www.primefaces.org/documentation/) first !
    - There is also a [PrimeFaces Cookbook - Second Edition](https://www.packtpub.com/application-development/primefaces-cookbook-second-edition) from 2015.
  - ​Check the [PrimeFaces forum](https://forum.primefaces.org/), where you are more likely to get more help from the volunteers :sleeping: if you can provide a nice test web app (like one **adapted** from this mini test web app template).
  - Even if you have a paid [PrimeFaces support subscription](https://www.primefaces.org/support/) you'll get faster help if you have a good test app demonstrating your problem.

- ​The volunteer :sleeping: IT community forum [StackOverflow](http://stackoverflow.com/) has a [[jsf]](http://stackoverflow.com/questions/tagged/jsf)  tag (see also version tags like [[jsf-2]](http://stackoverflow.com/questions/tagged/jsf-2) and [[jsf-2.3]](http://stackoverflow.com/questions/tagged/jsf-2.3)) as well as a dedicated [[primefaces]](http://stackoverflow.com/questions/tagged/primefaces) tag. Because the [PrimeFaces community forum](https://forum.primefaces.org/) is based on volunteered time :hourglass: it's often worth cross-posting also to StackOverflow, which has a lot of good JSF and PrimeFaces traffic.

- Check out also the [OmniFaces](http://showcase.omnifaces.org/) utilities designed "To make JSF life easier" :sunglasses:. 



### Get JRebel hot reload technology from ZeroTurnaround !

​If you are doing a lot of Java EE web app development, it's a no brainer, get [JRebel](https://zeroturnaround.com/software/jrebel/)  (:+1:) hot reload :yum: technology. It will save you a heap of :hourglass:time=money :moneybag:, it will make your development time massively more efficient and enjoyable, and it will make preparing even simple test web apps much easier and faster.

------

#### Q: How did anybody edit such a long README.md so easily in Markdown syntax ?

​There is apparently a new site :globe_with_meridians: called Google that [lists a gazillion pages comparing Markdown editors](https://www.google.com/search?q=best+markdown+editors) for all operating systems. I find [Typora](https://www.typora.io/) for Mac good, it has an excellent live preview, but some of the emojis look a bit different than on GitHub (and they don't recognise an octocat :octocat: yet). But then again, [this cheat-sheet for GitHub emojis](https://www.webpagefx.com/tools/emoji-cheat-sheet/) also does not look exactly like on GitHub. Visit also this guide to [GitHub Flavored Markdown](https://help.github.com/articles/getting-started-with-writing-and-formatting-on-github/).

------

#### Did you [ZIP-download](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant/archive/master.zip) (or [fork](https://help.github.com/articles/fork-a-repo/)) this project to **copy then adapt** ?

​Then please delete :scissors: and replace :pencil2: this long `README.md` file immediately **after reading it all** !

#### 

