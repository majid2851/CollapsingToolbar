package com.majid2851.collapsingtoolbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.majid2851.collapsingtoolbar.ui.theme.CollapsingToolbarTheme
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CollapsingToolbarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent()
{
    val state= rememberCollapsingToolbarScaffoldState()
    CollapsingToolbarScaffold(
        modifier = Modifier,
        state = state,
        scrollStrategy = ScrollStrategy.EnterAlways,
        toolbar = {
            val textSize=(18+(30-12)*state.toolbarState.progress).sp

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .pin()
                .background(color = MaterialTheme.colorScheme.primary))

            Image(
                painter = painterResource(id = R.drawable.landscape),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alpha =if(textSize.value==18f) 0f else 1f,
                modifier = Modifier.fillMaxSize()
            )

            Text(
                text = "CollapsingToolbar",
                style = TextStyle(color = Color.White, fontSize = textSize),
                modifier = Modifier.padding(16.dp)
            )
        }
    )
    {
        LazyColumn(modifier = Modifier.fillMaxSize())
        {
            items(100)
            {
                Card(modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                )
                {
                    Text(text = "Card Number $it", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                    )
                    
                }
            }
        }

    }

    
}









