package `is`.skill.firstkjproject.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import `is`.skill.firstkjproject.R

val nunitoFamily= FontFamily(
    Font(R.font.nunitolight,FontWeight.Light),
    Font(R.font.nunitoregular,FontWeight.Normal),
    Font(R.font.nunitobold,FontWeight.Bold),
)

val Typography = Typography(
    defaultFontFamily = nunitoFamily
)