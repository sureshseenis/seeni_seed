package com.seeni.android_seed.ui.view.widget

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seeni.android_seed.ui.theme.colors
import com.seeni.android_seed.ui.utils.preview.PreviewContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    darkMode: Boolean,
    fontFamily: FontFamily = FontFamily.Cursive,
    fontSize: TextUnit = 25.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    onThemeUpdated: () -> Unit,
    onSearchClick: () -> Unit
) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    fontSize = fontSize,
                    fontFamily = fontFamily,
                    color = colors.primaryContainer,
                    fontWeight = fontWeight
                )
            },
            actions = {
                IconButton(
                    onClick = { onSearchClick() }
                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }
                IconButton(
                    onClick = { onThemeUpdated() }
                ) {
                    val icon = if (darkMode) {
                        Filled.FavoriteBorder
                    } else {
                        Outlined.Favorite
                    }
                    Icon(imageVector = icon, contentDescription = "Dark Mode")
                }
            }
        )
    }
}

@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TopBarPreview() {
    PreviewContainer {
        Column {
            TopBar("AppName", true, onThemeUpdated = {}, onSearchClick = {})
            Spacer(modifier = Modifier.padding(10.dp))
            TopBar("Home", false, onThemeUpdated = {}, onSearchClick = {})
        }
    }
}