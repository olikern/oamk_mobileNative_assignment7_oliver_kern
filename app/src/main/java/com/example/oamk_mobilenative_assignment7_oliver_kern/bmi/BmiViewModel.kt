package com.example.oamk_mobilenative_assignment7_oliver_kern.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    private var _heightInput: String by mutableStateOf(value = "")
    private var _heightValue: Float by mutableFloatStateOf(value = 0.0f)
    private var _weightInput: String by mutableStateOf(value = "")
    private var _weightValue: Int by mutableIntStateOf(value = 0)
    private var _bmi: Float? by mutableStateOf(value = null)

    fun getHeight(): String {
        return _heightInput
    }
    fun setHeight(input: String) {
        _heightInput = input.replace(',', '.')
        _heightValue = _heightInput.toFloatOrNull() ?: 0.0f
        _heightValue = if (_heightValue > 3.0) _heightValue / 100 else _heightValue
        calculateBmi()
    }

    fun getWeight(): String {
        return _weightInput
    }
    fun setWeight(input: String) {
        _weightInput = input.replace(',', '.')
        _weightValue = _weightInput.toIntOrNull() ?: 0
        calculateBmi()
    }

    fun getBmi(): Float? {
        return _bmi
    }
    private fun calculateBmi() {
        _bmi = if (_heightValue != 0.0f && _weightValue != 0) {
            _weightValue / (_heightValue * _heightValue)
        } else {
            null
        }
    }
}