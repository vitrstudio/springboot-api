package studio.vitr.springboot.api.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import studio.vitr.springboot.api.constants.Properties.USER_ID
import studio.vitr.springboot.api.errors.MissingExpectedParameter
import studio.vitr.springboot.api.utils.TimeUtil
import java.util.*
import jakarta.persistence.GenerationType.UUID as UUIDX

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = UUIDX) val id: UUID? = null,
    val email: String,
    val password: String,
    val createdAt: Long = TimeUtil.now(),
) {
    fun idStr() = id?.toString() ?: throw MissingExpectedParameter(USER_ID)
}
