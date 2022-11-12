package com.group.libraryapp.domain.book

import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BookTest {

    @Test
    fun init() {
        //given & when & then
        assertThrows<IllegalArgumentException> {
            val book = Book("", BookType.SOCIETY)
        }.apply {
            AssertionsForInterfaceTypes.assertThat(message).isEqualTo("이름은 비어 있을 수 없습니다.")
        }
    }
}