package com.alessandrofarandagancio.openweather.ui.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.alessandrofarandagancio.openweather.api.openweather.baseIconOpenWeather
import com.alessandrofarandagancio.openweather.api.openweather.model.Weather
import com.alessandrofarandagancio.openweather.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var searchText by remember { mutableStateOf("") }
        SearchBar(searchText = searchText, onSearchTextChanged = { text ->
            searchText = text
            viewModel.setSearchText(text)
        })
        WeatherConditionItem(weather = viewModel.weather, modifier = Modifier.padding(top = 16.dp))
        CurrentLocation(modifier = Modifier.padding(top = 16.dp), viewModel.location)
    }
}

@Composable
fun SearchBar(
    searchText: String,
    onSearchTextChanged: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        IconButton(
            onClick = { /* Handle search button click */ },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        }
        BasicTextField(
            value = searchText,
            onValueChange = onSearchTextChanged,
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            singleLine = true
        )
    }
}

@Composable
fun CurrentLocation(modifier: Modifier = Modifier, location: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Rounded.LocationOn,
            contentDescription = "Current Location",
            tint = Color.Gray
        )
        Text(
            text = location,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun WeatherConditionItem(weather: Weather, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        WeatherConditionIcon(icon = weather.icon, modifier = modifier)
        Text(
            text = weather.main,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun WeatherConditionIcon(icon: String, modifier: Modifier = Modifier) {
    val iconUrl = baseIconOpenWeather.format(icon)
    val imagePainter = rememberAsyncImagePainter(iconUrl)
    Icon(
        painter = imagePainter,
        contentDescription = "Weather Condition",
        modifier = modifier
    )
}