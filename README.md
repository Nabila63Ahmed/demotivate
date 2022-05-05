<div align="center">
  <h1>Demotivate</h1>

  <div align="center">
    <b>Get motivated with hilarious "de"motivational quotes! 😎
</b>
  </div>
</div>

### Description
An Android application that displays a random demotivational quote with a click of a button.

[//]: # (from the [Demotivational Quotes GraphQL API]&#40;https://github.com/aravindasiva/demotivational-quotes-api&#41;.)

### Architecture
The application follows the Model, View, ViewModel(MVVM) software architectural pattern. 
With the following <b>file and directory structure</b>:

```
📦app
 ┣ ..
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂com.example.demotivate
 ┃ ┃ ┃   ┣ 📂model
 ┃ ┃ ┃   ┃ ┣ 📜Quote.kt
 ┃ ┃ ┃   ┃ ┗ 📜QuotesProvider.kt
 ┃ ┃ ┃   ┣ 📂view
 ┃ ┃ ┃   ┃ ┗ 📜MainActivity.kt
 ┃ ┃ ┃   ┗ 📂viewmodel
 ┃ ┃ ┃     ┗ 📜QuotesViewModel.kt
 ┃ ┃ ┗ ..
 ┃ ┣ ..
 ┗ ..
```
#### 1. Model: 
Has the definition of a Quote in a <b>data</b> class and the list of quotes to provide the viewModel.

#### 2. View:
- Controls the application's display of the quotes and interaction with the user through the button
- Triggering and Subscribing to the viewModel's <b>LiveData</b> updates

#### 3. ViewModel:
- Fetches the Quotes from the model
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

