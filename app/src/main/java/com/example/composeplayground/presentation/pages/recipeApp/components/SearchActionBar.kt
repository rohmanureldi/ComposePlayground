package com.example.composeplayground.presentation.pages.recipeApp.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun SearchActionBar(
    inputValue: String,
    onValueChange: (String) -> Unit,
    onImeActionClicked: () -> Unit,
    changeVisibility: () -> Unit,
    visible: Boolean,
) {
    val keyboard = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
                .padding(
                    vertical = 16.dp,
                    horizontal = 8.dp
                ),

            ) {
            Row {
                AnimatedVisibility(
                    visible = visible,
                    enter = expandHorizontally(
                        expandFrom = Alignment.Start
                    ) + fadeIn(
                        initialAlpha = 0.3f
                    ),
                    exit =  shrinkHorizontally() + fadeOut(),
                    modifier = Modifier.height(55.dp)
                ) {
                    TextField(
                        value = inputValue,
                        onValueChange = {
                            onValueChange(it)
                        },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Words,
                            autoCorrect = false,
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions {
                            onImeActionClicked()
                            keyboard?.hide()
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(percent = 50),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = null,
                                tint = MaterialTheme.colors.primary
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = null,
                                modifier = Modifier
                                    .clickable {
                                        onValueChange("")
                                        changeVisibility()
                                    }
                                    .indication(
                                        interactionSource = remember {
                                            MutableInteractionSource()
                                        },
                                        indication = rememberRipple(
                                            bounded = true,
                                            radius = 30.dp
                                        )
                                    ),
                                tint = MaterialTheme.colors.primary
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            disabledTextColor = Color.Transparent,
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                }

                AnimatedVisibility(
                    visible = !visible,
                    enter = fadeIn(
                        initialAlpha = 0.3f
                    ),
                    exit = fadeOut(),
                    modifier = Modifier.height(55.dp)
                ) {
                    Button(
                        onClick = {
                            changeVisibility()
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .focusable(),
                        shape = RoundedCornerShape(percent = 50)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}