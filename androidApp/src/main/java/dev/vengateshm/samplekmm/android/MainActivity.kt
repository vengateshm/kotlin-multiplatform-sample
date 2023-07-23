package dev.vengateshm.samplekmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import dev.vengateshm.samplekmm.Sample
import dev.vengateshm.samplekmm.getInt
import dev.vengateshm.samplekmm.putInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        putInt("sdk_version", android.os.Build.VERSION.SDK_INT)
        putInt("latest_sdk_version", android.os.Build.VERSION_CODES.TIRAMISU)

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    SampleView()
//                    PreferenceStorageSample()
//                    StockApp()
                    StarWarsFilm()
                }
            }
        }
    }
}

@Composable
fun SampleView() {
    var text by remember { mutableStateOf("Loading") }
    LaunchedEffect(key1 = true) {
        text = try {
            Sample().getSampleText()
        } catch (e: Exception) {
            e.localizedMessage ?: "error"
        }
    }
    Text(text = text)
}

@Composable
fun PreferenceStorageSample() {
    val context = LocalContext.current
    var sdkVersionFromPreference by remember { mutableStateOf(-1) }
    LaunchedEffect(key1 = Unit) {
        sdkVersionFromPreference = context.getInt("sdk_version")
    }
    if (sdkVersionFromPreference != -1) {
        Text(text = "SDK Version = $sdkVersionFromPreference")
    }
}