package com.example.blackcofferassessment

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackcofferassessment.ui.theme.BlackCofferAssessmentTheme
import com.example.blackcofferassessment.ui.theme.Brown
import com.example.blackcofferassessment.ui.theme.DeepBlue
import com.example.blackcofferassessment.ui.theme.InviteCard
import com.example.blackcofferassessment.ui.theme.LightGrey
import com.example.blackcofferassessment.ui.theme.LightOcean
import com.example.blackcofferassessment.ui.theme.OceanBlue
import com.example.blackcofferassessment.ui.theme.PurpleGrey40
import com.example.blackcofferassessment.ui.theme.ReddishBrown

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackCofferAssessmentTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen() {
    var sectionColor by remember {
        mutableStateOf(PurpleGrey40)
    }
    Column {
        UpScreen()
        Sections(listOf("Personal","Services","Businesses"))
        Search()
        Slides(items = listOf(
            InviteCard(
                name = "Devid",
                loc = "Noida",
                role = "SDE",
                startSym = "DY",
                profileScore = 70f
            ),
            InviteCard(
                name = "Jasmi",
                loc = "Delhi",
                role = "SDE - II",
                startSym = "JM",
                profileScore = 60f
            ),
            InviteCard(
                name = "Louis",
                loc = "Noida",
                role = "Manager",
                startSym = "LP",
                profileScore = 80f
            ),
            InviteCard(
                name = "Sophia",
                loc = "Pune",
                role = "SDE - I",
                startSym = "SI",
                profileScore = 85f
            )
        ))
        bottom()
    }
}

@Composable
fun UpScreen() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(){
            Icon(imageVector = Icons.Rounded.Menu,
                contentDescription = "Sided",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(text = "Howdy",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){

                    Icon(imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Location",
                        tint = Color.White,
                        modifier = Modifier
                            .size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "Fetching...",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    )
                }
            }
        }

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable {  }
        ) {
            Icon(imageVector = Icons.Filled.List,
                contentDescription = "Logo",
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
                )
            Text(text = "Refine",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            )
        }

    }
}

@Composable
fun Sections(
    items : List<String>
) {
    var selectedInd by remember {
        mutableStateOf(items[0].hashCode())
    }
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        for (item in items){
            Surface(
                color = if(selectedInd == item.hashCode()) LightOcean else OceanBlue,
                shadowElevation = 10.dp,
                modifier = Modifier
                    .size(width = 120.dp, height = 40.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { selectedInd = item.hashCode() }
                ) {
                    Text(
                        text = "$item",
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color.White
                        ),
                        modifier = Modifier
                            .padding(0.dp)
                    )
                }
            }
        }

    }
}


@Composable
fun Search() {
    var value by remember {
        mutableStateOf("")
    }
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
    ){
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            value = value,
            onValueChange = {value = it},
            label = {
                Row {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "search",
                        tint = Color.Black
                    )
                    Text(text = "Search", color = Color.Black)
                }
            },
            shape = RoundedCornerShape(15.dp),
            singleLine = true
        )
        Spacer(modifier = Modifier.width(25.dp))
        Icon(imageVector = Icons.Filled.Settings, contentDescription = "Setting",
            tint = Color.Black,
            modifier = Modifier
                .padding(5.dp)
                .size(25.dp)
                .clickable { }
        )
    }
}

@Composable
fun Slides(
    items : List<InviteCard>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.88f)
    ) {
        items(items.size){
            SlideItem(item = items[it])
        }
    }
}

@Composable
fun SlideItem(
    item : InviteCard
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(15.dp),
            color = Color.Transparent,
            border = BorderStroke(width = 1.dp, color = Color.Black)
        ) {
            Column {
                Row(
                    Modifier
                        .offset(x = 100.dp)
                        .padding(top = 10.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
                ) {
                    Text(
                        text = "${item.name}",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    )
                    Spacer(modifier = Modifier.width(120.dp))
                    Text(
                        text = "+INVITE",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )

                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .offset(x = 100.dp)
                        .padding(top = 8.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
                ){
                    Text(
                        text = "${item.loc}  |  ",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp
                        )
                    )
                    Text(
                        text = "${item.role}",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .offset(x = 100.dp)
                        .padding(top = 8.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
                ) {
                    Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Dis",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(15.dp)
                        )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${item.profileScore} KM",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        color = LightGrey,
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
                ) {
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "Dis",
                        tint = Brown,
                        modifier = Modifier
                            .size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "COFFEE | ",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        color = Brown,
                    )
                    Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "Dis",
                        tint = ReddishBrown,
                        modifier = Modifier
                            .size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "BUSINESS | ",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        color = ReddishBrown,
                    )
                    Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "Dis",
                        tint = ReddishBrown,
                        modifier = Modifier
                            .size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "WorkFlow | ",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        color = ReddishBrown,
                    )
                }
                Text(
                    text = "Hi Community, I am open to Work!",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14 .sp
                    ),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
                )
            }
        }

        Surface(
            color = LightGrey,
            modifier = Modifier
                .fillMaxWidth(0.30f)
                .height(90.dp)
                .padding(8.dp),
            shape = RoundedCornerShape(10.dp),
            shadowElevation = 0.1.dp
        ) {
            Box (contentAlignment = Alignment.Center){
                Text(text = "${item.startSym}",
                    color = DeepBlue,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
fun bottom() {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ){
        bottomFrame(Title = "Explore", id = Icons.Filled.Info)
        bottomFrame(Title = "Contact", id = Icons.Filled.AccountBox)
        bottomFrame(Title = "Explore", id = )
        bottomFrame(Title = "Explore", id = Icons.Filled.Info)
        bottomFrame(Title = "Explore", id = Icons.Filled.Info)
    }
}


@Composable
fun bottomFrame(
    Title : String,
    id : ImageVector
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
    ){
        Icon(imageVector = id,
            contentDescription = "Icon",
            tint = Color.White,
            modifier = Modifier
                .size(20.dp)
        )
        Text(text = Title,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            ),
            color = Color.White
        )
    }
}