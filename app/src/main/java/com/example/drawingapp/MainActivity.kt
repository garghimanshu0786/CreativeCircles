package com.example.drawingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.drawingapp.ui.theme.DrawingAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DrawingAppTheme {
				Canvas(
					Modifier
						.size(1200.dp, 800.dp)
						.background(Color.White)
				) {
					val orbitRadius = 300f

					for (r in 0..359 step 2) {
						val rad = Math.toRadians(r.toDouble())
						val x = (orbitRadius * kotlin.math.cos(rad)).toFloat()
						val y = (orbitRadius * kotlin.math.sin(rad)).toFloat()
						drawCircle(
							color = Color.Gray,
							radius = 75f,
							center = Offset(this.center.x + x, this.center.y + y),
							style = Stroke(width = 1f)
						)
					}
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String) {
	Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	DrawingAppTheme {
		Greeting("Android")
	}
}