package studio.vitr.springboot.api.service

import org.springframework.stereotype.Service
import studio.vitr.springboot.api.constants.Properties.USER
import studio.vitr.springboot.api.errors.NotFound
import studio.vitr.springboot.api.model.User
import studio.vitr.springboot.api.repository.UserRepository
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoderService: PasswordEncoderService
) {

    fun getAll(): List<User> = userRepository.findAll()

    fun get(id: UUID): User? = userRepository
        .findById(id)
        .orElse(null)

    fun create(email: String, password: String) = passwordEncoderService
        .encodePassword(password)
        .let { User(email = email, password = it) }
        .let { userRepository.save(it) }

    fun delete(userId: UUID) = get(userId)
        ?.let { userRepository.delete(it) }
        ?: throw NotFound(USER, userId.toString())

    fun verifyPassword(userId: UUID, password: String) = get(userId)
        ?.let { verifyPassword(password, it.password) }
        ?: throw NotFound(USER, userId.toString())

    fun verifyPassword(raw: String, encoded: String) = passwordEncoderService
        .verifyPassword(raw, encoded)

    fun findByEmail(email: String) = userRepository.findByEmail(email)
}