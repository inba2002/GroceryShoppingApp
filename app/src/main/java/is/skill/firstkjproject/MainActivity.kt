package `is`.skill.firstkjproject

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.contentValuesOf
import `is`.skill.firstkjproject.ui.theme.FirstKJProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstKJProjectTheme {
                MainTheme {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun MainTheme(content: @Composable() () -> Unit){
    FirstKJProjectTheme {
        Surface(color=MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen(){
    Box{
      Image(
          modifier = Modifier
              .fillMaxWidth()
              .offset(0.dp, (-30).dp),
          painter = painterResource(id = R.drawable.bg_main),
          contentDescription = "Header Background",
          contentScale = ContentScale.FillWidth
          )
        Scaffold(
            topBar = {AppBar()},
            backgroundColor = Color.Transparent
        ) {paddingValues ->
            Content(paddingValues)
        }
    }

}

@Composable
fun AppBar() {
    Row(
        Modifier
            .padding(16.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        TextField(
            value = "",
            onValueChange = {},
            label={Text(text="Search Food, Vegetable, etc.", fontSize = 12.sp)},
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription ="Search" )},
            colors=TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Spacer(modifier=Modifier.width(8.dp))
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "",tint= Color.White)
        }
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "",tint= Color.White)
        }
    }
}

@Composable
fun Content(paddingValues: PaddingValues){
    Column(Modifier.padding(paddingValues)){
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        promotions()
        Spacer(modifier = Modifier.height(16.dp))
        CategorySection()
        Spacer(modifier = Modifier.height(16.dp))
        BestSellerSection()
    }
}

@Composable
fun Header() {
    Card(
        Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        elevation = 4.dp,
        shape=RoundedCornerShape(8.dp)
    ){
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            QRButton()
            VerticalDivider()
            Row(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
            ){
                Icon(painter = painterResource(id = R.drawable.ic_money), contentDescription = "", tint = Color(0xFF6FCF97))
                Column(Modifier.padding(8.dp)) {
                    Text(text = "Rs120", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Top Up", color=MaterialTheme.colors.primary, fontSize = 12.sp)
                }
            }
            VerticalDivider()
            Row(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
            ){
                Icon(painter = painterResource(id = R.drawable.ic_coin), contentDescription = "", tint = MaterialTheme.colors.primary)
                Column(Modifier.padding(8.dp)) {
                    Text(text = "Rs10", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Points", color=Color.LightGray, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun QRButton() {
    IconButton(onClick = {}, modifier = Modifier
        .fillMaxHeight()
        .aspectRatio(1f)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Composable
fun VerticalDivider() {
    Divider(
        color=Color(0xFFF1F1F1),
        modifier = Modifier
            .width(1.dp)
            .height(32.dp)
    )
}

@Composable
fun promotions() {
    LazyRow(Modifier
                .height(160.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.promotion),
                title = "Fruit",
                subtitle = "Start @",
                header = "Rs.50",
                backgroundColor = MaterialTheme.colors.primary
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.meat),
                title = "Meat",
                subtitle = "Start @",
                header = "Rs.200",
                backgroundColor = Color(0xff6EB6F5)
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.ic_cheese),
                title = "Dairy",
                subtitle = "Start @",
                header = "Rs.80",
                backgroundColor = MaterialTheme.colors.primary
            )
        }
    }
}

@Composable
fun PromotionItem(
    title:String="",
    subtitle:String="",
    header:String="",
    backgroundColor:Color=Color.Transparent,
    imagePainter:Painter
){
    Card(Modifier
        .width(300.dp),
        shape=RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ){
        Row{
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
            ){
                Text(text=title, fontSize = 14.sp, color= Color.White)
                Text(text=subtitle, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text=header, fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Image(painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                    alignment = Alignment.CenterEnd,
                    contentScale = ContentScale.Crop)
        }
    }
}


@Composable
fun CategorySection() {
    Column(Modifier
        .padding(horizontal = 16.dp)
    ){
        Row(Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text="Category",style=MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }
        Row(
            Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
        ){
            CategoryButton(text="Fruits",
                icon = painterResource(id = R.drawable.ic_orange),
                backgroundColor = Color(0xffFEF4E7)
            )
            CategoryButton(text="Fruits",
                icon = painterResource(id = R.drawable.ic_veg),
                backgroundColor = Color(0xffFEF4E7)
            )
            CategoryButton(text="Fruits",
                icon = painterResource(id = R.drawable.ic_cheese),
                backgroundColor = Color(0xffFEF4E7)
            )
            CategoryButton(text="Fruits",
                icon = painterResource(id = R.drawable.ic_meat),
                backgroundColor = Color(0xffFEF4E7)
            )
        }
    }
}

@Composable
fun CategoryButton(
    text:String="",
    icon:Painter,
    backgroundColor: Color
) {
    Column(
        Modifier
            .size(64.dp)
            .clickable { }
    ){
        Box(
            Modifier
                .size(64.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(18.dp)
        ){
            Image(painter=icon, contentDescription = "", modifier = Modifier.fillMaxSize())
        }
        Text(text=text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

@Composable
fun BestSellerSection() {
    Column(){
        Row(Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text="Best Sellers",style=MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text="More",color=MaterialTheme.colors.primary)
            }
        }
        BestSellerItems()
    }
}

@Composable
fun BestSellerItems() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.lettuce),
                title = "Iceberg Lettuce",
                price="30",
                discountPercent = 10
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.apple),
                title = "Iceberg Lettuce",
                price="60",
                discountPercent = 10
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.meat),
                title = "Iceberg Lettuce",
                price="300",
                discountPercent = 10
            )
        }
    }
}

@Composable
fun BestSellerItem(
    title:String="",
    price:String="",
    discountPercent:Int=0,
    imagePainter: Painter
){
    Card(
        Modifier
            .width(160.dp)
            .padding(bottom = 32.dp)
    ){
        Column(Modifier
            .padding(bottom = 32.dp)
        ){
            Image(
                painter=imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(Modifier
                .padding(horizontal = 8.dp)
            ) {
                Text(text=title, fontWeight = FontWeight.Bold)
                Row{
                    Text(
                        "Rs${price}",
                        textDecoration = if (discountPercent>0)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None,
                        color = if(discountPercent>0) Color.Black else Color.Gray
                    )
                    if(discountPercent>0){
                        Text(text="[$discountPercent%]",color=MaterialTheme.colors.primary)
                    }
                }
            }
        }
    }
}
