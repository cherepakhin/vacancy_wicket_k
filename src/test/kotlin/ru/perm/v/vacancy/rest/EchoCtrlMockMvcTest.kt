package ru.perm.v.vacancy.rest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import ru.perm.v.vacancy.config.MyConfig
import ru.perm.v.vacancy.dto.CompanyDto

@WebMvcTest(EchoCtrl::class)
class EchoCtrlMockMvcTest(@Autowired val mockMvc: MockMvc) {
    @Test
    fun echo() {
        assertEquals("Hello", EchoCtrl().echo("Hello"))
    }

    @Test
    fun testResponse() {
        mockMvc.perform(get("/echo/TEST_MESSAGE").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().string("TEST_MESSAGE"))
    }
}