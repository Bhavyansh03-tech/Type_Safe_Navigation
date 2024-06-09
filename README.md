# Jetpack Compose Type-Safe Navigation Examples

Welcome to the Jetpack Compose Type-Safe Navigation Examples repository! This project showcases how to implement type-safe basic navigation, passing arguments, and nested navigation using Jetpack Compose with Kotlin.

## Features

- Type-Safe Basic Navigation
- Passing Arguments
- Nested Navigation

## Setup

To get a local copy up and running, follow these simple steps:

1. Clone the repository.

```bash
git clone https://github.com/Bhavyansh03-tech/Type_Safe_Navigation.git
```

2. Open the project in Android Studio.
3. Build the project.

## Steps to Nested Implement Navigation Compose

To implement Nested Navigation Compose, follow these steps:

1. Add navigation compose dependency in both libs.version.toml and gradle.build.

```bash
[versions]
kotlin = "2.0.0"
composeBom = "2024.05.00"
navigationCompose = "2.8.0-beta02"
kotlinxSerializationJson = "1.7.0-RC"

[libraries]
androidx-navigation-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "navigationCompose" }
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "kotlinxSerializationJson" }

[plugins]
# Compose :->
compose-compiler = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }

# Serialization :->
kotlin-serialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlin" }
```


2. Now, create a kotlin file to add screen names and pass arguments.

```Kotlin
import kotlinx.serialization.Serializable

@Serializable object AUTH
@Serializable object ROOT
@Serializable object Home
@Serializable object Login
@Serializable object Signup

// Passing arguments :
@Serializable
data class Detail(
    val name: String,
    val age: Int
)
```


3. Now, create a Kotlin file and set up the `NavGraph` in that file.

```Kotlin
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AUTH
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}
```


4. Create a new Kotlin file and define a function that extends `NavGraphBuilder` with the name of your navigation graph. For example: `NavGraphBuilder.nameOfNavGraph()`.

```Kotlin
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.typesafenavigation.screens.LoginScreen
import com.example.typesafenavigation.screens.SignupScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){
    navigation<AUTH>(
        startDestination = Login
    ){
        composable<Login>{
            LoginScreen(navController = navController)
        }
        composable<Signup>{
            SignupScreen(navController = navController)
        }
    }
}
```


5. Don't forget to initialize `navController` in the `MainActivity`.

```Kotlin
val navController = rememberNavController()
SetupNavGraph(navController = navController)
```


6. Now Add Navigation in screens. For example:

```Kotlin
@Composable
fun LoginScreen(
    navController: NavHostController
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = "Login Screen",
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(35.dp))

            Button(
                onClick = {
                    navController.navigate(Signup)
                }
            ) {
                Text(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    text = "SignUp"
                )
            }

            OutlinedButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(ROOT)
                }
            ) {
                Text(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    text = "Go To Home Screen"
                )
            }
        }
    }

}
```


7. To pop a screen from the back stack, you can use:

```Kotlin
// Just OnBackPressed() function :->
navController.popBackStack()

// If you want to pass any data to the previous screen :->
navController.navigate(Home) {
    popUpTo(Home)  {
        inclusive = true
    }
}
```


8. Passing arguments :

```Kotlin
// Create a data class in screen name file.
// Passing arguments in navgraph in composable.
composable<Detail>{
    val args = it.toRoute<Detail>()
    DetailScreen(navController = navController, args.age, args.name)
}

// Passing arguments in screens.
navController.navigate(
    Detail(
    name = "Android",
    age = 13
  )
)

// Getting value in screen.
@Composable
fun DetailScreen(
    navController: NavHostController,
    age: Int,
    name: String
) {
// Arguments :->
Text(
    fontSize = MaterialTheme.typography.labelSmall.fontSize,
    text = "Name : $name"
)
Text(
  fontSize = MaterialTheme.typography.labelSmall.fontSize,
  text = "Age : $age"
)
}
```



## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

1.> Fork the Project.\
2.> Create your Feature Branch `git checkout -b feature/AmazingFeature`.\
3.> Commit your Changes `git commit -m 'Add some AmazingFeature'`.\
4.> Push to the Branch `git push origin feature/AmazingFeature`.\
5.> Open a Pull Request

## Acknowledgements

- Inspiration from various Android development tutorials and documentation.
## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech).
