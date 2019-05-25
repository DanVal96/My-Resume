package com.example.myresume.domain.errors

sealed class ResumeErrors {
    class ConnectionError: Exception()
    class TimeoutException: Exception()
    class GenericError: Exception()
}