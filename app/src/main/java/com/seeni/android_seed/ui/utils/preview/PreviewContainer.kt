package com.seeni.android_seed.ui.utils.preview

import androidx.compose.runtime.Composable
import com.seeni.android_seed.ui.theme.Seeni_seedTheme

@Composable
fun PreviewContainer(
    content: @Composable () -> Unit
) {
    Seeni_seedTheme  {
        content()
    }
}