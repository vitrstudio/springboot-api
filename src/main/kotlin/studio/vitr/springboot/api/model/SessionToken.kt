package studio.vitr.springboot.api.model

import studio.vitr.springboot.api.utils.TimeUtil

class SessionToken(
    val type: TokenType,
    val userId: String,
    val email: String?,
    val issuedAt: Long,
    val expiresAt: Long
) {
    fun isExpired() = TimeUtil.now() > expiresAt
}