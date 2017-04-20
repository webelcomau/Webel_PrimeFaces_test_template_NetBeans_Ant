## Webel_PrimeFaces_test_template_NetBeans_Ant
A template project for preparing mini [NetBeans IDE](https://netbeans.org/) Ant-based web apps for testing and demonstrating issues with the [PrimeFaces](https://www.primefaces.org/) toolkit for [JavaServer Faces (JSF)](http://www.oracle.com/technetwork/java/javaee/javaserverfaces-139869.html).

#### *Q: Did you ZIP-download (or [fork](https://help.github.com/articles/fork-a-repo/)) this project to copy then adapt ?* 

​Then please delete :scissors: and replace :pencil2: this long `README.md` file immediately **after reading it all** !

#### *Q: Why the long README ?*

Because this is a template project - designed to be **copied then adapted** - the GitHub Wiki system is deliberately not used. Please do read this entire README, it contains some important information.



## Foreword

This project is developed by Dr Darren Kelly of [Webel IT Australia](https://www.webel.com.au) and [GreenSoft Australia Pty Ltd](http://www.greensoftaustralia.com) for our own purposes for spawning JavaServer Faces (JSF) test web apps that use the [PrimeFaces](https://www.primefaces.org) toolkit for JSF.

*It is offered to the public (without any warranty or guarantee of fitness for any purpose) in the hope that it may also be of use to others, especially for submitting mini test web apps to the PrimeFaces support team and/or to the Stackoverflow forums as **adapted** projects.*

**This project does not offer collaboration invitations or accept pull requests from forks !** You are however welcome to make feature suggestions or report issues via the GitHub [issues reporting](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant/issues) mechanism.

**This project is NOT commercially supported, and response to any issue reports may be sporadic.**



### Disclaimer

This project is not officially endorsed by [PrimeTek Informatics](http://primetek.com.tr/), developers of the [PrimeFaces](https://www.primefaces.org) JSF toolkit; It is up to the PrimeFaces support team to determine whether any **adaptations** of this project you make and submit to them meet their requirements for issue test case submissions. 

​Similarly, if you make test cases available to - for example - the Stackoverflow forums it is up to those volunteering :sleeping: to help you to determine whether any **adaptations** of this project you make and submit to them meet their requirements for [Minimal, Complete, and Verifiable](http://stackoverflow.com/help/mcve) examples.

### Disclaimer: PrimeFaces tests vs core JavaServer Faces (JSF) tests

You may choose to submit a **copied and adapted** test using this template to the core [JavaServer Faces (JSF) JIRA issue tracking system](https://java.net/jira/browse/JAVASERVERFACES/), it is up to Oracle to decide whether they'll accept a test with PrimeFaces content.



## Description

A famous "quote" [often attributed to Einstein](http://quoteinvestigator.com/2011/05/13/einstein-simple/), who probably actually said something not quite as simple:

*"Everything Should Be Made as Simple as Possible, But Not Simpler"*

 As software developers encountering issues, we are frequently told by 3rd-party software support team members that we are not to submit complex real-world web apps demonstrating suspected bugs/issues that we encounter while working on our complex real-world web apps. However, experience shows that:

- It can be difficult to reproduce some problems in overly simplified mini test web apps.
- ​It can be very time-consuming :hourglass: preparing suitable test web apps completely from scratch.

This test web app template is designed to at least help address that 2nd point. It provides some JSF XHTML example test pages and some supporting Java classes for you to **copy then adapt** to quickly prepare your own test cases, along with some developer comments to help you on your way. Read on for how it works.



### About licensing and strict indications of authorship

*But first, the boring-yet-important part :sleeping:.*

This project is intended to be **copied then adapted** by others, so the [GNU GPLv3.0 License](https://choosealicense.com/licenses/gpl-3.0/) is used; if you offer it **adapted** to others that same license must be used. [PrimeFaces](https://www.primefaces.org/license/) itself uses the [Apache License 2.0](https://choosealicense.com/licenses/apache-2.0/).

There are however some very specific additional conditions concerning indications of authorship when **copying then adapting** JSF XHTML pages and Java code pages from this template project. Simply put:

> 
> ​*I don't mind people **copying then adapting** :innocent: this template project code, that it what is for.*
> ​*I do mind code introduced by other developers inadvertently appearing to be attributed :rage: to me .*
>
> (Dr Darren)"
> 

Therefore please:

- When you **copy then adapt** a JSF XHTML file, immediately **rename it and re-author it**  😀 using a free-style authorship indication in an XML header comment:
  - There are some diagnostic composite components like `<util:warn/>` and a template component `<util:0/>`under `/web/resources/util`. You are welcome to use them as is, but if you want to **adapt** them please create a new folder like `/web/resource/mine` then **copy, rename, re-author** :smiley:.
- ​Please DO NOT directly edit  any Java classes in or under `com.webel.test` packages :scream: !
- ​Please DO NOT use `com.webel.test` packages for **copied and adapted** Java classes :astonished: !
  - Create a new package indicating your organisation and copy your **renamed** Java class into it :wink:.
- ​Immediately re-author :grinning: the Javadoc `@author` tag in the class docs of each **copied and adapted** class from 'Darren Kelly (Webel IT Australia)' to yourself.

Then the code is yours to do whatever you like with :yum:. Also, this process helps preserve the example test cases. You are welcome to completely delete those from the web app once you've prepared your own test(s).



### What does the mini test web app do (out of the box) ?

When you run it it offers an `index.xhtml` home page with some (easily removed) explanatory help panels and links to some example PrimeFaces test pages. That home page acts as a launch-pad to the actual test:

- ​BTW, please DO NOT develop your own test(s) directly in the `index.xhtml` home page :angry: ! Link to your test(s) from it.

There is a **dynamic, interrogative, header** (on every JSF page that includes the `/common.xhtml`) that shows:

1. The running Mojarra (JSF implementation) version.
2. The running PrimeFaces build version.
3. The running Java version.
4. A link back to the home (index) page, which has links to the actual test pages.

Behind the scenes it has a simple `FakeEntity` and `FakeQuery` system that mimics simple database interactions. There is no actual database used. On startup, it is pre-populated with a couple of fake entities to get you started, so you can easily populate PrimeFaces components for testing. (More on that below.)

It offers three example test pages:

1. A CDI-compatible `@ViewScoped` page with a row-editable `p:dataTable`, being one of the most powerful and useful PrimeFaces components. It also has a `p:commandButton` for adding new fake entity items:
   - There is some basic JSF validation and `p:inputNumber` validation.
2. A simple view page with a `p:panelGrid` for showing a fake entity by `id`, gleaned using `f:viewParam`:
   - The view page has an `h:link` to a simple edit page for the same fake entity, by `id`.
3. A simple edit page with a `p:panelGrid` for showing a fake entity by `id`, gleaned using `f:viewParam`:
   - There is some basic JSF validation and `p:inputNumber` validation.
   - Saving the edit form successfully takes you back to the view page.

That's deliberately all it **does**. However, it offers some other useful features under-the-hood (see below).



### How do I run the mini test web app (as is, out of the box) ?

1. You need  [NetBeans IDE](https://netbeans.org/) (currently version 8.2), which includes the Glassfish-4.1.1 server. 
2. You need to ensure that the Glassfish-4.1.1 server is assigned as a server in your NetBeans configuration. If it is not already, please refer to sub-section **2.1.4.2 To Add GlassFish Server as a Server Using NetBeans IDE** within the [2.1 Required Software](https://docs.oracle.com/javaee/7/tutorial/usingexamples001.htm#GEXAJ) section in the The Java EE Tutorial 7.
   - Alternatively, you may install and use [Payara](http://www.payara.fish) (currently Payara41, v171), but if you do please be aware that somebody else running your test may then not have the identical server setup !
3. From the [GitHub project page](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant) perform a ZIP-Archive download by clicking on the **Clone or download** button once then choose **Download ZIP** (or just use [this master archive download link](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant/archive/master.zip)):
   - Please **DO NOT use the full Git clone option** ! It's better to re-Git an archive download (see below).
   - ​Experts :sunglasses: may wish to nevertheless [fork](https://help.github.com/articles/fork-a-repo/) **then adapt** this project. If you do, please follow the special instructions concerning re-authoring at the top of this README, and the instructions below about renaming the test page titles :angel:. **Pull requests from forks will however NOT be accepted.**
4. Unzip the downloaded `Webel_PrimeFaces_test_template_NetBeans_Ant-master.zip` somewhere:
   - It will unzip as a folder `Webel_PrimeFaces_test_template_NetBeans_Ant-master`.
5. Open that project folder in NetBeans IDE.
6. **Clean and Build** the project in NetBeans IDE (right click on the project node in the *Projects* window).
7. (It's best to ensure your Glassfish web app server does not have any other deployed apps running; if it does, undeploy them. It's also a good idea to restart the server.)
8. **Run** the project, it will open the `index.xhtml `home page in the whatever browser is set for NetBeans.




### It's running, what do I do now (BEFORE adapting the project) ?

*Firstly, notice the web page header with details about the running PrimeFaces, JSF Mojarra, and Java versions.*

Please then take time to read the instructions in the help panels in the home (index) page:

- Later, once you've read all of the help panels - and once you are ready to adapt the project - you may comment out or simply delete the `<ui:include .. >` used for each help panel from the `index.html`.

- There are 3 test case links in a fieldset at the bottom (deliberately) of the page. Please click on each one and experiment. You can always navigate back via the **Home** button link at the top of each page:

  - When you create your own test cases you will not be using those exact test links or those exact test pages, but you may **copy, re-author, then adapt** them and create an `<h:link>` for each NEW test.

    ​

### How do I adapt the project for my own tests ?

​You've read the instructions at the top about re-authoring **copied then adapted** XHTML pages and Java code, right :innocent: ? And you've read all of the help boxes and panels on the home page, right :+1: "? Time to adapt !

Please first immediately perform these steps:

1. In NetBeans IDE rename the project:
   - From `Webel_PrimeFaces_test_template`
   - To `[YourCompany]_PrimeFaces_test_[testname]`
     - If you are preparing a test for a specific issue support ticket consider using the issue number in the [testname] part !
2. You can do this in the main NetBeans IDE *Projects* window by right-clicking on the project and choosing **Rename....**
   1. Please make sure you tick the **[✔] Also Rename Project Folder option** !
3. In the top level `/web/index.xhtml`:
   - At the very top find the `<ui:param name="title" value=" …"/>` and give it a meaningful new title.
     - `<ui:param name="title" value="PrimeFaces: test web app: [PLEASE RENAME]"/>`
   - **DO NOT comment out or delete the following line**, it should be at the top of every JSF page or JSF template, so that the date/time diagnostics and library versions appear in the page header every time a page is served:
     - `<ui:include src="common.xhtml"/>`
   - Comment out (or simply delete :scissors:) every `<ui:include ... />` for help panels and help boxes:
     - You may then also completely delete the entire `/web/help` folder if you wish :relieved:.
   - Comment out the `<ui:include ... />` for the default test links (it's best to keep the referenced file in case you want to examine the examples again later, unless you've done this many time before):
     - `<ui:include src="/include/default_test_links.xhtml"/>`
4. Then **Clean and Build** and **Run** your renamed test web app **before** making any other JSF/XHTML code or Java class code modifications.

You are now ready to start creating your own test web app variation with **new** test pages :grinning::

- Create your JSF test page. It's entirely up to you what it does and where it lives, but keep it simple at first:
  - You may wish to **copy, re-author, then adapt** one of the existing test page examples for `FakeEntity`:
    - If so, please DO remove any references to **Webel IT Australia** in **copied and adapted** page title defined in `<ui:param name="title" value=".."/>`, and insert your own title description.
  - Your test page has this in it right at the top, yes ? :angel:
    - `<ui:include src="common.xhtml"/>`
- In the `index.xhtml`, find this `p:panel` and give it a descriptive title and contents about your test(s):
  - `<p:panel header="About this mini test web app" ..`
  - If you are reporting on an issue with an external support page consider including a link to it there.
  - At the bottom there is a simple `<fieldset>` around some `<ul> <li>` list items with this legend:
    - `<legend>Links to test pages</legend>`
    - Place a well-described `<h:link>` to your test page inside a list item `<li>…</li>`.
- Then **Clean and Build** and **Run** and see whether your test web app and test JSF page runs ok.

​Congratulations ​:+1:​ ! You are off and running with your own version of the test web app with your own tests. It's time to find out what else the template web app offers to make preparing your tests easier.



#### *Q: Why does this mini test web app template use Ant not Maven ? Maven is so cool.*

This particular test web app deliberately does not use Maven. It uses the most basic Ant-based NetBeans web app project type designed to be used completely offline, with the simplest possible folder structure, and without any Maven setup. (Maven is indeed very cool, and a Maven-based version might also be offered later too.)  See below for instructions on how to easily change JSF Mojarra and PrimeFaces versions.

### How to configure alternative Mojarra (JSF implementation) and PrimeFaces libraries for comparitive tests

Often to test an issue one needs to experiment with different library versions and compare test runs.  This is quite easily done with this mini NetBeans web app. By default this web app will use the Mojarra bundled with your web app server (Glassfish as bundled with NetBeans, or Payara if you installed it extra), and a recent PrimeFaces community edittion version is included as a JAR under the `./lib` folder.

**To run against a specific Mojarra (or other JSF implementation) version:**

- Download a Mojarra implementation JAR [from the Glassfish Maven repository](https://maven.java.net/content/repositories/releases/org/glassfish/javax.faces/) (you don't need Maven).
- Place a clearly named and versioned `javax.faces-[version].jar` in the `./lib` folder of this project (do not over-write your server's version, as it may impact on other JSF web applications, and it's tedious).
- Assign it from the NetBeans IDE *Projects* window from the **Libraries** node for this project by right clicking and using just **Add JAR** (not as a full NetBeans Library) and **use the relative path** option.
- Then uncomment BOTH LINES indicated in the `glassfish-web.xml` to `useBundledJsf`.
- **Clean and Build** then **Run**; the `common.xhtml` header will show you whether it caught the new version.

**To run a specific Primefaces version:**

- You can directly download [Community Edition JARs for PrimeFaces from the main PrimeFaces site](https://www.primefaces.org/downloads/) (you may have to scroll down a bit),  or ELITE and PRO versions if you are a subscribed customer.

- Place a clearly named and versioned `primefaces-[version].jar` in the `./lib` folder of this project. 

- In the *Projects* window under the **Libraries** node for this project you might have to remove any existing Primefaces jar library assignment. (It won't delete the actual JAR from the `./lib`, it just un-assigns it.)

- Assign the new one from the *Projects* window from the **Libraries** node for this project by right-clicking and using just **Add JAR** (not as a full NetBeans Library) and **use the relative path** option.

- **Clean and Build** then **Run**; the `common.xhtml` header will show you whether it caught the new version.

  ​



### About fake entities and fake queries (you may not need EJBs or a real database)

Behind the scenes this mini web app offers three main Java classes:

- `FakeEntity`: a POJO with some basic fields one can get and set.
  - It has a special field `detached` to mimic JPA detachment.
- `FakeQuery`: simulates some classic JPA EntityManager CRUD interactions with `FakeEntity` items using a map of fake entities. It does not actually write to a database,  and it is not an actual EJB (or even used as an injected CDI bean).
- `ViewBean`: a CDI-compliant `@ViewScoped` JSF backing bean. It offers the ability to interact with`FakeEntity` items "fetched" via `FakeQuery`, almost like a real EJB query:
  - Importantly, it performs lazy loading in `getEntities()` via `fetchEntities()`, but only on first access or after a `reset()`. See the example `/web/dataTable.xhtml` test page (and the explanation below).
  - It also offers a `setId(Long id)` for use with `f:viewParam` in the `view.xhtml` and `edit.xhtml` pages example test pages for individual `FakeEntity` items.
  - ​`ViewBean` also has some simple formatted diagnostic logging methods. (On other projects I use a nice reusable log4j-based universal logger-wrapper system for this, but often when I include it in such issue report test apps some support people complain :-1:  that it is not minimal enough.)

You are most welcome to **copy then adapt** `FakeEntity`, `FakeQuery`, and `ViewBean`  as you require, that is what this template test app is for, but if you do, please **follow the renaming, re-packaging and re-authoring instructions at the top of this README**  !

You may of course introduce actual @EJBs. However, keep in mind that actual database interaction makes your test web app far less portable and much harder to share. You may also use CDI bean injection in your tests, but keep in mind your focus should be on testing JSF and PrimeFaces, not underlying Java EE.

You will probably be able to prepare most JSF and PrimeFaces tests just using the simple `FakeQuery` and `FakeEntity` system offered here (although they can't imitate the full JPA query detach/merge process).



#### More about lazy loading/fetching in entity getters vs @PostConstruct in JSF

One of the biggest problems newcomers to JSF encounter is that a JSF page load has many phases, and getter methods of backing beans are often invoked multiple times during a single page load. If you perform a naive database fetch in a getter, that database fetch is invoked multiple times :facepunch:. This is bad not only for performance reasons :hourglass:, but it means (depending on the chosen scope and the JSF user interface interactions) that changes made by a user appear "not to take", because they are over-written by the repeated database fetch. This is a particular concern with @ViewScoped and @SessionScoped, and may also cause problems during AJAX calls. This is NOT a problem with JSF; it is a problem with how you are using JSF :baby:.

There are 2 main easy solutions experienced JSF users use :smirk:: 

- Load all entities you wish to operate on once, in advance, from database, in a @PostConstruct method.
- Lazy load entities in getter methods, fetching from database only when a field behind the getter is `null`. This approach has the advantage that one can use a `reset()` action or action listener method to reset fields to `null` so that entities will be re-fetched (refreshed) as desired. This is illustrated in `ViewBean` and `/web/dataTable.xhtml` for the `p:commandButton` that adds a new entity row to the table.

In any case, if you don't use at least one of these methods, and you think you are having problems with a JSF component, the first thing any JSF support team will tell you is to use one of the above methods !



#### About the mini composite components

There are some diagnostic composite components under `/web/resources/util/`. You'll see them used in the help panels included in the `index.xhtml`. If you wish to add new composite components, please do create your own folder for them such as `/web/resources/mine` :angel:.

​There is also a template composite component you can copy at `/web/resources/util/0.xhtml`. This illustrates a well known trick using a DIV-wrapper (or SPAN-wrapper) for making composite components easily renderable by component id, as explained in answers by JSF expert :sunglasses: Bauke Scholtz ([BalusC](https://github.com/BalusC)) at:

- [Rerendering composite component by ajax](http://stackoverflow.com/questions/18379689/rerendering-composite-component-by-ajax/)
- [Using id-attribute in JSF 2 composite component with targets](http://stackoverflow.com/questions/20053256/using-id-attribute-in-jsf-2-composite-component-with-targets)



#### About the CSS style file

There is a `styles.css` CSS style file at `/web/resources/styles.css`.  Please feel free to add your own styles directly in the file **at the bottom at the spot indicated by a comment**. Please don't make them complicated !

BTW the idea of having at least one style file is that too much inline CSS makes XHTML code hard to read.



### About submitting your test case to a support team

Before you go over-board :hourglass:forking this project or Git-if-ying the archive ZIP-download, please consider how you are going to submit it to the support team. Here are some simple options:

- Share it as a ZIP or TGZ via an email with a Dropbox link or another cloud service.
- If it's small enough, attach it to a direct email.
- Upload it as a ZIP or TGZ to the support team's issue tracking system.

Even if you are sharing your test "in public" for Stackoverflow, you can still use a Dropbox link if you trust it.

To prepare and share a simple test web app illustrating a problem, you may not need a new GitHub project.



### But I do want to use Git on my copied then adapted test web app 

*Git is wonderful :+1:, and when preparing more complex test apps it can be useful to track your changes.*

The recommended way to use Git with **adaptations** of this project is NOT to [fork](https://help.github.com/articles/fork-a-repo/) this project but instead to:

1. Perform a [ZIP-archive Download](https://github.com/webelcomau/Webel_PrimeFaces_test_template_NetBeans_Ant/archive/master.zip) of the master branch, and rename the project (see details above).
2. **Delete this README.me** immediately after reading and create your own that explains **your** test case.
3. Delete the `<ui:include ..>` for the help panels in `/web/index.xhtml` and the entire `/web/help` folder.
4. Start a new Git project using `git init` with your own credentials then push your **adapted** project to [a **new** GitHub project repo](https://help.github.com/articles/create-a-repo/), where a support team can easily download it as a ZIP-archive for testing.

You may like to keep or adapt the (Mac-friendly) `.gitignore` and `.gitattributes` files in your project, which are both by default included in the ZIP-archive download. Note that  `/nbproject/private` is excluded from git commits and the archive download, because it may contain full paths that reference your development machine username :smiling_imp:, which is best kept out of any projects (and Git repositories) used just for testing.

Also, if you wish to make your Git test case project public (rather than [inviting a collaborator to a private repository](https://help.github.com/articles/inviting-collaborators-to-a-personal-repository/)), make sure you follow these GitHub instructions about [keeping your email private](https://help.github.com/articles/keeping-your-email-address-private/) :wink:.



#### Some useful links for developing JSF test case projects and reporting issues

- If it's a core JSF project, report at https://java.net/jira/browse/JAVASERVERFACES !

- Always inspect the examples at the [PrimeFaces Showcase](https://www.primefaces.org/showcase/) first !

- Make sure you've read the [PrimeFaces Documentation](https://www.primefaces.org/documentation/) first !

- Check the [PrimeFaces forum](https://forum.primefaces.org/), where your might get more help if you can provide a nice test web app.

- Even if you have a paid [PrimeFaces support subscription](https://www.primefaces.org/support/) you'll get faster help if you have a test app.

- You should also be at least aware of the [OmniFaces](http://showcase.omnifaces.org/) utilities designed "To make JSF life easier" :sunglasses:. 

- If you don't know JSF you might get told by support teams or forums that you should by now have read [JavaServer Faces (2.0) : The Complete Reference](http://www.goodreads.com/book/show/7213221-javaserver-faces-2-0); although it desperately needs an update for JSF2.3, it is still essential reading. Note that PrimeFaces makes much of the slog-work of core JSF redundant :smiley:.

- Read both of these from Arjan Tijms' Weblog:

  - [What's new in JSF2.2](http://arjan-tijms.omnifaces.org/p/jsf-22.html)
  - [What's new in JSF2.3](http://arjan-tijms.omnifaces.org/p/jsf-23.html)

- From Andy Schwartz's Weblog: [What's New in JSF2](https://andyschwartz.wordpress.com/2009/07/31/whats-new-in-jsf-2/) (has also some good further reading links)

- ​The volunteer :zzz: IT community forum [StackOverflow](http://stackoverflow.com/) has a [jsf](http://stackoverflow.com/questions/tagged/jsf)  tag (see also version tags like [jsf-2](http://stackoverflow.com/questions/tagged/jsf-2) and [jsf-2.3](http://stackoverflow.com/questions/tagged/jsf-2.3)) as well as a dedicated [[primefaces]](http://stackoverflow.com/questions/tagged/primefaces) tag. (If you don't have a paid [PrimeFaces support subscription](https://www.primefaces.org/support/), because the [PrimeFaces community forum](https://forum.primefaces.org/) is based on volunteered time :hourglass: it's often worth posting to both.)

  ​

#### *Q: Did you ZIP-download (or [fork](https://help.github.com/articles/fork-a-repo/)) this project to **copy then adapt** ?*

​Then please delete :scissors: and replace :pencil2: this long `README.md` file immediately **after reading it all** !

#### 

