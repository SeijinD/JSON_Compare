import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import composable.HomeScreen
import model.HomeUiState

fun main() = application {
    Window(
        title = "JSON Compare",
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        MaterialTheme {
            val homeUiState = HomeUiState()
            HomeScreen(homeUiState = homeUiState)
        }
    }
}
