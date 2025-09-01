package com.example.artifact.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


//primary -	Main accent color — used for buttons, links, and key interactive elements.
//secondary	- Soft background for infoboxes or secondary containers.
//tertiary - Used for icons and input field backgrounds — adds contrast and depth.
//background -	Overall screen background — warm and light, easy on the eyes.
//surface -	Card backgrounds or elevated surfaces — slightly darker than background.
//onPrimary	- Text/icons on primary — ensures readability on RadicalRed.
//onSecondary -	Text/icons on secondary — readable against DairyCream.
//onTertiary - Text/icons on tertiary — likely a lighter contrast for darker elements.
//onBackground	- Default text color on background.
//onSurface	- Text/icons on surface — consistent with other text colors.

// Dark theme colors
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFB8CDE0),       // Powder Blue – soft accent for titles/buttons
    secondary = Color(0xFF9E8F76),     // Muted Sandstone – warm highlight for info
    tertiary = Color(0xFF8C7F6B),      // Weathered Taupe – icons and inputs
    background = Color(0xFF1E1A16),    // Charcoal Umber – main background
    surface = Color(0xFF2C2620),       // Deep Cocoa – card surfaces
    onPrimary = Color(0xFFF4EEE7),     // Linen White – text on blue
    onSecondary = Color(0xFFF4EEE7),   // Linen White – text on sandstone
    onTertiary = Color(0xFFF4EEE7),    // Linen White – text on taupe
    onBackground = Color(0xFFE4DACC),  // Cream – body text
    onSurface = Color(0xFFE4DACC)      // Cream – surface text
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF3F6386),        // accents and headings
    secondary = Color (0xFFD8C49F),     //info boxes and highlights
    tertiary = Color (0xFF162C36),      // icons and subtle accents
    background = Color (0xFFF0E5D3),    // Linen White – main background
    surface = Color (0xFFEDD0A0),        // Cream – card surfaces and form fields
    onPrimary = Color(0xFFF4EEE7),     // Linen White – text on blue
    onSecondary = Color (0xFF241D13),   // Deep Brown – text on beige
    onTertiary = Color (0xFF241D13),    // Deep Brown – text on grey
    onBackground = Color (0xFF241D13),  // Deep Brown – body text
    onSurface = Color (0xFF241D13)      // Deep Brown – surface text
)


@Composable
fun ArtiFactTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}