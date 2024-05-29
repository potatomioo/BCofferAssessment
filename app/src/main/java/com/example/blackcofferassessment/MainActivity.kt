package com.example.blackcofferassessment

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blackcofferassessment.ui.theme.BlackCofferAssessmentTheme
import com.example.blackcofferassessment.ui.theme.BottomGrey
import com.example.blackcofferassessment.ui.theme.Brown
import com.example.blackcofferassessment.ui.theme.DeepBlue
import com.example.blackcofferassessment.ui.theme.InviteCard
import com.example.blackcofferassessment.ui.theme.LightGrey
import com.example.blackcofferassessment.ui.theme.LightOcean
import com.example.blackcofferassessment.ui.theme.OceanBlue
import com.example.blackcofferassessment.ui.theme.PurpleGrey40
import com.example.blackcofferassessment.ui.theme.ReddishBrown
import com.example.blackcofferassessment.ui.theme.bottomFrames

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackCofferAssessmentTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen"){
        composable("MainScreen"){
            MainScreen({navController.navigate("RefineScreen")})
        }
        composable("RefineScreen"){
            Refine({navController.navigate("MainScreen")})
        }
    }
}

@Composable
fun MainScreen(
    RefineScreen : ()->Unit
) {
    var sectionColor by remember {
        mutableStateOf(PurpleGrey40)
    }
    Column {
        UpScreen(RefineScreen)
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
        bottom(Sections = listOf(
            bottomFrames(base = "Explore", id = Icons.Filled.Info),
            bottomFrames(base = "Contact", id = Icons.Filled.AccountBox),
            bottomFrames(base = "Details", id = Icons.Filled.DateRange),
            bottomFrames(base = "Notify", id = Icons.Filled.Notifications),
            bottomFrames(base = "Profile", id = Icons.Filled.Person)
        ))
    }
}

@Composable
fun UpScreen(
    RefineScreen : ()->Unit
) {
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
                .clickable { RefineScreen() }
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
fun bottom(
    Sections : List<bottomFrames>
) {
    var selected by remember {
        mutableStateOf(Sections[0].hashCode())
    }
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(BottomGrey)
    ){
        for(i in Sections){
            bottomFrame(Title = i.base, id = i.id)
        }
    }
}


@Composable
fun bottomFrame(
    Title : String,
    id : ImageVector,

) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .clickable {}
    ){
        Icon(imageVector = id,
            contentDescription = "Icon",
            tint = Color.Black ,
            modifier = Modifier
                .size(20.dp)
        )
        Text(text = Title,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            ),
            color = Color.Black
        )
    }
}


@Composable
fun Refine(
    MainScreen : () ->Unit
) {
    Column {
        RefineTop(MainScreen)
        RefineBottom()
    }
}

@Composable
fun RefineTop(
    MainScreen: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(DeepBlue)
    ) {
        Icon(imageVector = Icons.Filled.KeyboardArrowLeft,
            contentDescription = "back",
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp)
                .clickable { MainScreen() },
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = "Refine",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            ),
            modifier = Modifier
                .padding(15.dp)
        )
    }
}

@Composable
fun RefineBottom() {
    var textchange by remember {
        mutableStateOf("")
    }
    var per by remember {
        mutableStateOf(0f)
    }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Select Your Availability",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 15.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
        )
        avalabilityStatus()
        Text(
            text = "Add Your Status",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 15.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
        )
        OutlinedTextField(value = textchange, onValueChange = { textchange = it },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .padding(top = 10.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            singleLine = true,
            supportingText = {
                Text(text = "${textchange.length}/250")
            }
        )
        Text(
            text = "Select Hyper Local Distance",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 15.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
        )
        Slider(
            value = per,
            onValueChange = {per = it},
            valueRange = 1f..100f,
            modifier = Modifier
                .padding(top = 10.dp, start = 15.dp, end = 15.dp, bottom = 0.dp),
            colors = SliderDefaults.colors(
                thumbColor = DeepBlue,
                activeTrackColor = DeepBlue,
                inactiveTrackColor = Color.LightGray,
                activeTickColor = Color.Transparent,
                inactiveTickColor = Color.Transparent
            )
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp, start = 10.dp, end = 10.dp, bottom = 0.dp)
        ){
            Text(text = "1 KM", style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            ), color = LightGrey
            )
            Text(text = "100 KM",style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            ), color = LightGrey
            )
        }
        Text(
            text = "Select Perpose",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 15.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
        )
        purposes(items = listOf(
            "Coffee","Business","Hobbies","Movies","Dining","Dating"
        ))

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DeepBlue
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .padding(top = 50.dp)
            ) {
                Text(
                    text = "Save & explore",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun avalabilityStatus() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("Available | Hey Let Us Connect") }

    val options = listOf(
        "Available | Hey Let Us Connect",
        "Away | Stay Discrete And Watch",
        "Busy | Do Not Disturb | Will Catch Up Later",
        "SOS | Emergency! Need Assistance! HELP!"
    )

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = selectedOptionText,
            onValueChange = {},
            shape = RoundedCornerShape(5.dp),
            readOnly = true,
            label = { Text("Select Your Availability") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                )
            }
        }
    }
}


@Composable
fun purposes(
    items : List<String>
) {
    var ifselected by remember {
        mutableStateOf(items[0])
    }
    LazyRow (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 0.dp)
    ){
        items(items){
            Box (
                modifier = Modifier
                    .padding(start = 5.dp, end = 0.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .border(width = 1.dp, color = DeepBlue)
                    .background(if (ifselected == it) DeepBlue else Color.Transparent)

                    .clickable { ifselected = it },
                contentAlignment = Alignment.Center
            ){
                Text(text = "${it}", style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                ),
                    modifier = Modifier
                        .padding(10.dp),
                    color = if(ifselected == it) Color.White else DeepBlue
                )
            }
        }
    }
}