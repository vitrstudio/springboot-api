package studio.vitr.springboot.api.model.api

import java.util.*

class UserResponse(
    val id: UUID,
    val email: String,
    val createdAt: Long
)