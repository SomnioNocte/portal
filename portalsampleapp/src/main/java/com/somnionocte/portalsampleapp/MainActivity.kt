package com.somnionocte.portalsampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.somnionocte.portal.BasicModalView
import com.somnionocte.portal.NexusPortal
import com.somnionocte.portalsampleapp.ui.theme.PortalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PortalTheme {
                NexusPortal {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        var showModalView by rememberSaveable { mutableStateOf(false) }

                        if(showModalView) {
                            BasicModalView(
                                onCloseRequest = { showModalView = false },
                                surfaceColor = MaterialTheme.colorScheme.surface,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "Press the outside of the modal view to close it",
                                    Modifier.padding(82.dp),
                                    color = MaterialTheme.colorScheme.onSurface,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        Column(
                            Modifier.fillMaxSize().padding(innerPadding),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            FilledTonalButton({ showModalView = true }) {
                                Text("Show modal view")
                            }
                        }
                    }
                }
            }
        }
    }
}