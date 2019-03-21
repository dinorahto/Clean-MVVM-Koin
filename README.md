# Clean Architecture | MVVM and Koin | Getting Started 

## Architecture ## 
Google has switched the architecture approach from MVP to MVVM, with that in mind, Google offers Architectural Components to fulfill the task of the multiple layers of abstraction inside a regular Android app. After different architectural designs, we learned one important lesson: we need an architecture pattern that allows fast reaction to design changes. 
That's why Google's proposed Model-View-ViewModel is the recommended architecture for Android, however this only solves the main interaction of the architecture, the presentation layer, we need to solve the problem of the data layer and we can use Clean Architecture as the general pattern for the app, this means we have two parts:

Presentation layer: In charge of Clicks, Scrolls and user interaction.
Data Layer: In charge of API Requests, Data Models. 

This application will implement Koin as an injection library making all the Data Modules available for the injections. 

### Presentation Layer MVVM over MVP ###
Handles the views, the listener for the clicks, views scrolls and all the interactions with the user, this part contains the maximum expression of MVVM (Model View ViewModel). The main players in the MVVM pattern are:

The View — that informs the ViewModel about the user’s actions
The ViewModel — exposes streams of data relevant to the View
The DataModel — abstracts the data source. The ViewModel works with the DataModel to get and save the data.
At a first glance, MVVM seems very similar to the MVP pattern, because both of them do a great job in abstracting the view’s state and behavior. The Presentation Model abstracts a View independent from a specific user-interface platform, whereas the MVVM pattern was created to simplify the event driven programming of user interfaces.

If the MVP pattern meant that the Presenter was telling the View directly what to display, in MVVM, ViewModel exposes streams of events to which the Views can bind to. Therefore, the ViewModel does not need to hold a reference to the View anymore, unlike the Presenter pattern. This also means that all the interfaces that the MVP pattern requires are now dropped.

The Views also notify the ViewModel about different actions. Thus, the MVVM pattern supports two-way data binding between the View and ViewModel and there is a many-to-one relationship between View and ViewModel. View has a reference to ViewModel but ViewModel has no information about the View. The consumer of the data should know about the producer, but the producer — the ViewModel — doesn’t know, and doesn’t care, who consumes the data.

We are going to use the Architectural Components that Google has provided, you can find it here: https://developer.android.com/topic/libraries/architecture/index.html

We are making a simple recommendation that every Android Developer should follow, don't make implementation of the business logic inside the Activities and Fragments, do it in the ViewModel and make the connection with exposure. If you are using MVVM you can achieve the Presenter-Interface model using a LiveData and ViewModels object from the Architectural components.

### Data Layer ###
The Data layer represents the Business logic of the projects, is in charge of the web server connection and the local databases. Everything in this part is implemented as a secondary module from the project, allowing for simple testing

The Data Layer is divided in two, after the repository, which means we have a Local repository and a Remote Repository.

Local Repository: Management of all the data bases, Shared preferences and Crypto objects
Remote Repository: Manage the connection to API's and WebSockets, including all the Interceptor's
For Local Repository we are not going to use Room, instead we are using Realm Database because it allows managing all the crypto objects and all the transactions in a simpler way. 
For the control of the Remote repository we are using Retrofit, RxJava and OkHttp.

### Coroutines over RxJava ###
Don’t block, keep moving, coroutines are simple, scalable and bulletproof for memory leaks. A coroutine is a way to handle concurrency tasks in a thread. It will run until stopped, and the thread will change the context to each coroutine without creating new threads.


## Contact ##
If you are facing some trouble with the code and need information, please send an email to: dinorahto@gmail.com
