package composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.HomeUiState
import util.compareJSON

@Composable
internal fun HomeScreen(homeUiState: HomeUiState) {
    HomeContent(homeUiState = homeUiState)
}

@Composable
private fun HomeContent(homeUiState: HomeUiState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = homeUiState.firstJson.value,
                    onValueChange = { homeUiState.firstJson.value = it },
                    label = { Text(text = "1st JSON") }
                )
                Spacer(modifier = Modifier.width(16.dp))
                OutlinedTextField(
                    value = homeUiState.secondJson.value,
                    onValueChange = { homeUiState.secondJson.value = it },
                    label = { Text(text = "2nd JSON") }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        homeUiState.result.value = compareJSON(homeUiState.firstJson.value, homeUiState.secondJson.value)
                    }
                ) {
                    Text("Compare")
                }
            }
            if (homeUiState.result.value.isNotBlank()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        value = homeUiState.result.value,
                        readOnly = true,
                        onValueChange = {},
                        label = { Text("Result:") }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeContentPreview() {
    MaterialTheme {
        HomeContent(homeUiState = HomeUiState())
    }
}