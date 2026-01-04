package studio.vitr.springboot.api.model

import studio.vitr.springboot.api.constants.Properties.TOKEN_TYPE
import studio.vitr.springboot.api.errors.InvalidEnumValue

enum class TokenType {
    ACCESS,
    REFRESH;

    companion object {
        fun fromString(value: String) = entries
            .find { it.toString() == value }
            ?: throw InvalidEnumValue(TOKEN_TYPE, value)
    }
}