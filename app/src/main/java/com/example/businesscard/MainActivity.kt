package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.twotone.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(getString(R.string.name), getString(R.string.business))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, business: String) {

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.LightGray)) {

        val image = painterResource(id = R.drawable.android_logo)

        Image(painter = image,
            contentDescription = stringResource(R.string.android_icon),
            modifier = Modifier
                .height(150.dp)
                .width(120.dp)
                .background(color = Color.DarkGray)
        )

        Text(text = name,
            fontSize = 50.sp
        )

        Text(text = business,
            fontSize = 30.sp
        )
    }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 600.dp)) {

        Row(modifier = Modifier.align(alignment = Alignment.Start)) {

            Icon(
                Icons.TwoTone.Share,
                contentDescription = stringResource(R.string.link),
                modifier = Modifier
                    .padding(20.dp)
            )

            Text(
                text = stringResource(R.string.linkedin_link),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }

        Row(modifier = Modifier.align(alignment = Alignment.Start)) {

            Icon(
                Icons.Default.Email,
                contentDescription = stringResource(R.string.email_icon),
                modifier = Modifier
                    .padding(20.dp)
            )

            Text(
                text = stringResource(R.string.email),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.CenterVertically)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard("Akshita Korwar", "Software Engineer")
    }
}