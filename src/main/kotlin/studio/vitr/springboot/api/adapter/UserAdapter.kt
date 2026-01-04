package studio.vitr.springboot.api.adapter

import org.springframework.stereotype.Component
import studio.vitr.springboot.api.constants.Properties.ID
import studio.vitr.springboot.api.errors.InvalidParameter
import studio.vitr.springboot.api.model.User
import studio.vitr.springboot.api.model.api.UserResponse

@Component
class UserAdapter {
    fun toUserResponse(u: User) = UserResponse(
        id = u.id ?: throw InvalidParameter(ID),
        email = u.email,
        createdAt = u.createdAt,
    )
}