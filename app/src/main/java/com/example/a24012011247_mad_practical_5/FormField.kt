package com.example.a24012011247_mad_practical_5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a24012011247_mad_practical_5.ui.theme._24012011247_MAD_Practical5Theme

@Composable
fun FormField(
    lable: String,
    textState: String,
    onTextChange: (String) -> Unit,
    isPassword: Boolean = false,
    isNumeric: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = lable,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f)
        )
        if (!isNumeric) {
            OutlinedTextField(
                value = textState,
                onValueChange = onTextChange,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(2f),
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                label = { Text("Enter $lable") },
                placeholder = { Text("Enter $lable") }
            )
        } else {
            OutlinedTextField(
                value = textState,
                onValueChange = { newValue ->
                    if (newValue.all { it.isDigit() }) {
                        onTextChange(newValue)
                    }
                },
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(2f),
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                label = { Text("Enter $lable") },
                placeholder = { Text("Enter $lable") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = VisualTransformation.None
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormFieldPreview() {
    _24012011247_MAD_Practical5Theme {
        FormField(
            lable = "Email",
            textState = "user@example.com",
            onTextChange = {}
        )
    }
}
