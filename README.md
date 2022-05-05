<div align="center">
 <p>
    <img src=https://cdn.shopify.com/s/files/1/0535/6917/products/giveupREPLACEMENT.jpg?v=1506028831" width="400"/>
  </p>
  <h1>Demotivate</h1>

  <div align="center">
    <b>Get motivated with hilarious "de"motivational quotes! 😎
</b>
  </div>
</div>

### Description
An Android application that displays a random demotivational quote from the [Demotivational Quotes GraphQL API](https://github.com/aravindasiva/demotivational-quotes-api) with a click of a button.

### Architecture
The application follows the Model, View, ViewModel (MVVM) software architectural pattern. 
With the following <b>file and directory structure</b>:

```
📦app
 ┣ ..
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂com.example.demotivate
 ┃ ┃ ┃    ┣ 📂graphql
 ┃ ┃ ┃    ┃ ┗ 📜Apollo.kt
 ┃ ┃ ┃    ┣ 📂view
 ┃ ┃ ┃     ┃ ┗ 📜MainActivity.kt
 ┃ ┃ ┃     ┗ 📂viewmodel
 ┃ ┃ ┃      ┗ 📜QuotesViewModel.kt
 ┃ ┃ ┗ ..
 ┃ ┣ ..
 ┗ ..
```
#### 1. Model: 
- Given a GraphQL schema and query definition the Apollo kotlin plugin defines a task named `generateApolloSources` to generate the models

#### 2. View:
- Fetches all quotes through the apollo client and sends them to the viewModel
- Controls the application's display of the quotes and interaction with the user through the button
- Triggering and Subscribing to the viewModel's <b>LiveData</b> updates

#### 3. ViewModel:
- Updates the <b>MutableLiveData</b> with a random quote

### Testing
Random generation functional test:
```kotlin
@Test
fun randomNumber_inRange() {
    val randomNumber = randomIndex(6)
    assertTrue("randomNumber is not in range!",
        randomNumber in 0 until 6)
} 
```

