package ir.madreseyar.teacher

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF173F73),
    secondary = Color(0xFF2F6B5F),
    tertiary = Color(0xFFB7791F),
    background = Color(0xFFF4F6F8),
    surface = Color.White
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFAECBF0),
    secondary = Color(0xFF8FD0C2),
    background = Color(0xFF101418),
    surface = Color(0xFF171C21)
)

@Composable
fun MadreseyarTeacherTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors,
        content = content
    )
}
