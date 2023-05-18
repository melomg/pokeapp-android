package com.melih.android.pokeapp.core.designsystem.compose

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    showBackground = true,
    name = "phone",
    device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    showBackground = true,
    name = "phone dark mode",
    device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    showBackground = true,
    name = "landscape",
    device = "spec:shape=Normal,width=640,height=360,unit=dp,dpi=480",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    showBackground = true,
    name = "foldable",
    device = "spec:shape=Normal,width=673,height=841,unit=dp,dpi=480",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    showBackground = true,
    name = "tablet",
    device = "spec:shape=Normal,width=1280,height=800,unit=dp,dpi=480",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
annotation class DevicePreviews
