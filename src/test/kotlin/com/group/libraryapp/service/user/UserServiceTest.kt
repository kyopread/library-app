package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService
) {

    @Test
    fun saveUserTest() {
        // given
        val request = UserCreateRequest("kyopread", null)

        // when
        userService.saveUser(request)

        // then
        val results = userRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("kyopread")
//        assertThat(results[0]?.age).isNull()
        assertThat(results[0].age).isNull()

        // kotlin에서는 자바의 변수가 null이 들어갈 수 있는 변수인지 아닌지를 판별을 못한다.
        // 그렇기 때문에 java의 클래스에 @NotNull, @Nullable를 명시해주면 알 수 있다.
    }
}