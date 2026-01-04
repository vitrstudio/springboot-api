package studio.vitr.springboot.api.model

class Session(
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Long
)