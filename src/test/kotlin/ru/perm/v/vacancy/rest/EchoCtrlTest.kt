package ru.perm.v.vacancy.rest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EchoCtrlTest {
    @Test
    fun echo() {
        val echoCtrl = EchoCtrl()

        assertEquals("MESSAGE", echoCtrl.echo("MESSAGE"))
    }
}